package com.javaee.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.javaee.dao.LoginDAO;
import com.javaee.dao.LoginDAOImpl;
import com.javaee.model.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements Action, ModelDriven<Login>, ServletContextAware,SessionAware {
	
	SessionMap<String,String> sessionmap;
	@Override
	public String execute() throws Exception {
		
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		LoginDAO userDAO = new LoginDAOImpl(sf);
		if (login.getLoginName().equals(null) || login.getLoginName().equals(""))
		{
			addActionError("Please fill the username!");
		}
		else if (login.getLoginPass().equals(null) || login.getLoginPass().equals(""))
		{
			addActionError("Please fill the password!");
		} else {
			Login userDB = userDAO.getUserByCredentials(login.getLoginName(), login.getLoginPass());
			if(userDB == null) { 
				addActionError("Username not exists!");
				return ERROR;
			} else {
				String logID = new String(Integer.toString(userDB.getLoginId()));
				sessionmap.put("login", logID);
				sessionmap.put("name", userDB.getLoginName());
				sessionmap.put("level", userDB.getLevel());
				return SUCCESS;
			}
		}
		return ERROR; 
	}
	
	public void setSession(Map map) {
		sessionmap=(SessionMap)map;
	}
	
	public String logout(){
		sessionmap.invalidate();
		return "success";
	}
	
	@Override
	public Login getModel() {
		return login;
	}
	
	private Login login = new Login();
	
	private ServletContext ctx;

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}
	
}