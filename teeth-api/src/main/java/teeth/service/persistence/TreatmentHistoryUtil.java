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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import teeth.model.TreatmentHistory;

/**
 * The persistence utility for the treatment history service. This utility wraps <code>teeth.service.persistence.impl.TreatmentHistoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentHistoryPersistence
 * @generated
 */
public class TreatmentHistoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TreatmentHistory treatmentHistory) {
		getPersistence().clearCache(treatmentHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TreatmentHistory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TreatmentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TreatmentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TreatmentHistory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TreatmentHistory update(TreatmentHistory treatmentHistory) {
		return getPersistence().update(treatmentHistory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TreatmentHistory update(
		TreatmentHistory treatmentHistory, ServiceContext serviceContext) {

		return getPersistence().update(treatmentHistory, serviceContext);
	}

	/**
	 * Returns all the treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID(long patientID) {
		return getPersistence().findByTeeth_PatientID(patientID);
	}

	/**
	 * Returns a range of all the treatment histories where patientID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end) {

		return getPersistence().findByTeeth_PatientID(patientID, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findByTeeth_PatientID(
			patientID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeeth_PatientID(
			patientID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_First(
			long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_First(
			patientID, orderByComparator);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_First(
		long patientID, OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_First(
			patientID, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_Last(
			long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_Last(
			patientID, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_Last(
		long patientID, OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_Last(
			patientID, orderByComparator);
	}

	/**
	 * Returns the treatment histories before and after the current treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param treatmentID the primary key of the current treatment history
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory[] findByTeeth_PatientID_PrevAndNext(
			long treatmentID, long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_PrevAndNext(
			treatmentID, patientID, orderByComparator);
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 */
	public static void removeByTeeth_PatientID(long patientID) {
		getPersistence().removeByTeeth_PatientID(patientID);
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the number of matching treatment histories
	 */
	public static int countByTeeth_PatientID(long patientID) {
		return getPersistence().countByTeeth_PatientID(patientID);
	}

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum) {

		return getPersistence().findByTeeth_PatientID_TeethNum(
			patientID, teethNum);
	}

	/**
	 * Returns a range of all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end) {

		return getPersistence().findByTeeth_PatientID_TeethNum(
			patientID, teethNum, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findByTeeth_PatientID_TeethNum(
			patientID, teethNum, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeeth_PatientID_TeethNum(
			patientID, teethNum, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_TeethNum_First(
			long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_First(
			patientID, teethNum, orderByComparator);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_TeethNum_First(
		long patientID, long teethNum,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_First(
			patientID, teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_TeethNum_Last(
			long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_Last(
			patientID, teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_TeethNum_Last(
		long patientID, long teethNum,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_Last(
			patientID, teethNum, orderByComparator);
	}

	/**
	 * Returns the treatment histories before and after the current treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param treatmentID the primary key of the current treatment history
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory[] findByTeeth_PatientID_TeethNum_PrevAndNext(
			long treatmentID, long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_PrevAndNext(
			treatmentID, patientID, teethNum, orderByComparator);
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 */
	public static void removeByTeeth_PatientID_TeethNum(
		long patientID, long teethNum) {

		getPersistence().removeByTeeth_PatientID_TeethNum(patientID, teethNum);
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the number of matching treatment histories
	 */
	public static int countByTeeth_PatientID_TeethNum(
		long patientID, long teethNum) {

		return getPersistence().countByTeeth_PatientID_TeethNum(
			patientID, teethNum);
	}

	/**
	 * Returns all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate) {

		return getPersistence().findByTeeth_PatientID_Date(
			patientID, treatmentDate);
	}

	/**
	 * Returns a range of all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end) {

		return getPersistence().findByTeeth_PatientID_Date(
			patientID, treatmentDate, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findByTeeth_PatientID_Date(
			patientID, treatmentDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeeth_PatientID_Date(
			patientID, treatmentDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_Date_First(
			long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_Date_First(
			patientID, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_Date_First(
		long patientID, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_Date_First(
			patientID, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_Date_Last(
			long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_Date_Last(
			patientID, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_Date_Last(
		long patientID, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_Date_Last(
			patientID, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the treatment histories before and after the current treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param treatmentID the primary key of the current treatment history
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory[] findByTeeth_PatientID_Date_PrevAndNext(
			long treatmentID, long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_Date_PrevAndNext(
			treatmentID, patientID, treatmentDate, orderByComparator);
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 */
	public static void removeByTeeth_PatientID_Date(
		long patientID, Date treatmentDate) {

		getPersistence().removeByTeeth_PatientID_Date(patientID, treatmentDate);
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	public static int countByTeeth_PatientID_Date(
		long patientID, Date treatmentDate) {

		return getPersistence().countByTeeth_PatientID_Date(
			patientID, treatmentDate);
	}

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate);
	}

	/**
	 * Returns a range of all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end) {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment histories
	 */
	public static List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_TeethNum_Date_First(
			long patientID, long teethNum, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date_First(
			patientID, teethNum, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_First(
		long patientID, long teethNum, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_Date_First(
			patientID, teethNum, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory findByTeeth_PatientID_TeethNum_Date_Last(
			long patientID, long teethNum, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date_Last(
			patientID, teethNum, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Last(
		long patientID, long teethNum, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_Date_Last(
			patientID, teethNum, treatmentDate, orderByComparator);
	}

	/**
	 * Returns the treatment histories before and after the current treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param treatmentID the primary key of the current treatment history
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory[]
			findByTeeth_PatientID_TeethNum_Date_PrevAndNext(
				long treatmentID, long patientID, long teethNum,
				Date treatmentDate,
				OrderByComparator<TreatmentHistory> orderByComparator)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date_PrevAndNext(
			treatmentID, patientID, teethNum, treatmentDate, orderByComparator);
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 */
	public static void removeByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		getPersistence().removeByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate);
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	public static int countByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		return getPersistence().countByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate);
	}

	/**
	 * Returns the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; or throws a <code>NoSuchTreatmentHistoryException</code> if it could not be found.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public static TreatmentHistory
			findByTeeth_PatientID_TeethNum_Date_Treatment(
				long patientID, long teethNum, Date treatmentDate,
				String treatment)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment);
	}

	/**
	 * Returns the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory
		fetchByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate,
			String treatment) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment);
	}

	/**
	 * Returns the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public static TreatmentHistory
		fetchByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate, String treatment,
			boolean useFinderCache) {

		return getPersistence().fetchByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment, useFinderCache);
	}

	/**
	 * Removes the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the treatment history that was removed
	 */
	public static TreatmentHistory
			removeByTeeth_PatientID_TeethNum_Date_Treatment(
				long patientID, long teethNum, Date treatmentDate,
				String treatment)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().removeByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment);
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the number of matching treatment histories
	 */
	public static int countByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment) {

		return getPersistence().countByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment);
	}

	/**
	 * Caches the treatment history in the entity cache if it is enabled.
	 *
	 * @param treatmentHistory the treatment history
	 */
	public static void cacheResult(TreatmentHistory treatmentHistory) {
		getPersistence().cacheResult(treatmentHistory);
	}

	/**
	 * Caches the treatment histories in the entity cache if it is enabled.
	 *
	 * @param treatmentHistories the treatment histories
	 */
	public static void cacheResult(List<TreatmentHistory> treatmentHistories) {
		getPersistence().cacheResult(treatmentHistories);
	}

	/**
	 * Creates a new treatment history with the primary key. Does not add the treatment history to the database.
	 *
	 * @param treatmentID the primary key for the new treatment history
	 * @return the new treatment history
	 */
	public static TreatmentHistory create(long treatmentID) {
		return getPersistence().create(treatmentID);
	}

	/**
	 * Removes the treatment history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history that was removed
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory remove(long treatmentID)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().remove(treatmentID);
	}

	public static TreatmentHistory updateImpl(
		TreatmentHistory treatmentHistory) {

		return getPersistence().updateImpl(treatmentHistory);
	}

	/**
	 * Returns the treatment history with the primary key or throws a <code>NoSuchTreatmentHistoryException</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory findByPrimaryKey(long treatmentID)
		throws teeth.exception.NoSuchTreatmentHistoryException {

		return getPersistence().findByPrimaryKey(treatmentID);
	}

	/**
	 * Returns the treatment history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history, or <code>null</code> if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory fetchByPrimaryKey(long treatmentID) {
		return getPersistence().fetchByPrimaryKey(treatmentID);
	}

	/**
	 * Returns all the treatment histories.
	 *
	 * @return the treatment histories
	 */
	public static List<TreatmentHistory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the treatment histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of treatment histories
	 */
	public static List<TreatmentHistory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the treatment histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of treatment histories
	 */
	public static List<TreatmentHistory> findAll(
		int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of treatment histories
	 */
	public static List<TreatmentHistory> findAll(
		int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the treatment histories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of treatment histories.
	 *
	 * @return the number of treatment histories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TreatmentHistoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TreatmentHistoryPersistence _persistence;

}