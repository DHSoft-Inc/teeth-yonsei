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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import teeth.model.TreatmentHistory;
import teeth.service.base.TreatmentHistoryLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=teeth.model.TreatmentHistory", service = AopService.class)
public class TreatmentHistoryLocalServiceImpl extends TreatmentHistoryLocalServiceBaseImpl {

	public TreatmentHistory AddHistory(long patientID, long teethNum, Date treatmentDate, String treatment,
			String state, Date editedDate, long editedUserID) {
		_log.info(patientID + " " + teethNum + " " + treatmentDate + " " + treatment);
		try {
			if (getPatientTreatmentByAll(patientID, teethNum, treatmentDate, treatment) != null) {
				_log.info("Duplicate Record!");
				return null;
			} else {
				long treatmentID = counterLocalService.increment("TreatmentID");
				TreatmentHistory record = treatmentHistoryPersistence.create(treatmentID);
				record.setPatientID(patientID);
				record.setTeethNum(teethNum);
				record.setTreatmentDate(treatmentDate);
				record.setTreatment(treatment);
				record.setState(state);
				record.setEditedDate(editedDate);
				record.setEditedUserID(editedUserID);
				treatmentHistoryPersistence.update(record);
				return record;
			}
		} catch (Exception e) {
			_log.info("Error during Add Record!");
			e.printStackTrace();
			return null;
		}
	}

	public TreatmentHistory UpdateHistory(long treatmentID, String treatment, String state, Date editedDate,
			long editedUserID) {
		try {
			TreatmentHistory record = getPatientTreatmentByTreatmentID(treatmentID);
			record.setTreatment(treatment);
			record.setEditedDate(editedDate);
			record.setEditedUserID(editedUserID);
			record.setState(state);
			treatmentHistoryPersistence.update(record);
			_log.info("Record Updated!");
			return record;
		} catch (Exception e) {
			_log.info("Error during Update Record!");
			e.printStackTrace();
			return null;
		}
	}

	public TreatmentHistory deleteHistory(TreatmentHistory record) {
		treatmentHistoryPersistence.remove(record);
		return record;
	}

	public TreatmentHistory deleteHistory(long treatmentID) throws PortalException {
		try {
			TreatmentHistory record = treatmentHistoryPersistence.findByPrimaryKey(treatmentID);
			return deleteHistory(record);
		} catch (Exception e) {
			_log.info("Error during Delete Record!");
			e.printStackTrace();
			return treatmentHistoryPersistence.findByPrimaryKey(treatmentID);
		}
	}

	public List<TreatmentHistory> getPatientTreatmentList(long patientID) {
		return treatmentHistoryPersistence.findByTeeth_PatientID(patientID);
	}

	public List<TreatmentHistory> getPatientTreatmentListByTeethNum(long patientID, long teethNum) {
		// _log.info("Oh Hi!");
		try {
			return treatmentHistoryPersistence.findByTeeth_PatientID_TeethNum(patientID, teethNum);
		} catch (Exception e) {
			_log.info("No Such Data!");
			e.printStackTrace();
			List<TreatmentHistory> EmptyList = new ArrayList<>();
			return EmptyList;
		}
	}

	public List<TreatmentHistory> getPatientTreatmentListByDate(long patientID, Date treatmentDate) {
		return treatmentHistoryPersistence.findByTeeth_PatientID_Date(patientID, treatmentDate);
	}

	public List<TreatmentHistory> getPatientTreatmentByDateAndTeethNum(long patientID, long teethNum,
			Date treatmentDate) {
		try {
			return treatmentHistoryPersistence.findByTeeth_PatientID_TeethNum_Date(patientID, teethNum, treatmentDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.info("No Such Data!");
			e.printStackTrace();
			List<TreatmentHistory> EmptyList = new ArrayList<>();
			return EmptyList;
		}
	}

	public TreatmentHistory getPatientTreatmentByTreatmentID(long TreatmentID) {
		try {
			return treatmentHistoryPersistence.findByPrimaryKey(TreatmentID);
		} catch (Exception e) {
			return null;
		}
	}

	public TreatmentHistory getPatientTreatmentByAll(long patientID, long teethNum, Date treatmentDate,
			String treatment) {
		try {
			return treatmentHistoryPersistence.findByTeeth_PatientID_TeethNum_Date_Treatment(patientID, teethNum,
					treatmentDate, treatment);
		} catch (Exception e) {
			_log.info("Error Occured Or No Duplication!");
			return null;
		}
	}

	Log _log = LogFactoryUtil.getLog(TreatmentHistoryLocalServiceImpl.class);

}