package com.japp.safe.activity;


import com.japp.safe.biz.LoginHelper;
import com.japp.safe.biz.ViewHelper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends Activity {
	private TextView tv_splash_version;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		tv_splash_version = (TextView)this.findViewById(R.id.tv_splash_version);
		tv_splash_version.setText("°æ±¾ºÅ£º"+ViewHelper.getVersion(SplashActivity.this));
		
		LoginHelper.getInstance(this).getConnection();
	}
}
