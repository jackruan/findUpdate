package com.jack.findUpdate.dto;

import java.util.ArrayList;
import java.util.List;

public class ModifyPath {
	private String path;
	private ModifyType modifyType;
	private PathType pathType;
	private List<String> realPaths = new ArrayList<String>();
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path.replaceAll("\\\\", "/");
	}

	public List<String> getRealPaths() {
		return realPaths;
	}
	
	public String getFirstRealPath() {
		return realPaths.get(0);
	}

	public void addRealPath(String realPath) {
		realPaths.add(realPath);
	}

	public ModifyType getModifyType() {
		return modifyType;
	}

	public void setModifyType(ModifyType modifyType) {
		this.modifyType = modifyType;
	}
	
	public void setModifyType(String modifyType) {
		if("added".equals(modifyType)){
			this.modifyType = ModifyType.ADD;
		}else if("modified".equals(modifyType)){
			this.modifyType = ModifyType.MODIFY;
		}else if("deleted".equals(modifyType)){
			this.modifyType = ModifyType.REMOVE;
		}
	}

	public PathType getPathType() {
		return pathType;
	}

	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}
	
	public void setPathType(String pathType) {
		if("dir".equals(pathType)){
			this.pathType = PathType.DIR;
		}else if("file".equals(pathType)){
			this.pathType = PathType.FILE;
		}
	}

	public static enum ModifyType{
		ADD,
		MODIFY,
		REMOVE
	}
	
	public static enum PathType{
		FILE,
		DIR
	}
}
