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
 *         这个Activity 列出西大 学院的列表， 点击进去 可以看见详细信息
 */
public class List_colleges_Activity extends Activity {
	// 网格布局
	private GridView grid;
	// 给网格布局装入的内容
	private List<Map<String, Object>> mData;
	// 头部指示
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_colleges_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("学院专业介绍");
		grid = (GridView) findViewById(R.id.gridview);
		mData = getData();
		GridViewAdapter myadapter = new GridViewAdapter(getApplicationContext());
		grid.setAdapter(myadapter);
		/*
		 * 根据某个学院所在的 list 的位置 注册点击不同的事件 发送不同的数据 数据自己收集的 烦啊这个
		 */
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int key = arg2;
				Intent intent;
				switch (key) {
				// 计算机学院
				case 0:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					// 给 Colleges_detail_info这个类 发送 学院名称，学院主页地址，及介绍资源的 id 下面的一样
					intent.putExtra("colleges_name", "计算机与电子信息学院");
					intent.putExtra("weburl", "http://www.ccie.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jidian_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 机械工程学院
				case 1:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "机械工程学院");
					intent.putExtra("weburl", "http://me.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jixiegongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 电器工程学院
				case 2:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "电器工程学院");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/kjc/kjdj/xyzs/dqxy.htm");
					intent.putExtra("colleges_info", R.raw.dianqigongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 土木建筑工程学院
				case 3:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "土木建筑工程学院");
					intent.putExtra("weburl", "http://tmxy.gxu.edu.cn");
					intent.putExtra("colleges_info",
							R.raw.tumujianchugongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 化学化工学院
				case 4:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "化学化工学院");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/college/hxhgxy/");
					intent.putExtra("colleges_info", R.raw.huagong_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 资源与环境学院
				case 5:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "资源与环境学院");
					intent.putExtra("weburl", "http://zyyj.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.ziyuanyuyejin_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				case 6:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 轻工与食品工程学院");
					intent.putExtra("weburl", "http://gxulif.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.qinggongyusipin_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 生命科学与技术学院
				case 7:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "  生命科学与技术学院");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/kjc/kjdj/xyzs/smxy.htm");
					intent.putExtra("colleges_info", R.raw.shengmingkexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 农学院
				case 8:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 农学院");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/college/nongxue");
					intent.putExtra("colleges_info", R.raw.nongxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 林 学 院
				case 9:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 林 学 院");
					intent.putExtra("weburl", "http://lxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.linxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 动物科学技术学院
				case 10:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 动物科学技术学院");
					intent.putExtra("weburl",
							"http://210.36.17.42/gxudky/test/index.html");
					intent.putExtra("colleges_info", R.raw.dongwukexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 数学与信息科学学院
				case 11:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 数学与信息科学学院");
					intent.putExtra("weburl",
							"http://baike.baidu.com/view/20091.htm");
					intent.putExtra("colleges_info", R.raw.shuxinxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 物理科学与工程技术学院
				case 12:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 物理科学与工程技术学院");
					intent.putExtra("weburl", "http://wl.gxu.edu.cn/physics");
					intent.putExtra("colleges_info", R.raw.wulikexue_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 文学院
				case 13:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 文学院");
					intent.putExtra("weburl", "http://wxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.wenxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 外国语学院
				case 14:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 外国语学院");
					intent.putExtra("weburl", "http://flc.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.weiguoyuxueyaun_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 公共管理学院
				case 15:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 公共管理学院");
					intent.putExtra("weburl", "http://www3.gxu.edu.cn/ggglxy");
					intent.putExtra("colleges_info", R.raw.gongguanxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 商 学 院
				case 16:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 商 学 院");
					intent.putExtra("weburl",
							"http://bs.gxu.edu.cn/shang/index.jsp");
					intent.putExtra("colleges_info", R.raw.shengxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 法学院
				case 17:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 法学院");
					intent.putExtra("weburl", "http://law.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.faxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 中加国际学院
				case 18:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 中加国际学院");
					intent.putExtra("weburl", "http://www.sinocan.cn");
					intent.putExtra("colleges_info", R.raw.zhongjiaguoji_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 继续教育学院

				case 19:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 继续教育学院");
					intent.putExtra("weburl",
							"http://cjxy.gxu.edu.cn/Web/Default.aspx");
					intent.putExtra("colleges_info", R.raw.jixujiaoyu_info);
					List_colleges_Activity.this.startActivity(intent);
					break;

				// 体育学院
				case 20:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 体育学院");
					intent.putExtra("weburl", "http://tyxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.tiyuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 教育学院
				case 21:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "  教育学院");
					intent.putExtra("weburl", "http://jyxy.gxu.edu.cn");
					intent.putExtra("colleges_info", R.raw.jiaoyuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 艺术学院
				case 22:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 艺术学院	");
					intent.putExtra("weburl", "http://www3.gxu.edu.cn/ysx");
					intent.putExtra("colleges_info", R.raw.yishuxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 政治学院
				case 23:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 政治学院");
					intent.putExtra("weburl", "http://www.xdzzxy.com");
					intent.putExtra("colleges_info", R.raw.zhengzhixueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 国际教育学院
				case 24:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", " 国际教育学院");
					intent.putExtra("weburl",
							"http://www.gxu.edu.cn/administration/gjc/");
					intent.putExtra("colleges_info", R.raw.guojijiaoyu_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 新闻传播学院
				case 25:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "新闻传播学院");
					intent.putExtra("weburl", "http://sjc.gxu.edu.cn/");
					intent.putExtra("colleges_info", R.raw.xinwenchuanbo_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 材料科学与工程学院
				case 26:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "材料科学与工程学院");
					intent.putExtra("weburl",
							"http://baike.baidu.com/view/3240500.htm");
					intent.putExtra("colleges_info",
							R.raw.cailiaogongcheng_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 环境学院
				case 27:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "环境学院");
					intent.putExtra("weburl", "http://hjxy.gxu.edu.cn/hjxy/");
					intent.putExtra("colleges_info", R.raw.huanjingxueyuan_info);
					List_colleges_Activity.this.startActivity(intent);
					break;
				// 国防教育学院
				case 28:
					intent = new Intent();
					intent.setClass(getApplicationContext(),
							Colleges_detail_info.class);
					intent.putExtra("colleges_name", "国防教育学院");
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
		// 计算机与电子信息学院
		Map<String, Object> map = new HashMap<String, Object>();
		// 在这个 Activity 里 列表的 名称 图片 以下的 一样
		map.put("info", "计算机与电子信息学院");
		map.put("img", R.drawable.icon_00);
		list.add(map);
		// 机械工程学院
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("info", "机械工程学院");
		map2.put("img", R.drawable.icon_02);
		list.add(map2);
		// 电气工程学院
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("info", "电气工程学院");
		map3.put("img", R.drawable.icon_03);
		list.add(map3);
		// 土木建筑工程学院
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("info", "土木建筑工程学院");
		map4.put("img", R.drawable.icon_01);
		list.add(map4);
		// 化学化工学院
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("info", "化学化工学院");
		map5.put("img", R.drawable.icon_04);
		list.add(map5);
		// 资源与冶金学院
		Map<String, Object> map6 = new HashMap<String, Object>();
		map6.put("info", "资源与冶金学院");
		map6.put("img", R.drawable.icon_05);
		list.add(map6);
		// 轻工与食品工程学院
		Map<String, Object> map7 = new HashMap<String, Object>();
		map7.put("info", " 	轻工与食品工程学院");
		map7.put("img", R.drawable.icon_06);
		list.add(map7);
		// 生命科学与技术学院
		Map<String, Object> map8 = new HashMap<String, Object>();
		map8.put("info", " 	生命科学与技术学院");
		map8.put("img", R.drawable.icon_07);
		list.add(map8);
		// 农 学 院
		Map<String, Object> map9 = new HashMap<String, Object>();
		map9.put("info", " 农 学 院");
		map9.put("img", R.drawable.icon_08);
		list.add(map9);
		// 林 学 院
		Map<String, Object> map10 = new HashMap<String, Object>();
		map10.put("info", " 林学院");
		map10.put("img", R.drawable.icon_09);
		list.add(map10);
		// 动物科学技术学院
		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("info", " 动物科学技术学院");
		map11.put("img", R.drawable.icon_10);
		list.add(map11);
		// 数学与信息科学学院
		Map<String, Object> map12 = new HashMap<String, Object>();
		map12.put("info", " 数学与信息科学学院");
		map12.put("img", R.drawable.icon_11);
		list.add(map12);
		// 物理科学与工程技术学院
		Map<String, Object> map13 = new HashMap<String, Object>();
		map13.put("info", " 物理科学与工程技术学院");
		map13.put("img", R.drawable.icon_12);
		list.add(map13);
		// 文学院
		Map<String, Object> map14 = new HashMap<String, Object>();
		map14.put("info", " 文学院");
		map14.put("img", R.drawable.icon_13);
		list.add(map14);
		// 外国语学院
		Map<String, Object> map15 = new HashMap<String, Object>();
		map15.put("info", "外国语学院");
		map15.put("img", R.drawable.icon_14);
		list.add(map15);
		// 公共管理学院
		Map<String, Object> map16 = new HashMap<String, Object>();
		map16.put("info", "公共管理学院");
		map16.put("img", R.drawable.icon_15);
		list.add(map16);
		// 商 学 院
		Map<String, Object> map17 = new HashMap<String, Object>();
		map17.put("info", "商 学 院");
		map17.put("img", R.drawable.icon_16);
		list.add(map17);
		// 法学院
		Map<String, Object> map18 = new HashMap<String, Object>();
		map18.put("info", "法学院");
		map18.put("img", R.drawable.icon_17);
		list.add(map18);
		// 中加国际学院
		Map<String, Object> map19 = new HashMap<String, Object>();
		map19.put("info", "中加国际学院");
		map19.put("img", R.drawable.icon_18);
		list.add(map19);
		// 继续教育学院
		Map<String, Object> map20 = new HashMap<String, Object>();
		map20.put("info", "继续教育学院");
		map20.put("img", R.drawable.icon_19);
		list.add(map20);
		// 体育学院
		Map<String, Object> map21 = new HashMap<String, Object>();
		map21.put("info", "体育学院");
		map21.put("img", R.drawable.icon_20);
		list.add(map21);
		// 教育学院
		Map<String, Object> map22 = new HashMap<String, Object>();
		map22.put("info", "教育学院");
		map22.put("img", R.drawable.icon_21);
		list.add(map22);
		// 艺术学院
		Map<String, Object> map23 = new HashMap<String, Object>();
		map23.put("info", "艺术学院");
		map23.put("img", R.drawable.icon_22);
		list.add(map23);
		// 政治学院
		Map<String, Object> map24 = new HashMap<String, Object>();
		map24.put("info", "政治学院");
		map24.put("img", R.drawable.icon_23);
		list.add(map24);
		// 国际教育学院
		Map<String, Object> map25 = new HashMap<String, Object>();
		map25.put("info", "国际教育学院");
		map25.put("img", R.drawable.icon_24);
		list.add(map25);
		// 新闻传播学院
		Map<String, Object> map26 = new HashMap<String, Object>();
		map26.put("info", "新闻传播学院");
		map26.put("img", R.drawable.icon_25);
		list.add(map26);
		// 材料科学与工程学院
		Map<String, Object> map27 = new HashMap<String, Object>();
		map27.put("info", "材料科学与工程学院");
		map27.put("img", R.drawable.icon_26);
		list.add(map27);
		// 环境学院
		Map<String, Object> map28 = new HashMap<String, Object>();
		map28.put("info", "环境学院");
		map28.put("img", R.drawable.icon_27);
		list.add(map28);
		// 国防教育学院
		Map<String, Object> map29 = new HashMap<String, Object>();
		map29.put("info", "国防教育学院");
		map29.put("img", R.drawable.icon_28);
		list.add(map29);
		return list;
	}

	// BaseAdapter 重写 这个类
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
