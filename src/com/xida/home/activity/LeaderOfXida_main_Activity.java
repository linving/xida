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
 * @author ving �����ѧУ�쵼���б�� Activity
 *         �������ԣ�http://www.gxu.edu.cn/2003/2003xxgk/xrld001.htm ����� �ṹ ����
 *         ѧԺרҵ����� һ��������
 */
public class LeaderOfXida_main_Activity extends Activity {
	// ����
	private GridView grid;
	//
	private List<Map<String, Object>> mData;
	// ͷ��ָʾ����
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.leaderofxida_main_layout);
		grid = (GridView) this.findViewById(R.id.gridview);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("�����쵼");
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);
		// ע�����
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
					intent.putExtra("leader_name", "��ӱ");
					intent.putExtra("leader_title", R.raw.liangyin_title);
					intent.putExtra("leader_img", R.drawable.liangyin);
					intent.putExtra("leader_info", R.raw.liangyin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 1:

					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "������");
					intent.putExtra("leader_title", R.raw.zhaoyanlin_title);
					intent.putExtra("leader_img", R.drawable.zhaoyanlin);
					intent.putExtra("leader_info", R.raw.zhaoyanlin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);

					break;
				case 2:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "������");
					intent.putExtra("leader_title", R.raw.liangyin_title);
					intent.putExtra("leader_img", R.drawable.yanliubin);
					intent.putExtra("leader_info", R.raw.yanliubin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 3:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "�˾�");
					intent.putExtra("leader_title", R.raw.dengjun_title);
					intent.putExtra("leader_img", R.drawable.dengjun);
					intent.putExtra("leader_info", R.raw.dengjun_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 4:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "ë����");
					intent.putExtra("leader_title", R.raw.mouhanling_title);
					intent.putExtra("leader_img", R.drawable.mouhanling);
					intent.putExtra("leader_info", R.raw.mouhanling_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 5:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "��Э��");
					intent.putExtra("leader_title", R.raw.zhangxiekui_title);
					intent.putExtra("leader_img", R.drawable.zhangxiekui);
					intent.putExtra("leader_info", R.raw.zhangxiekui_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 6:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "Τ��");
					intent.putExtra("leader_title", R.raw.weihua_title);
					intent.putExtra("leader_img", R.drawable.weihua);
					intent.putExtra("leader_info", R.raw.weihua_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 7:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "�±���");
					intent.putExtra("leader_title", R.raw.chenbaoshan_title);
					intent.putExtra("leader_img", R.drawable.chenbaoshan);
					intent.putExtra("leader_info", R.raw.chenbaoshan_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 8:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "��ƽ��");
					intent.putExtra("leader_title", R.raw.tangpinqiu_tetle);
					intent.putExtra("leader_img", R.drawable.tangpinqiu);
					intent.putExtra("leader_info", R.raw.tangpinqiu_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 9:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "��͢��");
					intent.putExtra("leader_title", R.raw.loutingrong_tetle);
					intent.putExtra("leader_img", R.drawable.loutingrong);
					intent.putExtra("leader_info", R.raw.loutingrong_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 10:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "���ұ�");
					intent.putExtra("leader_title", R.raw.liangjiabin_title);
					intent.putExtra("leader_img", R.drawable.liangjiabin);
					intent.putExtra("leader_info", R.raw.liangjiabin_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 11:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "���Ⱥ�");
					intent.putExtra("leader_title", R.raw.shangnahong_title);
					intent.putExtra("leader_img", R.drawable.shangnahong);
					intent.putExtra("leader_info", R.raw.shangnahong_info);
					LeaderOfXida_main_Activity.this.startActivity(intent);
					break;
				case 12:
					intent.setClass(getApplicationContext(),
							Leader_detail_Activity.class);
					intent.putExtra("leader_name", "κԶ��");
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
		map.put("info", "��ί���");
		map.put("img", R.drawable.liangyin);
		list.add(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "��ί�����,����У��");
		map2.put("img", R.drawable.zhaoyanlin);
		list.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "��ί�����,��ί���");
		map3.put("img", R.drawable.yanliubin);
		list.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "��ί��,���");
		map4.put("img", R.drawable.dengjun);
		list.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "У��ί��ί,��У��");
		map5.put("img", R.drawable.mouhanling);
		list.add(map5);
		// У��ί��,��У��
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "У��ί��ί,��У��");
		map6.put("img", R.drawable.zhangxiekui);
		list.add(map6);
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", "У��ί��ί,��У��");
		map7.put("img", R.drawable.weihua);
		list.add(map7);
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", "У��ί��ί,��У��");
		map8.put("img", R.drawable.chenbaoshan);
		list.add(map8);
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", "У��ί��ί,��У��");
		map9.put("img", R.drawable.tangpinqiu);
		list.add(map9);
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", "У��ί��ί,��У��");
		map10.put("img", R.drawable.loutingrong);
		list.add(map10);
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", "У��ί��ί,�ܻ��ʦ");
		map11.put("img", R.drawable.liangjiabin);
		list.add(map11);
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put("info", "У��ί��ί,��У��");
		map12.put("img", R.drawable.shangnahong);
		list.add(map12);
		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put("info", "У��ί��ί,��У��");
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
