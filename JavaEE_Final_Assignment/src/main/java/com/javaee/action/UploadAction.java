package com.javaee.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.javaee.dao.FileUploadDAO;
import com.javaee.dao.FileUploadDAOImpl;
import com.javaee.model.Files;
import com.javaee.model.FilesUtil;
import com.javaee.model.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UploadAction extends ActionSupport implements Action, ModelDriven<FilesUtil>, ServletContextAware{
	
	private String filesPath;
	
	SessionMap<String,String> sessionmap;
	
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}
	@Override
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession(false);
		String loginID = (String) session.getAttribute("login");
		int logID = Integer.parseInt(loginID);
		login.setLoginId(logID);
		System.out.println("File Name is:"+fu.getFileFileName());
		System.out.println("File ContentType is:"+fu.getFileContentType());
		System.out.println("Files Directory is:"+filesPath);
		try {
			FilesUtil.saveFile(fu.getFile(), fu.getFileFileName(), ctx.getRealPath("") + File.separator + filesPath);
			SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
			FileUploadDAO FilesDAO = new FileUploadDAOImpl(sf);
			byte[] dataType = new byte[(int) fu.getFile().length()];
			files.setFilename(fu.getFileFileName());
			files.setFileData(dataType);
			files.setLogin(login);
			FilesDAO.saveFiles(files);
		} catch (IOException e) {
			e.printStackTrace();
			addActionError("Upload failed!");
			return ERROR;
		}
		return SUCCESS;	
	}
	
	private FilesUtil fu = new FilesUtil();
	
	private Files files = new Files();
	
	private Login login = new Login();
	
	private ServletContext ctx;

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx=sc;
	}
	@Override
	public FilesUtil getModel() {
		
		return fu;
	}

}
