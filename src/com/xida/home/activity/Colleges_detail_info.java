/**
 * 
 */
package com.xida.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.loadtxt.LoadTxt;

/**
 * @author ving 这个Activity 是 学院专业 的 Activity
 */
public class Colleges_detail_info extends Activity {
	private TextView college_info_tv, college_name;
	private Intent intent;
	private int info_id;
	private String name;
	private Button college_home;
	private String url = null;
	//
	private ImageView back_home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.college_info_detail_layout);
		
		back_home = (ImageView) this.findViewById(R.id.back_home);

		intent = this.getIntent();
		// 获得介绍资源的id
		info_id = intent.getIntExtra("colleges_info", 0);
		// 获得学院的名称
		name = intent.getStringExtra("colleges_name");
		// 学院的主页 地址
		url = intent.getStringExtra("weburl");
		// 装介绍的TextView
		college_info_tv = (TextView) this.findViewById(R.id.college_zhuanye);
		// 头上学院名称的指示
		college_name = (TextView) this.findViewById(R.id.college_name);
		college_home = (Button) this.findViewById(R.id.college_home);
		college_name.setText(name);
		String info_text = null;
		// 打开 资源
		LoadTxt laodtxt = new LoadTxt(info_id, getApplicationContext());
		info_text = laodtxt.getText();

		college_info_tv.setText(info_text);
		// 打开 学院的主要Button 注册监听
		college_home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("weburl", url);
				// 在 webview 中 打开 学院主页
				intent.setClass(Colleges_detail_info.this, My_WebView.class);
				Colleges_detail_info.this.startActivity(intent);
			}
		});
		
		back_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), Main.class);
				Colleges_detail_info.this.startActivity(intent);

			}
		});
		
	}

}
