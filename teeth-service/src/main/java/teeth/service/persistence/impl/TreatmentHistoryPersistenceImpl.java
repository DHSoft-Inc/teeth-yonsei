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

package teeth.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import teeth.exception.NoSuchTreatmentHistoryException;

import teeth.model.TreatmentHistory;
import teeth.model.impl.TreatmentHistoryImpl;
import teeth.model.impl.TreatmentHistoryModelImpl;

import teeth.service.persistence.TreatmentHistoryPersistence;
import teeth.service.persistence.TreatmentHistoryUtil;
import teeth.service.persistence.impl.constants.TeethPersistenceConstants;

/**
 * The persistence implementation for the treatment history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TreatmentHistoryPersistence.class)
public class TreatmentHistoryPersistenceImpl
	extends BasePersistenceImpl<TreatmentHistory>
	implements TreatmentHistoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TreatmentHistoryUtil</code> to access the treatment history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TreatmentHistoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTeeth_PatientID;
	private FinderPath _finderPathWithoutPaginationFindByTeeth_PatientID;
	private FinderPath _finderPathCountByTeeth_PatientID;

	/**
	 * Returns all the treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the matching treatment histories
	 */
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID(long patientID) {
		return findByTeeth_PatientID(
			patientID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end) {

		return findByTeeth_PatientID(patientID, start, end, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return findByTeeth_PatientID(
			patientID, start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID(
		long patientID, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTeeth_PatientID;
				finderArgs = new Object[] {patientID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTeeth_PatientID;
			finderArgs = new Object[] {
				patientID, start, end, orderByComparator
			};
		}

		List<TreatmentHistory> list = null;

		if (useFinderCache) {
			list = (List<TreatmentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentHistory treatmentHistory : list) {
					if (patientID != treatmentHistory.getPatientID()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				list = (List<TreatmentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory findByTeeth_PatientID_First(
			long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = fetchByTeeth_PatientID_First(
			patientID, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_First(
		long patientID, OrderByComparator<TreatmentHistory> orderByComparator) {

		List<TreatmentHistory> list = findByTeeth_PatientID(
			patientID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history
	 * @throws NoSuchTreatmentHistoryException if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory findByTeeth_PatientID_Last(
			long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = fetchByTeeth_PatientID_Last(
			patientID, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_Last(
		long patientID, OrderByComparator<TreatmentHistory> orderByComparator) {

		int count = countByTeeth_PatientID(patientID);

		if (count == 0) {
			return null;
		}

		List<TreatmentHistory> list = findByTeeth_PatientID(
			patientID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory[] findByTeeth_PatientID_PrevAndNext(
			long treatmentID, long patientID,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = findByPrimaryKey(treatmentID);

		Session session = null;

		try {
			session = openSession();

			TreatmentHistory[] array = new TreatmentHistoryImpl[3];

			array[0] = getByTeeth_PatientID_PrevAndNext(
				session, treatmentHistory, patientID, orderByComparator, true);

			array[1] = treatmentHistory;

			array[2] = getByTeeth_PatientID_PrevAndNext(
				session, treatmentHistory, patientID, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentHistory getByTeeth_PatientID_PrevAndNext(
		Session session, TreatmentHistory treatmentHistory, long patientID,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_PATIENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientID);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 */
	@Override
	public void removeByTeeth_PatientID(long patientID) {
		for (TreatmentHistory treatmentHistory :
				findByTeeth_PatientID(
					patientID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(treatmentHistory);
		}
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63;.
	 *
	 * @param patientID the patient ID
	 * @return the number of matching treatment histories
	 */
	@Override
	public int countByTeeth_PatientID(long patientID) {
		FinderPath finderPath = _finderPathCountByTeeth_PatientID;

		Object[] finderArgs = new Object[] {patientID};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_PATIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEETH_PATIENTID_PATIENTID_2 =
		"treatmentHistory.patientID = ?";

	private FinderPath _finderPathWithPaginationFindByTeeth_PatientID_TeethNum;
	private FinderPath
		_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum;
	private FinderPath _finderPathCountByTeeth_PatientID_TeethNum;

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the matching treatment histories
	 */
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum) {

		return findByTeeth_PatientID_TeethNum(
			patientID, teethNum, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end) {

		return findByTeeth_PatientID_TeethNum(
			patientID, teethNum, start, end, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return findByTeeth_PatientID_TeethNum(
			patientID, teethNum, start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum(
		long patientID, long teethNum, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum;
				finderArgs = new Object[] {patientID, teethNum};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTeeth_PatientID_TeethNum;
			finderArgs = new Object[] {
				patientID, teethNum, start, end, orderByComparator
			};
		}

		List<TreatmentHistory> list = null;

		if (useFinderCache) {
			list = (List<TreatmentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentHistory treatmentHistory : list) {
					if ((patientID != treatmentHistory.getPatientID()) ||
						(teethNum != treatmentHistory.getTeethNum())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_PATIENTID_2);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_TEETHNUM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				list = (List<TreatmentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_TeethNum_First(
			long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			fetchByTeeth_PatientID_TeethNum_First(
				patientID, teethNum, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", teethNum=");
		sb.append(teethNum);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_First(
		long patientID, long teethNum,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		List<TreatmentHistory> list = findByTeeth_PatientID_TeethNum(
			patientID, teethNum, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Last(
			long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			fetchByTeeth_PatientID_TeethNum_Last(
				patientID, teethNum, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", teethNum=");
		sb.append(teethNum);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Last(
		long patientID, long teethNum,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		int count = countByTeeth_PatientID_TeethNum(patientID, teethNum);

		if (count == 0) {
			return null;
		}

		List<TreatmentHistory> list = findByTeeth_PatientID_TeethNum(
			patientID, teethNum, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory[] findByTeeth_PatientID_TeethNum_PrevAndNext(
			long treatmentID, long patientID, long teethNum,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = findByPrimaryKey(treatmentID);

		Session session = null;

		try {
			session = openSession();

			TreatmentHistory[] array = new TreatmentHistoryImpl[3];

			array[0] = getByTeeth_PatientID_TeethNum_PrevAndNext(
				session, treatmentHistory, patientID, teethNum,
				orderByComparator, true);

			array[1] = treatmentHistory;

			array[2] = getByTeeth_PatientID_TeethNum_PrevAndNext(
				session, treatmentHistory, patientID, teethNum,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentHistory getByTeeth_PatientID_TeethNum_PrevAndNext(
		Session session, TreatmentHistory treatmentHistory, long patientID,
		long teethNum, OrderByComparator<TreatmentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_PATIENTID_2);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_TEETHNUM_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientID);

		queryPos.add(teethNum);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 */
	@Override
	public void removeByTeeth_PatientID_TeethNum(
		long patientID, long teethNum) {

		for (TreatmentHistory treatmentHistory :
				findByTeeth_PatientID_TeethNum(
					patientID, teethNum, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(treatmentHistory);
		}
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @return the number of matching treatment histories
	 */
	@Override
	public int countByTeeth_PatientID_TeethNum(long patientID, long teethNum) {
		FinderPath finderPath = _finderPathCountByTeeth_PatientID_TeethNum;

		Object[] finderArgs = new Object[] {patientID, teethNum};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_PATIENTID_2);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_TEETHNUM_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_PATIENTID_2 =
			"treatmentHistory.patientID = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_TEETHNUM_2 =
			"treatmentHistory.teethNum = ?";

	private FinderPath _finderPathWithPaginationFindByTeeth_PatientID_Date;
	private FinderPath _finderPathWithoutPaginationFindByTeeth_PatientID_Date;
	private FinderPath _finderPathCountByTeeth_PatientID_Date;

	/**
	 * Returns all the treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate) {

		return findByTeeth_PatientID_Date(
			patientID, treatmentDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end) {

		return findByTeeth_PatientID_Date(
			patientID, treatmentDate, start, end, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return findByTeeth_PatientID_Date(
			patientID, treatmentDate, start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_Date(
		long patientID, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTeeth_PatientID_Date;
				finderArgs = new Object[] {patientID, _getTime(treatmentDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTeeth_PatientID_Date;
			finderArgs = new Object[] {
				patientID, _getTime(treatmentDate), start, end,
				orderByComparator
			};
		}

		List<TreatmentHistory> list = null;

		if (useFinderCache) {
			list = (List<TreatmentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentHistory treatmentHistory : list) {
					if ((patientID != treatmentHistory.getPatientID()) ||
						!Objects.equals(
							treatmentDate,
							treatmentHistory.getTreatmentDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_PATIENTID_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				list = (List<TreatmentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_Date_First(
			long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = fetchByTeeth_PatientID_Date_First(
			patientID, treatmentDate, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", treatmentDate=");
		sb.append(treatmentDate);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the first treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_Date_First(
		long patientID, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		List<TreatmentHistory> list = findByTeeth_PatientID_Date(
			patientID, treatmentDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_Date_Last(
			long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = fetchByTeeth_PatientID_Date_Last(
			patientID, treatmentDate, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", treatmentDate=");
		sb.append(treatmentDate);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
	}

	/**
	 * Returns the last treatment history in the ordered set where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment history, or <code>null</code> if a matching treatment history could not be found
	 */
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_Date_Last(
		long patientID, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		int count = countByTeeth_PatientID_Date(patientID, treatmentDate);

		if (count == 0) {
			return null;
		}

		List<TreatmentHistory> list = findByTeeth_PatientID_Date(
			patientID, treatmentDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory[] findByTeeth_PatientID_Date_PrevAndNext(
			long treatmentID, long patientID, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = findByPrimaryKey(treatmentID);

		Session session = null;

		try {
			session = openSession();

			TreatmentHistory[] array = new TreatmentHistoryImpl[3];

			array[0] = getByTeeth_PatientID_Date_PrevAndNext(
				session, treatmentHistory, patientID, treatmentDate,
				orderByComparator, true);

			array[1] = treatmentHistory;

			array[2] = getByTeeth_PatientID_Date_PrevAndNext(
				session, treatmentHistory, patientID, treatmentDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentHistory getByTeeth_PatientID_Date_PrevAndNext(
		Session session, TreatmentHistory treatmentHistory, long patientID,
		Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_PATIENTID_2);

		boolean bindTreatmentDate = false;

		if (treatmentDate == null) {
			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_1);
		}
		else {
			bindTreatmentDate = true;

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientID);

		if (bindTreatmentDate) {
			queryPos.add(new Timestamp(treatmentDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 */
	@Override
	public void removeByTeeth_PatientID_Date(
		long patientID, Date treatmentDate) {

		for (TreatmentHistory treatmentHistory :
				findByTeeth_PatientID_Date(
					patientID, treatmentDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(treatmentHistory);
		}
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	@Override
	public int countByTeeth_PatientID_Date(long patientID, Date treatmentDate) {
		FinderPath finderPath = _finderPathCountByTeeth_PatientID_Date;

		Object[] finderArgs = new Object[] {patientID, _getTime(treatmentDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_PATIENTID_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_DATE_PATIENTID_2 =
			"treatmentHistory.patientID = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_1 =
			"treatmentHistory.treatmentDate IS NULL";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_DATE_TREATMENTDATE_2 =
			"treatmentHistory.treatmentDate = ?";

	private FinderPath
		_finderPathWithPaginationFindByTeeth_PatientID_TeethNum_Date;
	private FinderPath
		_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date;
	private FinderPath _finderPathCountByTeeth_PatientID_TeethNum_Date;

	/**
	 * Returns all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the matching treatment histories
	 */
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		return findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end) {

		return findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, start, end, null);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, start, end, orderByComparator,
			true);
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
	@Override
	public List<TreatmentHistory> findByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate, int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date;
				finderArgs = new Object[] {
					patientID, teethNum, _getTime(treatmentDate)
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTeeth_PatientID_TeethNum_Date;
			finderArgs = new Object[] {
				patientID, teethNum, _getTime(treatmentDate), start, end,
				orderByComparator
			};
		}

		List<TreatmentHistory> list = null;

		if (useFinderCache) {
			list = (List<TreatmentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentHistory treatmentHistory : list) {
					if ((patientID != treatmentHistory.getPatientID()) ||
						(teethNum != treatmentHistory.getTeethNum()) ||
						!Objects.equals(
							treatmentDate,
							treatmentHistory.getTreatmentDate())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_PATIENTID_2);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TEETHNUM_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				list = (List<TreatmentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_First(
			long patientID, long teethNum, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			fetchByTeeth_PatientID_TeethNum_Date_First(
				patientID, teethNum, treatmentDate, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", teethNum=");
		sb.append(teethNum);

		sb.append(", treatmentDate=");
		sb.append(treatmentDate);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
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
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_First(
		long patientID, long teethNum, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		List<TreatmentHistory> list = findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_Last(
			long patientID, long teethNum, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			fetchByTeeth_PatientID_TeethNum_Date_Last(
				patientID, teethNum, treatmentDate, orderByComparator);

		if (treatmentHistory != null) {
			return treatmentHistory;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientID=");
		sb.append(patientID);

		sb.append(", teethNum=");
		sb.append(teethNum);

		sb.append(", treatmentDate=");
		sb.append(treatmentDate);

		sb.append("}");

		throw new NoSuchTreatmentHistoryException(sb.toString());
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
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Last(
		long patientID, long teethNum, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		int count = countByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate);

		if (count == 0) {
			return null;
		}

		List<TreatmentHistory> list = findByTeeth_PatientID_TeethNum_Date(
			patientID, teethNum, treatmentDate, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentHistory[] findByTeeth_PatientID_TeethNum_Date_PrevAndNext(
			long treatmentID, long patientID, long teethNum, Date treatmentDate,
			OrderByComparator<TreatmentHistory> orderByComparator)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = findByPrimaryKey(treatmentID);

		Session session = null;

		try {
			session = openSession();

			TreatmentHistory[] array = new TreatmentHistoryImpl[3];

			array[0] = getByTeeth_PatientID_TeethNum_Date_PrevAndNext(
				session, treatmentHistory, patientID, teethNum, treatmentDate,
				orderByComparator, true);

			array[1] = treatmentHistory;

			array[2] = getByTeeth_PatientID_TeethNum_Date_PrevAndNext(
				session, treatmentHistory, patientID, teethNum, treatmentDate,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentHistory getByTeeth_PatientID_TeethNum_Date_PrevAndNext(
		Session session, TreatmentHistory treatmentHistory, long patientID,
		long teethNum, Date treatmentDate,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_PATIENTID_2);

		sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TEETHNUM_2);

		boolean bindTreatmentDate = false;

		if (treatmentDate == null) {
			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_1);
		}
		else {
			bindTreatmentDate = true;

			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientID);

		queryPos.add(teethNum);

		if (bindTreatmentDate) {
			queryPos.add(new Timestamp(treatmentDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentHistory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentHistory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63; from the database.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 */
	@Override
	public void removeByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		for (TreatmentHistory treatmentHistory :
				findByTeeth_PatientID_TeethNum_Date(
					patientID, teethNum, treatmentDate, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(treatmentHistory);
		}
	}

	/**
	 * Returns the number of treatment histories where patientID = &#63; and teethNum = &#63; and treatmentDate = &#63;.
	 *
	 * @param patientID the patient ID
	 * @param teethNum the teeth num
	 * @param treatmentDate the treatment date
	 * @return the number of matching treatment histories
	 */
	@Override
	public int countByTeeth_PatientID_TeethNum_Date(
		long patientID, long teethNum, Date treatmentDate) {

		FinderPath finderPath = _finderPathCountByTeeth_PatientID_TeethNum_Date;

		Object[] finderArgs = new Object[] {
			patientID, teethNum, _getTime(treatmentDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TREATMENTHISTORY_WHERE);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_PATIENTID_2);

			sb.append(_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TEETHNUM_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_PATIENTID_2 =
			"treatmentHistory.patientID = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TEETHNUM_2 =
			"treatmentHistory.teethNum = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_1 =
			"treatmentHistory.treatmentDate IS NULL";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENTDATE_2 =
			"treatmentHistory.treatmentDate = ?";

	private FinderPath
		_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment;
	private FinderPath
		_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment;

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
	@Override
	public TreatmentHistory findByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate, String treatment)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			fetchByTeeth_PatientID_TeethNum_Date_Treatment(
				patientID, teethNum, treatmentDate, treatment);

		if (treatmentHistory == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("patientID=");
			sb.append(patientID);

			sb.append(", teethNum=");
			sb.append(teethNum);

			sb.append(", treatmentDate=");
			sb.append(treatmentDate);

			sb.append(", treatment=");
			sb.append(treatment);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTreatmentHistoryException(sb.toString());
		}

		return treatmentHistory;
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
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment) {

		return fetchByTeeth_PatientID_TeethNum_Date_Treatment(
			patientID, teethNum, treatmentDate, treatment, true);
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
	@Override
	public TreatmentHistory fetchByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment,
		boolean useFinderCache) {

		treatment = Objects.toString(treatment, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				patientID, teethNum, _getTime(treatmentDate), treatment
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
				finderArgs, this);
		}

		if (result instanceof TreatmentHistory) {
			TreatmentHistory treatmentHistory = (TreatmentHistory)result;

			if ((patientID != treatmentHistory.getPatientID()) ||
				(teethNum != treatmentHistory.getTeethNum()) ||
				!Objects.equals(
					treatmentDate, treatmentHistory.getTreatmentDate()) ||
				!Objects.equals(treatment, treatmentHistory.getTreatment())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_TREATMENTHISTORY_WHERE);

			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_PATIENTID_2);

			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TEETHNUM_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_2);
			}

			boolean bindTreatment = false;

			if (treatment.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_3);
			}
			else {
				bindTreatment = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				if (bindTreatment) {
					queryPos.add(treatment);
				}

				List<TreatmentHistory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									patientID, teethNum,
									_getTime(treatmentDate), treatment
								};
							}

							_log.warn(
								"TreatmentHistoryPersistenceImpl.fetchByTeeth_PatientID_TeethNum_Date_Treatment(long, long, Date, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TreatmentHistory treatmentHistory = list.get(0);

					result = treatmentHistory;

					cacheResult(treatmentHistory);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
						finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TreatmentHistory)result;
		}
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
	@Override
	public TreatmentHistory removeByTeeth_PatientID_TeethNum_Date_Treatment(
			long patientID, long teethNum, Date treatmentDate, String treatment)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory =
			findByTeeth_PatientID_TeethNum_Date_Treatment(
				patientID, teethNum, treatmentDate, treatment);

		return remove(treatmentHistory);
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
	@Override
	public int countByTeeth_PatientID_TeethNum_Date_Treatment(
		long patientID, long teethNum, Date treatmentDate, String treatment) {

		treatment = Objects.toString(treatment, "");

		FinderPath finderPath =
			_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment;

		Object[] finderArgs = new Object[] {
			patientID, teethNum, _getTime(treatmentDate), treatment
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_TREATMENTHISTORY_WHERE);

			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_PATIENTID_2);

			sb.append(
				_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TEETHNUM_2);

			boolean bindTreatmentDate = false;

			if (treatmentDate == null) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_1);
			}
			else {
				bindTreatmentDate = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_2);
			}

			boolean bindTreatment = false;

			if (treatment.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_3);
			}
			else {
				bindTreatment = true;

				sb.append(
					_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientID);

				queryPos.add(teethNum);

				if (bindTreatmentDate) {
					queryPos.add(new Timestamp(treatmentDate.getTime()));
				}

				if (bindTreatment) {
					queryPos.add(treatment);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_PATIENTID_2 =
			"treatmentHistory.patientID = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TEETHNUM_2 =
			"treatmentHistory.teethNum = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_1 =
			"treatmentHistory.treatmentDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENTDATE_2 =
			"treatmentHistory.treatmentDate = ? AND ";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_2 =
			"treatmentHistory.treatment = ?";

	private static final String
		_FINDER_COLUMN_TEETH_PATIENTID_TEETHNUM_DATE_TREATMENT_TREATMENT_3 =
			"(treatmentHistory.treatment IS NULL OR treatmentHistory.treatment = '')";

	public TreatmentHistoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TreatmentHistory.class);

		setModelImplClass(TreatmentHistoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the treatment history in the entity cache if it is enabled.
	 *
	 * @param treatmentHistory the treatment history
	 */
	@Override
	public void cacheResult(TreatmentHistory treatmentHistory) {
		entityCache.putResult(
			entityCacheEnabled, TreatmentHistoryImpl.class,
			treatmentHistory.getPrimaryKey(), treatmentHistory);

		finderCache.putResult(
			_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
			new Object[] {
				treatmentHistory.getPatientID(), treatmentHistory.getTeethNum(),
				treatmentHistory.getTreatmentDate(),
				treatmentHistory.getTreatment()
			},
			treatmentHistory);

		treatmentHistory.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the treatment histories in the entity cache if it is enabled.
	 *
	 * @param treatmentHistories the treatment histories
	 */
	@Override
	public void cacheResult(List<TreatmentHistory> treatmentHistories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (treatmentHistories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TreatmentHistory treatmentHistory : treatmentHistories) {
			if (entityCache.getResult(
					entityCacheEnabled, TreatmentHistoryImpl.class,
					treatmentHistory.getPrimaryKey()) == null) {

				cacheResult(treatmentHistory);
			}
			else {
				treatmentHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all treatment histories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TreatmentHistoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the treatment history.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TreatmentHistory treatmentHistory) {
		entityCache.removeResult(
			entityCacheEnabled, TreatmentHistoryImpl.class,
			treatmentHistory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TreatmentHistoryModelImpl)treatmentHistory, true);
	}

	@Override
	public void clearCache(List<TreatmentHistory> treatmentHistories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TreatmentHistory treatmentHistory : treatmentHistories) {
			entityCache.removeResult(
				entityCacheEnabled, TreatmentHistoryImpl.class,
				treatmentHistory.getPrimaryKey());

			clearUniqueFindersCache(
				(TreatmentHistoryModelImpl)treatmentHistory, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TreatmentHistoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TreatmentHistoryModelImpl treatmentHistoryModelImpl) {

		Object[] args = new Object[] {
			treatmentHistoryModelImpl.getPatientID(),
			treatmentHistoryModelImpl.getTeethNum(),
			_getTime(treatmentHistoryModelImpl.getTreatmentDate()),
			treatmentHistoryModelImpl.getTreatment()
		};

		finderCache.putResult(
			_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment, args,
			treatmentHistoryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TreatmentHistoryModelImpl treatmentHistoryModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				treatmentHistoryModelImpl.getPatientID(),
				treatmentHistoryModelImpl.getTeethNum(),
				_getTime(treatmentHistoryModelImpl.getTreatmentDate()),
				treatmentHistoryModelImpl.getTreatment()
			};

			finderCache.removeResult(
				_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment,
				args);
			finderCache.removeResult(
				_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
				args);
		}

		if ((treatmentHistoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				treatmentHistoryModelImpl.getOriginalPatientID(),
				treatmentHistoryModelImpl.getOriginalTeethNum(),
				_getTime(treatmentHistoryModelImpl.getOriginalTreatmentDate()),
				treatmentHistoryModelImpl.getOriginalTreatment()
			};

			finderCache.removeResult(
				_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment,
				args);
			finderCache.removeResult(
				_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment,
				args);
		}
	}

	/**
	 * Creates a new treatment history with the primary key. Does not add the treatment history to the database.
	 *
	 * @param treatmentID the primary key for the new treatment history
	 * @return the new treatment history
	 */
	@Override
	public TreatmentHistory create(long treatmentID) {
		TreatmentHistory treatmentHistory = new TreatmentHistoryImpl();

		treatmentHistory.setNew(true);
		treatmentHistory.setPrimaryKey(treatmentID);

		return treatmentHistory;
	}

	/**
	 * Removes the treatment history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history that was removed
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	@Override
	public TreatmentHistory remove(long treatmentID)
		throws NoSuchTreatmentHistoryException {

		return remove((Serializable)treatmentID);
	}

	/**
	 * Removes the treatment history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the treatment history
	 * @return the treatment history that was removed
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	@Override
	public TreatmentHistory remove(Serializable primaryKey)
		throws NoSuchTreatmentHistoryException {

		Session session = null;

		try {
			session = openSession();

			TreatmentHistory treatmentHistory = (TreatmentHistory)session.get(
				TreatmentHistoryImpl.class, primaryKey);

			if (treatmentHistory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTreatmentHistoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(treatmentHistory);
		}
		catch (NoSuchTreatmentHistoryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TreatmentHistory removeImpl(TreatmentHistory treatmentHistory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(treatmentHistory)) {
				treatmentHistory = (TreatmentHistory)session.get(
					TreatmentHistoryImpl.class,
					treatmentHistory.getPrimaryKeyObj());
			}

			if (treatmentHistory != null) {
				session.delete(treatmentHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (treatmentHistory != null) {
			clearCache(treatmentHistory);
		}

		return treatmentHistory;
	}

	@Override
	public TreatmentHistory updateImpl(TreatmentHistory treatmentHistory) {
		boolean isNew = treatmentHistory.isNew();

		if (!(treatmentHistory instanceof TreatmentHistoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(treatmentHistory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					treatmentHistory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in treatmentHistory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TreatmentHistory implementation " +
					treatmentHistory.getClass());
		}

		TreatmentHistoryModelImpl treatmentHistoryModelImpl =
			(TreatmentHistoryModelImpl)treatmentHistory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(treatmentHistory);

				treatmentHistory.setNew(false);
			}
			else {
				treatmentHistory = (TreatmentHistory)session.merge(
					treatmentHistory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				treatmentHistoryModelImpl.getPatientID()
			};

			finderCache.removeResult(_finderPathCountByTeeth_PatientID, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeeth_PatientID, args);

			args = new Object[] {
				treatmentHistoryModelImpl.getPatientID(),
				treatmentHistoryModelImpl.getTeethNum()
			};

			finderCache.removeResult(
				_finderPathCountByTeeth_PatientID_TeethNum, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum,
				args);

			args = new Object[] {
				treatmentHistoryModelImpl.getPatientID(),
				treatmentHistoryModelImpl.getTreatmentDate()
			};

			finderCache.removeResult(
				_finderPathCountByTeeth_PatientID_Date, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeeth_PatientID_Date, args);

			args = new Object[] {
				treatmentHistoryModelImpl.getPatientID(),
				treatmentHistoryModelImpl.getTeethNum(),
				treatmentHistoryModelImpl.getTreatmentDate()
			};

			finderCache.removeResult(
				_finderPathCountByTeeth_PatientID_TeethNum_Date, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((treatmentHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeeth_PatientID.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentHistoryModelImpl.getOriginalPatientID()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID, args);

				args = new Object[] {treatmentHistoryModelImpl.getPatientID()};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID, args);
			}

			if ((treatmentHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentHistoryModelImpl.getOriginalPatientID(),
					treatmentHistoryModelImpl.getOriginalTeethNum()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_TeethNum, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum,
					args);

				args = new Object[] {
					treatmentHistoryModelImpl.getPatientID(),
					treatmentHistoryModelImpl.getTeethNum()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_TeethNum, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum,
					args);
			}

			if ((treatmentHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeeth_PatientID_Date.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentHistoryModelImpl.getOriginalPatientID(),
					treatmentHistoryModelImpl.getOriginalTreatmentDate()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_Date, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_Date,
					args);

				args = new Object[] {
					treatmentHistoryModelImpl.getPatientID(),
					treatmentHistoryModelImpl.getTreatmentDate()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_Date, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_Date,
					args);
			}

			if ((treatmentHistoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentHistoryModelImpl.getOriginalPatientID(),
					treatmentHistoryModelImpl.getOriginalTeethNum(),
					treatmentHistoryModelImpl.getOriginalTreatmentDate()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_TeethNum_Date, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date,
					args);

				args = new Object[] {
					treatmentHistoryModelImpl.getPatientID(),
					treatmentHistoryModelImpl.getTeethNum(),
					treatmentHistoryModelImpl.getTreatmentDate()
				};

				finderCache.removeResult(
					_finderPathCountByTeeth_PatientID_TeethNum_Date, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TreatmentHistoryImpl.class,
			treatmentHistory.getPrimaryKey(), treatmentHistory, false);

		clearUniqueFindersCache(treatmentHistoryModelImpl, false);
		cacheUniqueFindersCache(treatmentHistoryModelImpl);

		treatmentHistory.resetOriginalValues();

		return treatmentHistory;
	}

	/**
	 * Returns the treatment history with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the treatment history
	 * @return the treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	@Override
	public TreatmentHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTreatmentHistoryException {

		TreatmentHistory treatmentHistory = fetchByPrimaryKey(primaryKey);

		if (treatmentHistory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTreatmentHistoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return treatmentHistory;
	}

	/**
	 * Returns the treatment history with the primary key or throws a <code>NoSuchTreatmentHistoryException</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history
	 * @throws NoSuchTreatmentHistoryException if a treatment history with the primary key could not be found
	 */
	@Override
	public TreatmentHistory findByPrimaryKey(long treatmentID)
		throws NoSuchTreatmentHistoryException {

		return findByPrimaryKey((Serializable)treatmentID);
	}

	/**
	 * Returns the treatment history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param treatmentID the primary key of the treatment history
	 * @return the treatment history, or <code>null</code> if a treatment history with the primary key could not be found
	 */
	@Override
	public TreatmentHistory fetchByPrimaryKey(long treatmentID) {
		return fetchByPrimaryKey((Serializable)treatmentID);
	}

	/**
	 * Returns all the treatment histories.
	 *
	 * @return the treatment histories
	 */
	@Override
	public List<TreatmentHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentHistory> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TreatmentHistory> findAll(
		int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentHistory> findAll(
		int start, int end,
		OrderByComparator<TreatmentHistory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<TreatmentHistory> list = null;

		if (useFinderCache) {
			list = (List<TreatmentHistory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TREATMENTHISTORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TREATMENTHISTORY;

				sql = sql.concat(TreatmentHistoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TreatmentHistory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the treatment histories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TreatmentHistory treatmentHistory : findAll()) {
			remove(treatmentHistory);
		}
	}

	/**
	 * Returns the number of treatment histories.
	 *
	 * @return the number of treatment histories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TREATMENTHISTORY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "treatmentID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TREATMENTHISTORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TreatmentHistoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the treatment history persistence.
	 */
	@Activate
	public void activate() {
		TreatmentHistoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TreatmentHistoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTeeth_PatientID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTeeth_PatientID",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTeeth_PatientID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTeeth_PatientID",
			new String[] {Long.class.getName()},
			TreatmentHistoryModelImpl.PATIENTID_COLUMN_BITMASK);

		_finderPathCountByTeeth_PatientID = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTeeth_PatientID",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTeeth_PatientID_TeethNum =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TreatmentHistoryImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTeeth_PatientID_TeethNum",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TreatmentHistoryImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTeeth_PatientID_TeethNum",
				new String[] {Long.class.getName(), Long.class.getName()},
				TreatmentHistoryModelImpl.PATIENTID_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TEETHNUM_COLUMN_BITMASK);

		_finderPathCountByTeeth_PatientID_TeethNum = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTeeth_PatientID_TeethNum",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByTeeth_PatientID_Date = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTeeth_PatientID_Date",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTeeth_PatientID_Date = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTeeth_PatientID_Date",
			new String[] {Long.class.getName(), Date.class.getName()},
			TreatmentHistoryModelImpl.PATIENTID_COLUMN_BITMASK |
			TreatmentHistoryModelImpl.TREATMENTDATE_COLUMN_BITMASK);

		_finderPathCountByTeeth_PatientID_Date = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTeeth_PatientID_Date",
			new String[] {Long.class.getName(), Date.class.getName()});

		_finderPathWithPaginationFindByTeeth_PatientID_TeethNum_Date =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TreatmentHistoryImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTeeth_PatientID_TeethNum_Date",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Date.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByTeeth_PatientID_TeethNum_Date =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TreatmentHistoryImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTeeth_PatientID_TeethNum_Date",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Date.class.getName()
				},
				TreatmentHistoryModelImpl.PATIENTID_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TEETHNUM_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TREATMENTDATE_COLUMN_BITMASK);

		_finderPathCountByTeeth_PatientID_TeethNum_Date = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTeeth_PatientID_TeethNum_Date",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			});

		_finderPathFetchByTeeth_PatientID_TeethNum_Date_Treatment =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				TreatmentHistoryImpl.class, FINDER_CLASS_NAME_ENTITY,
				"fetchByTeeth_PatientID_TeethNum_Date_Treatment",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Date.class.getName(), String.class.getName()
				},
				TreatmentHistoryModelImpl.PATIENTID_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TEETHNUM_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TREATMENTDATE_COLUMN_BITMASK |
				TreatmentHistoryModelImpl.TREATMENT_COLUMN_BITMASK);

		_finderPathCountByTeeth_PatientID_TeethNum_Date_Treatment =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTeeth_PatientID_TeethNum_Date_Treatment",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Date.class.getName(), String.class.getName()
				});

		_setTreatmentHistoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTreatmentHistoryUtilPersistence(null);

		entityCache.removeCache(TreatmentHistoryImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setTreatmentHistoryUtilPersistence(
		TreatmentHistoryPersistence treatmentHistoryPersistence) {

		try {
			Field field = TreatmentHistoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, treatmentHistoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = TeethPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.teeth.model.TreatmentHistory"),
			true);
	}

	@Override
	@Reference(
		target = TeethPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TeethPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_TREATMENTHISTORY =
		"SELECT treatmentHistory FROM TreatmentHistory treatmentHistory";

	private static final String _SQL_SELECT_TREATMENTHISTORY_WHERE =
		"SELECT treatmentHistory FROM TreatmentHistory treatmentHistory WHERE ";

	private static final String _SQL_COUNT_TREATMENTHISTORY =
		"SELECT COUNT(treatmentHistory) FROM TreatmentHistory treatmentHistory";

	private static final String _SQL_COUNT_TREATMENTHISTORY_WHERE =
		"SELECT COUNT(treatmentHistory) FROM TreatmentHistory treatmentHistory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "treatmentHistory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TreatmentHistory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TreatmentHistory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TreatmentHistoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"state"});

}