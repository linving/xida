/**
 * 
 */
package com.xida.home.jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.xida.home.entity.LibNews;
import com.xida.home.entity.LibNewsTitle;

/**
 * @author ving
 * 
 */
public class ParseLibNews {
	// 获取图书馆新闻的标题
	public List<LibNewsTitle> parseLibNewsTitle(String url) throws IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				entity.getContent(), "gbk"));
		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = r.readLine()) != null) {
			sb.append(s);
		}
		Document doc = Jsoup.parse(sb.toString());
		Log.i("XXXXXXXXXXXX", doc.toString());
		Element body = doc.body();
		Elements trTag = body.getElementsByClass("channel");
		Elements target = trTag.select("a[target]");
		List<LibNewsTitle> listTitle = new ArrayList<LibNewsTitle>();
		for (Element e : target) {
			LibNewsTitle newsTitle = new LibNewsTitle();
			String linkHref = e.attr("href");
			String linkText = e.text();
			newsTitle.setTitle(linkText);
			newsTitle.setUrl("http://www.lib.gxu.edu.cn/content/" + linkHref);
			listTitle.add(newsTitle);
			// System.out.println("http://www.lib.gxu.edu.cn/content/"+linkHref);
			// System.out.println("文字  "+linkText);
		}
		return listTitle;
	}

	// 通过URL获取 新闻的 具体内容
	public LibNews getNewsContent(String url) throws IOException {
		LibNews news = new LibNews();

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				entity.getContent(), "gbk"));
		String s;
		StringBuffer sb1 = new StringBuffer();
		while ((s = r.readLine()) != null) {
			sb1.append(s);
		}
		// 下面是经过新闻html 的结构获取 解析新闻 的内容
		Document doc = Jsoup.parse(sb1.toString());
		Element body = doc.body();
		Log.i("XXXXXXXXXXXXXXXXXXX", body.toString());
		String bodyTxet = body.toString().replace("&nbsp;", "");
		doc = Jsoup.parse(bodyTxet);
		StringBuffer sb = new StringBuffer();
		Elements divTag = doc.getElementsByTag("div");
		Elements pTag = doc.getElementsByTag("p");
		Elements fontTag = doc.getElementsByTag("font");
		for (Element e : pTag) {
			String linkText = e.ownText();
			sb.append(linkText);
		}
		for (Element e : fontTag) {
			String linkText = e.ownText();
			sb.append(linkText);
		}
		for (Element e : divTag) {
			String contents = e.ownText();
			sb.append(contents);
		}
		news.setContent(sb.toString());
		news.setUrl(url);
		return news;
	}
}
