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

import java.util.List;
import java.util.Map;
import java.util.Set;

import teeth.model.TreatmentAudit;

/**
 * The persistence utility for the treatment audit service. This utility wraps <code>teeth.service.persistence.impl.TreatmentAuditPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentAuditPersistence
 * @generated
 */
public class TreatmentAuditUtil {

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
	public static void clearCache(TreatmentAudit treatmentAudit) {
		getPersistence().clearCache(treatmentAudit);
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
	public static Map<Serializable, TreatmentAudit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TreatmentAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TreatmentAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TreatmentAudit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TreatmentAudit update(TreatmentAudit treatmentAudit) {
		return getPersistence().update(treatmentAudit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TreatmentAudit update(
		TreatmentAudit treatmentAudit, ServiceContext serviceContext) {

		return getPersistence().update(treatmentAudit, serviceContext);
	}

	/**
	 * Returns all the treatment audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the treatment audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByUuid_First(
			String uuid, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUuid_First(
		String uuid, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByUuid_Last(
			String uuid, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUuid_Last(
		String uuid, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByUuid_PrevAndNext(
			long AuditID, String uuid,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_PrevAndNext(
			AuditID, uuid, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of treatment audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching treatment audits
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTreatmentAuditException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByUUID_G(String uuid, long groupId)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the treatment audit where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the treatment audit that was removed
	 */
	public static TreatmentAudit removeByUUID_G(String uuid, long groupId)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of treatment audits where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching treatment audits
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByUuid_C_PrevAndNext(
			long AuditID, String uuid, long companyId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByUuid_C_PrevAndNext(
			AuditID, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching treatment audits
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByAudit_TeethNum(long teethNum) {
		return getPersistence().findByAudit_TeethNum(teethNum);
	}

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
	public static List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end) {

		return getPersistence().findByAudit_TeethNum(teethNum, start, end);
	}

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
	public static List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByAudit_TeethNum(
			teethNum, start, end, orderByComparator);
	}

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
	public static List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAudit_TeethNum(
			teethNum, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByAudit_TeethNum_First(
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_TeethNum_First(
			teethNum, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByAudit_TeethNum_First(
		long teethNum, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByAudit_TeethNum_First(
			teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByAudit_TeethNum_Last(
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_TeethNum_Last(
			teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByAudit_TeethNum_Last(
		long teethNum, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByAudit_TeethNum_Last(
			teethNum, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByAudit_TeethNum_PrevAndNext(
			long AuditID, long teethNum,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_TeethNum_PrevAndNext(
			AuditID, teethNum, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where teethNum = &#63; from the database.
	 *
	 * @param teethNum the teeth num
	 */
	public static void removeByAudit_TeethNum(long teethNum) {
		getPersistence().removeByAudit_TeethNum(teethNum);
	}

	/**
	 * Returns the number of treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the number of matching treatment audits
	 */
	public static int countByAudit_TeethNum(long teethNum) {
		return getPersistence().countByAudit_TeethNum(teethNum);
	}

	/**
	 * Returns all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId) {

		return getPersistence().findByG_C_P_L(
			groupId, crfId, patientID, linkId);
	}

	/**
	 * Returns a range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end) {

		return getPersistence().findByG_C_P_L(
			groupId, crfId, patientID, linkId, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByG_C_P_L(
			groupId, crfId, patientID, linkId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end, OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_P_L(
			groupId, crfId, patientID, linkId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_C_P_L_First(
			long groupId, long crfId, long patientID, long linkId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_First(
			groupId, crfId, patientID, linkId, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_C_P_L_First(
		long groupId, long crfId, long patientID, long linkId,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_C_P_L_First(
			groupId, crfId, patientID, linkId, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_C_P_L_Last(
			long groupId, long crfId, long patientID, long linkId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_Last(
			groupId, crfId, patientID, linkId, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_C_P_L_Last(
		long groupId, long crfId, long patientID, long linkId,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_C_P_L_Last(
			groupId, crfId, patientID, linkId, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByG_C_P_L_PrevAndNext(
			long AuditID, long groupId, long crfId, long patientID, long linkId,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_PrevAndNext(
			AuditID, groupId, crfId, patientID, linkId, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 */
	public static void removeByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId) {

		getPersistence().removeByG_C_P_L(groupId, crfId, patientID, linkId);
	}

	/**
	 * Returns the number of treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @return the number of matching treatment audits
	 */
	public static int countByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId) {

		return getPersistence().countByG_C_P_L(
			groupId, crfId, patientID, linkId);
	}

	/**
	 * Returns all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum) {

		return getPersistence().findByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum);
	}

	/**
	 * Returns a range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end) {

		return getPersistence().findByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end, OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_C_P_L_TN_First(
			long groupId, long crfId, long patientID, long linkId,
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_TN_First(
			groupId, crfId, patientID, linkId, teethNum, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_C_P_L_TN_First(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_C_P_L_TN_First(
			groupId, crfId, patientID, linkId, teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_C_P_L_TN_Last(
			long groupId, long crfId, long patientID, long linkId,
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_TN_Last(
			groupId, crfId, patientID, linkId, teethNum, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_C_P_L_TN_Last(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_C_P_L_TN_Last(
			groupId, crfId, patientID, linkId, teethNum, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByG_C_P_L_TN_PrevAndNext(
			long AuditID, long groupId, long crfId, long patientID, long linkId,
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_C_P_L_TN_PrevAndNext(
			AuditID, groupId, crfId, patientID, linkId, teethNum,
			orderByComparator);
	}

	/**
	 * Removes all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 */
	public static void removeByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum) {

		getPersistence().removeByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum);
	}

	/**
	 * Returns the number of treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 * @return the number of matching treatment audits
	 */
	public static int countByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum) {

		return getPersistence().countByG_C_P_L_TN(
			groupId, crfId, patientID, linkId, teethNum);
	}

	/**
	 * Returns all the treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByAudit_EditType(String editType) {
		return getPersistence().findByAudit_EditType(editType);
	}

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
	public static List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end) {

		return getPersistence().findByAudit_EditType(editType, start, end);
	}

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
	public static List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByAudit_EditType(
			editType, start, end, orderByComparator);
	}

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
	public static List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAudit_EditType(
			editType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByAudit_EditType_First(
			String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_EditType_First(
			editType, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByAudit_EditType_First(
		String editType, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByAudit_EditType_First(
			editType, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByAudit_EditType_Last(
			String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_EditType_Last(
			editType, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByAudit_EditType_Last(
		String editType, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByAudit_EditType_Last(
			editType, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByAudit_EditType_PrevAndNext(
			long AuditID, String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByAudit_EditType_PrevAndNext(
			AuditID, editType, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where editType = &#63; from the database.
	 *
	 * @param editType the edit type
	 */
	public static void removeByAudit_EditType(String editType) {
		getPersistence().removeByAudit_EditType(editType);
	}

	/**
	 * Returns the number of treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the number of matching treatment audits
	 */
	public static int countByAudit_EditType(String editType) {
		return getPersistence().countByAudit_EditType(editType);
	}

	/**
	 * Returns all the treatment audits where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the treatment audits where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByStatus(
		int status, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByStatus(
		int status, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByStatus_First(
			int status, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByStatus_First(
		int status, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByStatus_Last(
			int status, OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByStatus_Last(
		int status, OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where status = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByStatus_PrevAndNext(
			long AuditID, int status,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByStatus_PrevAndNext(
			AuditID, status, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of treatment audits where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching treatment audits
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @return the range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TreatmentAuditModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of treatment audits
	 * @param end the upper bound of the range of treatment audits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching treatment audits
	 */
	public static List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_S_First(
			long groupId, int status,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public static TreatmentAudit findByG_S_Last(
			long groupId, int status,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public static TreatmentAudit fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit[] findByG_S_PrevAndNext(
			long AuditID, long groupId, int status,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByG_S_PrevAndNext(
			AuditID, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the treatment audits where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching treatment audits
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Caches the treatment audit in the entity cache if it is enabled.
	 *
	 * @param treatmentAudit the treatment audit
	 */
	public static void cacheResult(TreatmentAudit treatmentAudit) {
		getPersistence().cacheResult(treatmentAudit);
	}

	/**
	 * Caches the treatment audits in the entity cache if it is enabled.
	 *
	 * @param treatmentAudits the treatment audits
	 */
	public static void cacheResult(List<TreatmentAudit> treatmentAudits) {
		getPersistence().cacheResult(treatmentAudits);
	}

	/**
	 * Creates a new treatment audit with the primary key. Does not add the treatment audit to the database.
	 *
	 * @param AuditID the primary key for the new treatment audit
	 * @return the new treatment audit
	 */
	public static TreatmentAudit create(long AuditID) {
		return getPersistence().create(AuditID);
	}

	/**
	 * Removes the treatment audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit that was removed
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit remove(long AuditID)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().remove(AuditID);
	}

	public static TreatmentAudit updateImpl(TreatmentAudit treatmentAudit) {
		return getPersistence().updateImpl(treatmentAudit);
	}

	/**
	 * Returns the treatment audit with the primary key or throws a <code>NoSuchTreatmentAuditException</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit findByPrimaryKey(long AuditID)
		throws teeth.exception.NoSuchTreatmentAuditException {

		return getPersistence().findByPrimaryKey(AuditID);
	}

	/**
	 * Returns the treatment audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit, or <code>null</code> if a treatment audit with the primary key could not be found
	 */
	public static TreatmentAudit fetchByPrimaryKey(long AuditID) {
		return getPersistence().fetchByPrimaryKey(AuditID);
	}

	/**
	 * Returns all the treatment audits.
	 *
	 * @return the treatment audits
	 */
	public static List<TreatmentAudit> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TreatmentAudit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TreatmentAudit> findAll(
		int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TreatmentAudit> findAll(
		int start, int end, OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the treatment audits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of treatment audits.
	 *
	 * @return the number of treatment audits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TreatmentAuditPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TreatmentAuditPersistence _persistence;

}