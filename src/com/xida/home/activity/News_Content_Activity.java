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
 ��������б� ������� ������ϸ���� �� ���棨Activity��

 */
public class News_Content_Activity extends Activity {
	// ͷ�ϵ����ű��⣬�����ŵľ�������
	private TextView news_title, news_content;
	// ������� ���ŵ� ԭҳ��
	private Button yuan_web;
	// ������
	private ProgressDialog progressDialog;
	// ��ת��ַ
	String weburl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		// ���ŵ� ԭҳ���ַ
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
		// �첽�� �� ��װ�˽��� html �� ������ ���� ���ŵ� ��ַ��url�� �� ͨ�� get();���� News ���ʵ����
		// ��Ȼ��� ��ַһ��Ҫ�� �������� http://news.gxu.edu.cn/ ĳ�����ŵĵ�ַ���ܽ����������ŵ�����
		// �����ĵ�ַ���ƻ�û�����ݻ������ҵ����ݣ����ﶼ��̫�ܱ�֤����������ȷ���������ݣ���Ϊ��������ŵ�html �ṹ̫������
		MyNewsThread myNewsThread = new MyNewsThread();
		// ���˵�ַ
		myNewsThread.execute(url);
		// ����
		News mynews = new News();
		try {
			// ����������
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
		// ����
		news_title.setText(title);
		// ��������
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

	// �첽��
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
