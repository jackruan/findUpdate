package com.jack.findUpdate.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.dom4j.Attribute;

import com.jack.findUpdate.dataCollect.DataCollect;
import com.jack.findUpdate.dataCollect.DataCollectFactory;
import com.jack.findUpdate.dto.ModifyPath;
import com.jack.findUpdate.dto.UserData;
import com.jack.findUpdate.util.FileUtil;
import com.jack.findUpdate.util.PropertiesUtil;
import com.jack.findUpdate.util.XmlUtil;

public class MainService {
	private static Logger log = Logger.getLogger(MainService.class);
	
	public static List<ModifyPath> getModifyPath(UserData userData)
			throws Exception {
		DataCollect collect = DataCollectFactory.getCollect(userData
				.getToolType());
		List<ModifyPath> paths = collect.findModifyPathsFromVersion(userData);
		return paths;
	}

	public static boolean saveUpdate(UserData userData) throws Exception {
		//check version
		log.info("check version begin");
		DataCollect collect = DataCollectFactory.getCollect(userData.getToolType());
		int curVersion = collect.getCurrentVersion(userData);
		int endVersion = userData.getEndVersion();
		if(endVersion == 0){
			endVersion = collect.getHeadVersion(userData);
		}
		if(curVersion!=endVersion){
			throw new Exception(PropertiesUtil.getErrorText("checkversion.fail"));
		}
		log.info("check version end");
		//get modify path
		log.info("get modify path begin");
		List<ModifyPath> paths = getModifyPath(userData);
		if (paths == null || paths.size() == 0) {
			return true;
		}
		log.info("get modify path end");
		// generdate dir
		log.info("generdate dir begin");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String date = sdf.format(new Date());
		String destDir = userData.getBuildPath() + "/" + date + "/data";
		new File(destDir).mkdirs();
		String updateDir = destDir + "/..";
		log.info("generdate dir end");
		
//		String srcClassDir = null;
//		if (userData.getAppType().toLowerCase().equals("web")) {
//			srcClassDir = "WebRoot/WEB-INF/classes";//TODO
//		}
		
		//get source path and output path from .classpath
		File classPathFile = new File(userData.getProjectPath() + "/.classpath");
		String outputPath = null;
		List<String> sourcePaths = new ArrayList<String>();
		String projectPath = userData.getProjectPath().replaceAll("\\\\", "/") + "/";
		if(classPathFile.exists()){
			outputPath = XmlUtil.selectSingleAttribute(classPathFile, "/classpath/classpathentry[@kind='output']/@path").getValue();
			outputPath = userData.getProjectPath().replaceAll("\\\\", "/") + "/" + outputPath;
			List<Attribute> attrs = XmlUtil.selectAttributeList(classPathFile, "/classpath/classpathentry[@kind='src']/@path");
			for(Attribute attr : attrs){
				sourcePaths.add(projectPath + attr.getValue());
			}
			if(outputPath==null || sourcePaths.size()==0){
				throw new Exception(PropertiesUtil.getErrorText("classpath.srcOrOutputNotExists"));
			}
		}else{
			throw new Exception(PropertiesUtil.getErrorText("classpath.notexists"));
		}
		
		// copy update file
		List<ModifyPath> deletePaths = new ArrayList<ModifyPath>();
		for (ModifyPath path : paths) {
			if (path.getModifyType() == ModifyPath.ModifyType.ADD
					|| path.getModifyType() == ModifyPath.ModifyType.MODIFY) {
				String newPath = path.getPath();
				for(String sourcePath : sourcePaths){
					if(path.getPath().contains(sourcePath)){
						newPath = path.getPath().replaceAll(sourcePath, outputPath);
						break;
					}
				}
				if (path.getPathType() == ModifyPath.PathType.DIR) {
					new File(path.getPath()).mkdirs();
				} else if (path.getPathType() == ModifyPath.PathType.FILE) {
					if (path.getPath().endsWith(".java")) {
						String temp = newPath.replace(".java", ".class");
						String dir = temp.substring(0, temp.lastIndexOf("/"));
						String targetClass = temp.substring(temp.lastIndexOf("/") + 1);
						String[] allClasses = FileUtil.findRelateClass(dir, targetClass.replace(".class", ""));
						for(String c : allClasses){
							String temp2 = dir + "/" + c;
							FileUtil.copyFile(new File(temp2), new File(destDir + temp2.replace(userData.getProjectPath().replaceAll("\\\\", "/"), "")));
						}
					} else {
						FileUtil
								.copyFile(
										new File(newPath),
										new File(destDir + newPath.replace(userData.getProjectPath().replaceAll("\\\\", "/"), "")));
					}
				}
			} else if (path.getModifyType() == ModifyPath.ModifyType.REMOVE) {
				deletePaths.add(path);
			}
		}
//		String srcDir = destDir + "/src";
//		if(new File(srcDir).exists()){			
//			FileUtil.copyDirectiory(destDir + "/src", destDir + "/WebRoot/WEB-INF/classes");
//			FileUtil.deleteFile(new File(srcDir));
//		}
		// save update info
		userData.setEndVersion(endVersion);
		saveUpdateInfo(paths, date, userData, updateDir);
		saveBaseInfo(userData.getBuildPath(), date, endVersion);
		log.info("complete");
		return true;
	}

	private static void saveBaseInfo(String buildPath, String lastdate, int endVersion) throws Exception {
		try{
			String baseInfoFile = buildPath + "/" + BASE_INFO_FILE;
			File file = new File(baseInfoFile);
			Map<String, String> map = null;
			if(file.exists()){
				map = PropertiesUtil.loadProperties(baseInfoFile);
			}else{
				map = new HashMap<String, String>();
			}
			map.put(BASE_INFO_LAST_DATE, lastdate);
			map.put(BASE_INFO_LAST_VERSION, endVersion + "");
			PropertiesUtil.saveProperties(baseInfoFile, map);
		}catch(Exception e){
			log.error("save baseinfo error", e);
			throw new Exception(PropertiesUtil.getErrorText("save.baseInfo.error"));
		}
	}

	private static void saveUpdateInfo(List<ModifyPath> paths, String dateStr,
			UserData userData, String updateDir) throws IOException {
		VelocityContext context = new VelocityContext();
		context.put("paths", paths);
		context.put("dateStr", dateStr);
		context.put("userData", userData);
		
		saveTemple("updateinfo.vm", updateDir + "/update.xml", context);
	}
	
	private static void saveTemple(String vmfile, String targetFile, VelocityContext context)throws IOException{
		Properties p = new Properties();
		p.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		p.setProperty("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
		Velocity.init(p);
		Template template = null;
		try {
			template = Velocity.getTemplate(vmfile);
		} catch (ResourceNotFoundException rnfe) {
			System.out.println("Example : error : cannot find template "
					+ "update_info.vm");
		} catch (ParseErrorException pee) {
			System.out.println("Example : Syntax error in template "
					+ "update_info.vm" + ":" + pee);
		}
		
		BufferedWriter writer;
		writer = new BufferedWriter(new FileWriter(new File(targetFile)));

		if (template != null)
			template.merge(context, writer);

		writer.flush();
		writer.close();
	}
	
	private static final String BASE_INFO_FILE = "baseinfo.properties";
	private static final String BASE_INFO_LAST_DATE = "lastDate";
	private static final String BASE_INFO_LAST_VERSION = "lastVersion";

	public static int checkBaseInfo(String buildPath) throws Exception{
		//check baseInfo file
		File file = new File(buildPath + "/" + BASE_INFO_FILE);
		if(file.exists()){
			Properties p = new Properties();
			p.load(new FileInputStream(file));
			//get last version from baseInfo
			String lastVersion = p.getProperty(BASE_INFO_LAST_VERSION);
			if(lastVersion == null){
				return -1;
			}else{
				return Integer.parseInt(lastVersion);
			}
		}else{
			return -1;			
		}
	}
}
