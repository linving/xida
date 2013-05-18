package com.xida.home.entity;

//某条新闻的 内容实体类
public class NewsTitel {
	private String newstitel;
	private String newsurl;

	public String getNewstitel() {
		return newstitel;
	}

	public void setNewstitel(String newstitel) {
		this.newstitel = newstitel;
	}

	public String getNewsurl() {
		return newsurl;
	}

	public void setNewsurl(String newsurl) {
		this.newsurl = newsurl;
	}

	@Override
	public String toString() {
		return "NewsTitel [newstitel=" + newstitel + ", newsurl=" + newsurl
				+ "]";
	}

}
