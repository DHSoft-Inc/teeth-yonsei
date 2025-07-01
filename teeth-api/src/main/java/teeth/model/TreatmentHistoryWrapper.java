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
 * This class is a wrapper for {@link TreatmentHistory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TreatmentHistory
 * @generated
 */
public class TreatmentHistoryWrapper
	extends BaseModelWrapper<TreatmentHistory>
	implements ModelWrapper<TreatmentHistory>, TreatmentHistory {

	public TreatmentHistoryWrapper(TreatmentHistory treatmentHistory) {
		super(treatmentHistory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("treatmentID", getTreatmentID());
		attributes.put("patientID", getPatientID());
		attributes.put("editedUserID", getEditedUserID());
		attributes.put("teethNum", getTeethNum());
		attributes.put("treatmentDate", getTreatmentDate());
		attributes.put("editedDate", getEditedDate());
		attributes.put("treatment", getTreatment());
		attributes.put("state", getState());
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

		Long treatmentID = (Long)attributes.get("treatmentID");

		if (treatmentID != null) {
			setTreatmentID(treatmentID);
		}

		Long patientID = (Long)attributes.get("patientID");

		if (patientID != null) {
			setPatientID(patientID);
		}

		Long editedUserID = (Long)attributes.get("editedUserID");

		if (editedUserID != null) {
			setEditedUserID(editedUserID);
		}

		Long teethNum = (Long)attributes.get("teethNum");

		if (teethNum != null) {
			setTeethNum(teethNum);
		}

		Date treatmentDate = (Date)attributes.get("treatmentDate");

		if (treatmentDate != null) {
			setTreatmentDate(treatmentDate);
		}

		Date editedDate = (Date)attributes.get("editedDate");

		if (editedDate != null) {
			setEditedDate(editedDate);
		}

		String treatment = (String)attributes.get("treatment");

		if (treatment != null) {
			setTreatment(treatment);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
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
	 * Returns the company ID of this treatment history.
	 *
	 * @return the company ID of this treatment history
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this treatment history.
	 *
	 * @return the create date of this treatment history
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the edited date of this treatment history.
	 *
	 * @return the edited date of this treatment history
	 */
	@Override
	public Date getEditedDate() {
		return model.getEditedDate();
	}

	/**
	 * Returns the edited user ID of this treatment history.
	 *
	 * @return the edited user ID of this treatment history
	 */
	@Override
	public long getEditedUserID() {
		return model.getEditedUserID();
	}

	/**
	 * Returns the group ID of this treatment history.
	 *
	 * @return the group ID of this treatment history
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this treatment history.
	 *
	 * @return the modified date of this treatment history
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient ID of this treatment history.
	 *
	 * @return the patient ID of this treatment history
	 */
	@Override
	public long getPatientID() {
		return model.getPatientID();
	}

	/**
	 * Returns the primary key of this treatment history.
	 *
	 * @return the primary key of this treatment history
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this treatment history.
	 *
	 * @return the state of this treatment history
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the status of this treatment history.
	 *
	 * @return the status of this treatment history
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this treatment history.
	 *
	 * @return the status by user ID of this treatment history
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this treatment history.
	 *
	 * @return the status by user name of this treatment history
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this treatment history.
	 *
	 * @return the status by user uuid of this treatment history
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this treatment history.
	 *
	 * @return the status date of this treatment history
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the teeth num of this treatment history.
	 *
	 * @return the teeth num of this treatment history
	 */
	@Override
	public long getTeethNum() {
		return model.getTeethNum();
	}

	/**
	 * Returns the treatment of this treatment history.
	 *
	 * @return the treatment of this treatment history
	 */
	@Override
	public String getTreatment() {
		return model.getTreatment();
	}

	/**
	 * Returns the treatment date of this treatment history.
	 *
	 * @return the treatment date of this treatment history
	 */
	@Override
	public Date getTreatmentDate() {
		return model.getTreatmentDate();
	}

	/**
	 * Returns the treatment ID of this treatment history.
	 *
	 * @return the treatment ID of this treatment history
	 */
	@Override
	public long getTreatmentID() {
		return model.getTreatmentID();
	}

	/**
	 * Returns the user ID of this treatment history.
	 *
	 * @return the user ID of this treatment history
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this treatment history.
	 *
	 * @return the user name of this treatment history
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this treatment history.
	 *
	 * @return the user uuid of this treatment history
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this treatment history.
	 *
	 * @return the uuid of this treatment history
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this treatment history is approved.
	 *
	 * @return <code>true</code> if this treatment history is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this treatment history is denied.
	 *
	 * @return <code>true</code> if this treatment history is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this treatment history is a draft.
	 *
	 * @return <code>true</code> if this treatment history is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this treatment history is expired.
	 *
	 * @return <code>true</code> if this treatment history is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this treatment history is inactive.
	 *
	 * @return <code>true</code> if this treatment history is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this treatment history is incomplete.
	 *
	 * @return <code>true</code> if this treatment history is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this treatment history is pending.
	 *
	 * @return <code>true</code> if this treatment history is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this treatment history is scheduled.
	 *
	 * @return <code>true</code> if this treatment history is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this treatment history.
	 *
	 * @param companyId the company ID of this treatment history
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this treatment history.
	 *
	 * @param createDate the create date of this treatment history
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the edited date of this treatment history.
	 *
	 * @param editedDate the edited date of this treatment history
	 */
	@Override
	public void setEditedDate(Date editedDate) {
		model.setEditedDate(editedDate);
	}

	/**
	 * Sets the edited user ID of this treatment history.
	 *
	 * @param editedUserID the edited user ID of this treatment history
	 */
	@Override
	public void setEditedUserID(long editedUserID) {
		model.setEditedUserID(editedUserID);
	}

	/**
	 * Sets the group ID of this treatment history.
	 *
	 * @param groupId the group ID of this treatment history
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this treatment history.
	 *
	 * @param modifiedDate the modified date of this treatment history
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient ID of this treatment history.
	 *
	 * @param patientID the patient ID of this treatment history
	 */
	@Override
	public void setPatientID(long patientID) {
		model.setPatientID(patientID);
	}

	/**
	 * Sets the primary key of this treatment history.
	 *
	 * @param primaryKey the primary key of this treatment history
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this treatment history.
	 *
	 * @param state the state of this treatment history
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the status of this treatment history.
	 *
	 * @param status the status of this treatment history
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this treatment history.
	 *
	 * @param statusByUserId the status by user ID of this treatment history
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this treatment history.
	 *
	 * @param statusByUserName the status by user name of this treatment history
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this treatment history.
	 *
	 * @param statusByUserUuid the status by user uuid of this treatment history
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this treatment history.
	 *
	 * @param statusDate the status date of this treatment history
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the teeth num of this treatment history.
	 *
	 * @param teethNum the teeth num of this treatment history
	 */
	@Override
	public void setTeethNum(long teethNum) {
		model.setTeethNum(teethNum);
	}

	/**
	 * Sets the treatment of this treatment history.
	 *
	 * @param treatment the treatment of this treatment history
	 */
	@Override
	public void setTreatment(String treatment) {
		model.setTreatment(treatment);
	}

	/**
	 * Sets the treatment date of this treatment history.
	 *
	 * @param treatmentDate the treatment date of this treatment history
	 */
	@Override
	public void setTreatmentDate(Date treatmentDate) {
		model.setTreatmentDate(treatmentDate);
	}

	/**
	 * Sets the treatment ID of this treatment history.
	 *
	 * @param treatmentID the treatment ID of this treatment history
	 */
	@Override
	public void setTreatmentID(long treatmentID) {
		model.setTreatmentID(treatmentID);
	}

	/**
	 * Sets the user ID of this treatment history.
	 *
	 * @param userId the user ID of this treatment history
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this treatment history.
	 *
	 * @param userName the user name of this treatment history
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this treatment history.
	 *
	 * @param userUuid the user uuid of this treatment history
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this treatment history.
	 *
	 * @param uuid the uuid of this treatment history
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
	protected TreatmentHistoryWrapper wrap(TreatmentHistory treatmentHistory) {
		return new TreatmentHistoryWrapper(treatmentHistory);
	}

}