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

package teeth.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TreatmentAudit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentAudit
 * @generated
 */
public class TreatmentAuditWrapper
	extends BaseModelWrapper<TreatmentAudit>
	implements ModelWrapper<TreatmentAudit>, TreatmentAudit {

	public TreatmentAuditWrapper(TreatmentAudit treatmentAudit) {
		super(treatmentAudit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("AuditID", getAuditID());
		attributes.put("teethNum", getTeethNum());
		attributes.put("editedDate", getEditedDate());
		attributes.put("editedUserID", getEditedUserID());
		attributes.put("editType", getEditType());
		attributes.put("treatmentDate", getTreatmentDate());
		attributes.put("beforeData", getBeforeData());
		attributes.put("afterData", getAfterData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long AuditID = (Long)attributes.get("AuditID");

		if (AuditID != null) {
			setAuditID(AuditID);
		}

		Long teethNum = (Long)attributes.get("teethNum");

		if (teethNum != null) {
			setTeethNum(teethNum);
		}

		Date editedDate = (Date)attributes.get("editedDate");

		if (editedDate != null) {
			setEditedDate(editedDate);
		}

		Long editedUserID = (Long)attributes.get("editedUserID");

		if (editedUserID != null) {
			setEditedUserID(editedUserID);
		}

		String editType = (String)attributes.get("editType");

		if (editType != null) {
			setEditType(editType);
		}

		Date treatmentDate = (Date)attributes.get("treatmentDate");

		if (treatmentDate != null) {
			setTreatmentDate(treatmentDate);
		}

		String beforeData = (String)attributes.get("beforeData");

		if (beforeData != null) {
			setBeforeData(beforeData);
		}

		String afterData = (String)attributes.get("afterData");

		if (afterData != null) {
			setAfterData(afterData);
		}
	}

	/**
	 * Returns the after data of this treatment audit.
	 *
	 * @return the after data of this treatment audit
	 */
	@Override
	public String getAfterData() {
		return model.getAfterData();
	}

	/**
	 * Returns the audit ID of this treatment audit.
	 *
	 * @return the audit ID of this treatment audit
	 */
	@Override
	public long getAuditID() {
		return model.getAuditID();
	}

	/**
	 * Returns the before data of this treatment audit.
	 *
	 * @return the before data of this treatment audit
	 */
	@Override
	public String getBeforeData() {
		return model.getBeforeData();
	}

	/**
	 * Returns the edited date of this treatment audit.
	 *
	 * @return the edited date of this treatment audit
	 */
	@Override
	public Date getEditedDate() {
		return model.getEditedDate();
	}

	/**
	 * Returns the edited user ID of this treatment audit.
	 *
	 * @return the edited user ID of this treatment audit
	 */
	@Override
	public long getEditedUserID() {
		return model.getEditedUserID();
	}

	/**
	 * Returns the edit type of this treatment audit.
	 *
	 * @return the edit type of this treatment audit
	 */
	@Override
	public String getEditType() {
		return model.getEditType();
	}

	/**
	 * Returns the primary key of this treatment audit.
	 *
	 * @return the primary key of this treatment audit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the teeth num of this treatment audit.
	 *
	 * @return the teeth num of this treatment audit
	 */
	@Override
	public long getTeethNum() {
		return model.getTeethNum();
	}

	/**
	 * Returns the treatment date of this treatment audit.
	 *
	 * @return the treatment date of this treatment audit
	 */
	@Override
	public Date getTreatmentDate() {
		return model.getTreatmentDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the after data of this treatment audit.
	 *
	 * @param afterData the after data of this treatment audit
	 */
	@Override
	public void setAfterData(String afterData) {
		model.setAfterData(afterData);
	}

	/**
	 * Sets the audit ID of this treatment audit.
	 *
	 * @param AuditID the audit ID of this treatment audit
	 */
	@Override
	public void setAuditID(long AuditID) {
		model.setAuditID(AuditID);
	}

	/**
	 * Sets the before data of this treatment audit.
	 *
	 * @param beforeData the before data of this treatment audit
	 */
	@Override
	public void setBeforeData(String beforeData) {
		model.setBeforeData(beforeData);
	}

	/**
	 * Sets the edited date of this treatment audit.
	 *
	 * @param editedDate the edited date of this treatment audit
	 */
	@Override
	public void setEditedDate(Date editedDate) {
		model.setEditedDate(editedDate);
	}

	/**
	 * Sets the edited user ID of this treatment audit.
	 *
	 * @param editedUserID the edited user ID of this treatment audit
	 */
	@Override
	public void setEditedUserID(long editedUserID) {
		model.setEditedUserID(editedUserID);
	}

	/**
	 * Sets the edit type of this treatment audit.
	 *
	 * @param editType the edit type of this treatment audit
	 */
	@Override
	public void setEditType(String editType) {
		model.setEditType(editType);
	}

	/**
	 * Sets the primary key of this treatment audit.
	 *
	 * @param primaryKey the primary key of this treatment audit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the teeth num of this treatment audit.
	 *
	 * @param teethNum the teeth num of this treatment audit
	 */
	@Override
	public void setTeethNum(long teethNum) {
		model.setTeethNum(teethNum);
	}

	/**
	 * Sets the treatment date of this treatment audit.
	 *
	 * @param treatmentDate the treatment date of this treatment audit
	 */
	@Override
	public void setTreatmentDate(Date treatmentDate) {
		model.setTreatmentDate(treatmentDate);
	}

	@Override
	protected TreatmentAuditWrapper wrap(TreatmentAudit treatmentAudit) {
		return new TreatmentAuditWrapper(treatmentAudit);
	}

}