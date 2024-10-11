/**
 */

package org.eclipse.emf.examples.extlibrary;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Circulating Item</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.CirculatingItem#getCopies <em>Copies</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.CirculatingItem#getBorrowers <em>Borrowers</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getCirculatingItem()
 * @model abstract="true"
 * @generated
 */
public interface CirculatingItem extends Item {
	
	/**
	 * Returns the value of the '<em><b>Copies</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Copies</em>' attribute.
	 * @see #setCopies(int)
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getCirculatingItem_Copies()
	 * @model required="true"
	 * @generated
	 */
	int getCopies();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.examples.extlibrary.CirculatingItem#getCopies <em>Copies</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Copies</em>' attribute.
	 * @see #getCopies()
	 * @generated
	 */
	void setCopies(int value);
	
	/**
	 * Returns the value of the '<em><b>Borrowers</b></em>' reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.Borrower}. It is bidirectional and its opposite is '{@link org.eclipse.emf.examples.extlibrary.Borrower#getBorrowed <em>Borrowed</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Borrowers</em>' reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getCirculatingItem_Borrowers()
	 * @see org.eclipse.emf.examples.extlibrary.Borrower#getBorrowed
	 * @model opposite="borrowed" ordered="false"
	 * @generated NOT
	 */
	List<Borrower> getBorrowers();
	
} // CirculatingItem
