package com.jack.findUpdate.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileUtil {
	
	private static Logger log = Logger.getLogger(FileUtil.class);
	
    public static void copyFile(File sourceFile, File targetFile) throws IOException{
    	log.info("copyFile : sourceFile=" + sourceFile + "&targetFile=" + targetFile);
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
        	if(!targetFile.getParentFile().exists()){
        		targetFile.getParentFile().mkdirs();
        	}
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[1024];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        (new File(targetDir)).mkdirs();
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                File sourceFile = file[i];
                File targetFile = new File(targetDir + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                String dir1 = sourceDir + File.separator + file[i].getName();
                String dir2 = targetDir + File.separator + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }
    
	public static void deleteFile(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteFile(files[i]);
				}
			}
			file.delete();
		}
	}
	
	public static String[] findRelateClass(String dir, final String className){
		File file = new File(dir);
		String[] list = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.matches(className+"(\\$.*)?\\.class");
			}
		});
		return list;
	}
    
    public static void main(String[] args) throws IOException {
		String src = "F:\\testsvn\\test\\c";
		String dest = "F:\\testsvn\\test\\jack\\f";
//		copyFile(new File(src), new File(dest));
		copyDirectiory(src, dest);
	}
}
