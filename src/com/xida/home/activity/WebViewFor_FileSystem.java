/**
 * 
 */
package com.xida.home.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.xida.home.R;

/**
 * @author ving
 *
 */
public class WebViewFor_FileSystem extends Activity{
	// private ProgressBar progressBar;
	private WebView news_web;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);

		setContentView(R.layout.new_webview_layout);
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
				Window.PROGRESS_VISIBILITY_ON);
		Intent intent = getIntent();
		String url = intent.getStringExtra("weburl");
		news_web = (WebView) this.findViewById(R.id.news_webview);
		news_web.getSettings().setJavaScriptEnabled(true);
		news_web.getSettings().setSupportZoom(true);
		news_web.getSettings().setBuiltInZoomControls(true);
		Log.i("url", url);
		news_web.loadUrl(url);
		final WebViewFor_FileSystem MyActivity = this;
		news_web.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				int a = progress * 100;
				MyActivity.setTitle("Loading..." + progress + "%");
				MyActivity.setProgress(a);
				if (progress == 100)
					MyActivity.setTitle("º”‘ÿÕÍ≥…");
			}

		});
	}
}
