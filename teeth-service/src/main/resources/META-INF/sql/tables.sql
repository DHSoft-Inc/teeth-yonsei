create table treatment_audit (
	AuditID LONG not null primary key,
	teethNum LONG,
	editedDate DATE null,
	editedUserID LONG,
	editType VARCHAR(75) null,
	treatmentDate DATE null,
	beforeData VARCHAR(75) null,
	afterData VARCHAR(75) null
);

create table treatment_history (
	treatmentID LONG not null primary key,
	patientID LONG,
	editedUserID LONG,
	teethNum LONG,
	treatmentDate DATE null,
	editedDate DATE null,
	treatment VARCHAR(75) null,
	state_ VARCHAR(75) null
);