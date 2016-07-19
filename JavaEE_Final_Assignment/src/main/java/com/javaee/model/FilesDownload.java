package com.javaee.model;

public class FilesDownload {
	private Integer fileId;
	
	private String filename;
	
	private byte[] fileData;
	
	private Integer loginId;
	
	public Integer getFileId() {
		return fileId;
	}
	
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public byte[] getFileData() {
		return fileData;
	}
	
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	public Integer getLoginId() {
		return loginId;
	}
	
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
}
