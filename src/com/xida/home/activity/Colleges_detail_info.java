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
 * @author ving ���Activity �� ѧԺרҵ �� Activity
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
		// ��ý�����Դ��id
		info_id = intent.getIntExtra("colleges_info", 0);
		// ���ѧԺ������
		name = intent.getStringExtra("colleges_name");
		// ѧԺ����ҳ ��ַ
		url = intent.getStringExtra("weburl");
		// װ���ܵ�TextView
		college_info_tv = (TextView) this.findViewById(R.id.college_zhuanye);
		// ͷ��ѧԺ���Ƶ�ָʾ
		college_name = (TextView) this.findViewById(R.id.college_name);
		college_home = (Button) this.findViewById(R.id.college_home);
		college_name.setText(name);
		String info_text = null;
		// �� ��Դ
		LoadTxt laodtxt = new LoadTxt(info_id, getApplicationContext());
		info_text = laodtxt.getText();

		college_info_tv.setText(info_text);
		// �� ѧԺ����ҪButton ע�����
		college_home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("weburl", url);
				// �� webview �� �� ѧԺ��ҳ
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
