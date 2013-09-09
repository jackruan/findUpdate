package com.jack.findUpdate.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
	
	
}
