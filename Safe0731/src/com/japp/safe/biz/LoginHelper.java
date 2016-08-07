package com.japp.safe.biz;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.app.Activity;

import com.japp.safe.activity.R;
import com.japp.safe.bean.UpdateBean;
import com.japp.safe.utils.XmlParseUtil;

/**
 * ��¼
 * @author wei.jiang
 * @since 2016-08-07
 */
public class LoginHelper {
	private static LoginHelper loginHelper;
	private Activity context;
	private LoginHelper(Activity context){
		this.context = context;
	}

	public static LoginHelper getInstance(Activity context){
		if(loginHelper == null){
			loginHelper = new LoginHelper(context);
		}
		return loginHelper;
	}
	
	public void getConnection(){
		new Thread(new Runnable() {			
			@Override
			public void run() {
				connect();				
			}
		}).start();
	}
	
	private void connect() {
		String updateApkUrl = context.getResources().getString(R.string.update_app_url);
		try {
			URL url = new URL(updateApkUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			
			if(conn.getResponseCode() == 200){
				UpdateBean updateBean = XmlParseUtil.getUpdateInfo(conn.getInputStream());
				if(updateBean != null){
					if(updateBean.getVersion() == ViewHelper.getVersion(context)){//������£��Ѿ������µİ汾��ֱ�ӽ���������
						enterMainActivity();
					}else{//���°汾����Ҫ���£�������ʾ
						
					}
				}
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȥ������
	 */
	private void enterMainActivity() {
		
	}
}
