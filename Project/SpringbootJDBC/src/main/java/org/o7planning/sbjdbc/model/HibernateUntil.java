package org.o7planning.sbjdbc.model;
import java.util.List;




import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUntil {
	private static SessionFactory sessionFactory = buildsSessionFactory() ;
	    /*private static Configuration cfg= null;
	 
	    static {
	        try {
	            cfg = new Configuration();
	            cfg.configure("hibernate.cfg.xml");
	            sessionFactory = cfg.buildSessionFactory();
	        } catch (HibernateException ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }*/
	 
	 // Hibernate 5:
	private static SessionFactory buildsSessionFactory() {
	  try {
	        if (sessionFactory == null) {
	            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
	                    .configure("/hibernate.cfg.xml").build();
	            Metadata metaData = new MetadataSources(standardRegistry)
	                    .getMetadataBuilder().build();
	            sessionFactory = metaData.getSessionFactoryBuilder().build();
	        }
	        return sessionFactory;
	    } catch (Throwable th) {

	        System.err.println("Enitial SessionFactory creation failed" + th);

	        throw new ExceptionInInitializerError(th);

	    }
	
	  }
	 
	  public static SessionFactory getSessionFactory() {
	      return sessionFactory;
	  }
	 
	  public static void shutdown() {
	      // Giải phóng cache và Connection Pools.
	      getSessionFactory().close();
	  }
	 
}
