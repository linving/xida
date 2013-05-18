/**
 * 
 */
package com.xida.home.loadtxt;

import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.content.Context;

/**
 * @author ving
 * 
 */
public class LoadTxt {
	private int resId;
	private Context context;
//接收 阐数
	public LoadTxt(int resId, Context context) {
		this.context = context;
		this.resId = resId;
	}

	public String getText() {
		String info_text = null;
		try {
			InputStream in = context.getResources().openRawResource(resId);
			int length = in.available();
			byte[] buffer = new byte[length];
			in.read(buffer);
			info_text = EncodingUtils.getString(buffer, "gbk");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!(info_text.isEmpty())) {
			return info_text;
		} else {
			return "暂时没有数据";
		}

	}

}
