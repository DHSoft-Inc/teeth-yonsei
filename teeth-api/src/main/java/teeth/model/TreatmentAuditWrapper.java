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

import com.liferay.exportimport.kernel.lar.StagedModelType;
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

		attributes.put("uuid", getUuid());
		attributes.put("AuditID", getAuditID());
		attributes.put("teethNum", getTeethNum());
		attributes.put("editedDate", getEditedDate());
		attributes.put("editedUserID", getEditedUserID());
		attributes.put("editType", getEditType());
		attributes.put("treatmentDate", getTreatmentDate());
		attributes.put("beforeData", getBeforeData());
		attributes.put("afterData", getAfterData());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
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
	 * Returns the company ID of this treatment audit.
	 *
	 * @return the company ID of this treatment audit
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this treatment audit.
	 *
	 * @return the create date of this treatment audit
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
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
	 * Returns the group ID of this treatment audit.
	 *
	 * @return the group ID of this treatment audit
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this treatment audit.
	 *
	 * @return the modified date of this treatment audit
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
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
	 * Returns the status of this treatment audit.
	 *
	 * @return the status of this treatment audit
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this treatment audit.
	 *
	 * @return the status by user ID of this treatment audit
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this treatment audit.
	 *
	 * @return the status by user name of this treatment audit
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this treatment audit.
	 *
	 * @return the status by user uuid of this treatment audit
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this treatment audit.
	 *
	 * @return the status date of this treatment audit
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
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

	/**
	 * Returns the user ID of this treatment audit.
	 *
	 * @return the user ID of this treatment audit
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this treatment audit.
	 *
	 * @return the user name of this treatment audit
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this treatment audit.
	 *
	 * @return the user uuid of this treatment audit
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this treatment audit.
	 *
	 * @return the uuid of this treatment audit
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is approved.
	 *
	 * @return <code>true</code> if this treatment audit is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is denied.
	 *
	 * @return <code>true</code> if this treatment audit is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is a draft.
	 *
	 * @return <code>true</code> if this treatment audit is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is expired.
	 *
	 * @return <code>true</code> if this treatment audit is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is inactive.
	 *
	 * @return <code>true</code> if this treatment audit is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is incomplete.
	 *
	 * @return <code>true</code> if this treatment audit is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is pending.
	 *
	 * @return <code>true</code> if this treatment audit is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this treatment audit is scheduled.
	 *
	 * @return <code>true</code> if this treatment audit is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
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
	 * Sets the company ID of this treatment audit.
	 *
	 * @param companyId the company ID of this treatment audit
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this treatment audit.
	 *
	 * @param createDate the create date of this treatment audit
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
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
	 * Sets the group ID of this treatment audit.
	 *
	 * @param groupId the group ID of this treatment audit
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this treatment audit.
	 *
	 * @param modifiedDate the modified date of this treatment audit
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
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
	 * Sets the status of this treatment audit.
	 *
	 * @param status the status of this treatment audit
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this treatment audit.
	 *
	 * @param statusByUserId the status by user ID of this treatment audit
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this treatment audit.
	 *
	 * @param statusByUserName the status by user name of this treatment audit
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this treatment audit.
	 *
	 * @param statusByUserUuid the status by user uuid of this treatment audit
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this treatment audit.
	 *
	 * @param statusDate the status date of this treatment audit
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
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

	/**
	 * Sets the user ID of this treatment audit.
	 *
	 * @param userId the user ID of this treatment audit
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this treatment audit.
	 *
	 * @param userName the user name of this treatment audit
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this treatment audit.
	 *
	 * @param userUuid the user uuid of this treatment audit
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this treatment audit.
	 *
	 * @param uuid the uuid of this treatment audit
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TreatmentAuditWrapper wrap(TreatmentAudit treatmentAudit) {
		return new TreatmentAuditWrapper(treatmentAudit);
	}

}