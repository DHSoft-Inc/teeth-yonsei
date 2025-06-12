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

		attributes.put("treatmentID", getTreatmentID());
		attributes.put("patientID", getPatientID());
		attributes.put("editedUserID", getEditedUserID());
		attributes.put("teethNum", getTeethNum());
		attributes.put("treatmentDate", getTreatmentDate());
		attributes.put("editedDate", getEditedDate());
		attributes.put("treatment", getTreatment());
		attributes.put("state", getState());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

	@Override
	public void persist() {
		model.persist();
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

	@Override
	protected TreatmentHistoryWrapper wrap(TreatmentHistory treatmentHistory) {
		return new TreatmentHistoryWrapper(treatmentHistory);
	}

}