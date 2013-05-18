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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xida.home.R;

/*
 @Author
 */
public class About_Xida_main_Activity extends Activity {
	private GridView grid;
	private List<Map<String, Object>> mData;
	private TextView head_title;
	private ImageView back_home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_xida_main_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("关于西大");
		grid = (GridView) findViewById(R.id.gridview);
		back_home = (ImageView) this.findViewById(R.id.back_home);
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
				// 西大简介
				case 0:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							IntroductionOfXiDa_Activity.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				// 现任领导
				case 1:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							LeaderOfXida_main_Activity.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				// 学院专业
				case 2:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							List_colleges_Activity.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				// 西大风景
				case 3:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Scene_of_xida_Activity.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				// 文件系统
				case 4:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.putExtra("weburl", "http://wjxt.gxu.edu.cn/");
					intent.setClass(getApplicationContext(),
							WebViewFor_FileSystem.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				case 5:
					info = (String) mData.get(arg2).get("info");
					Toast.makeText(getApplicationContext(), info,
							Toast.LENGTH_SHORT).show();
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							ZhaoSheng_main_Activity.class);
					About_Xida_main_Activity.this.startActivity(intent);
					break;
				default:
					break;
				}
			}
		});

		back_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), Main.class);
				About_Xida_main_Activity.this.startActivity(intent);

			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "西大简介");
		map.put("img", R.drawable.list_icon_03);
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "现任领导");
		map2.put("img", R.drawable.list_icon_04);
		list.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "学院专业");
		map3.put("img", R.drawable.list_icon_05);
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "西大风景");
		map4.put("img", R.drawable.list_icon_11);
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "广西大学文件系统");
		map5.put("img", R.drawable.list_icon_10);
		list.add(map5);
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "招生计划 ");
		map6.put("img", R.drawable.list_icon_09);
		list.add(map6);
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", "办公电话");
		map7.put("img", R.drawable.list_icon_12);
		list.add(map7);
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
