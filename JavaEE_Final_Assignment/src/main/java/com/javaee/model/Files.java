package com.javaee.model;

// Generated Jan 3, 2015 5:41:54 PM by Hibernate Tools 4.0.0

/**
 * Files generated by hbm2java
 */
@SuppressWarnings("serial")
public class Files implements java.io.Serializable {
	
	private Integer fileId;
	private Login login;
	private String filename;
	private byte[] fileData;

	public Files() {
	}

	public Files(Login login, String filename, byte[] fileData) {
		this.login = login;
		this.filename = filename;
		this.fileData = fileData;
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFileData() {
		return this.fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

}
