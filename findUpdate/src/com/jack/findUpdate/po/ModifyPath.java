package com.jack.findUpdate.po;

public class ModifyPath {
	private String path;
	private ModifyType modifyType;
	private PathType pathType;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ModifyType getModifyType() {
		return modifyType;
	}

	public void setModifyType(ModifyType modifyType) {
		this.modifyType = modifyType;
	}

	public PathType getPathType() {
		return pathType;
	}

	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}

	enum ModifyType{
		ADD,
		MODIFY,
		REMOVE
	}
	
	enum PathType{
		FILE,
		DIR
	}
}
