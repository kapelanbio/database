/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.examples.extlibrary.impl;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.impl.ItemImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.examples.extlibrary.impl.ItemImpl#getPublicationDate <em>Publication Date</em>}</li>
 * </ul>
 *
 * @generated
 */
@Entity
public abstract class ItemImpl extends EObjectImpl implements Item {
	
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int	ID_EDEFAULT					= 0;
	
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int				id							= ID_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getPublicationDate() <em>Publication Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublicationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date		PUBLICATION_DATE_EDEFAULT	= null;
	
	/**
	 * The cached value of the '{@link #getPublicationDate() <em>Publication Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPublicationDate()
	 * @generated
	 * @ordered
	 */
	protected Date					publicationDate				= PUBLICATION_DATE_EDEFAULT;
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EXTLibraryPackage.Literals.ITEM;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXTLibraryPackage.ITEM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublicationDate(Date newPublicationDate) {
		Date oldPublicationDate = publicationDate;
		publicationDate = newPublicationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EXTLibraryPackage.ITEM__PUBLICATION_DATE, oldPublicationDate, publicationDate));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EXTLibraryPackage.ITEM__ID:
				return getId();
			case EXTLibraryPackage.ITEM__PUBLICATION_DATE:
				return getPublicationDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EXTLibraryPackage.ITEM__ID:
				setId((Integer)newValue);
				return;
			case EXTLibraryPackage.ITEM__PUBLICATION_DATE:
				setPublicationDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EXTLibraryPackage.ITEM__ID:
				setId(ID_EDEFAULT);
				return;
			case EXTLibraryPackage.ITEM__PUBLICATION_DATE:
				setPublicationDate(PUBLICATION_DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EXTLibraryPackage.ITEM__ID:
				return id != ID_EDEFAULT;
			case EXTLibraryPackage.ITEM__PUBLICATION_DATE:
				return PUBLICATION_DATE_EDEFAULT == null ? publicationDate != null : !PUBLICATION_DATE_EDEFAULT.equals(publicationDate);
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", publicationDate: "); //$NON-NLS-1$
		result.append(publicationDate);
		result.append(')');
		return result.toString();
	}
	
} //ItemImpl
