/**
 */

package org.eclipse.emf.examples.extlibrary;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Library</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getWriters <em>Writers</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getEmployees <em>Employees</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getBorrowers <em>Borrowers</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Library#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends Addressable {
	
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Id()
	 * @model id="true"
	 * @generated
	 */
	int getId();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.Library#getId <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);
	
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Name()
	 * @model
	 * @generated
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.Library#getName <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	
	/**
	 * Returns the value of the '<em><b>Writers</b></em>' containment reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Writer}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Writers</em>' containment reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Writers()
	 * @model containment="true" resolveProxies="true"
	 * @generated NOT
	 */
	List<Writer> getWriters();
	
	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Employee}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Employees()
	 * @model containment="true" resolveProxies="true"
	 * @generated NOT
	 */
	List<Employee> getEmployees();
	
	/**
	 * Returns the value of the '<em><b>Borrowers</b></em>' containment reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Borrower}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Borrowers</em>' containment reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Borrowers()
	 * @model containment="true" resolveProxies="true"
	 * @generated NOT
	 */
	List<Borrower> getBorrowers();
	
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Book}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getLibrary_Books()
	 * @model containment="true" resolveProxies="true"
	 * @generated NOT
	 */
	List<Book> getBooks();
	
} // Library
