/**
 * 
 */
package com.xida.home.entity;

/**
 * @author ving
 * 
 */
public class LibNews {
	// ����
	private String title;
	// ����
	private String content;
	// ��ַ
	private String url;

	@Override
	public String toString() {
		return "LibNews [title=" + title + ", content=" + content + ", url="
				+ url + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
