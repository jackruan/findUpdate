package com.jack.findUpdate.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
		new File(updateDir).mkdirs();
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
					//new File(path.getPath()).mkdirs();
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
		String srcDir = destDir + "/src";
		if(new File(srcDir).exists()){			
			FileUtil.copyDirectiory(destDir + "/src", destDir + "/WebRoot/WEB-INF/classes");
			FileUtil.deleteFile(new File(srcDir));
		}
		// save update info
		userData.setEndVersion(endVersion);
		saveUpdateInfo(paths, date, userData, updateDir);
		log.info("complete");
		return true;
	}

	private static void saveUpdateInfo(List<ModifyPath> paths, String dateStr,
			UserData userData, String updateDir) throws IOException {
		Properties p = new Properties();
		p.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		p.setProperty("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
		Velocity.init(p);
		VelocityContext context = new VelocityContext();
		context.put("paths", paths);
		context.put("dateStr", dateStr);
		context.put("userData", userData);
		Template template = null;

		try {
			template = Velocity.getTemplate("updateinfo.vm");
		} catch (ResourceNotFoundException rnfe) {
			System.out.println("Example : error : cannot find template "
					+ "update_info.vm");
		} catch (ParseErrorException pee) {
			System.out.println("Example : Syntax error in template "
					+ "update_info.vm" + ":" + pee);
		}

		/*
		 * Now have the template engine process your template using the data
		 * placed into the context. Think of it as a 'merge' of the template and
		 * the data to produce the output stream.
		 */

		BufferedWriter writer;
		writer = new BufferedWriter(new FileWriter(new File(updateDir + "/update.html")));

		if (template != null)
			template.merge(context, writer);

		/*
		 * flush and cleanup
		 */

		writer.flush();
		writer.close();
	}
}
