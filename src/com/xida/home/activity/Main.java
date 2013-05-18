package com.xida.home.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.xida.home.R;

public class Main extends Activity {
	// �ײ��ĵ���
	private LinearLayout bottom_home_layout, bottom_news_layout,
			bottom_about_xiada_layout, bottom_lib_news_layout,
			bottom_about_us_layout;
	// ���񲼾�
	private GridView grid;
	private List<Map<String, Object>> mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

		// GridView
		grid = (GridView) findViewById(R.id.gridview);
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int key = arg2;
				Intent intent;
				String info = null;
				switch (key) {
				// У԰��̬
				case 0:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							News_List_Activity.class);
					Main.this.startActivity(intent);
					break;
				// ͼ���֪ͨ
				case 1:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							LibNews_list_Activity.class);
					Main.this.startActivity(intent);
					break;
				// ѧԺרҵ
				case 2:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							List_colleges_Activity.class);
					Main.this.startActivity(intent);
					break;
				// ��������̳�������棩
				case 3:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.putExtra("weburl",
							"http://bbs.newgxu.cn/ng/m/do_login");
					intent.setClass(getApplicationContext(), My_WebView.class);
					Main.this.startActivity(intent);
					break;
				// ��������
				case 4:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							About_Xida_main_Activity.class);
					Main.this.startActivity(intent);
					break;
				// ��������
				case 5:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					/*
					 * intent = new Intent();
					 * intent.setClass(getApplicationContext(),
					 * ZhaoSheng_main_Activity.class);
					 * Main.this.startActivity(intent);
					 */
					break;
				default:
					break;
				}
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
			intent.setClass(Main.this, LibNews_list_Activity.class);
			Main.this.startActivity(intent);
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
			Main.this.startActivity(intent);
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
			Main.this.startActivity(intent);
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
			intent.setClass(getApplicationContext(),
					About_us_Activity.class);
			Main.this.startActivity(intent);
		}
	};

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "У԰��̬");
		map.put("img", R.drawable.about_xida_img_icon);
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "ͼ���֪ͨ");
		map2.put("img", R.drawable.list_icon_32);
		list.add(map2);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "ѧԺ����");
		map5.put("img", R.drawable.list_icon_31);
		list.add(map5);
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "��������̳");
		map6.put("img", R.drawable.list_icon_08);
		list.add(map6);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "��������");
		map3.put("img", R.drawable.list_icon_07);
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "��������");
		map4.put("img", R.drawable.list_icon_06);
		list.add(map4);
		return list;
	}

	private class GridViewAdapter extends BaseAdapter {
		private LayoutInflater mInflater;

		public GridViewAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			convertView = mInflater.inflate(R.layout.gridview_item_ly, null);
			ImageView img = (ImageView) convertView
					.findViewById(R.id.grid_view_img);
			TextView tx = (TextView) convertView
					.findViewById(R.id.grid_view_text);
			tx.setText((String) mData.get(position).get("info"));
			img.setBackgroundResource((Integer) mData.get(position).get("img"));
			return convertView;
		}
	}
}
