package com.jack.findUpdate.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jack.findUpdate.dataCollect.DataCollect;
import com.jack.findUpdate.dataCollect.DataCollectFactory;
import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;

public class MainService {
	public static List<ModifyPath> getModifyPath(UserData userData) throws Exception{
		DataCollect collect = DataCollectFactory.getCollect(userData.getToolType());
		List<ModifyPath> paths = collect.findModifyPathsFromVersion(userData);
		return paths;
	}
	
	public static boolean saveUpdate(UserData userData)throws Exception{
		List<ModifyPath> paths = getModifyPath(userData);
		if(paths==null || paths.size()==0){
			return true;
		}
		//generdate dir
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String date = sdf.format(new Date());
		String destDir = userData.getBuildPath() + "/" + date;
		new File(destDir).mkdirs();
		String updateDir = destDir + "/update";
		new File(updateDir).mkdirs();
		//copy update file
		String srcClassDir = null;
		String destClassDir = null;
		if(userData.getAppType().equals("web")){
			srcClassDir = userData.getProjectPath() + "/WebRoot/WEB-INF/classes";
		}
		List<ModifyPath> deletePaths = new ArrayList<ModifyPath>();
		for(ModifyPath path : paths){
			if(path.getModifyType()==ModifyPath.ModifyType.ADD){
				if(path.getPathType()==ModifyPath.PathType.DIR){
					new File(path.getPath()).mkdirs();
				}else if(path.getPathType()==ModifyPath.PathType.FILE){
					if(userData.getAppType().equals("web")){
						
					}
				}
			}
		}
		return false;
	}
}
