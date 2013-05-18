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

import com.xida.home.entity.News;
import com.xida.home.entity.NewsTitel;

/*
 Jsoup �Լ������������ ��װ
 �������ֻ����磨2G �� �Ļ� 
 java.net ���ӳ�ʱ
 ����Ӧ�� ֱ�� �ҵ�
 */
public class ParseNews {

	// ���ص����� �����γɱ����б������б�

	public List<NewsTitel> parseNewsTitle(String url) throws IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				entity.getContent(), "utf-8"));

		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = r.readLine()) != null) {
			sb.append(s);
		}
		Document doc1 = Jsoup.parse(sb.toString());
		List<NewsTitel> titelList = new ArrayList<NewsTitel>();
		// Document doc = Jsoup.connect(url).get();
		Element body = doc1.body();
		// ��ʾ�����title ��<a>
		Elements aHaveHref = body.select("a[title]");
		for (Element e : aHaveHref) {
			NewsTitel newTitel = new NewsTitel();
			String linkHref = e.attr("href");
			String linkTitel = e.text();
			newTitel.setNewsurl(linkHref);
			newTitel.setNewstitel(linkTitel);
			titelList.add(newTitel);
		}
		return titelList;

	}

	// ͨ��URL��ȡ ���ŵ� ��������
	public News getNewsContent(String url) throws IOException {
		News news = new News();
		// Document doc = Jsoup.connect(url).get();

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				entity.getContent(), "utf-8"));
		String s;
		StringBuffer sb1 = new StringBuffer();
		while ((s = r.readLine()) != null) {
			sb1.append(s);
		}
		// �����Ǿ�������html �Ľṹ��ȡ �������� ������
		Document doc = Jsoup.parse(sb1.toString());
		Element body = doc.body();
		Elements head = body.getElementsByTag("h1");
		String newsTitle = head.text();
		Elements spanTag = body.getElementsByTag("span");
		String newsContent = null;
		StringBuffer sb = new StringBuffer();
		for (Element e : spanTag) {
			// newsContent = e.ownText();
			// newsContent = e.text();
			sb.append(newsContent = e.ownText());
			Log.i("spanTagspanTagspanTag", e.toString());
		}
		newsContent = sb.toString();
		news.setNewContent(newsContent);
		news.setNewTitle(newsTitle);
		news.setNewurl(url);
		return news;
	}

}
