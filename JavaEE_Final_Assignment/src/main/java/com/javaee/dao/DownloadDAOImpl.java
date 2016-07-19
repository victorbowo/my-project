package com.javaee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javaee.model.Files;

public class DownloadDAOImpl implements DownloadDAO{
	private SessionFactory sf;
	
	public DownloadDAOImpl(SessionFactory sf){
		this.sf = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Files> getFiles()
	{
		Session session = sf.openSession();
		session.beginTransaction();
		  
		List<Files> files = new ArrayList<Files>();
	    List<String> obj = new ArrayList<String>();
	    try
	    {
	    	obj = session.createQuery("select filename from Files").list();
	    	int i=0;
	    	while(i<obj.size()){
	    		Files temp = new Files(null,null,null);
	    		temp.setFilename(obj.get(i));
	    		files.add(i, temp);
	    		i++;
	    		}
	    	session.getTransaction().commit();
	    	session.close();
	    	}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return files;
	}
	
	@SuppressWarnings("unchecked")
	public List<Files> getFilesByUsers(Integer logId)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		  
		List<Files> files = new ArrayList<Files>();
	    List<String> obj = new ArrayList<String>();
	    try
	    {
	    	Query query = session.createQuery("select filename from Files where loginId=:loginId");
	    	query.setInteger("loginId", logId);
	    	obj = query.list();
	    	int i=0;
	    	while(i<obj.size()){
	    		Files temp = new Files(null,null,null);
	    		temp.setFilename(obj.get(i));
	    		files.add(i, temp);
	    		i++;
	    		}
	    	session.getTransaction().commit();
	    	session.close();
	    	}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return files;
	}
	
	@SuppressWarnings("unchecked")
	public List<Files> getFileByName(String fileName)
	{
		Session session = sf.openSession();
		session.beginTransaction();
		  
		List<Files> files = new ArrayList<Files>();
	    List<String> obj = new ArrayList<String>();
	    try
	    {
	    	Query query = session.createQuery("select filename from Files where filename=:fileName");
	    	query.setString("fileName", fileName);
	    	obj = query.list();
	    	int i=0;
	    	while(i<obj.size()){
	    		Files temp = new Files(null,null,null);
	    		temp.setFilename(obj.get(i));
	    		files.add(i, temp);
	    		i++;
	    		}
	    	session.getTransaction().commit();
	    	session.close();
	    	}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    return files;
	}
	
	public void deleteFiles(String fileName) {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "delete from Files where filename=:fileName";
		Query query = session.createQuery(hql);
		query.setString("fileName", fileName);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
