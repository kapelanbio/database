
package org.eclipse.emf.examples.extlibrary.start;

import java.util.Date;
import javax.swing.ProgressMonitor;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.BookCategory;
import org.eclipse.emf.examples.extlibrary.Borrower;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.Employee;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;

public class LibraryFactory {
	
	public final static LibraryFactory	instance	= new LibraryFactory();
	
	void save(final ProgressMonitor progressMonitor, Library library) {
		// TODO Save to database
	}
	
	Library load(final ProgressMonitor progressMonitor) {
		Library library = null;
		// TODO Load from database
		return library;
	}
	
	Library create(final ProgressMonitor progressMonitor) {
		final int bookCount = 50000;
		final int writerCount = bookCount / 10;
		final int employeeCount = 10;
		final int borrowerCount = 1000;
		final int borrowedBooksMax = 10;
		
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
