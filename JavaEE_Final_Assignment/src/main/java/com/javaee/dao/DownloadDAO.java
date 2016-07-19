package com.javaee.dao;

import java.util.List;

import com.javaee.model.Files;

public interface DownloadDAO {
	List<Files> getFiles();
	List<Files> getFilesByUsers(Integer logId);
	List<Files> getFileByName(String fileName);
	void deleteFiles(String fileName);
}