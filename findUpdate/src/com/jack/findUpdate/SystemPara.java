package com.jack.findUpdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jack.findUpdate.util.PropertiesUtil;

public class SystemPara {
	
	private static final String propertiesPath = "findUpdate.ini";
	private static Map<String, String> data;
	
	static{
		try {
			data = PropertiesUtil.loadProperties(propertiesPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(data==null){
			data = new HashMap<String, String>();
		}
	}
	
	public static enum Type{
		startVersion,
		endVersion,
		toolType,
		toolPath,
		username,
		password,
		projectPath,
		buildPath,
		appType
	}
	
	public static String getProperties(Type type){
		return data.get(type.toString());
	}
	
	public static String getProperties(Type type, String defaultValue){
		String value = getProperties(type);
		if(value==null){
			return defaultValue;
		}else{
			return value;
		}
	}

	
	public static void setProperties(Type type, String value){
		data.put(type.toString(), value);
	}
	
	public static void saveParas() throws FileNotFoundException, IOException{
		PropertiesUtil.saveProperties(propertiesPath, data);
	}
}
