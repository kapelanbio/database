/**
 */

package org.eclipse.emf.examples.extlibrary.impl;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.examples.extlibrary.Borrower;
import org.eclipse.emf.examples.extlibrary.CirculatingItem;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Borrower</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.emf.examples.extlibrary.impl.BorrowerImpl#getBorrowed <em>Borrowed</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity
public class BorrowerImpl extends PersonImpl implements Borrower {
	
	/**
	 * The cached value of the '{@link #getBorrowed() <em>Borrowed</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBorrowed()
	 * @generated NOT
	 * @ordered
	 */
	@ManyToMany(targetEntity = CirculatingItemImpl.class, mappedBy = "borrowers")
	protected List<CirculatingItem> borrowed;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BorrowerImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EXTLibraryPackage.Literals.BORROWER;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public List<CirculatingItem> getBorrowed() {
		if(borrowed == null) {
			borrowed = new EObjectWithInverseResolvingEList.ManyInverse<CirculatingItem>(CirculatingItem.class, this, EXTLibraryPackage.BORROWER__BORROWED, EXTLibraryPackage.CIRCULATING_ITEM__BORROWERS);
		}
		return borrowed;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
			case EXTLibraryPackage.BORROWER__BORROWED:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getBorrowed()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
			case EXTLibraryPackage.BORROWER__BORROWED:
				return ((InternalEList<?>) getBorrowed()).basicRemove(otherEnd, msgs);
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
			case EXTLibraryPackage.BORROWER__BORROWED:
				return getBorrowed();
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
			case EXTLibraryPackage.BORROWER__BORROWED:
				getBorrowed().clear();
				getBorrowed().addAll((Collection<? extends CirculatingItem>) newValue);
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
			case EXTLibraryPackage.BORROWER__BORROWED:
				getBorrowed().clear();
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
			case EXTLibraryPackage.BORROWER__BORROWED:
				return borrowed != null && !borrowed.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
} //BorrowerImpl
