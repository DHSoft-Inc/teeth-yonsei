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

package teeth.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import teeth.model.TreatmentHistory;

/**
 * The cache model class for representing TreatmentHistory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TreatmentHistoryCacheModel
	implements CacheModel<TreatmentHistory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TreatmentHistoryCacheModel)) {
			return false;
		}

		TreatmentHistoryCacheModel treatmentHistoryCacheModel =
			(TreatmentHistoryCacheModel)object;

		if (treatmentID == treatmentHistoryCacheModel.treatmentID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, treatmentID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{treatmentID=");
		sb.append(treatmentID);
		sb.append(", patientID=");
		sb.append(patientID);
		sb.append(", editedUserID=");
		sb.append(editedUserID);
		sb.append(", teethNum=");
		sb.append(teethNum);
		sb.append(", treatmentDate=");
		sb.append(treatmentDate);
		sb.append(", editedDate=");
		sb.append(editedDate);
		sb.append(", treatment=");
		sb.append(treatment);
		sb.append(", state=");
		sb.append(state);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TreatmentHistory toEntityModel() {
		TreatmentHistoryImpl treatmentHistoryImpl = new TreatmentHistoryImpl();

		treatmentHistoryImpl.setTreatmentID(treatmentID);
		treatmentHistoryImpl.setPatientID(patientID);
		treatmentHistoryImpl.setEditedUserID(editedUserID);
		treatmentHistoryImpl.setTeethNum(teethNum);

		if (treatmentDate == Long.MIN_VALUE) {
			treatmentHistoryImpl.setTreatmentDate(null);
		}
		else {
			treatmentHistoryImpl.setTreatmentDate(new Date(treatmentDate));
		}

		if (editedDate == Long.MIN_VALUE) {
			treatmentHistoryImpl.setEditedDate(null);
		}
		else {
			treatmentHistoryImpl.setEditedDate(new Date(editedDate));
		}

		if (treatment == null) {
			treatmentHistoryImpl.setTreatment("");
		}
		else {
			treatmentHistoryImpl.setTreatment(treatment);
		}

		if (state == null) {
			treatmentHistoryImpl.setState("");
		}
		else {
			treatmentHistoryImpl.setState(state);
		}

		treatmentHistoryImpl.resetOriginalValues();

		return treatmentHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		treatmentID = objectInput.readLong();

		patientID = objectInput.readLong();

		editedUserID = objectInput.readLong();

		teethNum = objectInput.readLong();
		treatmentDate = objectInput.readLong();
		editedDate = objectInput.readLong();
		treatment = objectInput.readUTF();
		state = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(treatmentID);

		objectOutput.writeLong(patientID);

		objectOutput.writeLong(editedUserID);

		objectOutput.writeLong(teethNum);
		objectOutput.writeLong(treatmentDate);
		objectOutput.writeLong(editedDate);

		if (treatment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(treatment);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}
	}

	public long treatmentID;
	public long patientID;
	public long editedUserID;
	public long teethNum;
	public long treatmentDate;
	public long editedDate;
	public String treatment;
	public String state;

}