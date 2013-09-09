package com.jack.findUpdate.util;

public class SystemUtil {
	static enum OperateSystemType{
		Windows,
		Linux
	}
	public static OperateSystemType getOperateSystemType(){
		String os = System.getProperties().getProperty("os.name");
		if(os.startsWith("win") || os.startsWith("Win") ){
			return OperateSystemType.Windows;
		}else{
			return OperateSystemType.Linux;
		}
	}
}
