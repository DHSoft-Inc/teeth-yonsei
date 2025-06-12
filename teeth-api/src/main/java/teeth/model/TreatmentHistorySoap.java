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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TreatmentHistorySoap implements Serializable {

	public static TreatmentHistorySoap toSoapModel(TreatmentHistory model) {
		TreatmentHistorySoap soapModel = new TreatmentHistorySoap();

		soapModel.setTreatmentID(model.getTreatmentID());
		soapModel.setPatientID(model.getPatientID());
		soapModel.setEditedUserID(model.getEditedUserID());
		soapModel.setTeethNum(model.getTeethNum());
		soapModel.setTreatmentDate(model.getTreatmentDate());
		soapModel.setEditedDate(model.getEditedDate());
		soapModel.setTreatment(model.getTreatment());
		soapModel.setState(model.getState());

		return soapModel;
	}

	public static TreatmentHistorySoap[] toSoapModels(
		TreatmentHistory[] models) {

		TreatmentHistorySoap[] soapModels =
			new TreatmentHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TreatmentHistorySoap[][] toSoapModels(
		TreatmentHistory[][] models) {

		TreatmentHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TreatmentHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TreatmentHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TreatmentHistorySoap[] toSoapModels(
		List<TreatmentHistory> models) {

		List<TreatmentHistorySoap> soapModels =
			new ArrayList<TreatmentHistorySoap>(models.size());

		for (TreatmentHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TreatmentHistorySoap[soapModels.size()]);
	}

	public TreatmentHistorySoap() {
	}

	public long getPrimaryKey() {
		return _treatmentID;
	}

	public void setPrimaryKey(long pk) {
		setTreatmentID(pk);
	}

	public long getTreatmentID() {
		return _treatmentID;
	}

	public void setTreatmentID(long treatmentID) {
		_treatmentID = treatmentID;
	}

	public long getPatientID() {
		return _patientID;
	}

	public void setPatientID(long patientID) {
		_patientID = patientID;
	}

	public long getEditedUserID() {
		return _editedUserID;
	}

	public void setEditedUserID(long editedUserID) {
		_editedUserID = editedUserID;
	}

	public long getTeethNum() {
		return _teethNum;
	}

	public void setTeethNum(long teethNum) {
		_teethNum = teethNum;
	}

	public Date getTreatmentDate() {
		return _treatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate) {
		_treatmentDate = treatmentDate;
	}

	public Date getEditedDate() {
		return _editedDate;
	}

	public void setEditedDate(Date editedDate) {
		_editedDate = editedDate;
	}

	public String getTreatment() {
		return _treatment;
	}

	public void setTreatment(String treatment) {
		_treatment = treatment;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	private long _treatmentID;
	private long _patientID;
	private long _editedUserID;
	private long _teethNum;
	private Date _treatmentDate;
	private Date _editedDate;
	private String _treatment;
	private String _state;

}