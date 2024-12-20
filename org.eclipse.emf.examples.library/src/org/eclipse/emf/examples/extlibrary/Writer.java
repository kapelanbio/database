/**
 */

package org.eclipse.emf.examples.extlibrary;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Writer</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Writer#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Writer#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getWriter()
 * @model
 * @generated
 */
public interface Writer extends Person {
	
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getWriter_Name()
	 * @model
	 * @generated
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.Writer#getName <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);
	
	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Book}. It is bidirectional and its opposite is '{@link org.eclipse.emf.examples.extlibrary.Book#getAuthor <em>Author</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getWriter_Books()
	 * @see org.eclipse.emf.examples.extlibrary.Book#getAuthor
	 * @model opposite="author"
	 * @generated NOT
	 */
	List<Book> getBooks();
	
} // Writer
