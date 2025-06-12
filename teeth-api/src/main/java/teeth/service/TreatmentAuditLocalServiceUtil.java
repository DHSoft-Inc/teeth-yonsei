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

import teeth.model.TreatmentAudit;

/**
 * Provides the local service utility for TreatmentAudit. This utility wraps
 * <code>teeth.service.impl.TreatmentAuditLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentAuditLocalService
 * @generated
 */
public class TreatmentAuditLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>teeth.service.impl.TreatmentAuditLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static TreatmentAudit AddAudit(
		long teethNum, long editedUserID, java.util.Date TreatmentDate,
		String editType, String BeforeData, String afterData) {

		return getService().AddAudit(
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
	public static TreatmentAudit addTreatmentAudit(
		TreatmentAudit treatmentAudit) {

		return getService().addTreatmentAudit(treatmentAudit);
	}

	/**
	 * Creates a new treatment audit with the primary key. Does not add the treatment audit to the database.
	 *
	 * @param AuditID the primary key for the new treatment audit
	 * @return the new treatment audit
	 */
	public static TreatmentAudit createTreatmentAudit(long AuditID) {
		return getService().createTreatmentAudit(AuditID);
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
	public static TreatmentAudit deleteTreatmentAudit(long AuditID)
		throws PortalException {

		return getService().deleteTreatmentAudit(AuditID);
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
	public static TreatmentAudit deleteTreatmentAudit(
		TreatmentAudit treatmentAudit) {

		return getService().deleteTreatmentAudit(treatmentAudit);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentAuditModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>teeth.model.impl.TreatmentAuditModelImpl</code>.
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

	public static TreatmentAudit fetchTreatmentAudit(long AuditID) {
		return getService().fetchTreatmentAudit(AuditID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<TreatmentAudit> getAuditByEditType(String EditType) {
		return getService().getAuditByEditType(EditType);
	}

	public static List<TreatmentAudit> getAuditByTeethNum(long teethNum) {
		return getService().getAuditByTeethNum(teethNum);
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

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the treatment audit with the primary key.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws PortalException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit getTreatmentAudit(long AuditID)
		throws PortalException {

		return getService().getTreatmentAudit(AuditID);
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
	public static List<TreatmentAudit> getTreatmentAudits(int start, int end) {
		return getService().getTreatmentAudits(start, end);
	}

	/**
	 * Returns the number of treatment audits.
	 *
	 * @return the number of treatment audits
	 */
	public static int getTreatmentAuditsCount() {
		return getService().getTreatmentAuditsCount();
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
	public static TreatmentAudit updateTreatmentAudit(
		TreatmentAudit treatmentAudit) {

		return getService().updateTreatmentAudit(treatmentAudit);
	}

	public static TreatmentAuditLocalService getService() {
		return _service;
	}

	private static volatile TreatmentAuditLocalService _service;

}