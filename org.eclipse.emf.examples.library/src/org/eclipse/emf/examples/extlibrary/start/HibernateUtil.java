
package org.eclipse.emf.examples.extlibrary.start;

import java.time.Duration;
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
	
	private enum Database {
		H2_LOCAL, H2_SERVER, H2_INTRANET, MARIA_DB_INTRANET, MYSQL_INTRANET, MSSQL_INTRANET
	}
	
	private enum ConnectionPool {
		C3P0, HIKARI, AGROAL
	}
	
	private static SessionFactory buildSessionFactory() {
		// Hibernate configuration
		Configuration configuration = new Configuration();
		
		addDatabaseToConfiguration(configuration, Database.H2_LOCAL);
		addConnectionPoolToConfiguration(configuration, ConnectionPool.C3P0);
		
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
	
	private static void addDatabaseToConfiguration(Configuration configuration, Database database) {
		switch(database) {
			case H2_LOCAL: {
				configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/test;AUTO_SERVER=TRUE");
				configuration.setProperty("hibernate.connection.username", "sa");
				configuration.setProperty("hibernate.connection.password", "");
				break;
			}
			case H2_SERVER: {
				configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:h2:tcp://87.106.141.12:9092/C:/Labimage/test;AUTO_SERVER=TRUE");
				configuration.setProperty("hibernate.connection.username", "sa");
				configuration.setProperty("hibernate.connection.password", "");
				break;
			}
			case H2_INTRANET: {
				configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:h2:tcp://192.168.18.79:9092/labimage;AUTO_SERVER=TRUE");
				configuration.setProperty("hibernate.connection.username", "sa");
				configuration.setProperty("hibernate.connection.password", "");
				break;
			}
			case MARIA_DB_INTRANET: {
				configuration.setProperty("hibernate.connection.driver_class", "org.mariadb.jdbc.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:mariadb://192.168.18.111:3306/labimage");
				configuration.setProperty("hibernate.connection.username", "labimage");
				configuration.setProperty("hibernate.connection.password", "labimage23");
				break;
			}
			case MYSQL_INTRANET: {
				configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				configuration.setProperty("hibernate.connection.url", "jdbc:mysql://192.168.18.111:3306/labimage");
				configuration.setProperty("hibernate.connection.username", "labimage");
				configuration.setProperty("hibernate.connection.password", "labimage23");
				break;
			}
			case MSSQL_INTRANET: {
				configuration.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				configuration.setProperty("hibernate.connection.url", "jdbc:sqlserver://192.168.18.94:1433;databaseName=labimage");
				configuration.setProperty("hibernate.connection.username", "sa");
				configuration.setProperty("hibernate.connection.password", "kbi2020");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + database);
		}
	}
	
	private static void addConnectionPoolToConfiguration(Configuration configuration, ConnectionPool connectionPool) {
		switch(connectionPool) {
			case C3P0:
				configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
				configuration.setProperty("hibernate.c3p0.min_size", 5);
				configuration.setProperty("hibernate.c3p0.max_size", 20);
				configuration.setProperty("hibernate.c3p0.timeout", 300);
				configuration.setProperty("hibernate.c3p0.max_statements", 50);
				configuration.setProperty("hibernate.c3p0.idle_test_period", 3000);
				break;
			case HIKARI:
				configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.HikariCPConnectionProvider");
				configuration.setProperty("hibernate.hikari.minimumIdle", 5);
				configuration.setProperty("hibernate.hikari.maximumPoolSize", 20);
				configuration.setProperty("hibernate.hikari.idleTimeout", 30000);
				configuration.setProperty("hibernate.hikari.connectionTimeout", 30000);
				configuration.setProperty("hibernate.hikari.maxLifetime", 1800000);
				break;
			case AGROAL:
				configuration.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.AgroalConnectionProvider");
				configuration.setProperty("hibernate.agroal.minSize", "5");
				configuration.setProperty("hibernate.agroal.maxSize", "20");
				configuration.setProperty("hibernate.agroal.idleTimeout", Duration.ofMillis(30000).toString());
				configuration.setProperty("hibernate.agroal.maxLifetime", Duration.ofMillis(60000).toString());
				configuration.setProperty("hibernate.agroal.acquisitionTimeout", Duration.ofMillis(1000).toString());
				configuration.setProperty("hibernate.agroal.reapTimeout", Duration.ofMillis(10000).toString());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + connectionPool);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
