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

import teeth.model.TreatmentAudit;

/**
 * The cache model class for representing TreatmentAudit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TreatmentAuditCacheModel
	implements CacheModel<TreatmentAudit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TreatmentAuditCacheModel)) {
			return false;
		}

		TreatmentAuditCacheModel treatmentAuditCacheModel =
			(TreatmentAuditCacheModel)object;

		if (AuditID == treatmentAuditCacheModel.AuditID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, AuditID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", AuditID=");
		sb.append(AuditID);
		sb.append(", teethNum=");
		sb.append(teethNum);
		sb.append(", editedDate=");
		sb.append(editedDate);
		sb.append(", editedUserID=");
		sb.append(editedUserID);
		sb.append(", editType=");
		sb.append(editType);
		sb.append(", treatmentDate=");
		sb.append(treatmentDate);
		sb.append(", beforeData=");
		sb.append(beforeData);
		sb.append(", afterData=");
		sb.append(afterData);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TreatmentAudit toEntityModel() {
		TreatmentAuditImpl treatmentAuditImpl = new TreatmentAuditImpl();

		if (uuid == null) {
			treatmentAuditImpl.setUuid("");
		}
		else {
			treatmentAuditImpl.setUuid(uuid);
		}

		treatmentAuditImpl.setAuditID(AuditID);
		treatmentAuditImpl.setTeethNum(teethNum);

		if (editedDate == Long.MIN_VALUE) {
			treatmentAuditImpl.setEditedDate(null);
		}
		else {
			treatmentAuditImpl.setEditedDate(new Date(editedDate));
		}

		treatmentAuditImpl.setEditedUserID(editedUserID);

		if (editType == null) {
			treatmentAuditImpl.setEditType("");
		}
		else {
			treatmentAuditImpl.setEditType(editType);
		}

		if (treatmentDate == Long.MIN_VALUE) {
			treatmentAuditImpl.setTreatmentDate(null);
		}
		else {
			treatmentAuditImpl.setTreatmentDate(new Date(treatmentDate));
		}

		if (beforeData == null) {
			treatmentAuditImpl.setBeforeData("");
		}
		else {
			treatmentAuditImpl.setBeforeData(beforeData);
		}

		if (afterData == null) {
			treatmentAuditImpl.setAfterData("");
		}
		else {
			treatmentAuditImpl.setAfterData(afterData);
		}

		treatmentAuditImpl.setGroupId(groupId);
		treatmentAuditImpl.setCompanyId(companyId);
		treatmentAuditImpl.setUserId(userId);

		if (userName == null) {
			treatmentAuditImpl.setUserName("");
		}
		else {
			treatmentAuditImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			treatmentAuditImpl.setCreateDate(null);
		}
		else {
			treatmentAuditImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			treatmentAuditImpl.setModifiedDate(null);
		}
		else {
			treatmentAuditImpl.setModifiedDate(new Date(modifiedDate));
		}

		treatmentAuditImpl.setStatus(status);
		treatmentAuditImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			treatmentAuditImpl.setStatusByUserName("");
		}
		else {
			treatmentAuditImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			treatmentAuditImpl.setStatusDate(null);
		}
		else {
			treatmentAuditImpl.setStatusDate(new Date(statusDate));
		}

		treatmentAuditImpl.resetOriginalValues();

		return treatmentAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		AuditID = objectInput.readLong();

		teethNum = objectInput.readLong();
		editedDate = objectInput.readLong();

		editedUserID = objectInput.readLong();
		editType = objectInput.readUTF();
		treatmentDate = objectInput.readLong();
		beforeData = objectInput.readUTF();
		afterData = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(AuditID);

		objectOutput.writeLong(teethNum);
		objectOutput.writeLong(editedDate);

		objectOutput.writeLong(editedUserID);

		if (editType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(editType);
		}

		objectOutput.writeLong(treatmentDate);

		if (beforeData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(beforeData);
		}

		if (afterData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(afterData);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long AuditID;
	public long teethNum;
	public long editedDate;
	public long editedUserID;
	public String editType;
	public long treatmentDate;
	public String beforeData;
	public String afterData;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}