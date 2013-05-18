/**
 * 
 */
package com.xida.home.activity;

import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xida.home.R;

/**
 * @author ving
 * 
 */
public class Colleges_Info_Activity extends Activity {
	private TextView college_info_tv, header_title;
	private ImageView back_home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.college_info_layout);
		back_home = (ImageView) this.findViewById(R.id.back_home);
		back_home.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), Main.class);
				Colleges_Info_Activity.this.startActivity(intent);

			}
		});
		college_info_tv = (TextView) this.findViewById(R.id.college_info_tv);
		header_title = (TextView) this.findViewById(R.id.head_title);
		header_title.setText("ѧԺרҵ");
		String info_text = "";
		try {
			InputStream in = getResources().openRawResource(R.raw.college_info);
			int length = in.available();
			byte[] buffer = new byte[length];
			in.read(buffer);
			info_text = EncodingUtils.getString(buffer, "gbk");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		college_info_tv.setText(info_text);
	}

}
