package com.jack.findUpdate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class PropertiesUtil {
	public static Map<String, String> loadProperties(String filePath) throws FileNotFoundException, IOException{
		Map<String, String> map = new HashMap<String, String>(); 
		Properties ps = new Properties();
		File file = new File(filePath);
		if(file.exists()){
			ps.load(new FileInputStream(file));
			Set keySet = ps.keySet();
			for(Object key : keySet){
				map.put(key.toString(), ps.getProperty(key.toString()));
			}
			return map;
		}
		return null;
	}
	
	
	public static void saveProperties(String filePath, Map<String, String> paras) throws FileNotFoundException, IOException{
		Properties ps = new Properties();
		Set<String> keys = paras.keySet();
		for(String key : keys){
			ps.put(key, paras.get(key)==null?"":paras.get(key));
		}
		ps.store(new FileOutputStream(filePath), new Date().toString());
	}
	
	public static String getI18nText(String file, String key){
		ResourceBundle bundle = ResourceBundle.getBundle(file);
		return bundle.getString(key);
	}
	
	public static String getMsgText(String key){
		return PropertiesUtil.getI18nText("com.jack.findUpdate.resource.msg", key);
	}
	public static String getErrorText(String key){
		return PropertiesUtil.getI18nText("com.jack.findUpdate.resource.error", key);
	}
}
