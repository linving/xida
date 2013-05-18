/**
 * 
 */
package com.xida.home.activity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.entity.LibNews;
import com.xida.home.jsoup.ParseLibNews;

/**
 * @author ving
 * 
 */
public class LibNews_Content_Activity extends Activity {
	String url, title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_content_layout);
		TextView news_title, news_content;
		Button yuan_web;
		// String url, title;
		news_title = (TextView) this.findViewById(R.id.news_title);
		news_content = (TextView) this.findViewById(R.id.news_content);

		yuan_web = (Button) this.findViewById(R.id.yuan_web);

		Intent intent = getIntent();
		url = intent.getStringExtra("url");
		title = intent.getStringExtra("title");
		news_title.setText(title);
		newsThread thread = new newsThread();
		thread.execute(url);
		LibNews news = null;
		try {
			news = thread.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (news.getContent().isEmpty()) {
			news_content.setText("本页解析有错，请打开原网页浏览！");
		} else {
			news_content.setText(news.getContent());
		}

		yuan_web.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LibNews_Content_Activity.this, My_WebView.class);
				intent.putExtra("weburl", url);
				LibNews_Content_Activity.this.startActivity(intent);
			}
		});
	}

	private class newsThread extends AsyncTask<String, Integer, LibNews> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.os.AsyncTask#doInBackground(Params[])
		 */
		private LibNews news;

		@Override
		protected LibNews doInBackground(String... params) {
			// TODO Auto-generated method stub
			ParseLibNews parse = new ParseLibNews();
			try {
				news = parse.getNewsContent(params[0]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return news;
		}

	}
}
