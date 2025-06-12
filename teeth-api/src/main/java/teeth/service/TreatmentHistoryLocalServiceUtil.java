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

package teeth.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import teeth.model.TreatmentHistory;

/**
 * Provides the local service utility for TreatmentHistory. This utility wraps
 * <code>teeth.service.impl.TreatmentHistoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentHistoryLocalService
 * @generated
 */
public class TreatmentHistoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>teeth.service.impl.TreatmentHistoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TreatmentHistory AddHistory(
		long patientID, long teethNum, java.util.Date treatmentDate,
		String treatment, String state, java.util.Date editedDate,
		long editedUserID) {

		return getService().AddHistory(
			patientID, teethNum, treatmentDate, treatment, state, editedDate,
			editedUserID);
	}

	/**
	 * Adds the treatment history to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentHistory the treatment history
	 * @return the treatment history that was added
	 */
	public static TreatmentHistory addTreatmentHistory(
		TreatmentHistory treatmentHistory) {

		return getService().addTreatmentHistory(treatmentHistory);
	}

	/**
	 * Creates a new treatment history with the primary key. Does not add the treatment history to the database.
	 *
	 * @param treatmentID the primary key for the new treatment history
	 * @return the new treatment history
	 */
	public static TreatmentHistory createTreatmentHistory(long treatmentID) {
		return getService().createTreatmentHistory(treatmentID);
	}

	public static TreatmentHistory deleteHistory(long treatmentID)
		throws PortalException {

		return getService().deleteHistory(treatmentID);
	}

	public static TreatmentHistory deleteHistory(TreatmentHistory record) {
		return getService().deleteHistory(record);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the treatment history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history that was removed
	 * @throws PortalException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory deleteTreatmentHistory(long treatmentID)
		throws PortalException {

		return getService().deleteTreatmentHistory(treatmentID);
	}

	/**
	 * Deletes the treatment history from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentHistory the treatment history
	 * @return the treatment history that was removed
	 */
	public static TreatmentHistory deleteTreatmentHistory(
		TreatmentHistory treatmentHistory) {

		return getService().deleteTreatmentHistory(treatmentHistory);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TreatmentHistory fetchTreatmentHistory(long treatmentID) {
		return getService().fetchTreatmentHistory(treatmentID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static TreatmentHistory getPatientTreatmentByAll(
		long patientID, long teethNum, java.util.Date treatmentDate,
		String treatment) {

		return getService().getPatientTreatmentByAll(
			patientID, teethNum, treatmentDate, treatment);
	}

	public static List<TreatmentHistory> getPatientTreatmentByDateAndTeethNum(
		long patientID, long teethNum, java.util.Date treatmentDate) {

		return getService().getPatientTreatmentByDateAndTeethNum(
			patientID, teethNum, treatmentDate);
	}

	public static TreatmentHistory getPatientTreatmentByTreatmentID(
		long TreatmentID) {

		return getService().getPatientTreatmentByTreatmentID(TreatmentID);
	}

	public static List<TreatmentHistory> getPatientTreatmentList(
		long patientID) {

		return getService().getPatientTreatmentList(patientID);
	}

	public static List<TreatmentHistory> getPatientTreatmentListByDate(
		long patientID, java.util.Date treatmentDate) {

		return getService().getPatientTreatmentListByDate(
			patientID, treatmentDate);
	}

	public static List<TreatmentHistory> getPatientTreatmentListByTeethNum(
		long patientID, long teethNum) {

		return getService().getPatientTreatmentListByTeethNum(
			patientID, teethNum);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the treatment histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentHistoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment histories
	 * @param end the upper bound of the range of treatment histories (not inclusive)
	 * @return the range of treatment histories
	 */
	public static List<TreatmentHistory> getTreatmentHistories(
		int start, int end) {

		return getService().getTreatmentHistories(start, end);
	}

	/**
	 * Returns the number of treatment histories.
	 *
	 * @return the number of treatment histories
	 */
	public static int getTreatmentHistoriesCount() {
		return getService().getTreatmentHistoriesCount();
	}

	/**
	 * Returns the treatment history with the primary key.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history
	 * @throws PortalException if a treatment history with the primary key could not be found
	 */
	public static TreatmentHistory getTreatmentHistory(long treatmentID)
		throws PortalException {

		return getService().getTreatmentHistory(treatmentID);
	}

	public static TreatmentHistory UpdateHistory(
		long treatmentID, String treatment, String state,
		java.util.Date editedDate, long editedUserID) {

		return getService().UpdateHistory(
			treatmentID, treatment, state, editedDate, editedUserID);
	}

	/**
	 * Updates the treatment history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentHistoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentHistory the treatment history
	 * @return the treatment history that was updated
	 */
	public static TreatmentHistory updateTreatmentHistory(
		TreatmentHistory treatmentHistory) {

		return getService().updateTreatmentHistory(treatmentHistory);
	}

	public static TreatmentHistoryLocalService getService() {
		return _service;
	}

	private static volatile TreatmentHistoryLocalService _service;

}