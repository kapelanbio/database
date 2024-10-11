/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.examples.extlibrary.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.examples.extlibrary.Book;
import org.eclipse.emf.examples.extlibrary.Borrower;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Employee;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.examples.extlibrary.Writer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Library</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getAddress <em>Address</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getWriters <em>Writers</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getEmployees <em>Employees</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getBorrowers <em>Borrowers</em>}</li>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.LibraryImpl#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity
public class LibraryImpl extends EObjectImpl implements Library {
	
	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String	ADDRESS_EDEFAULT	= null;
	
	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String				address				= ADDRESS_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int		ID_EDEFAULT			= 0;
	
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int					id					= ID_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String	NAME_EDEFAULT		= null;
	
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String				name				= NAME_EDEFAULT;
	
	/**
	 * The cached value of the '{@link #getWriters() <em>Writers</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWriters()
	 * @generated NOT
	 * @ordered
	 */
	@OneToMany(targetEntity = WriterImpl.class, cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Writer>			writers;
	
	/**
	 * The cached value of the '{@link #getEmployees() <em>Employees</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEmployees()
	 * @generated
	 * @ordered
	 */
	@OneToMany(targetEntity = EmployeeImpl.class, cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Employee>		employees;
	
	/**
	 * The cached value of the '{@link #getBorrowers() <em>Borrowers</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBorrowers()
	 * @generated
	 * @ordered
	 */
	@OneToMany(targetEntity = BorrowerImpl.class, cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Borrower>		borrowers;
	
	/**
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBooks()
	 * @generated NOT
	 * @ordered
	 */
	@OneToMany(targetEntity = BookImpl.class, cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Book>			books;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EXTLibraryPackage.Literals.LIBRARY;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAddress(String newAddress) {
		String oldAddress = address;
		address = newAddress;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXTLibraryPackage.LIBRARY__ADDRESS, oldAddress, address));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXTLibraryPackage.LIBRARY__ID, oldId, id));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXTLibraryPackage.LIBRARY__NAME, oldName, name));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Writer> getWriters() {
		if(writers == null) {
			writers = new EObjectContainmentEList.Resolving<Writer>(Writer.class, this, EXTLibraryPackage.LIBRARY__WRITERS);
		}
		return writers;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Employee> getEmployees() {
		if(employees == null) {
			employees = new EObjectContainmentEList.Resolving<Employee>(Employee.class, this, EXTLibraryPackage.LIBRARY__EMPLOYEES);
		}
		return employees;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Borrower> getBorrowers() {
		if(borrowers == null) {
			borrowers = new EObjectContainmentEList.Resolving<Borrower>(Borrower.class, this, EXTLibraryPackage.LIBRARY__BORROWERS);
		}
		return borrowers;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<Book> getBooks() {
		if(books == null) {
			books = new EObjectContainmentEList.Resolving<Book>(Book.class, this, EXTLibraryPackage.LIBRARY__BOOKS);
		}
		return books;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
			case EXTLibraryPackage.LIBRARY__WRITERS:
				return ((InternalEList<?>) getWriters()).basicRemove(otherEnd, msgs);
			case EXTLibraryPackage.LIBRARY__EMPLOYEES:
				return ((InternalEList<?>) getEmployees()).basicRemove(otherEnd, msgs);
			case EXTLibraryPackage.LIBRARY__BORROWERS:
				return ((InternalEList<?>) getBorrowers()).basicRemove(otherEnd, msgs);
			case EXTLibraryPackage.LIBRARY__BOOKS:
				return ((InternalEList<?>) getBooks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
			case EXTLibraryPackage.LIBRARY__ADDRESS:
				return getAddress();
			case EXTLibraryPackage.LIBRARY__ID:
				return getId();
			case EXTLibraryPackage.LIBRARY__NAME:
				return getName();
			case EXTLibraryPackage.LIBRARY__WRITERS:
				return getWriters();
			case EXTLibraryPackage.LIBRARY__EMPLOYEES:
				return getEmployees();
			case EXTLibraryPackage.LIBRARY__BORROWERS:
				return getBorrowers();
			case EXTLibraryPackage.LIBRARY__BOOKS:
				return getBooks();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
			case EXTLibraryPackage.LIBRARY__ADDRESS:
				setAddress((String) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__ID:
				setId((Integer) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__NAME:
				setName((String) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__WRITERS:
				getWriters().clear();
				getWriters().addAll((Collection<? extends Writer>) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__EMPLOYEES:
				getEmployees().clear();
				getEmployees().addAll((Collection<? extends Employee>) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__BORROWERS:
				getBorrowers().clear();
				getBorrowers().addAll((Collection<? extends Borrower>) newValue);
				return;
			case EXTLibraryPackage.LIBRARY__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
			case EXTLibraryPackage.LIBRARY__ADDRESS:
				setAddress(ADDRESS_EDEFAULT);
				return;
			case EXTLibraryPackage.LIBRARY__ID:
				setId(ID_EDEFAULT);
				return;
			case EXTLibraryPackage.LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EXTLibraryPackage.LIBRARY__WRITERS:
				getWriters().clear();
				return;
			case EXTLibraryPackage.LIBRARY__EMPLOYEES:
				getEmployees().clear();
				return;
			case EXTLibraryPackage.LIBRARY__BORROWERS:
				getBorrowers().clear();
				return;
			case EXTLibraryPackage.LIBRARY__BOOKS:
				getBooks().clear();
				return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
			case EXTLibraryPackage.LIBRARY__ADDRESS:
				return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
			case EXTLibraryPackage.LIBRARY__ID:
				return id != ID_EDEFAULT;
			case EXTLibraryPackage.LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EXTLibraryPackage.LIBRARY__WRITERS:
				return writers != null && !writers.isEmpty();
			case EXTLibraryPackage.LIBRARY__EMPLOYEES:
				return employees != null && !employees.isEmpty();
			case EXTLibraryPackage.LIBRARY__BORROWERS:
				return borrowers != null && !borrowers.isEmpty();
			case EXTLibraryPackage.LIBRARY__BOOKS:
				return books != null && !books.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();
		
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (address: "); //$NON-NLS-1$
		result.append(address);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}
	
} //LibraryImpl
