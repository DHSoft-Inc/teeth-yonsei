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
	 * Returns all the treatment audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByUuid(String uuid);

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
	public java.util.List<TreatmentAudit> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TreatmentAudit> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where uuid = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit[] findByUuid_PrevAndNext(
			long AuditID, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of treatment audits where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching treatment audits
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTreatmentAuditException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByUUID_G(String uuid, long groupId)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the treatment audit where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the treatment audit where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the treatment audit that was removed
	 */
	public TreatmentAudit removeByUUID_G(String uuid, long groupId)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the number of treatment audits where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching treatment audits
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit[] findByUuid_C_PrevAndNext(
			long AuditID, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of treatment audits where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching treatment audits
	 */
	public int countByUuid_C(String uuid, long companyId);

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
	 * Returns all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

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
	public TreatmentAudit findByG_C_P_L_First(
			long groupId, long crfId, long patientID, long linkId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

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
	public TreatmentAudit fetchByG_C_P_L_First(
		long groupId, long crfId, long patientID, long linkId,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit findByG_C_P_L_Last(
			long groupId, long crfId, long patientID, long linkId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

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
	public TreatmentAudit fetchByG_C_P_L_Last(
		long groupId, long crfId, long patientID, long linkId,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit[] findByG_C_P_L_PrevAndNext(
			long AuditID, long groupId, long crfId, long patientID, long linkId,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 */
	public void removeByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId);

	/**
	 * Returns the number of treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @return the number of matching treatment audits
	 */
	public int countByG_C_P_L(
		long groupId, long crfId, long patientID, long linkId);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

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
	public TreatmentAudit findByG_C_P_L_TN_First(
			long groupId, long crfId, long patientID, long linkId,
			long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

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
	public TreatmentAudit fetchByG_C_P_L_TN_First(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit findByG_C_P_L_TN_Last(
			long groupId, long crfId, long patientID, long linkId,
			long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

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
	public TreatmentAudit fetchByG_C_P_L_TN_Last(
		long groupId, long crfId, long patientID, long linkId, long teethNum,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit[] findByG_C_P_L_TN_PrevAndNext(
			long AuditID, long groupId, long crfId, long patientID, long linkId,
			long teethNum,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where groupId = &#63; and crfId = &#63; and patientID = &#63; and linkId = &#63; and teethNum = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param crfId the crf ID
	 * @param patientID the patient ID
	 * @param linkId the link ID
	 * @param teethNum the teeth num
	 */
	public void removeByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum);

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
	public int countByG_C_P_L_TN(
		long groupId, long crfId, long patientID, long linkId, long teethNum);

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
	 * Returns all the treatment audits where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByStatus(int status);

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
	public java.util.List<TreatmentAudit> findByStatus(
		int status, int start, int end);

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
	public java.util.List<TreatmentAudit> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the treatment audits before and after the current treatment audit in the ordered set where status = &#63;.
	 *
	 * @param AuditID the primary key of the current treatment audit
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	public TreatmentAudit[] findByStatus_PrevAndNext(
			long AuditID, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of treatment audits where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching treatment audits
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching treatment audits
	 */
	public java.util.List<TreatmentAudit> findByG_S(long groupId, int status);

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
	public java.util.List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public java.util.List<TreatmentAudit> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the first treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	public TreatmentAudit findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Returns the last treatment audit in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	public TreatmentAudit fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
			orderByComparator);

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
	public TreatmentAudit[] findByG_S_PrevAndNext(
			long AuditID, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TreatmentAudit>
				orderByComparator)
		throws NoSuchTreatmentAuditException;

	/**
	 * Removes all the treatment audits where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of treatment audits where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching treatment audits
	 */
	public int countByG_S(long groupId, int status);

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