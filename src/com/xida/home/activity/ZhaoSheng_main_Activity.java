/**
 * 
 */
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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xida.home.R;

/**
 * @author ving
 * 
 */
public class ZhaoSheng_main_Activity extends Activity {
	private GridView grid;
	private List<Map<String, Object>> mData;
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_xida_main_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("关于西大");
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
				// String info = null;
				switch (key) {
				// 2012年招生总计划

				case 0:
					intent = new Intent();
					intent.putExtra("weburl", "http://zs.gxu.edu.cn/2012jh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);
					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012年区外招生计划
				case 1:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012qwjh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012年国防生计划
				case 2:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012gfs.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011年招生总计划
				case 3:
					intent = new Intent();
					intent.putExtra("weburl", "http://zs.gxu.edu.cn/2011jh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011年区外招生计划
				case 4:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011qwjh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012年区内录取统计
				case 5:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012年分省录取分数线
				case 6:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012shx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011年区内录取统计
				case 7:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011年分省录取分数线
				case 8:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011shx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2010年区内录取统计
				case 9:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2010qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2010年分省录取分数线
				case 10:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2010shx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				default:
					break;
				}
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 2012年招生总计划
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "2012年招生总计划");
		map.put("img", R.drawable.list_icon_33);
		list.add(map);
		// 2012年区外招生计划
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", " 2012年区外招生计划");
		map2.put("img", R.drawable.list_icon_34);
		list.add(map2);
		// 2012年国防生计划
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "2012年国防生计划");
		map3.put("img", R.drawable.list_icon_35);
		list.add(map3);
		// 2011年招生总计划
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "2011年招生总计划");
		map4.put("img", R.drawable.list_icon_36);
		list.add(map4);
		// 2011年区外招生计划
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", " 2011年区外招生计划");
		map5.put("img", R.drawable.list_icon_38);
		list.add(map5);
		// 2012年区内录取统计
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "2012年区内录取统计");
		map6.put("img", R.drawable.list_icon_39);
		list.add(map6);
		// 2012年分省录取分数线
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", "2012年分省录取分数线");
		map7.put("img", R.drawable.list_icon_40);
		list.add(map7);
		// 广西大学2011年区内录取情况统计
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", "2011年区内录取情况");
		map8.put("img", R.drawable.list_icon_41);
		list.add(map8);
		// 广西大学2011年分省录取分数线
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", "2011年分省录取分数线");
		map9.put("img", R.drawable.list_icon_42);
		list.add(map9);
		// 广西大学2010年区内录取情况统计
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", "2010年区内录取情况");
		map10.put("img", R.drawable.list_icon_43);
		list.add(map10);
		// 广西大学2010年分省录取分数线
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", "2010年分省录取分数线");
		map11.put("img", R.drawable.list_icon_25);
		list.add(map11);
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
