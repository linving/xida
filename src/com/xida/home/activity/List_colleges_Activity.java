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
 *         ���Activity �г����� ѧԺ���б� �����ȥ ���Կ�����ϸ��Ϣ
 */
public class List_colleges_Activity extends Activity {
	// ���񲼾�
	private GridView grid;
	// �����񲼾�װ�������
	private List<Map<String, Object>> mData;
	// ͷ��ָʾ
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_colleges_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("ѧԺרҵ����");
		grid = (GridView) findViewById(R.id.gridview);
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);
		/*
		 * ����ĳ��ѧԺ���ڵ� list ��λ�� ע������ͬ���¼� ���Ͳ�ͬ������ �����Լ��ռ��� �������
		 */
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int key = arg2;
				Intent intent;
				switch (key) {
				// �����ѧԺ
				case 0:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					// �� Colleges_detail_info����� ���� ѧԺ���ƣ�ѧԺ��ҳ��ַ����������Դ�� id �����һ��
					intent.putExtra("colleges_name", "������������ϢѧԺ");
					intent.putExtra("weburl", "http://www.ccie.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jidian_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��е����ѧԺ
				case 1:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��е����ѧԺ");
					intent.putExtra("weburl", "http://me.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jixiegongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��������ѧԺ
				case 2:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��������ѧԺ");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/kjc/kjdj/xyzs/dqxy.htm");
					intent.putExtra("colleges_info", R.raw.dianqigongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��ľ��������ѧԺ
				case 3:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��ľ��������ѧԺ");
					intent.putExtra("weburl", "http://tmxy.gxu.edu.cn");
					intent.putExtra("colleges_info",
							R.raw.tumujianchugongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��ѧ����ѧԺ
				case 4:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��ѧ����ѧԺ");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/college/hxhgxy/");
					intent.putExtra("colleges_info", R.raw.huagong_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��Դ�뻷��ѧԺ
				case 5:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��Դ�뻷��ѧԺ");
					intent.putExtra("weburl", "http://zyyj.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.ziyuanyuyejin_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				case 6:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �Ṥ��ʳƷ����ѧԺ");
					intent.putExtra("weburl", "http://gxulif.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.qinggongyusipin_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ������ѧ�뼼��ѧԺ
				case 7:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "  ������ѧ�뼼��ѧԺ");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/kjc/kjdj/xyzs/smxy.htm");
					intent.putExtra("colleges_info", R.raw.shengmingkexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ũѧԺ
				case 8:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ũѧԺ");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/college/nongxue");
					intent.putExtra("colleges_info", R.raw.nongxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �� ѧ Ժ
				case 9:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �� ѧ Ժ");
					intent.putExtra("weburl", "http://lxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.linxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �����ѧ����ѧԺ
				case 10:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �����ѧ����ѧԺ");
					intent.putExtra("weburl",
							"http://210.36.17.42/gxudky/test/index.html");
					intent.putExtra("colleges_info", R.raw.dongwukexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��ѧ����Ϣ��ѧѧԺ
				case 11:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ��ѧ����Ϣ��ѧѧԺ");
					intent.putExtra("weburl",
							"http://baike.baidu.com/view/20091.htm");
					intent.putExtra("colleges_info", R.raw.shuxinxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �����ѧ�빤�̼���ѧԺ
				case 12:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �����ѧ�빤�̼���ѧԺ");
					intent.putExtra("weburl", "http://wl.gxu.edu.cn/physics");
					intent.putExtra("colleges_info", R.raw.wulikexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��ѧԺ
				case 13:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ��ѧԺ");
					intent.putExtra("weburl", "http://wxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.wenxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �����ѧԺ
				case 14:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �����ѧԺ");
					intent.putExtra("weburl", "http://flc.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.weiguoyuxueyaun_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��������ѧԺ
				case 15:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ��������ѧԺ");
					intent.putExtra("weburl", "http://www3.gxu.edu.cn/ggglxy");
					intent.putExtra("colleges_info", R.raw.gongguanxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �� ѧ Ժ
				case 16:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �� ѧ Ժ");
					intent.putExtra("weburl",
							"http://bs.gxu.edu.cn/shang/index.jsp");
					intent.putExtra("colleges_info", R.raw.shengxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��ѧԺ
				case 17:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ��ѧԺ");
					intent.putExtra("weburl", "http://law.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.faxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// �мӹ���ѧԺ
				case 18:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " �мӹ���ѧԺ");
					intent.putExtra("weburl", "http://www.sinocan.cn");
					intent.putExtra("colleges_info", R.raw.zhongjiaguoji_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��������ѧԺ

				case 19:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ��������ѧԺ");
					intent.putExtra("weburl",
							"http://cjxy.gxu.edu.cn/Web/Default.aspx");
					intent.putExtra("colleges_info", R.raw.jixujiaoyu_info);
					List_colleges_Activity.this.startActivity(intent);
					break;

				// ����ѧԺ
				case 20:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ����ѧԺ");
					intent.putExtra("weburl", "http://tyxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.tiyuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ����ѧԺ
				case 21:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "  ����ѧԺ");
					intent.putExtra("weburl", "http://jyxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jiaoyuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ����ѧԺ
				case 22:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ����ѧԺ	");
					intent.putExtra("weburl", "http://www3.gxu.edu.cn/ysx");
					intent.putExtra("colleges_info", R.raw.yishuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ����ѧԺ
				case 23:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ����ѧԺ");
					intent.putExtra("weburl", "http://www.xdzzxy.com");
					intent.putExtra("colleges_info", R.raw.zhengzhixueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ���ʽ���ѧԺ
				case 24:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " ���ʽ���ѧԺ");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/gjc/");
					intent.putExtra("colleges_info", R.raw.guojijiaoyu_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ���Ŵ���ѧԺ
				case 25:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "���Ŵ���ѧԺ");
					intent.putExtra("weburl", "http://sjc.gxu.edu.cn/");
					intent.putExtra("colleges_info", R.raw.xinwenchuanbo_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ���Ͽ�ѧ�빤��ѧԺ
				case 26:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "���Ͽ�ѧ�빤��ѧԺ");
					intent.putExtra("weburl",
							"http://baike.baidu.com/view/3240500.htm");
					intent.putExtra("colleges_info",
							R.raw.cailiaogongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ����ѧԺ
				case 27:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "����ѧԺ");
					intent.putExtra("weburl", "http://hjxy.gxu.edu.cn/hjxy/");
					intent.putExtra("colleges_info", R.raw.huanjingxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// ��������ѧԺ
				case 28:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "��������ѧԺ");
					intent.putExtra("weburl", "http://gfxy.gxu.edu.cn/");
					intent.putExtra("colleges_info", R.raw.guofangjiaoyu_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				default:
					break;
				}
			}
		});
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// ������������ϢѧԺ
		Map<String, Object> map = new HashMap<String, Object>();
		// ����� Activity �� �б�� ���� ͼƬ ���µ� һ��
		map.put("info", "������������ϢѧԺ");
		map.put("img", R.drawable.icon_00);
		list.add(map);
		// ��е����ѧԺ
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "��е����ѧԺ");
		map2.put("img", R.drawable.icon_02);
		list.add(map2);
		// ��������ѧԺ
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "��������ѧԺ");
		map3.put("img", R.drawable.icon_03);
		list.add(map3);
		// ��ľ��������ѧԺ
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "��ľ��������ѧԺ");
		map4.put("img", R.drawable.icon_01);
		list.add(map4);
		// ��ѧ����ѧԺ
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "��ѧ����ѧԺ");
		map5.put("img", R.drawable.icon_04);
		list.add(map5);
		// ��Դ��ұ��ѧԺ
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "��Դ��ұ��ѧԺ");
		map6.put("img", R.drawable.icon_05);
		list.add(map6);
		// �Ṥ��ʳƷ����ѧԺ
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", " 	�Ṥ��ʳƷ����ѧԺ");
		map7.put("img", R.drawable.icon_06);
		list.add(map7);
		// ������ѧ�뼼��ѧԺ
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", " 	������ѧ�뼼��ѧԺ");
		map8.put("img", R.drawable.icon_07);
		list.add(map8);
		// ũ ѧ Ժ
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", " ũ ѧ Ժ");
		map9.put("img", R.drawable.icon_08);
		list.add(map9);
		// �� ѧ Ժ
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", " ��ѧԺ");
		map10.put("img", R.drawable.icon_09);
		list.add(map10);
		// �����ѧ����ѧԺ
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", " �����ѧ����ѧԺ");
		map11.put("img", R.drawable.icon_10);
		list.add(map11);
		// ��ѧ����Ϣ��ѧѧԺ
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put("info", " ��ѧ����Ϣ��ѧѧԺ");
		map12.put("img", R.drawable.icon_11);
		list.add(map12);
		// �����ѧ�빤�̼���ѧԺ
		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put("info", " �����ѧ�빤�̼���ѧԺ");
		map13.put("img", R.drawable.icon_12);
		list.add(map13);
		// ��ѧԺ
		Map<String, Object> map14 = new HashMap<String, Object>();
		map14.put("info", " ��ѧԺ");
		map14.put("img", R.drawable.icon_13);
		list.add(map14);
		// �����ѧԺ
		Map<String, Object> map15 = new HashMap<String, Object>();
		map15.put("info", "�����ѧԺ");
		map15.put("img", R.drawable.icon_14);
		list.add(map15);
		// ��������ѧԺ
		Map<String, Object> map16 = new HashMap<String, Object>();
		map16.put("info", "��������ѧԺ");
		map16.put("img", R.drawable.icon_15);
		list.add(map16);
		// �� ѧ Ժ
		Map<String, Object> map17 = new HashMap<String, Object>();
		map17.put("info", "�� ѧ Ժ");
		map17.put("img", R.drawable.icon_16);
		list.add(map17);
		// ��ѧԺ
		Map<String, Object> map18 = new HashMap<String, Object>();
		map18.put("info", "��ѧԺ");
		map18.put("img", R.drawable.icon_17);
		list.add(map18);
		// �мӹ���ѧԺ
		Map<String, Object> map19 = new HashMap<String, Object>();
		map19.put("info", "�мӹ���ѧԺ");
		map19.put("img", R.drawable.icon_18);
		list.add(map19);
		// ��������ѧԺ
		Map<String, Object> map20 = new HashMap<String, Object>();
		map20.put("info", "��������ѧԺ");
		map20.put("img", R.drawable.icon_19);
		list.add(map20);
		// ����ѧԺ
		Map<String, Object> map21 = new HashMap<String, Object>();
		map21.put("info", "����ѧԺ");
		map21.put("img", R.drawable.icon_20);
		list.add(map21);
		// ����ѧԺ
		Map<String, Object> map22 = new HashMap<String, Object>();
		map22.put("info", "����ѧԺ");
		map22.put("img", R.drawable.icon_21);
		list.add(map22);
		// ����ѧԺ
		Map<String, Object> map23 = new HashMap<String, Object>();
		map23.put("info", "����ѧԺ");
		map23.put("img", R.drawable.icon_22);
		list.add(map23);
		// ����ѧԺ
		Map<String, Object> map24 = new HashMap<String, Object>();
		map24.put("info", "����ѧԺ");
		map24.put("img", R.drawable.icon_23);
		list.add(map24);
		// ���ʽ���ѧԺ
		Map<String, Object> map25 = new HashMap<String, Object>();
		map25.put("info", "���ʽ���ѧԺ");
		map25.put("img", R.drawable.icon_24);
		list.add(map25);
		// ���Ŵ���ѧԺ
		Map<String, Object> map26 = new HashMap<String, Object>();
		map26.put("info", "���Ŵ���ѧԺ");
		map26.put("img", R.drawable.icon_25);
		list.add(map26);
		// ���Ͽ�ѧ�빤��ѧԺ
		Map<String, Object> map27 = new HashMap<String, Object>();
		map27.put("info", "���Ͽ�ѧ�빤��ѧԺ");
		map27.put("img", R.drawable.icon_26);
		list.add(map27);
		// ����ѧԺ
		Map<String, Object> map28 = new HashMap<String, Object>();
		map28.put("info", "����ѧԺ");
		map28.put("img", R.drawable.icon_27);
		list.add(map28);
		// ��������ѧԺ
		Map<String, Object> map29 = new HashMap<String, Object>();
		map29.put("info", "��������ѧԺ");
		map29.put("img", R.drawable.icon_28);
		list.add(map29);
		return list;
	}

	// BaseAdapter ��д �����
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
