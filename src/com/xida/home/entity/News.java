package com.xida.home.entity;

//新闻列表 的实体类
public class News {
	private String newTitle;
	private String newContent;
	private String newurl;

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public String getNewurl() {
		return newurl;
	}

	public void setNewurl(String newurl) {
		this.newurl = newurl;
	}

	@Override
	public String toString() {
		return "News [newTitle=" + newTitle + ", newContent=" + newContent
				+ ", newurl=" + newurl + "]";
	}

}
