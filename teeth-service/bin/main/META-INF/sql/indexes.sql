create index IX_206851F2 on treatment_audit (editType[$COLUMN_LENGTH:75$]);
create index IX_853B0BEC on treatment_audit (teethNum);

create index IX_1C27CA1 on treatment_history (patientID, teethNum, treatmentDate, treatment[$COLUMN_LENGTH:75$]);
create index IX_65013579 on treatment_history (patientID, treatmentDate);