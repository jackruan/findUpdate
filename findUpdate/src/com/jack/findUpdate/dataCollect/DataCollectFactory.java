package com.jack.findUpdate.dataCollect;

public class DataCollectFactory {
	public static DataCollect getCollect(String type)throws Exception{
		if("svn".equals(type.toLowerCase())){
			return new SVNCollect();
		}
		throw new Exception(type + "not implement");
	}
}
