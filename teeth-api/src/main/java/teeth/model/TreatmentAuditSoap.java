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
public class TreatmentAuditSoap implements Serializable {

	public static TreatmentAuditSoap toSoapModel(TreatmentAudit model) {
		TreatmentAuditSoap soapModel = new TreatmentAuditSoap();

		soapModel.setAuditID(model.getAuditID());
		soapModel.setTeethNum(model.getTeethNum());
		soapModel.setEditedDate(model.getEditedDate());
		soapModel.setEditedUserID(model.getEditedUserID());
		soapModel.setEditType(model.getEditType());
		soapModel.setTreatmentDate(model.getTreatmentDate());
		soapModel.setBeforeData(model.getBeforeData());
		soapModel.setAfterData(model.getAfterData());

		return soapModel;
	}

	public static TreatmentAuditSoap[] toSoapModels(TreatmentAudit[] models) {
		TreatmentAuditSoap[] soapModels = new TreatmentAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TreatmentAuditSoap[][] toSoapModels(
		TreatmentAudit[][] models) {

		TreatmentAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TreatmentAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TreatmentAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TreatmentAuditSoap[] toSoapModels(
		List<TreatmentAudit> models) {

		List<TreatmentAuditSoap> soapModels = new ArrayList<TreatmentAuditSoap>(
			models.size());

		for (TreatmentAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TreatmentAuditSoap[soapModels.size()]);
	}

	public TreatmentAuditSoap() {
	}

	public long getPrimaryKey() {
		return _AuditID;
	}

	public void setPrimaryKey(long pk) {
		setAuditID(pk);
	}

	public long getAuditID() {
		return _AuditID;
	}

	public void setAuditID(long AuditID) {
		_AuditID = AuditID;
	}

	public long getTeethNum() {
		return _teethNum;
	}

	public void setTeethNum(long teethNum) {
		_teethNum = teethNum;
	}

	public Date getEditedDate() {
		return _editedDate;
	}

	public void setEditedDate(Date editedDate) {
		_editedDate = editedDate;
	}

	public long getEditedUserID() {
		return _editedUserID;
	}

	public void setEditedUserID(long editedUserID) {
		_editedUserID = editedUserID;
	}

	public String getEditType() {
		return _editType;
	}

	public void setEditType(String editType) {
		_editType = editType;
	}

	public Date getTreatmentDate() {
		return _treatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate) {
		_treatmentDate = treatmentDate;
	}

	public String getBeforeData() {
		return _beforeData;
	}

	public void setBeforeData(String beforeData) {
		_beforeData = beforeData;
	}

	public String getAfterData() {
		return _afterData;
	}

	public void setAfterData(String afterData) {
		_afterData = afterData;
	}

	private long _AuditID;
	private long _teethNum;
	private Date _editedDate;
	private long _editedUserID;
	private String _editType;
	private Date _treatmentDate;
	private String _beforeData;
	private String _afterData;

}