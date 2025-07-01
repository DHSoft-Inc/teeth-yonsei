create index IX_206851F2 on treatment_audit (editType[$COLUMN_LENGTH:75$]);
create index IX_EE36A4B6 on treatment_audit (groupId, status);
create index IX_A2B0C100 on treatment_audit (status);
create index IX_853B0BEC on treatment_audit (teethNum);
create index IX_766CAB8E on treatment_audit (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BEA6BD90 on treatment_audit (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8D86699D on treatment_history (groupId, status);
create index IX_1C27CA1 on treatment_history (patientID, teethNum, treatmentDate, treatment[$COLUMN_LENGTH:75$]);
create index IX_65013579 on treatment_history (patientID, treatmentDate);
create index IX_322F8C39 on treatment_history (status);
create index IX_C1158387 on treatment_history (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_37673FC9 on treatment_history (uuid_[$COLUMN_LENGTH:75$], groupId);