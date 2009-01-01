/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.wiki.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="WikiPageSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.wiki.service.http.WikiPageServiceSoap</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.wiki.service.http.WikiPageServiceSoap
 *
 */
public class WikiPageSoap implements Serializable {
	public static WikiPageSoap toSoapModel(WikiPage model) {
		WikiPageSoap soapModel = new WikiPageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPageId(model.getPageId());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNodeId(model.getNodeId());
		soapModel.setTitle(model.getTitle());
		soapModel.setVersion(model.getVersion());
		soapModel.setMinorEdit(model.getMinorEdit());
		soapModel.setContent(model.getContent());
		soapModel.setSummary(model.getSummary());
		soapModel.setFormat(model.getFormat());
		soapModel.setHead(model.getHead());
		soapModel.setParentTitle(model.getParentTitle());
		soapModel.setRedirectTitle(model.getRedirectTitle());

		return soapModel;
	}

	public static WikiPageSoap[] toSoapModels(List<WikiPage> models) {
		List<WikiPageSoap> soapModels = new ArrayList<WikiPageSoap>(models.size());

		for (WikiPage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WikiPageSoap[soapModels.size()]);
	}

	public WikiPageSoap() {
	}

	public long getPrimaryKey() {
		return _pageId;
	}

	public void setPrimaryKey(long pk) {
		setPageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}

	public boolean getMinorEdit() {
		return _minorEdit;
	}

	public boolean isMinorEdit() {
		return _minorEdit;
	}

	public void setMinorEdit(boolean minorEdit) {
		_minorEdit = minorEdit;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getFormat() {
		return _format;
	}

	public void setFormat(String format) {
		_format = format;
	}

	public boolean getHead() {
		return _head;
	}

	public boolean isHead() {
		return _head;
	}

	public void setHead(boolean head) {
		_head = head;
	}

	public String getParentTitle() {
		return _parentTitle;
	}

	public void setParentTitle(String parentTitle) {
		_parentTitle = parentTitle;
	}

	public String getRedirectTitle() {
		return _redirectTitle;
	}

	public void setRedirectTitle(String redirectTitle) {
		_redirectTitle = redirectTitle;
	}

	private String _uuid;
	private long _pageId;
	private long _resourcePrimKey;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _nodeId;
	private String _title;
	private double _version;
	private boolean _minorEdit;
	private String _content;
	private String _summary;
	private String _format;
	private boolean _head;
	private String _parentTitle;
	private String _redirectTitle;
}