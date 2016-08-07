package com.japp.safe.biz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ViewHelper {

	/**
	 * 获取版本号
	 * @param context
	 * @return
	 */
	public static String getVersion(Context context){
		PackageManager pm = context.getPackageManager();//拿到包的管理器
		try {
			//封装了所有功能的清单数据
			PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
			return info.versionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
