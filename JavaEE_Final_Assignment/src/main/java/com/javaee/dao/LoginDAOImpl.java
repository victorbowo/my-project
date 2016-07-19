package com.javaee.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.javaee.model.Login;

public class LoginDAOImpl implements LoginDAO{
	
		private SessionFactory sf;
		
		public LoginDAOImpl(SessionFactory sf){
			this.sf = sf;
		}
		
		@Override
		public Login getUserByCredentials(String loginName, String loginPass) {
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Login where loginName=:loginName and loginPass=:loginPass");
			query.setString("loginName", loginName); 
			query.setString("loginPass", loginPass);
			Login login = (Login) query.uniqueResult();
			tx.commit();
			session.close();
			return login;
		}
		
		public Login saveUser(Login login) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(login);
			session.getTransaction().commit();
			session.close();
			return login;
		}
}

