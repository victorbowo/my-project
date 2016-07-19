package com.javaee.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.javaee.dao.LoginDAO;
import com.javaee.dao.LoginDAOImpl;
import com.javaee.model.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements Action, ModelDriven<Login>, ServletContextAware {
	
	@Override
	public String execute() throws Exception {
		if (login.getLoginName().equals(null) || login.getLoginName().equals(""))
		{
			addActionError("Please fill the username!");
		}
		else if (login.getLoginPass().equals(null) || login.getLoginPass().equals(""))
		{
			addActionError("Please fill the password!");
		}
		else if (login.getLoginRepass().equals(null) || login.getLoginRepass().equals(""))
		{
			addActionError("Please fill the re-password!");
		}
		else if(!login.getLoginPass().equals(login.getLoginRepass()))
			{
				addActionError("Password and Confirm Password are not same!");
			} else {
				SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
				LoginDAO LoginDAO = new LoginDAOImpl(sf);
				Login loginDB = LoginDAO.getUserByCredentials(login.getLoginName(), login.getLoginPass());
				if(loginDB != null) {
					return ERROR; 
				} else {
				loginDB = LoginDAO.saveUser(login);
				return SUCCESS;
				}
			}
		return ERROR;
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