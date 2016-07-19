package com.javaee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javaee.model.Files;

public class FileUploadDAOImpl implements FileUploadDAO{
	private SessionFactory sf;
	
	public FileUploadDAOImpl(SessionFactory sf){
		this.sf = sf;
	}
	
	public Files saveFiles(Files files) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(files);
		session.getTransaction().commit();
		session.close();
		return files;
	}

}
