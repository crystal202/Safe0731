package com.japp.safe.utils;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.japp.safe.bean.UpdateBean;

public class XmlParseUtil {

	public static UpdateBean getUpdateInfo(InputStream inputStream) {
		//拿到解析器
		XmlPullParser parser = Xml.newPullParser();
		UpdateBean bean = new UpdateBean();
		try {
			parser.setInput(inputStream, "UTF-8");
			int type = parser.getEventType();//拿到事件类型
			while (type != XmlPullParser.END_DOCUMENT) {
				switch (type) {
				case XmlPullParser.START_TAG:
					if ("version".equals(parser.getName())) {
						bean.setVersion(parser.nextText());
					} else if ("desctiption".equals(parser.getName())) {
						bean.setDescription(parser.nextText());
					} else if ("apkurl".equals(parser.getName())) {
						bean.setUrl(parser.nextText());
					}
					break;
				}
				type = parser.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

}
