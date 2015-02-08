package com.tje.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.tje.hibernate.tutorial.model.Student;

public class ApplicationRunner {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");

	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                configuration.getProperties()).build();
	        return configuration.buildSessionFactory(serviceRegistry);
	        
	    }
	
	public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	}
	
	public static void main(String[] args) {
		Session session = ApplicationRunner.getSessionFactory().openSession();
		session.beginTransaction();
        Student student = new Student();
        student.setName("Open Source Lover");
        student.setAge(29);
        student.setStandard("9th");
        session.save(student);
        session.getTransaction().commit();
	}

}
