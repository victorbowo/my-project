package com.javaee.dao;

import com.javaee.model.Login;

public interface LoginDAO {
	
	Login getUserByCredentials(String loginName, String loginPass);
	Login saveUser(Login login);
}

