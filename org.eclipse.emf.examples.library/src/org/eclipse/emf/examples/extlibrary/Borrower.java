/**
 */

package org.eclipse.emf.examples.extlibrary;

import java.util.List;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Borrower</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.Borrower#getBorrowed <em>Borrowed</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getBorrower()
 * @model
 * @generated
 */
public interface Borrower extends Person {
	
	/**
	 * Returns the value of the '<em><b>Borrowed</b></em>' reference list. The list contents are of type {@link org.eclipse.emf.examples.extlibrary.CirculatingItem}. It is bidirectional and its opposite is '{@link org.eclipse.emf.examples.extlibrary.CirculatingItem#getBorrowers <em>Borrowers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Borrowed</em>' reference list.
	 * @see org.eclipse.emf.examples.extlibrary.EXTLibraryPackage#getBorrower_Borrowed()
	 * @see org.eclipse.emf.examples.extlibrary.CirculatingItem#getBorrowers
	 * @model opposite="borrowers"
	 * @generated NOT
	 */
	List<CirculatingItem> getBorrowed();
	
} // Borrower
