
package org.eclipse.emf.examples.extlibrary.start;

import org.eclipse.emf.examples.extlibrary.impl.BookImpl;
import org.eclipse.emf.examples.extlibrary.impl.BorrowerImpl;
import org.eclipse.emf.examples.extlibrary.impl.CirculatingItemImpl;
import org.eclipse.emf.examples.extlibrary.impl.EmployeeImpl;
import org.eclipse.emf.examples.extlibrary.impl.ItemImpl;
import org.eclipse.emf.examples.extlibrary.impl.LibraryImpl;
import org.eclipse.emf.examples.extlibrary.impl.PersonImpl;
import org.eclipse.emf.examples.extlibrary.impl.WriterImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		// Hibernate configuration
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/test;AUTO_SERVER=TRUE");
		configuration.setProperty("hibernate.connection.username", "sa");
		configuration.setProperty("hibernate.connection.password", "");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.show_sql", "false");
		
		configuration.addAnnotatedClass(BookImpl.class);
		configuration.addAnnotatedClass(CirculatingItemImpl.class);
		configuration.addAnnotatedClass(EmployeeImpl.class);
		configuration.addAnnotatedClass(ItemImpl.class);
		configuration.addAnnotatedClass(LibraryImpl.class);
		configuration.addAnnotatedClass(PersonImpl.class);
		configuration.addAnnotatedClass(WriterImpl.class);
		configuration.addAnnotatedClass(BorrowerImpl.class);
		
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
