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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xida.home.R;
import com.xida.home.entity.NewsTitel;
import com.xida.home.jsoup.ParseNews;

public class News_List_Activity extends Activity {
	//
	private Button news_xiaoyuanyaoxun, news_xidaxueren, news_zhongyaozixun,
			news_chengcaixida;
	// ��Ӧ��������
	private SimpleAdapter xaioyuanyaoxun_a, xidaxueren_a, zhongyaozixun_a,
			chengcaixida_a;
	// װ���ŵ��б�
	private ListView newslist;
	// ���µĵ�����
	// �ײ��ĵ���
	private LinearLayout bottom_home_layout, bottom_news_layout,
			bottom_about_xiada_layout, bottom_lib_news_layout,
			bottom_about_us_layout;
	private ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
	// ������
	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_lsit_layout);
		// У԰��Ѷ�İ�ť
		news_xiaoyuanyaoxun = (Button) this
				.findViewById(R.id.news_xiaoyuanyaoxun);
		news_xiaoyuanyaoxun.setOnClickListener(xiaoyuanyaoxun_onclick);
		// ����ѧ�˵İ�ť
		news_xidaxueren = (Button) this.findViewById(R.id.news_xidaxueren);
		news_xidaxueren.setOnClickListener(xidaxueren_onclick);
		// ��Ҫ��Ѷ�İ�ť
		news_zhongyaozixun = (Button) this
				.findViewById(R.id.news_zhongyaozixun);
		news_zhongyaozixun.setOnClickListener(zhongyaozixun_onclick);
		// �ɲ�����İ�ť
		news_chengcaixida = (Button) this.findViewById(R.id.news_chengcaixida);
		news_chengcaixida.setOnClickListener(chengcaixida_onclick);

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
		bottom_news_layout.setSelected(true);
		newslist = (ListView) this.findViewById(R.id.news_list);

		// ��ʼ������
		initi();
		newslist.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url = (String) listItem.get(arg2).get("NewsUrl");
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(),
						News_Content_Activity.class);
				intent.putExtra("newsurl", url);
				News_List_Activity.this.startActivity(intent);
			}
		});
	}

	// У԰��Ѷ �ļ���
	private OnClickListener xiaoyuanyaoxun_onclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String url = "http://news.gxu.edu.cn/xykx/";
			listItem = getItems(url);
			xaioyuanyaoxun_a = new SimpleAdapter(News_List_Activity.this,
					listItem,// ����Դ
					R.layout.news_list_item,// ListItem��XMLʵ��
					// ��̬������ImageItem��Ӧ������
					new String[] { "ItemImage", "ItemTitle", "ItemText" },
					// ImageItem��XML�ļ������һ��ImageView,����TextView ID
					new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
			newslist.setAdapter(xaioyuanyaoxun_a);
			news_xiaoyuanyaoxun.setSelected(true);
			news_xidaxueren.setSelected(false);
			news_zhongyaozixun.setSelected(false);
			news_chengcaixida.setSelected(false);

		}
	};

	// ����ѧ�˵� ����
	private OnClickListener xidaxueren_onclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			String url = "http://news.gxu.edu.cn/xdxr/";
			listItem = getItems(url);
			xidaxueren_a = new SimpleAdapter(News_List_Activity.this, listItem,// ����Դ
					R.layout.news_list_item,// ListItem��XMLʵ��
					// ��̬������ImageItem��Ӧ������
					new String[] { "ItemImage", "ItemTitle", "ItemText" },
					// ImageItem��XML�ļ������һ��ImageView,����TextView ID
					new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
			newslist.setAdapter(xidaxueren_a);
			news_xidaxueren.setSelected(true);
			news_xiaoyuanyaoxun.setSelected(false);
			news_zhongyaozixun.setSelected(false);
			news_chengcaixida.setSelected(false);

		}
	};
	// ��Ҫ��Ѷ�� ����
	private OnClickListener zhongyaozixun_onclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String url = "http://news.gxu.edu.cn/zyzx/";
			listItem = getItems(url);
			zhongyaozixun_a = new SimpleAdapter(News_List_Activity.this,
					listItem,// ����Դ
					R.layout.news_list_item,// ListItem��XMLʵ��
					// ��̬������ImageItem��Ӧ������
					new String[] { "ItemImage", "ItemTitle", "ItemText" },
					// ImageItem��XML�ļ������һ��ImageView,����TextView ID
					new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
			newslist.setAdapter(zhongyaozixun_a);
			news_xidaxueren.setSelected(false);
			news_xiaoyuanyaoxun.setSelected(false);
			news_zhongyaozixun.setSelected(true);
			news_chengcaixida.setSelected(false);

		}
	};
	// �ɲ����� ����
	private OnClickListener chengcaixida_onclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String url = "http://news.gxu.edu.cn/ccxd/";
			listItem = getItems(url);
			chengcaixida_a = new SimpleAdapter(News_List_Activity.this,
					listItem,// ����Դ
					R.layout.news_list_item,// ListItem��XMLʵ��
					// ��̬������ImageItem��Ӧ������
					new String[] { "ItemImage", "ItemTitle", "ItemText" },
					// ImageItem��XML�ļ������һ��ImageView,����TextView ID
					new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
			newslist.setAdapter(chengcaixida_a);
			news_xidaxueren.setSelected(false);
			news_xiaoyuanyaoxun.setSelected(false);
			news_zhongyaozixun.setSelected(false);
			news_chengcaixida.setSelected(true);

		}
	};

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
			intent.setClass(News_List_Activity.this,
					LibNews_list_Activity.class);
			News_List_Activity.this.startActivity(intent);
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
			News_List_Activity.this.startActivity(intent);
		}
	};
	// У԰��̬
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
			News_List_Activity.this.startActivity(intent);
		}
	};
	// ��������
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
			News_List_Activity.this.startActivity(intent);
		}
	};
	// ��������
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
			News_List_Activity.this.startActivity(intent);
		}
	};

	// ��ȡ���� �� �ĺ���
	public ArrayList<HashMap<String, Object>> getItems(String url) {
		ArrayList<HashMap<String, Object>> myItems = new ArrayList<HashMap<String, Object>>();
		myThread titleThread = new myThread();
		titleThread.execute(url);
		try {
			List<NewsTitel> titels = titleThread.get();
			for (NewsTitel news : titels) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("ItemImage", R.drawable.go);// ͼ����Դ��ID
				map.put("ItemTitle", "���ű��� ");
				map.put("ItemText", news.getNewstitel());
				map.put("NewsUrl", news.getNewsurl());
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

	public class myThread extends AsyncTask<String, Integer, List<NewsTitel>> {
		@Override
		protected List<NewsTitel> doInBackground(String... params) {
			// TODO Auto-generated method stub

			ParseNews newstitle = new ParseNews();
			List<NewsTitel> list = null;
			try {
				list = newstitle.parseNewsTitle(params[0]);
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
			progressDialog = new ProgressDialog(News_List_Activity.this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			progressDialog.show();
			super.onPreExecute();
		}
	}

	public void initi() {
		String url = "http://news.gxu.edu.cn/xykx/";
		listItem = getItems(url);
		SimpleAdapter listItemAdapter = new SimpleAdapter(
				News_List_Activity.this, listItem,// ����Դ
				R.layout.news_list_item,// ListItem��XMLʵ��
				// ��̬������ImageItem��Ӧ������
				new String[] { "ItemImage", "ItemTitle", "ItemText" },
				// ImageItem��XML�ļ������һ��ImageView,����TextView ID
				new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
		newslist.setAdapter(listItemAdapter);
		news_xiaoyuanyaoxun.setSelected(true);
		news_xidaxueren.setSelected(false);
	}

}
