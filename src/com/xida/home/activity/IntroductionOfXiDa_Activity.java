package com.xida.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.loadtxt.LoadTxt;

/*
 西大简介的这个页面 比较简单
 */
public class IntroductionOfXiDa_Activity extends Activity {
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introduction_activity_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("西大简介");

		TextView mytextview = (TextView) this
				.findViewById(R.id.introduction_info);
		String info = "";
		// R.raw.introduction_of_xida 介绍资源
		int res_id = R.raw.introduction_of_xida;
		// 加载的封装类
		LoadTxt laodtxt = new LoadTxt(res_id, getApplicationContext());
		// 获取信息
		info = laodtxt.getText();
		// 写到 Textview 中
		mytextview.setText(info);
	}

}
