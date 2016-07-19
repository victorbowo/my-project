package com.javaee.action;

import com.javaee.dao.DownloadDAO;
import com.javaee.dao.DownloadDAOImpl;
import com.javaee.model.Files;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ModelDriven;

public class DownloadAction extends ActionSupport implements  Action, ModelDriven<List<Files>>, ServletContextAware{
	
	
	public String execute() throws FileNotFoundException{
		setFileName(getFileName());
	    fileInputStream = new FileInputStream(new File("C:\\Users\\Vyx\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JavaEE_Final_Assignment\\JavaEE Upload Center\\"+fileName));
	    return SUCCESS;
	}
	
	public String listFiles(){
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		DownloadDAO DownloadDAO = new DownloadDAOImpl(sf);
		files = DownloadDAO.getFiles();
		return SUCCESS;
	}
	
	public String listFilesByUsers(){
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		String loginID = (String) session.getAttribute("login");
		int logID = Integer.parseInt(loginID);
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		DownloadDAO DownloadDAO = new DownloadDAOImpl(sf);
		files = DownloadDAO.getFilesByUsers(logID);
		return SUCCESS;
	}
	
	public String listFileByName(){
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		DownloadDAO DownloadDAO = new DownloadDAOImpl(sf);
		files = DownloadDAO.getFileByName(fileName);
		return SUCCESS;
	}
	
	public String deleteFiles(){
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		DownloadDAO DownloadDAO = new DownloadDAOImpl(sf);
		setFileName(getFileName());
		File deleteFile = new File("C:\\Users\\Vyx\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\JavaEE_Final_Assignment\\JavaEE Upload Center\\"+fileName);
		deleteFile.delete();
		DownloadDAO.deleteFiles(fileName);
		return SUCCESS;
	}
	
	@Override
	public List<Files> getModel() {
		// TODO Auto-generated method stub
		return files;
	}
	
	private String fileName;

	private InputStream fileInputStream;
	 
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private Files file = new Files();
	
	public Files getFile() {
		return file;
	}

	public void setFile(Files file) {
		this.file = file;
	}

	private List<Files> files = new ArrayList<Files>();
	
	public List<Files> getFiles() {
		return files;
	}

	public void setFiles(List<Files> files) {
		this.files = files;
	}

	private ServletContext ctx;
	
	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}
	
}

/*public class DownloadAction extends ActionSupport{
	private InputStream fileInputStream;
	 
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
 
	public String execute() throws Exception {
		String a = "C:\\Users\\Victor\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\JavaEE_Final_Assignment\\JavaEE Upload Center\\Desert.jpg";
	    fileInputStream = new FileInputStream(new File(""+a));
	    return SUCCESS;
	}
}
*/