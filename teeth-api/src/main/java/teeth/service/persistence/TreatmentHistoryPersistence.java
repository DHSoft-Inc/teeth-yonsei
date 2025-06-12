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

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

import teeth.exception.NoSuchTreatmentHistoryException;

import teeth.model.TreatmentHistory;

/**
 * The persistence interface for the treatment history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentHistoryUtil
 * @generated
 */
@ProviderType
public interface TreatmentHistoryPersistence
	extends BasePersistence<TreatmentHistory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TreatmentHistoryUtil} to access the treatment history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the matching treatment histories
	 */
	public java.util.List<TreatmentHistory> findByTeeth_PatientID(
		long patientID);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_First(
			long patientID,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_First(
		long patientID,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_Last(
			long patientID,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_Last(
		long patientID,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

	/**
	 * Returns the treatment histories before and after the current treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param treatmentID the primary key of the current treatment history
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public TreatmentHistory[] findByTeeth_PatientID_PrevAndNext(
			long treatmentID, long patientID,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Removes all the treatment histories where patientID = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 */
	public void removeByTeeth_PatientID(long patientID);

	/**
	 * Returns the number of treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the number of matching treatment histories
	 */
	public int countByTeeth_PatientID(long patientID);

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the matching treatment histories
	 */
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_TeethNum_First(
			long patientID, long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_First(
		long patientID, long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Last(
			long patientID, long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Last(
		long patientID, long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public TreatmentHistory[] findByTeeth_PatientID_TeethNum_PrevAndNext(
			long treatmentID, long patientID, long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 */
	public void removeByTeeth_PatientID_TeethNum(long patientID, long teethNum);

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the number of matching treatment histories
	 */
	public int countByTeeth_PatientID_TeethNum(long patientID, long teethNum);

	/**
	 * Returns all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_Date_First(
			long patientID, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_Date_First(
		long patientID, Date treatmentDate,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	public TreatmentHistory findByTeeth_PatientID_Date_Last(
			long patientID, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_Date_Last(
		long patientID, Date treatmentDate,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public TreatmentHistory[] findByTeeth_PatientID_Date_PrevAndNext(
			long treatmentID, long patientID, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Removes all the treatment histories where patientID = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 */
	public void removeByTeeth_PatientID_Date(
		long patientID, Date treatmentDate);

	/**
	 * Returns the number of treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	public int countByTeeth_PatientID_Date(long patientID, Date treatmentDate);

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public java.util.List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator,
		boolean useFinderCache);

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
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_First(
			long patientID, long teethNum, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_First(
		long patientID, long teethNum, Date treatmentDate,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_Last(
			long patientID, long teethNum, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Last(
		long patientID, long teethNum, Date treatmentDate,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public TreatmentHistory[] findByTeeth_PatientID_TeethNum_Date_PrevAndNext(
			long treatmentID, long patientID, long teethNum, Date treatmentDate,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
				orderByComparator)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 */
	public void removeByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate);

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	public int countByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate);

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
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate, String treatment)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment);

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
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment,
		boolean useFinderCache);

	/**
	 * Removes the treatment history where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the treatment history that was removed
	 */
	public TreatmentHistory removeByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate, String treatment)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; and treatment = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @param treatment the treatment
	 * @return the number of matching treatment histories
	 */
	public int countByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment);

	/**
	 * Caches the treatment history in the entity cache if it is enabled.
	 *
	 * @param treatmentHistory the treatment history
	 */
	public void cacheResult(TreatmentHistory treatmentHistory);

	/**
	 * Caches the treatment histories in the entity cache if it is enabled.
	 *
	 * @param treatmentHistories the treatment histories
	 */
	public void cacheResult(
		java.util.List<TreatmentHistory> treatmentHistories);

	/**
	 * Creates a new treatment history with the primary key. Does not add the treatment history to the database.
	 *
	 * @param treatmentID the primary key for the new treatment history
	 * @return the new treatment history
	 */
	public TreatmentHistory create(long treatmentID);

	/**
	 * Removes the treatment history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history that was removed
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public TreatmentHistory remove(long treatmentID)
		throws NoSuchTreatmentHistoryException;

	public TreatmentHistory updateImpl(TreatmentHistory treatmentHistory);

	/**
	 * Returns the treatment history with the primary key or throws a <code>NoSuchTreatmentHistoryException</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	public TreatmentHistory findByPrimaryKey(long treatmentID)
		throws NoSuchTreatmentHistoryException;

	/**
	 * Returns the treatment history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history, or <code>null</code> if a treatment history with the primary key could not be found
	 */
	public TreatmentHistory fetchByPrimaryKey(long treatmentID);

	/**
	 * Returns all the treatment histories.
	 *
	 * @return the treatment histories
	 */
	public java.util.List<TreatmentHistory> findAll();

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
	public java.util.List<TreatmentHistory> findAll(int start, int end);

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
	public java.util.List<TreatmentHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator);

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
	public java.util.List<TreatmentHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentHistory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the treatment histories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of treatment histories.
	 *
	 * @return the number of treatment histories
	 */
	public int countAll();

}