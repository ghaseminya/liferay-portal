/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.servlet.ServletContextUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.MinifierUtil;
import com.liferay.util.servlet.ServletResponseUtil;

import java.io.File;
import java.io.IOException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a href="ComboServlet.java.html"><b><i>View Source</i></b></a>
 *
 * @author Eduardo Lundgren
 */
public class ComboServlet extends HttpServlet {

	public void service(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		Map<String, String[]> parameterMap = request.getParameterMap();

		if (parameterMap.size() == 0) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

			return;
		}

		String minifierType = ParamUtil.getString(request, "minifierType");

		int size = parameterMap.size();
		byte[][] bytesArray = new byte[size][];
		for (String modulePath : parameterMap.keySet()) {
			bytesArray[--size] = getFileContent(modulePath, minifierType);
		}

		String contentType = ContentTypes.TEXT_JAVASCRIPT;

		String firstModulePath =
			(String)request.getParameterNames().nextElement();

		String extension = FileUtil.getExtension(firstModulePath);

		if (extension.equalsIgnoreCase(_CSS_EXTENSION)) {
			contentType = ContentTypes.TEXT_CSS;
		}

		response.setContentType(contentType);

		ServletResponseUtil.write(response, bytesArray);
	}

	protected File getFile(String path) throws IOException {
		ServletContext servletContext = getServletContext();

		String basePath = ServletContextUtil.getRealPath(
			servletContext, _JAVASCRIPT_DIR);

		if (basePath == null) {
			return null;
		}

		basePath = StringUtil.replace(
			basePath, StringPool.BACK_SLASH, StringPool.SLASH);

		File baseDir = new File(basePath);

		if (!baseDir.exists()) {
			return null;
		}

		String filePath = ServletContextUtil.getRealPath(servletContext, path);

		if (filePath == null) {
			return null;
		}

		filePath = StringUtil.replace(
			filePath, StringPool.BACK_SLASH, StringPool.SLASH);

		File file = new File(filePath);

		if (!file.exists()) {
			return null;
		}

		String baseCanonicalPath = baseDir.getCanonicalPath();
		String fileCanonicalPath = file.getCanonicalPath();

		if (fileCanonicalPath.indexOf(baseCanonicalPath) == 0) {
			return file;
		}

		return null;
	}

	private byte[] getFileContent(String path, String minifierType)
		throws IOException {

		byte[] fileContent = _fileContentMap.get(path);

		if (fileContent == null) {
			File file = getFile(path);
			if (file == null) {
				fileContent = _EMPTY_FILE_CONTENT;
			}
			else {
				String stringFileContent = FileUtil.read(file);
				if (minifierType.equals("css")) {
					stringFileContent = MinifierUtil.minifyCss(
						stringFileContent);
				}
				else if (minifierType.equals("js")) {
					stringFileContent = MinifierUtil.minifyJavaScript(
						stringFileContent);
				}
				fileContent = stringFileContent.getBytes(StringPool.UTF8);
			}

			byte[] oldFileContent =
				_fileContentMap.putIfAbsent(path, fileContent);
			if (oldFileContent != null) {
				fileContent = oldFileContent;
			}
		}

		return fileContent;
	}

	private static final String _CSS_EXTENSION = "css";

	private static final byte[] _EMPTY_FILE_CONTENT = new byte[0];

	private static final String _JAVASCRIPT_DIR = "html/js";

	private ConcurrentMap<String, byte[]> _fileContentMap =
		new ConcurrentHashMap<String, byte[]>();

}