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
 * Provides a wrapper for {@link TreatmentAuditLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentAuditLocalService
 * @generated
 */
public class TreatmentAuditLocalServiceWrapper
	implements ServiceWrapper<TreatmentAuditLocalService>,
			   TreatmentAuditLocalService {

	public TreatmentAuditLocalServiceWrapper(
		TreatmentAuditLocalService treatmentAuditLocalService) {

		_treatmentAuditLocalService = treatmentAuditLocalService;
	}

	@Override
	public teeth.model.TreatmentAudit AddAudit(
		long teethNum, long editedUserID, java.util.Date TreatmentDate,
		String editType, String BeforeData, String afterData) {

		return _treatmentAuditLocalService.AddAudit(
			teethNum, editedUserID, TreatmentDate, editType, BeforeData,
			afterData);
	}

	/**
	 * Adds the treatment audit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentAudit the treatment audit
	 * @return the treatment audit that was added
	 */
	@Override
	public teeth.model.TreatmentAudit addTreatmentAudit(
		teeth.model.TreatmentAudit treatmentAudit) {

		return _treatmentAuditLocalService.addTreatmentAudit(treatmentAudit);
	}

	/**
	 * Creates a new treatment audit with the primary key. Does not add the treatment audit to the database.
	 *
	 * @param AuditID the primary key for the new treatment audit
	 * @return the new treatment audit
	 */
	@Override
	public teeth.model.TreatmentAudit createTreatmentAudit(long AuditID) {
		return _treatmentAuditLocalService.createTreatmentAudit(AuditID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentAuditLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the treatment audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit that was removed
	 * @throws PortalException if a treatment audit with the primary key could not be found
	 */
	@Override
	public teeth.model.TreatmentAudit deleteTreatmentAudit(long AuditID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentAuditLocalService.deleteTreatmentAudit(AuditID);
	}

	/**
	 * Deletes the treatment audit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentAudit the treatment audit
	 * @return the treatment audit that was removed
	 */
	@Override
	public teeth.model.TreatmentAudit deleteTreatmentAudit(
		teeth.model.TreatmentAudit treatmentAudit) {

		return _treatmentAuditLocalService.deleteTreatmentAudit(treatmentAudit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _treatmentAuditLocalService.dynamicQuery();
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

		return _treatmentAuditLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentAuditModelImpl</code>.
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

		return _treatmentAuditLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentAuditModelImpl</code>.
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

		return _treatmentAuditLocalService.dynamicQuery(
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

		return _treatmentAuditLocalService.dynamicQueryCount(dynamicQuery);
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

		return _treatmentAuditLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public teeth.model.TreatmentAudit fetchTreatmentAudit(long AuditID) {
		return _treatmentAuditLocalService.fetchTreatmentAudit(AuditID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _treatmentAuditLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<teeth.model.TreatmentAudit> getAuditByEditType(
		String EditType) {

		return _treatmentAuditLocalService.getAuditByEditType(EditType);
	}

	@Override
	public java.util.List<teeth.model.TreatmentAudit> getAuditByTeethNum(
		long teethNum) {

		return _treatmentAuditLocalService.getAuditByTeethNum(teethNum);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _treatmentAuditLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _treatmentAuditLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentAuditLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the treatment audit with the primary key.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws PortalException if a treatment audit with the primary key could not be found
	 */
	@Override
	public teeth.model.TreatmentAudit getTreatmentAudit(long AuditID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _treatmentAuditLocalService.getTreatmentAudit(AuditID);
	}

	/**
	 * Returns a range of all the treatment audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of treatment audits
	 */
	@Override
	public java.util.List<teeth.model.TreatmentAudit> getTreatmentAudits(
		int start, int end) {

		return _treatmentAuditLocalService.getTreatmentAudits(start, end);
	}

	/**
	 * Returns the number of treatment audits.
	 *
	 * @return the number of treatment audits
	 */
	@Override
	public int getTreatmentAuditsCount() {
		return _treatmentAuditLocalService.getTreatmentAuditsCount();
	}

	/**
	 * Updates the treatment audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TreatmentAuditLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param treatmentAudit the treatment audit
	 * @return the treatment audit that was updated
	 */
	@Override
	public teeth.model.TreatmentAudit updateTreatmentAudit(
		teeth.model.TreatmentAudit treatmentAudit) {

		return _treatmentAuditLocalService.updateTreatmentAudit(treatmentAudit);
	}

	@Override
	public TreatmentAuditLocalService getWrappedService() {
		return _treatmentAuditLocalService;
	}

	@Override
	public void setWrappedService(
		TreatmentAuditLocalService treatmentAuditLocalService) {

		_treatmentAuditLocalService = treatmentAuditLocalService;
	}

	private TreatmentAuditLocalService _treatmentAuditLocalService;

}