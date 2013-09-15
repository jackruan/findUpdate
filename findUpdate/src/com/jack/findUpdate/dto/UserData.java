package com.jack.findUpdate.dto;

public class UserData {
	private int startVersion;
	private int endVersion;
	private String toolType;
	private String toolPath;
	private String username;
	private String password;
	private String projectPath;
	private String buildPath;
	private String appType;
	
	public int getStartVersion() {
		return startVersion;
	}
	public void setStartVersion(int startVersion) {
		this.startVersion = startVersion;
	}
	public int getEndVersion() {
		return endVersion;
	}
	public void setEndVersion(int endVersion) {
		this.endVersion = endVersion;
	}
	public String getToolType() {
		return toolType;
	}
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	public String getToolPath() {
		return toolPath;
	}
	public void setToolPath(String toolPath) {
		this.toolPath = toolPath;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProjectPath() {
		return projectPath;
	}
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	public String getBuildPath() {
		return buildPath;
	}
	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
