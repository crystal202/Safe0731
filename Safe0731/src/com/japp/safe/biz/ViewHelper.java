package com.japp.safe.biz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ViewHelper {

	/**
	 * ��ȡ�汾��
	 * @param context
	 * @return
	 */
	public static String getVersion(Context context){
		PackageManager pm = context.getPackageManager();//�õ����Ĺ�����
		try {
			//��װ�����й��ܵ��嵥����
			PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
