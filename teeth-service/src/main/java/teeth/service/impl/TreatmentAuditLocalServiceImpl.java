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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import teeth.model.TreatmentAudit;
import teeth.service.base.TreatmentAuditLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */

@Component(
	property = "model.class.name=teeth.model.TreatmentAudit",
	service = AopService.class
)

public class TreatmentAuditLocalServiceImpl extends TreatmentAuditLocalServiceBaseImpl {
	@Reference
	private AssetEntryLocalService _assetEntryLocalService;
	   
	@Reference
	private AssetLinkLocalService _assetLinkLocalService;
	
	public TreatmentAudit AddAudit(long crfId, long linkId, long patientId, long teethNum, long editedUserID, Date TreatmentDate, String editType, String BeforeData, String afterData, ServiceContext serviceContext) 
	{
		
		_log.info("teethNum: " + teethNum + " editType: " + editType + " BeforeData: " + BeforeData + " afterData: "
				+ afterData);
		try 
		{
			long groupId = serviceContext.getScopeGroupId();
			long AuditID = super.counterLocalService.increment();
			TreatmentAudit newAudit = super.treatmentAuditLocalService.createTreatmentAudit(AuditID);
			
			Date editedDate = new Date();
			
			newAudit.setGroupId(groupId);
			newAudit.setCrfId(crfId);
			newAudit.setLinkId(linkId);
			newAudit.setPatientID(patientId);			
			newAudit.setTeethNum(teethNum);
			newAudit.setUserId(editedUserID);
			newAudit.setEditedDate(editedDate);
			newAudit.setEditedUserID(editedUserID);
			newAudit.setTreatmentDate(TreatmentDate);
			newAudit.setEditType(editType);
			newAudit.setBeforeData(BeforeData);
			newAudit.setAfterData(afterData);
			treatmentAuditPersistence.update(newAudit);
			
			
            // �� AssetEntry �߰�/������Ʈ
            AssetEntry assetEntry = _assetEntryLocalService.updateEntry(
                serviceContext.getUserId(),
                groupId,
                newAudit.getCreateDate(),
                newAudit.getModifiedDate(),
                TreatmentAudit.class.getName(),
                newAudit.getAuditID(),
                newAudit.getUuid(),
                0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                true,  // visible
                true,  // publishDate <= now ?
                null,  // startDate
                null,  // endDate
                null,  // mimeType
                ContentTypes.TEXT_HTML,
                "Audit: " + newAudit.getEditType(),  // title
                null, null, null, null,
                0, 0,  // height, width
                serviceContext.getAssetPriority()
            );

            // �� AssetLink ���� ����
            _assetLinkLocalService.updateLinks(
                serviceContext.getUserId(),
                assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                com.liferay.asset.kernel.model.AssetLinkConstants.TYPE_RELATED
            );
			
			return newAudit;
		} 
		catch (Exception e) 
		{
			_log.info("Error during Add Audit!");
			e.printStackTrace();
			return null;
		}
	}
	
	public TreatmentAudit AddAudit(long teethNum, long editedUserID, Date TreatmentDate, String editType, String BeforeData, String afterData, ServiceContext serviceContext) 
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
			
			
            // �� AssetEntry �߰�/������Ʈ
            AssetEntry assetEntry = _assetEntryLocalService.updateEntry(
                serviceContext.getUserId(),
                serviceContext.getScopeGroupId(),
                newAudit.getCreateDate(),
                newAudit.getModifiedDate(),
                TreatmentAudit.class.getName(),
                newAudit.getAuditID(),
                newAudit.getUuid(),
                0,
                serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(),
                true,  // visible
                true,  // publishDate <= now ?
                null,  // startDate
                null,  // endDate
                null,  // mimeType
                ContentTypes.TEXT_HTML,
                "Audit: " + newAudit.getEditType(),  // title
                null, null, null, null,
                0, 0,  // height, width
                serviceContext.getAssetPriority()
            );

            // �� AssetLink ���� ����
            _assetLinkLocalService.updateLinks(
                serviceContext.getUserId(),
                assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(),
                com.liferay.asset.kernel.model.AssetLinkConstants.TYPE_RELATED
            );
			
			
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
	
	public List<TreatmentAudit> getAuditsByG_C_P_L(long groupId, long crfId, long patientID, long linkId) {
		return treatmentAuditPersistence.findByG_C_P_L(groupId, crfId, patientID, linkId);
	}
	
	public List<TreatmentAudit> getAuditsByG_C_P_L_TN(long groupId, long crfId, long patientID, long linkId, long teethNum) {
		return treatmentAuditPersistence.findByG_C_P_L_TN(groupId, crfId, patientID, linkId, teethNum);
	}

	Log _log = LogFactoryUtil.getLog(TreatmentAuditLocalServiceImpl.class);
}