/**
 * 
 */
package com.xida.home.activity;

import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;

import com.xida.home.R;

/**
 * @author ving
 * 
 */
public class Telephone_xida_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telephone_xida_layout);
		InputStream stream = getResources().openRawResource(R.raw.phone);
		

	}

}
