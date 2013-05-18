/**
 * 
 */
package com.xida.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.loadtxt.LoadTxt;

/**
 * @author ving 这个Activity 是某个领导的 详细内容的介绍界面
 */
public class Leader_detail_Activity extends Activity {
	// 头顶领导名字，和领导的详细内容
	private TextView head_title, titles, detail_info;
	// 领导图片
	private ImageView leader_img_view;
	// 领导名字
	private String leader_nane;
	// 领导职称，图片，简介资源 的 Id
	private int leader_title, leader_img, leader_info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leader_detail_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);

		titles = (TextView) this.findViewById(R.id.titles);
		detail_info = (TextView) this.findViewById(R.id.detail_info);
		leader_img_view = (ImageView) this.findViewById(R.id.leader_img);
		// 从上级获取信息
		Intent intent = getIntent();
		leader_nane = intent.getStringExtra("leader_name");
		head_title.setText(leader_nane);
		leader_img = (Integer) intent.getIntExtra("leader_img", 0);
		leader_title = (Integer) intent.getIntExtra("leader_title",
				R.drawable.liangyin);
		leader_info = (Integer) intent.getIntExtra("leader_info",
				R.drawable.liangyin);
		leader_img_view.setBackgroundResource(leader_img);
		String title_text = "";
		LoadTxt laodtxt = new LoadTxt(leader_title, getApplicationContext());
		title_text = laodtxt.getText();
		titles.setText(title_text);
		String info_text = "";
		LoadTxt laodtxt2 = new LoadTxt(leader_info, getApplicationContext());
		info_text = laodtxt2.getText();
		detail_info.setText(info_text);
	}
}
