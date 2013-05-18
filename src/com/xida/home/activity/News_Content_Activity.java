package com.xida.home.activity;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.entity.News;
import com.xida.home.jsoup.ParseNews;

/*
 点击新闻列表 后调到的 新闻详细内容 的 界面（Activity）

 */
public class News_Content_Activity extends Activity {
	// 头上的新闻标题，和新闻的具体内容
	private TextView news_title, news_content;
	// 点击调到 新闻的 原页面
	private Button yuan_web;
	// 进度条
	private ProgressDialog progressDialog;
	// 跳转地址
	String weburl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		// 新闻的 原页面地址
		final String url = intent.getStringExtra("newsurl");
		/*
		 * Toast.makeText(getApplicationContext(), url,
		 * Toast.LENGTH_SHORT).show();
		 */
		setContentView(R.layout.news_content_layout);
		yuan_web = (Button) this.findViewById(R.id.yuan_web);
		news_title = (TextView) this.findViewById(R.id.news_title);
		news_content = (TextView) this.findViewById(R.id.news_content);
		String title = "News";
		String content = "News Contnet";
		// 异步类 并 封装了解析 html 后 的内容 传人 新闻的 地址（url） 后 通过 get();返回 News 这个实体类
		// 当然这个 地址一定要是 西大新闻 http://news.gxu.edu.cn/ 某条新闻的地址才能解析出来新闻的内容
		// 其他的地址估计会没有内容或者是乱的内容，这里都不太能保证解析出来正确的新闻内容，因为西大的新闻的html 结构太复杂了
		MyNewsThread myNewsThread = new MyNewsThread();
		// 传人地址
		myNewsThread.execute(url);
		// 新闻
		News mynews = new News();
		try {
			// 给新闻内容
			mynews = myNewsThread.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		title = mynews.getNewTitle();
		content = mynews.getNewContent();
		// 标题
		news_title.setText(title);
		// 具体内容
		news_content.setText(content);
		weburl = mynews.getNewurl();
		yuan_web.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(News_Content_Activity.this, My_WebView.class);
				intent.putExtra("weburl", weburl);
				News_Content_Activity.this.startActivity(intent);
			}
		});

	}

	// 异步类
	public class MyNewsThread extends AsyncTask<String, Integer, News> {

		@Override
		protected News doInBackground(String... params) {
			// TODO Auto-generated method stub
			News news = new News();
			ParseNews parse = new ParseNews();
			try {
				news = parse.getNewsContent(params[0]);
				Log.i("XXXXXX", news.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressDialog.cancel();
			return news;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progressDialog = new ProgressDialog(News_Content_Activity.this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.show();
			super.onPreExecute();
		}

	}
}
