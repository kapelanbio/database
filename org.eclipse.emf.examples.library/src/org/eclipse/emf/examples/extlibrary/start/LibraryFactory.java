
package org.eclipse.emf.examples.extlibrary.start;

import java.util.Date;
import java.util.List;
import javax.swing.ProgressMonitor;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.Borrower;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.Employee;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;
import org.eclipse.emf.examples.extlibrary.impl.LibraryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.internal.EntityState;

public class LibraryFactory {
	
	public final static LibraryFactory instance = new LibraryFactory();
	
	void persistOrMerge(final ProgressMonitor progressMonitor, Library library) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			if(session.contains(library))
				session.merge(library);
			else {
				EntityState state = EntityState.getEntityState(library, null, null, session.unwrap(SessionImplementor.class), true);
				if(state == EntityState.DETACHED)
					session.merge(library);
				else
					session.persist(library);
			}
			transaction.commit();
			
		} catch(Exception e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		progressMonitor.setProgress(progressMonitor.getMaximum());
	}
	
	Library load(final ProgressMonitor progressMonitor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			List<LibraryImpl> libraryList = session.createQuery("FROM LibraryImpl", LibraryImpl.class).getResultList();
			for(Library library: libraryList)
				return library;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		progressMonitor.setProgress(progressMonitor.getMaximum());
		
		return null;
	}
	
	Library create(final ProgressMonitor progressMonitor) {
		final int bookCount = 500000;
		final int writerCount = bookCount / 10;
		final int employeeCount = 100;
		final int borrowerCount = 100;
		final int borrowedBooksMax = 5;
		
		progressMonitor.setMaximum(bookCount + writerCount + employeeCount + borrowerCount);
		
		final Library library = EXTLibraryFactory.eINSTANCE.createLibrary();
		
		int progress = 0;
		
		library.setAddress("LibraryAddress");
		library.setName("LibraryName");
		
		Employee manager = EXTLibraryFactory.eINSTANCE.createEmployee();
		manager.setAddress("ManagerAddress");
		manager.setFirstName("ManagerFirstName");
		manager.setLastName("ManagerLastName");
		
		library.getEmployees().add(manager);
		
		for(int i = 0; i < employeeCount; i++) {
			Employee employee = EXTLibraryFactory.eINSTANCE.createEmployee();
			employee.setAddress("EmployeeAddress" + (i + 1));
			employee.setFirstName("EmployeeFirstName" + (i + 1));
			employee.setLastName("EmployeeLastName" + (i + 1));
			employee.setManager(manager);
			library.getEmployees().add(employee);
			progressMonitor.setProgress(++progress);
		}
		
		for(int i = 0; i < writerCount; i++) {
			Writer writer = EXTLibraryFactory.eINSTANCE.createWriter();
			writer.setAddress("WriterAddress" + (i + 1));
			writer.setFirstName("WriterFirstName" + (i + 1));
			writer.setLastName("WriterLastName" + (i + 1));
			library.getWriters().add(writer);
			progressMonitor.setProgress(++progress);
		}
		
		for(int i = 0; i < bookCount; i++) {
			Book book = EXTLibraryFactory.eINSTANCE.createBook();
			book.setAuthor(library.getWriters().get((int) (Math.random() * library.getWriters().size() - 1)));
			book.setCategory(BookCategory.get((int) Math.random() * 2));
			book.setCopies(1 + (int) (Math.random() * 10));
			book.setPages(25 + (int) (Math.random() * 775));
			book.setPublicationDate(new Date((long) (Math.random() * System.currentTimeMillis())));
			book.setTitle("BookTitle" + (i + 1));
			library.getBooks().add(book);
			progressMonitor.setProgress(++progress);
		}
		
		for(int i = 0; i < borrowerCount; i++) {
			Borrower borrower = EXTLibraryFactory.eINSTANCE.createBorrower();
			borrower.setAddress("BorrowerAddress" + (i + 1));
			borrower.setFirstName("BorrowerFirstName" + (i + 1));
			borrower.setLastName("BorrowerLastName" + (i + 1));
			for(int j = 0; j < 1 + (int) (Math.random() * (borrowedBooksMax - 1)); j++)
				borrower.getBorrowed().add(library.getBooks().get((int) (Math.random() * library.getBooks().size() - 1)));
			library.getBorrowers().add(borrower);
			progressMonitor.setProgress(++progress);
		}
		return library;
	}
	
}
