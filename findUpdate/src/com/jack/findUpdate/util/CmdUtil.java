package com.jack.findUpdate.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class CmdUtil {
	public static final Logger log = Logger.getLogger(CmdUtil.class);
	public static String exeCmd(String cmd) {
		log.info("execute cmd " + cmd);
		InputStream inputStream = null;
		InputStream errorStream = null;
		OutputStream outputStream = null;
		String str = null;
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			int ret = process.waitFor();
			inputStream = process.getInputStream();
			errorStream = process.getErrorStream();
			outputStream = process.getOutputStream();
			
			if (ret == 0) {// normal exit
	            BufferedInputStream in = new BufferedInputStream(inputStream);  
	            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
	            StringBuilder sb = new StringBuilder();
	            String lineStr;
	            while ((lineStr = inBr.readLine()) != null){  
	                sb.append(lineStr);  
	            }
	            str = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (errorStream != null) {
				try {
					errorStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}
}
