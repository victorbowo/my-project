package com.javaee.model;

// Generated Jan 3, 2015 5:41:54 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Login generated by hbm2java
 */
@SuppressWarnings("serial")
public class Login implements java.io.Serializable {

	private Integer loginId;
	private String loginName;
	private String loginPass;
	private String level;
	private String loginRepass;
	private Set fileses = new HashSet(0);
	
	public String getLoginRepass() {
		return loginRepass;
	}

	public void setLoginRepass(String loginRepass) {
		this.loginRepass = loginRepass;
	}

	public Login() {
	}

	public Login(String loginName, String loginPass, String level) {
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.level = level;
	}

	public Login(String loginName, String loginPass, String level, Set fileses) {
		this.loginName = loginName;
		this.loginPass = loginPass;
		this.level = level;
		this.fileses = fileses;
	}

	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPass() {
		return this.loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set getFileses() {
		return this.fileses;
	}

	public void setFileses(Set fileses) {
		this.fileses = fileses;
	}

}