package com.jack.findUpdate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.jack.findUpdate.util.PropertiesUtil;

public class SystemPara {
	
	private static final String propertiesPath = "findUpdate.ini";
	private static Map<String, String> data = new HashMap<String, String>();
	
	static{
		try {
			data = PropertiesUtil.loadProperties(propertiesPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static enum Type{
		svnPath
	}
	
	public static String getProperties(Type type) throws Exception{
		return data.get(type.toString());
	}
	
	public static void setProperties(Type type, String value){
		data.put(type.toString(), value);
	}
}
