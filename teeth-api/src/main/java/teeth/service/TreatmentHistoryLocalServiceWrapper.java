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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TreatmentHistoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentHistoryLocalService
 * @generated
 */
public class TreatmentHistoryLocalServiceWrapper
	implements ServiceWrapper<TreatmentHistoryLocalService>,
			   TreatmentHistoryLocalService {

	public TreatmentHistoryLocalServiceWrapper(
		TreatmentHistoryLocalService treatmentHistoryLocalService) {

		_treatmentHistoryLocalService = treatmentHistoryLocalService;
	}

	@Override
	public teeth.model.TreatmentHistory AddHistory(
		long patientID, long teethNum, java.util.Date treatmentDate,
		String treatment, String state, java.util.Date editedDate,
		long editedUserID) {

		return _treatmentHistoryLocalService.AddHistory(
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
	@Override
	public teeth.model.TreatmentHistory addTreatmentHistory(
		teeth.model.TreatmentHistory treatmentHistory) {

		return _treatmentHistoryLocalService.addTreatmentHistory(
			treatmentHistory);
	}

	/**
	 * Creates a new treatment history with the primary key. Does not add the treatment history to the database.
	 *
	 * @param treatmentID the primary key for the new treatment history
	 * @return the new treatment history
	 */
	@Override
	public teeth.model.TreatmentHistory createTreatmentHistory(
		long treatmentID) {

		return _treatmentHistoryLocalService.createTreatmentHistory(
			treatmentID);
	}

	@Override
	public teeth.model.TreatmentHistory deleteHistory(long treatmentID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentHistoryLocalService.deleteHistory(treatmentID);
	}

	@Override
	public teeth.model.TreatmentHistory deleteHistory(
		teeth.model.TreatmentHistory record) {

		return _treatmentHistoryLocalService.deleteHistory(record);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentHistoryLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public teeth.model.TreatmentHistory deleteTreatmentHistory(long treatmentID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentHistoryLocalService.deleteTreatmentHistory(
			treatmentID);
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
	@Override
	public teeth.model.TreatmentHistory deleteTreatmentHistory(
		teeth.model.TreatmentHistory treatmentHistory) {

		return _treatmentHistoryLocalService.deleteTreatmentHistory(
			treatmentHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _treatmentHistoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _treatmentHistoryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _treatmentHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _treatmentHistoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _treatmentHistoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _treatmentHistoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public teeth.model.TreatmentHistory fetchTreatmentHistory(
		long treatmentID) {

		return _treatmentHistoryLocalService.fetchTreatmentHistory(treatmentID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _treatmentHistoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _treatmentHistoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _treatmentHistoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public teeth.model.TreatmentHistory getPatientTreatmentByAll(
		long patientID, long teethNum, java.util.Date treatmentDate,
		String treatment) {

		return _treatmentHistoryLocalService.getPatientTreatmentByAll(
			patientID, teethNum, treatmentDate, treatment);
	}

	@Override
	public java.util.List<teeth.model.TreatmentHistory>
		getPatientTreatmentByDateAndTeethNum(
			long patientID, long teethNum, java.util.Date treatmentDate) {

		return _treatmentHistoryLocalService.
			getPatientTreatmentByDateAndTeethNum(
				patientID, teethNum, treatmentDate);
	}

	@Override
	public teeth.model.TreatmentHistory getPatientTreatmentByTreatmentID(
		long TreatmentID) {

		return _treatmentHistoryLocalService.getPatientTreatmentByTreatmentID(
			TreatmentID);
	}

	@Override
	public java.util.List<teeth.model.TreatmentHistory> getPatientTreatmentList(
		long patientID) {

		return _treatmentHistoryLocalService.getPatientTreatmentList(patientID);
	}

	@Override
	public java.util.List<teeth.model.TreatmentHistory>
		getPatientTreatmentListByDate(
			long patientID, java.util.Date treatmentDate) {

		return _treatmentHistoryLocalService.getPatientTreatmentListByDate(
			patientID, treatmentDate);
	}

	@Override
	public java.util.List<teeth.model.TreatmentHistory>
		getPatientTreatmentListByTeethNum(long patientID, long teethNum) {

		return _treatmentHistoryLocalService.getPatientTreatmentListByTeethNum(
			patientID, teethNum);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentHistoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<teeth.model.TreatmentHistory> getTreatmentHistories(
		int start, int end) {

		return _treatmentHistoryLocalService.getTreatmentHistories(start, end);
	}

	/**
	 * Returns the number of treatment histories.
	 *
	 * @return the number of treatment histories
	 */
	@Override
	public int getTreatmentHistoriesCount() {
		return _treatmentHistoryLocalService.getTreatmentHistoriesCount();
	}

	/**
	 * Returns the treatment history with the primary key.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history
	 * @throws PortalException if a treatment history with the primary key could not be found
	 */
	@Override
	public teeth.model.TreatmentHistory getTreatmentHistory(long treatmentID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentHistoryLocalService.getTreatmentHistory(treatmentID);
	}

	@Override
	public teeth.model.TreatmentHistory UpdateHistory(
		long treatmentID, String treatment, String state,
		java.util.Date editedDate, long editedUserID) {

		return _treatmentHistoryLocalService.UpdateHistory(
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
	@Override
	public teeth.model.TreatmentHistory updateTreatmentHistory(
		teeth.model.TreatmentHistory treatmentHistory) {

		return _treatmentHistoryLocalService.updateTreatmentHistory(
			treatmentHistory);
	}

	@Override
	public TreatmentHistoryLocalService getWrappedService() {
		return _treatmentHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		TreatmentHistoryLocalService treatmentHistoryLocalService) {

		_treatmentHistoryLocalService = treatmentHistoryLocalService;
	}

	private TreatmentHistoryLocalService _treatmentHistoryLocalService;

}