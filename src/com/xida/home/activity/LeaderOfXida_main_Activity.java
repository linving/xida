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
 * @author ving 这个是学校领导的列表的 Activity
 *         数据来自：http://www.gxu.edu.cn/2003/2003xxgk/xrld001.htm 这个类 结构 介绍
 *         学院专业这个类 一样不解释
 */
public class LeaderOfXida_main_Activity extends Activity {
	// 网格
	private GridView grid;
	//
	private List<Map<String, Object>> mData;
	// 头顶指示标题
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.leaderofxida_main_layout);
		grid = (GridView) this.findViewById(R.id.gridview);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("西大领导");
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);
		// 注册监听
		grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int key = arg2;
			
				Intent intent = new Intent();

				switch (key) {
				case 0:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "梁颖");
					intent.putExtra("leader_title", R.raw.liangyin_title);
					intent.putExtra("leader_img", R.drawable.liangyin);
					intent.putExtra("leader_info", R.raw.liangyin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 1:

					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "赵艳林");
					intent.putExtra("leader_title", R.raw.zhaoyanlin_title);
					intent.putExtra("leader_img", R.drawable.zhaoyanlin);
					intent.putExtra("leader_info", R.raw.zhaoyanlin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);

					break;
				case 2:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "燕柳斌");
					intent.putExtra("leader_title", R.raw.liangyin_title);
					intent.putExtra("leader_img", R.drawable.yanliubin);
					intent.putExtra("leader_info", R.raw.yanliubin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 3:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "邓军");
					intent.putExtra("leader_title", R.raw.dengjun_title);
					intent.putExtra("leader_img", R.drawable.dengjun);
					intent.putExtra("leader_info", R.raw.dengjun_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 4:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "毛汉领");
					intent.putExtra("leader_title", R.raw.mouhanling_title);
					intent.putExtra("leader_img", R.drawable.mouhanling);
					intent.putExtra("leader_info", R.raw.mouhanling_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 5:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "张协奎");
					intent.putExtra("leader_title", R.raw.zhangxiekui_title);
					intent.putExtra("leader_img", R.drawable.zhangxiekui);
					intent.putExtra("leader_info", R.raw.zhangxiekui_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 6:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "韦化");
					intent.putExtra("leader_title", R.raw.weihua_title);
					intent.putExtra("leader_img", R.drawable.weihua);
					intent.putExtra("leader_info", R.raw.weihua_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 7:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "陈保善");
					intent.putExtra("leader_title", R.raw.chenbaoshan_title);
					intent.putExtra("leader_img", R.drawable.chenbaoshan);
					intent.putExtra("leader_info", R.raw.chenbaoshan_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 8:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "唐平秋");
					intent.putExtra("leader_title", R.raw.tangpinqiu_tetle);
					intent.putExtra("leader_img", R.drawable.tangpinqiu);
					intent.putExtra("leader_info", R.raw.tangpinqiu_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 9:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "罗廷荣");
					intent.putExtra("leader_title", R.raw.loutingrong_tetle);
					intent.putExtra("leader_img", R.drawable.loutingrong);
					intent.putExtra("leader_info", R.raw.loutingrong_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 10:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "梁家斌");
					intent.putExtra("leader_title", R.raw.liangjiabin_title);
					intent.putExtra("leader_img", R.drawable.liangjiabin);
					intent.putExtra("leader_info", R.raw.liangjiabin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 11:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "商娜红");
					intent.putExtra("leader_title", R.raw.shangnahong_title);
					intent.putExtra("leader_img", R.drawable.shangnahong);
					intent.putExtra("leader_info", R.raw.shangnahong_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 12:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "魏远安");
					intent.putExtra("leader_title", R.raw.weiyaunan_title);
					intent.putExtra("leader_img", R.drawable.weiyuanan);
					intent.putExtra("leader_info", R.raw.weiyuanan_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				default:
					break;
				}
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("info", "党委书记");
		map.put("img", R.drawable.liangyin);
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "党委副书记,现任校长");
		map2.put("img", R.drawable.zhaoyanlin);
		list.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "党委副书记,纪委书记");
		map3.put("img", R.drawable.yanliubin);
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "党委副,书记");
		map4.put("img", R.drawable.dengjun);
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "校党委常委,副校长");
		map5.put("img", R.drawable.mouhanling);
		list.add(map5);
		// 校党委常,副校长
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "校党委常委,副校长");
		map6.put("img", R.drawable.zhangxiekui);
		list.add(map6);
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", "校党委常委,副校长");
		map7.put("img", R.drawable.weihua);
		list.add(map7);
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", "校党委常委,副校长");
		map8.put("img", R.drawable.chenbaoshan);
		list.add(map8);
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", "校党委常委,副校长");
		map9.put("img", R.drawable.tangpinqiu);
		list.add(map9);
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", "校党委常委,副校长");
		map10.put("img", R.drawable.loutingrong);
		list.add(map10);
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", "校党委常委,总会计师");
		map11.put("img", R.drawable.liangjiabin);
		list.add(map11);
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put("info", "校党委常委,副校长");
		map12.put("img", R.drawable.shangnahong);
		list.add(map12);
		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put("info", "校党委常委,副校长");
		map13.put("img", R.drawable.weiyuanan);
		list.add(map13);
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
			convertView = mInflater.inflate(R.layout.leader_gridview_item_ly,
					null);
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
