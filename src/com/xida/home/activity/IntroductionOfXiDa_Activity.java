package com.xida.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xida.home.R;
import com.xida.home.loadtxt.LoadTxt;

/*
 ����������ҳ�� �Ƚϼ�
 */
public class IntroductionOfXiDa_Activity extends Activity {
	private TextView head_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introduction_activity_layout);
		head_title = (TextView) this.findViewById(R.id.head_title);
		head_title.setText("������");

		TextView mytextview = (TextView) this
				.findViewById(R.id.introduction_info);
		String info = "";
		// R.raw.introduction_of_xida ������Դ
		int res_id = R.raw.introduction_of_xida;
		// ���صķ�װ��
		LoadTxt laodtxt = new LoadTxt(res_id, getApplicationContext());
		// ��ȡ��Ϣ
		info = laodtxt.getText();
		// д�� Textview ��
		mytextview.setText(info);
	}

}
