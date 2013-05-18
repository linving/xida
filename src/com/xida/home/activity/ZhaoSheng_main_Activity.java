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
		head_title.setText("��������");
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
				// 2012�������ܼƻ�

				case 0:
					intent = new Intent();
					intent.putExtra("weburl", "http://zs.gxu.edu.cn/2012jh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);
					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012�����������ƻ�
				case 1:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012qwjh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012��������ƻ�
				case 2:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012gfs.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011�������ܼƻ�
				case 3:
					intent = new Intent();
					intent.putExtra("weburl", "http://zs.gxu.edu.cn/2011jh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011�����������ƻ�
				case 4:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011qwjh.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012������¼ȡͳ��
				case 5:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2012���ʡ¼ȡ������
				case 6:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2012shx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011������¼ȡͳ��
				case 7:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2011���ʡ¼ȡ������
				case 8:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2011shx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2010������¼ȡͳ��
				case 9:
					intent = new Intent();
					intent.putExtra("weburl",
							"http://zs.gxu.edu.cn/2010qnshx.htm");
					intent.setClass(getApplicationContext(), My_WebView.class);

					ZhaoSheng_main_Activity.this.startActivity(intent);
					break;
				// 2010���ʡ¼ȡ������
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
		// 2012�������ܼƻ�
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "2012�������ܼƻ�");
		map.put("img", R.drawable.list_icon_33);
		list.add(map);
		// 2012�����������ƻ�
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", " 2012�����������ƻ�");
		map2.put("img", R.drawable.list_icon_34);
		list.add(map2);
		// 2012��������ƻ�
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "2012��������ƻ�");
		map3.put("img", R.drawable.list_icon_35);
		list.add(map3);
		// 2011�������ܼƻ�
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "2011�������ܼƻ�");
		map4.put("img", R.drawable.list_icon_36);
		list.add(map4);
		// 2011�����������ƻ�
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", " 2011�����������ƻ�");
		map5.put("img", R.drawable.list_icon_38);
		list.add(map5);
		// 2012������¼ȡͳ��
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "2012������¼ȡͳ��");
		map6.put("img", R.drawable.list_icon_39);
		list.add(map6);
		// 2012���ʡ¼ȡ������
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", "2012���ʡ¼ȡ������");
		map7.put("img", R.drawable.list_icon_40);
		list.add(map7);
		// ������ѧ2011������¼ȡ���ͳ��
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", "2011������¼ȡ���");
		map8.put("img", R.drawable.list_icon_41);
		list.add(map8);
		// ������ѧ2011���ʡ¼ȡ������
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", "2011���ʡ¼ȡ������");
		map9.put("img", R.drawable.list_icon_42);
		list.add(map9);
		// ������ѧ2010������¼ȡ���ͳ��
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", "2010������¼ȡ���");
		map10.put("img", R.drawable.list_icon_43);
		list.add(map10);
		// ������ѧ2010���ʡ¼ȡ������
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", "2010���ʡ¼ȡ������");
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
