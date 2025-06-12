/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package teeth.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import teeth.exception.NoSuchTreatmentAuditException;

import teeth.model.TreatmentAudit;

/**
 * The persistence interface for the treatment audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentAuditUtil
 * @generated
 */
@ProviderType
public interface TreatmentAuditPersistence
	extends BasePersistence<TreatmentAudit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TreatmentAuditUtil} to access the treatment audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_TeethNum(long teethNum);

	/**
	 * Returns a range of all the treatment audits where teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end);

	/**
	 * Returns an ordered range of all the treatment audits where teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the treatment audits where teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByAudit_TeethNum_First(
			long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByAudit_TeethNum_First(
		long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByAudit_TeethNum_Last(
			long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByAudit_TeethNum_Last(
		long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit[] findByAudit_TeethNum_PrevAndNext(
			long AuditID, long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where teethNum = &#63; from the database.
	 *
	 * @param teethNum the teeth num
	 */
	public void removeByAudit_TeethNum(long teethNum);

	/**
	 * Returns the number of treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the number of matching treatment audits
	 */
	public int countByAudit_TeethNum(long teethNum);

	/**
	 * Returns all the treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_EditType(String editType);

	/**
	 * Returns a range of all the treatment audits where editType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param editType the edit type
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end);

	/**
	 * Returns an ordered range of all the treatment audits where editType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param editType the edit type
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the treatment audits where editType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param editType the edit type
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByAudit_EditType_First(
			String editType,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByAudit_EditType_First(
		String editType,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByAudit_EditType_Last(
			String editType,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByAudit_EditType_Last(
		String editType,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit[] findByAudit_EditType_PrevAndNext(
			long AuditID, String editType,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where editType = &#63; from the database.
	 *
	 * @param editType the edit type
	 */
	public void removeByAudit_EditType(String editType);

	/**
	 * Returns the number of treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the number of matching treatment audits
	 */
	public int countByAudit_EditType(String editType);

	/**
	 * Caches the treatment audit in the entity cache if it is enabled.
	 *
	 * @param treatmentAudit the treatment audit
	 */
	public void cacheResult(TreatmentAudit treatmentAudit);

	/**
	 * Caches the treatment audits in the entity cache if it is enabled.
	 *
	 * @param treatmentAudits the treatment audits
	 */
	public void cacheResult(java.util.List<TreatmentAudit> treatmentAudits);

	/**
	 * Creates a new treatment audit with the primary key. Does not add the treatment audit to the database.
	 *
	 * @param AuditID the primary key for the new treatment audit
	 * @return the new treatment audit
	 */
	public TreatmentAudit create(long AuditID);

	/**
	 * Removes the treatment audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit that was removed
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit remove(long AuditID)
		throws NoSuchTreatmentAuditException;

	public TreatmentAudit updateImpl(TreatmentAudit treatmentAudit);

	/**
	 * Returns the treatment audit with the primary key or throws a <code>NoSuchTreatmentAuditException</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit findByPrimaryKey(long AuditID)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the treatment audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit, or <code>null</code> if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit fetchByPrimaryKey(long AuditID);

	/**
	 * Returns all the treatment audits.
	 *
	 * @return the treatment audits
	 */
	public java.util.List<TreatmentAudit> findAll();

	/**
	 * Returns a range of all the treatment audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of treatment audits
	 */
	public java.util.List<TreatmentAudit> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the treatment audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of treatment audits
	 */
	public java.util.List<TreatmentAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns an ordered range of all the treatment audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of treatment audits
	 */
	public java.util.List<TreatmentAudit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the treatment audits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of treatment audits.
	 *
	 * @return the number of treatment audits
	 */
	public int countAll();

}