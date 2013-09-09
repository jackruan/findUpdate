package com.jack.findUpdate.dataCollect;

public class DataCollectFactory {
	public static DataCollect getCollect(String type){
		if("svn".equals(type)){
			return new SVNCollect();
		}
		return null;
	}
}
