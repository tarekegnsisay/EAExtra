package cs544.mum.edu.dataaccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cs544.mum.edu.models.Project;
import cs544.mum.edu.models.Task;
import cs544.mum.edu.models.Volunteer;

public class HibernateUtil {
private static final SessionFactory sessionFactory;
	
	static{
		try {
			
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Project.class);
			configuration.addAnnotatedClass(Task.class);
			configuration.addAnnotatedClass(Volunteer.class);
			configuration.configure();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			
		} catch (Throwable e) {
			
			e.printStackTrace();	
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
