/**
 * 
 */
package com.xida.home.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.entity.LibNewsTitle;
import com.xida.home.jsoup.ParseLibNews;

/**
 * @author ving
 * 
 */
public class LibNews_list_Activity extends Activity {

	// 装新闻的列表
	private ListView newslist;
	// 底部的导航
	private LinearLayout bottom_home_layout, bottom_news_layout,
			bottom_about_xiada_layout, bottom_lib_news_layout,
			bottom_about_us_layout;
	private TextView news_detail_head_title;
	// 进度条
	private ProgressDialog progressDialog;

	private ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.libnews_list_layout);

		bottom_home_layout = (LinearLayout) this
				.findViewById(R.id.bottom_home_layout);
		bottom_news_layout = (LinearLayout) this
				.findViewById(R.id.bottom_news_layout);
		bottom_about_xiada_layout = (LinearLayout) this
				.findViewById(R.id.bottom_about_xiada_layout);
		bottom_lib_news_layout = (LinearLayout) this
				.findViewById(R.id.bottom_lib_news_layout);
		bottom_about_us_layout = (LinearLayout) this
				.findViewById(R.id.bottom_about_us_layout);
		bottom_lib_news_layout.setOnClickListener(clickListener_libnews);
		bottom_home_layout.setOnClickListener(clickListener_home);
		bottom_news_layout.setOnClickListener(clickListener_news);
		bottom_about_xiada_layout.setOnClickListener(clickListener_about_xida);
		bottom_about_us_layout.setOnClickListener(clickListener_us);

		news_detail_head_title = (TextView) this
				.findViewById(R.id.news_detail_head_title);
		news_detail_head_title.setText("图书馆通知");
		bottom_lib_news_layout = (LinearLayout) this
				.findViewById(R.id.bottom_lib_news_layout);
		bottom_lib_news_layout.setSelected(true);
		newslist = (ListView) this.findViewById(R.id.news_list);
		// 加载数据
		initi();
		newslist.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url = (String) listItem.get(arg2).get("NewsUrl");
				String title = (String) listItem.get(arg2).get("ItemText");
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						LibNews_Content_Activity.class);
				intent.putExtra("url", url);
				intent.putExtra("title", title);

				LibNews_list_Activity.this.startActivity(intent);
			}
		});
	}

	private OnClickListener clickListener_libnews = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bottom_about_xiada_layout.setSelected(false);
			bottom_home_layout.setSelected(false);
			bottom_news_layout.setSelected(false);
			bottom_lib_news_layout.setSelected(true);
			bottom_about_us_layout.setSelected(false);
			Intent intent = new Intent();
			intent.setClass(LibNews_list_Activity.this,
					LibNews_list_Activity.class);
			LibNews_list_Activity.this.startActivity(intent);
		}
	};

	private OnClickListener clickListener_home = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bottom_about_xiada_layout.setSelected(false);
			bottom_home_layout.setSelected(true);
			bottom_news_layout.setSelected(false);
			bottom_lib_news_layout.setSelected(false);
			bottom_about_us_layout.setSelected(false);
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), Main.class);
			LibNews_list_Activity.this.startActivity(intent);
		}
	};
	// 校园动态
	private OnClickListener clickListener_news = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bottom_home_layout.setSelected(false);
			bottom_news_layout.setSelected(true);
			bottom_about_xiada_layout.setSelected(false);
			bottom_lib_news_layout.setSelected(false);
			bottom_about_us_layout.setSelected(false);

			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), News_List_Activity.class);
			LibNews_list_Activity.this.startActivity(intent);
		}
	};
	// 关于西大
	private OnClickListener clickListener_about_xida = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bottom_about_xiada_layout.setSelected(true);
			bottom_home_layout.setSelected(false);
			bottom_news_layout.setSelected(false);
			bottom_lib_news_layout.setSelected(false);
			bottom_about_us_layout.setSelected(false);

			Intent intent = new Intent();
			intent.setClass(getApplicationContext(),
					About_Xida_main_Activity.class);
			LibNews_list_Activity.this.startActivity(intent);
		}
	};
	// 关于我们
	private OnClickListener clickListener_us = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bottom_about_xiada_layout.setSelected(false);
			bottom_home_layout.setSelected(false);
			bottom_news_layout.setSelected(false);
			bottom_lib_news_layout.setSelected(false);
			bottom_about_us_layout.setSelected(true);
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), About_us_Activity.class);
			LibNews_list_Activity.this.startActivity(intent);
		}
	};

	public void initi() {
		String url = "http://www.lib.gxu.edu.cn/content/newslist.asp";
		listItem = getItems(url);
		SimpleAdapter listItemAdapter = new SimpleAdapter(
				LibNews_list_Activity.this, listItem,// 数据源
				R.layout.news_list_item,// ListItem的XML实现
				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemTitle", "ItemText" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
		newslist.setAdapter(listItemAdapter);

	}

	// 获取数据 项 的函数
	public ArrayList<HashMap<String, Object>> getItems(String url) {
		ArrayList<HashMap<String, Object>> myItems = new ArrayList<HashMap<String, Object>>();
		myThread titleThread = new myThread();
		titleThread.execute(url);
		try {
			List<LibNewsTitle> titels = titleThread.get();
			for (LibNewsTitle news : titels) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("ItemImage", R.drawable.go);// 图像资源的ID
				map.put("ItemTitle", "通知");
				map.put("ItemText", news.getTitle());
				map.put("NewsUrl", news.getUrl());
				myItems.add(map);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myItems;
	}

	public class myThread extends
			AsyncTask<String, Integer, List<LibNewsTitle>> {
		@Override
		protected List<LibNewsTitle> doInBackground(String... params) {
			// TODO Auto-generated method stub

			ParseLibNews newstitle = new ParseLibNews();
			List<LibNewsTitle> list = null;
			try {
				list = newstitle.parseLibNewsTitle(params[0]);
				Log.i("newstitle", list.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progressDialog.cancel();
			return list;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progressDialog = new ProgressDialog(LibNews_list_Activity.this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.show();
			super.onPreExecute();
		}

	}
}
