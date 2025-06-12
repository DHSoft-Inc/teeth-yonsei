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

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import teeth.exception.NoSuchTreatmentAuditException;

import teeth.model.TreatmentAudit;
import teeth.model.impl.TreatmentAuditImpl;
import teeth.model.impl.TreatmentAuditModelImpl;

import teeth.service.persistence.TreatmentAuditPersistence;
import teeth.service.persistence.TreatmentAuditUtil;
import teeth.service.persistence.impl.constants.TeethPersistenceConstants;

/**
 * The persistence implementation for the treatment audit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TreatmentAuditPersistence.class)
public class TreatmentAuditPersistenceImpl
	extends BasePersistenceImpl<TreatmentAudit>
	implements TreatmentAuditPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TreatmentAuditUtil</code> to access the treatment audit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TreatmentAuditImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByAudit_TeethNum;
	private FinderPath _finderPathWithoutPaginationFindByAudit_TeethNum;
	private FinderPath _finderPathCountByAudit_TeethNum;

	/**
	 * Returns all the treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the matching treatment audits
	 */
	@Override
	public List<TreatmentAudit> findByAudit_TeethNum(long teethNum) {
		return findByAudit_TeethNum(
			teethNum, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end) {

		return findByAudit_TeethNum(teethNum, start, end, null);
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
	@Override
	public List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return findByAudit_TeethNum(
			teethNum, start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentAudit> findByAudit_TeethNum(
		long teethNum, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAudit_TeethNum;
				finderArgs = new Object[] {teethNum};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAudit_TeethNum;
			finderArgs = new Object[] {teethNum, start, end, orderByComparator};
		}

		List<TreatmentAudit> list = null;

		if (useFinderCache) {
			list = (List<TreatmentAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentAudit treatmentAudit : list) {
					if (teethNum != treatmentAudit.getTeethNum()) {
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

			sb.append(_SQL_SELECT_TREATMENTAUDIT_WHERE);

			sb.append(_FINDER_COLUMN_AUDIT_TEETHNUM_TEETHNUM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(teethNum);

				list = (List<TreatmentAudit>)QueryUtil.list(
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
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit findByAudit_TeethNum_First(
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = fetchByAudit_TeethNum_First(
			teethNum, orderByComparator);

		if (treatmentAudit != null) {
			return treatmentAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teethNum=");
		sb.append(teethNum);

		sb.append("}");

		throw new NoSuchTreatmentAuditException(sb.toString());
	}

	/**
	 * Returns the first treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit fetchByAudit_TeethNum_First(
		long teethNum, OrderByComparator<TreatmentAudit> orderByComparator) {

		List<TreatmentAudit> list = findByAudit_TeethNum(
			teethNum, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit findByAudit_TeethNum_Last(
			long teethNum, OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = fetchByAudit_TeethNum_Last(
			teethNum, orderByComparator);

		if (treatmentAudit != null) {
			return treatmentAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("teethNum=");
		sb.append(teethNum);

		sb.append("}");

		throw new NoSuchTreatmentAuditException(sb.toString());
	}

	/**
	 * Returns the last treatment audit in the ordered set where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit fetchByAudit_TeethNum_Last(
		long teethNum, OrderByComparator<TreatmentAudit> orderByComparator) {

		int count = countByAudit_TeethNum(teethNum);

		if (count == 0) {
			return null;
		}

		List<TreatmentAudit> list = findByAudit_TeethNum(
			teethNum, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentAudit[] findByAudit_TeethNum_PrevAndNext(
			long AuditID, long teethNum,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = findByPrimaryKey(AuditID);

		Session session = null;

		try {
			session = openSession();

			TreatmentAudit[] array = new TreatmentAuditImpl[3];

			array[0] = getByAudit_TeethNum_PrevAndNext(
				session, treatmentAudit, teethNum, orderByComparator, true);

			array[1] = treatmentAudit;

			array[2] = getByAudit_TeethNum_PrevAndNext(
				session, treatmentAudit, teethNum, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentAudit getByAudit_TeethNum_PrevAndNext(
		Session session, TreatmentAudit treatmentAudit, long teethNum,
		OrderByComparator<TreatmentAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TREATMENTAUDIT_WHERE);

		sb.append(_FINDER_COLUMN_AUDIT_TEETHNUM_TEETHNUM_2);

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
			sb.append(TreatmentAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(teethNum);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment audits where teethNum = &#63; from the database.
	 *
	 * @param teethNum the teeth num
	 */
	@Override
	public void removeByAudit_TeethNum(long teethNum) {
		for (TreatmentAudit treatmentAudit :
				findByAudit_TeethNum(
					teethNum, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(treatmentAudit);
		}
	}

	/**
	 * Returns the number of treatment audits where teethNum = &#63;.
	 *
	 * @param teethNum the teeth num
	 * @return the number of matching treatment audits
	 */
	@Override
	public int countByAudit_TeethNum(long teethNum) {
		FinderPath finderPath = _finderPathCountByAudit_TeethNum;

		Object[] finderArgs = new Object[] {teethNum};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TREATMENTAUDIT_WHERE);

			sb.append(_FINDER_COLUMN_AUDIT_TEETHNUM_TEETHNUM_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_AUDIT_TEETHNUM_TEETHNUM_2 =
		"treatmentAudit.teethNum = ?";

	private FinderPath _finderPathWithPaginationFindByAudit_EditType;
	private FinderPath _finderPathWithoutPaginationFindByAudit_EditType;
	private FinderPath _finderPathCountByAudit_EditType;

	/**
	 * Returns all the treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the matching treatment audits
	 */
	@Override
	public List<TreatmentAudit> findByAudit_EditType(String editType) {
		return findByAudit_EditType(
			editType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end) {

		return findByAudit_EditType(editType, start, end, null);
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
	@Override
	public List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return findByAudit_EditType(
			editType, start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentAudit> findByAudit_EditType(
		String editType, int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator,
		boolean useFinderCache) {

		editType = Objects.toString(editType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAudit_EditType;
				finderArgs = new Object[] {editType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAudit_EditType;
			finderArgs = new Object[] {editType, start, end, orderByComparator};
		}

		List<TreatmentAudit> list = null;

		if (useFinderCache) {
			list = (List<TreatmentAudit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TreatmentAudit treatmentAudit : list) {
					if (!editType.equals(treatmentAudit.getEditType())) {
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

			sb.append(_SQL_SELECT_TREATMENTAUDIT_WHERE);

			boolean bindEditType = false;

			if (editType.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_3);
			}
			else {
				bindEditType = true;

				sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TreatmentAuditModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEditType) {
					queryPos.add(editType);
				}

				list = (List<TreatmentAudit>)QueryUtil.list(
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
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit findByAudit_EditType_First(
			String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = fetchByAudit_EditType_First(
			editType, orderByComparator);

		if (treatmentAudit != null) {
			return treatmentAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("editType=");
		sb.append(editType);

		sb.append("}");

		throw new NoSuchTreatmentAuditException(sb.toString());
	}

	/**
	 * Returns the first treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit fetchByAudit_EditType_First(
		String editType, OrderByComparator<TreatmentAudit> orderByComparator) {

		List<TreatmentAudit> list = findByAudit_EditType(
			editType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit
	 * @throws NoSuchTreatmentAuditException if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit findByAudit_EditType_Last(
			String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = fetchByAudit_EditType_Last(
			editType, orderByComparator);

		if (treatmentAudit != null) {
			return treatmentAudit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("editType=");
		sb.append(editType);

		sb.append("}");

		throw new NoSuchTreatmentAuditException(sb.toString());
	}

	/**
	 * Returns the last treatment audit in the ordered set where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching treatment audit, or <code>null</code> if a matching treatment audit could not be found
	 */
	@Override
	public TreatmentAudit fetchByAudit_EditType_Last(
		String editType, OrderByComparator<TreatmentAudit> orderByComparator) {

		int count = countByAudit_EditType(editType);

		if (count == 0) {
			return null;
		}

		List<TreatmentAudit> list = findByAudit_EditType(
			editType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TreatmentAudit[] findByAudit_EditType_PrevAndNext(
			long AuditID, String editType,
			OrderByComparator<TreatmentAudit> orderByComparator)
		throws NoSuchTreatmentAuditException {

		editType = Objects.toString(editType, "");

		TreatmentAudit treatmentAudit = findByPrimaryKey(AuditID);

		Session session = null;

		try {
			session = openSession();

			TreatmentAudit[] array = new TreatmentAuditImpl[3];

			array[0] = getByAudit_EditType_PrevAndNext(
				session, treatmentAudit, editType, orderByComparator, true);

			array[1] = treatmentAudit;

			array[2] = getByAudit_EditType_PrevAndNext(
				session, treatmentAudit, editType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TreatmentAudit getByAudit_EditType_PrevAndNext(
		Session session, TreatmentAudit treatmentAudit, String editType,
		OrderByComparator<TreatmentAudit> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TREATMENTAUDIT_WHERE);

		boolean bindEditType = false;

		if (editType.isEmpty()) {
			sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_3);
		}
		else {
			bindEditType = true;

			sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_2);
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
			sb.append(TreatmentAuditModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEditType) {
			queryPos.add(editType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						treatmentAudit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TreatmentAudit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the treatment audits where editType = &#63; from the database.
	 *
	 * @param editType the edit type
	 */
	@Override
	public void removeByAudit_EditType(String editType) {
		for (TreatmentAudit treatmentAudit :
				findByAudit_EditType(
					editType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(treatmentAudit);
		}
	}

	/**
	 * Returns the number of treatment audits where editType = &#63;.
	 *
	 * @param editType the edit type
	 * @return the number of matching treatment audits
	 */
	@Override
	public int countByAudit_EditType(String editType) {
		editType = Objects.toString(editType, "");

		FinderPath finderPath = _finderPathCountByAudit_EditType;

		Object[] finderArgs = new Object[] {editType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TREATMENTAUDIT_WHERE);

			boolean bindEditType = false;

			if (editType.isEmpty()) {
				sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_3);
			}
			else {
				bindEditType = true;

				sb.append(_FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEditType) {
					queryPos.add(editType);
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

	private static final String _FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_2 =
		"treatmentAudit.editType = ?";

	private static final String _FINDER_COLUMN_AUDIT_EDITTYPE_EDITTYPE_3 =
		"(treatmentAudit.editType IS NULL OR treatmentAudit.editType = '')";

	public TreatmentAuditPersistenceImpl() {
		setModelClass(TreatmentAudit.class);

		setModelImplClass(TreatmentAuditImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the treatment audit in the entity cache if it is enabled.
	 *
	 * @param treatmentAudit the treatment audit
	 */
	@Override
	public void cacheResult(TreatmentAudit treatmentAudit) {
		entityCache.putResult(
			entityCacheEnabled, TreatmentAuditImpl.class,
			treatmentAudit.getPrimaryKey(), treatmentAudit);

		treatmentAudit.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the treatment audits in the entity cache if it is enabled.
	 *
	 * @param treatmentAudits the treatment audits
	 */
	@Override
	public void cacheResult(List<TreatmentAudit> treatmentAudits) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (treatmentAudits.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TreatmentAudit treatmentAudit : treatmentAudits) {
			if (entityCache.getResult(
					entityCacheEnabled, TreatmentAuditImpl.class,
					treatmentAudit.getPrimaryKey()) == null) {

				cacheResult(treatmentAudit);
			}
			else {
				treatmentAudit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all treatment audits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TreatmentAuditImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the treatment audit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TreatmentAudit treatmentAudit) {
		entityCache.removeResult(
			entityCacheEnabled, TreatmentAuditImpl.class,
			treatmentAudit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TreatmentAudit> treatmentAudits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TreatmentAudit treatmentAudit : treatmentAudits) {
			entityCache.removeResult(
				entityCacheEnabled, TreatmentAuditImpl.class,
				treatmentAudit.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TreatmentAuditImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new treatment audit with the primary key. Does not add the treatment audit to the database.
	 *
	 * @param AuditID the primary key for the new treatment audit
	 * @return the new treatment audit
	 */
	@Override
	public TreatmentAudit create(long AuditID) {
		TreatmentAudit treatmentAudit = new TreatmentAuditImpl();

		treatmentAudit.setNew(true);
		treatmentAudit.setPrimaryKey(AuditID);

		return treatmentAudit;
	}

	/**
	 * Removes the treatment audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit that was removed
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	@Override
	public TreatmentAudit remove(long AuditID)
		throws NoSuchTreatmentAuditException {

		return remove((Serializable)AuditID);
	}

	/**
	 * Removes the treatment audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the treatment audit
	 * @return the treatment audit that was removed
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	@Override
	public TreatmentAudit remove(Serializable primaryKey)
		throws NoSuchTreatmentAuditException {

		Session session = null;

		try {
			session = openSession();

			TreatmentAudit treatmentAudit = (TreatmentAudit)session.get(
				TreatmentAuditImpl.class, primaryKey);

			if (treatmentAudit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTreatmentAuditException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(treatmentAudit);
		}
		catch (NoSuchTreatmentAuditException noSuchEntityException) {
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
	protected TreatmentAudit removeImpl(TreatmentAudit treatmentAudit) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(treatmentAudit)) {
				treatmentAudit = (TreatmentAudit)session.get(
					TreatmentAuditImpl.class,
					treatmentAudit.getPrimaryKeyObj());
			}

			if (treatmentAudit != null) {
				session.delete(treatmentAudit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (treatmentAudit != null) {
			clearCache(treatmentAudit);
		}

		return treatmentAudit;
	}

	@Override
	public TreatmentAudit updateImpl(TreatmentAudit treatmentAudit) {
		boolean isNew = treatmentAudit.isNew();

		if (!(treatmentAudit instanceof TreatmentAuditModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(treatmentAudit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					treatmentAudit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in treatmentAudit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TreatmentAudit implementation " +
					treatmentAudit.getClass());
		}

		TreatmentAuditModelImpl treatmentAuditModelImpl =
			(TreatmentAuditModelImpl)treatmentAudit;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(treatmentAudit);

				treatmentAudit.setNew(false);
			}
			else {
				treatmentAudit = (TreatmentAudit)session.merge(treatmentAudit);
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
				treatmentAuditModelImpl.getTeethNum()
			};

			finderCache.removeResult(_finderPathCountByAudit_TeethNum, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAudit_TeethNum, args);

			args = new Object[] {treatmentAuditModelImpl.getEditType()};

			finderCache.removeResult(_finderPathCountByAudit_EditType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByAudit_EditType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((treatmentAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAudit_TeethNum.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentAuditModelImpl.getOriginalTeethNum()
				};

				finderCache.removeResult(
					_finderPathCountByAudit_TeethNum, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAudit_TeethNum, args);

				args = new Object[] {treatmentAuditModelImpl.getTeethNum()};

				finderCache.removeResult(
					_finderPathCountByAudit_TeethNum, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAudit_TeethNum, args);
			}

			if ((treatmentAuditModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByAudit_EditType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					treatmentAuditModelImpl.getOriginalEditType()
				};

				finderCache.removeResult(
					_finderPathCountByAudit_EditType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAudit_EditType, args);

				args = new Object[] {treatmentAuditModelImpl.getEditType()};

				finderCache.removeResult(
					_finderPathCountByAudit_EditType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByAudit_EditType, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TreatmentAuditImpl.class,
			treatmentAudit.getPrimaryKey(), treatmentAudit, false);

		treatmentAudit.resetOriginalValues();

		return treatmentAudit;
	}

	/**
	 * Returns the treatment audit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	@Override
	public TreatmentAudit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTreatmentAuditException {

		TreatmentAudit treatmentAudit = fetchByPrimaryKey(primaryKey);

		if (treatmentAudit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTreatmentAuditException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return treatmentAudit;
	}

	/**
	 * Returns the treatment audit with the primary key or throws a <code>NoSuchTreatmentAuditException</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit
	 * @throws NoSuchTreatmentAuditException if a treatment audit with the primary key could not be found
	 */
	@Override
	public TreatmentAudit findByPrimaryKey(long AuditID)
		throws NoSuchTreatmentAuditException {

		return findByPrimaryKey((Serializable)AuditID);
	}

	/**
	 * Returns the treatment audit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param AuditID the primary key of the treatment audit
	 * @return the treatment audit, or <code>null</code> if a treatment audit with the primary key could not be found
	 */
	@Override
	public TreatmentAudit fetchByPrimaryKey(long AuditID) {
		return fetchByPrimaryKey((Serializable)AuditID);
	}

	/**
	 * Returns all the treatment audits.
	 *
	 * @return the treatment audits
	 */
	@Override
	public List<TreatmentAudit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TreatmentAudit> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TreatmentAudit> findAll(
		int start, int end,
		OrderByComparator<TreatmentAudit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TreatmentAudit> findAll(
		int start, int end, OrderByComparator<TreatmentAudit> orderByComparator,
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

		List<TreatmentAudit> list = null;

		if (useFinderCache) {
			list = (List<TreatmentAudit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TREATMENTAUDIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TREATMENTAUDIT;

				sql = sql.concat(TreatmentAuditModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TreatmentAudit>)QueryUtil.list(
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
	 * Removes all the treatment audits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TreatmentAudit treatmentAudit : findAll()) {
			remove(treatmentAudit);
		}
	}

	/**
	 * Returns the number of treatment audits.
	 *
	 * @return the number of treatment audits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TREATMENTAUDIT);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "AuditID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TREATMENTAUDIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TreatmentAuditModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the treatment audit persistence.
	 */
	@Activate
	public void activate() {
		TreatmentAuditModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TreatmentAuditModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByAudit_TeethNum = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAudit_TeethNum",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAudit_TeethNum = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAudit_TeethNum",
			new String[] {Long.class.getName()},
			TreatmentAuditModelImpl.TEETHNUM_COLUMN_BITMASK);

		_finderPathCountByAudit_TeethNum = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAudit_TeethNum",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByAudit_EditType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAudit_EditType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByAudit_EditType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TreatmentAuditImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAudit_EditType",
			new String[] {String.class.getName()},
			TreatmentAuditModelImpl.EDITTYPE_COLUMN_BITMASK);

		_finderPathCountByAudit_EditType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAudit_EditType",
			new String[] {String.class.getName()});

		_setTreatmentAuditUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTreatmentAuditUtilPersistence(null);

		entityCache.removeCache(TreatmentAuditImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setTreatmentAuditUtilPersistence(
		TreatmentAuditPersistence treatmentAuditPersistence) {

		try {
			Field field = TreatmentAuditUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, treatmentAuditPersistence);
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
				"value.object.column.bitmask.enabled.teeth.model.TreatmentAudit"),
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

	private static final String _SQL_SELECT_TREATMENTAUDIT =
		"SELECT treatmentAudit FROM TreatmentAudit treatmentAudit";

	private static final String _SQL_SELECT_TREATMENTAUDIT_WHERE =
		"SELECT treatmentAudit FROM TreatmentAudit treatmentAudit WHERE ";

	private static final String _SQL_COUNT_TREATMENTAUDIT =
		"SELECT COUNT(treatmentAudit) FROM TreatmentAudit treatmentAudit";

	private static final String _SQL_COUNT_TREATMENTAUDIT_WHERE =
		"SELECT COUNT(treatmentAudit) FROM TreatmentAudit treatmentAudit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "treatmentAudit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TreatmentAudit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TreatmentAudit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TreatmentAuditPersistenceImpl.class);

}