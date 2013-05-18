/**
 * 
 */
package com.xida.home.entity;

/**
 * @author ving
 * 
 */
public class LibNewsTitle {

	private String title;

	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "LibNewsTitle [title=" + title + ", url=" + url + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
