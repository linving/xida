package com.xida.home.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xida.home.R;

/*

 校园风光的 Activity


 */
public class Scene_of_xida_Activity extends Activity {
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

		setContentView(R.layout.scene_of_xida_layout);
		grid = (GridView) this.findViewById(R.id.gridview);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("西大领导");
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);
		// 注册监听
		/*
		 * grid.setOnItemClickListener(new OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> arg0, View arg1, int
		 * arg2, long arg3) { // TODO Auto-generated method stub int key = arg2;
		 * 
		 * Intent intent = new Intent();
		 * 
		 * switch (key) { case 0: intent.setClass(getApplicationContext(),
		 * Leader_detail_Activity.class); intent.putExtra("leader_name", "梁颖");
		 * intent.putExtra("leader_title", R.raw.liangyin_title);
		 * intent.putExtra("leader_img", R.drawable.liangyin);
		 * intent.putExtra("leader_info", R.raw.liangyin_info);
		 * Scene_of_xida_Activity.this.startActivity(intent); break;
		 * 
		 * default: break; } } });
		 */
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		int images[] = { R.drawable.scene_01, R.drawable.scene_02,
				R.drawable.scene_03, R.drawable.scene_04, R.drawable.scene_05,
				R.drawable.scene_06, R.drawable.scene_07, R.drawable.scene_08,
				R.drawable.scene_09, R.drawable.scene_10, R.drawable.scene_11,
				R.drawable.scene_12, R.drawable.scene_13, R.drawable.scene_14,
				R.drawable.scene_15, R.drawable.scene_16, R.drawable.scene_17,
				R.drawable.scene_18, R.drawable.scene_19, R.drawable.scene_20,
				R.drawable.scene_31, R.drawable.scene_32, R.drawable.scene_33,
				R.drawable.scene_34, R.drawable.scene_35
				};

		for (int i = 0; i < images.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("info", "风景独好");
			map.put("img", images[i]);
			list.add(map);
		}
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
