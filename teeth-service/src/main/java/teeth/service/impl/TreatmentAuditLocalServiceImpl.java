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

package teeth.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentAudit;
import teeth.service.base.TreatmentAuditLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=teeth.model.TreatmentAudit",
	service = AopService.class
)
public class TreatmentAuditLocalServiceImpl
	extends TreatmentAuditLocalServiceBaseImpl {
	
	public TreatmentAudit AddAudit(long teethNum, long editedUserID, Date TreatmentDate, String editType, String BeforeData, String afterData) 
	{

		_log.info("teethNum: " + teethNum + " editType: " + editType + " BeforeData: " + BeforeData + " afterData: "
				+ afterData);
		try 
		{
			long AuditID = counterLocalService.increment("AuditID");
			TreatmentAudit newAudit = treatmentAuditPersistence.create(AuditID);
			newAudit.setTeethNum(teethNum);
			Date editedDate = new Date();
			newAudit.setEditedDate(editedDate);
			newAudit.setEditedUserID(editedUserID);
			newAudit.setTreatmentDate(TreatmentDate);
			newAudit.setEditType(editType);
			newAudit.setBeforeData(BeforeData);
			newAudit.setAfterData(afterData);
			treatmentAuditPersistence.update(newAudit);
			return newAudit;
		} 
		catch (Exception e) 
		{
			_log.info("Error during Add Audit!");
			e.printStackTrace();
			return null;
		}
	}

	public List<TreatmentAudit> getAuditByTeethNum(long teethNum) 
	{
		return treatmentAuditPersistence.findByAudit_TeethNum(teethNum);
	}

	public List<TreatmentAudit> getAuditByEditType(String EditType) 
	{
		return treatmentAuditPersistence.findByAudit_EditType(EditType);
	}

	Log _log = LogFactoryUtil.getLog(TreatmentAuditLocalServiceImpl.class);
}