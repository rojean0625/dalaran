package com.dalaran.model;

public class PageInfo extends BaseVO {

	private static final long serialVersionUID = 491145146763889415L;
	private String pageId;
	private String bordId;
	private String titleInfo;
	private String contentInfo;


	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getBordId() {
		return bordId;
	}
	public void setBordId(String bordId) {
		this.bordId = bordId;
	}
	public String getContentInfo() {
		return contentInfo;
	}
	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}
	public String getTitleInfo() {
		return titleInfo;
	}
	public void setTitleInfo(String titleInfo) {
		this.titleInfo = titleInfo;
	}
}
