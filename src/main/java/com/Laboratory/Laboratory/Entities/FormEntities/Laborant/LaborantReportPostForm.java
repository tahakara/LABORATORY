package com.Laboratory.Laboratory.Entities.FormEntities.Laborant;

import java.time.Year;

public class LaborantReportPostForm {

    private String patientUUID;
    private String laborantUUID;

    private String reportNumber;
    private String patientName;
    private String patientSurname;
    private String patientIdentificationNumber;
    private String patientBirthYear;
    private String patientBirthMonth;
    private String patientBirthDay;

    private String DiagnoseTitle;
    private String DiagnoseDescription;

    private String ReportPhoto;

    // Internal fields
    private Boolean isAcceptable;


    // constructor
    public LaborantReportPostForm(String patientUUID, String laborantUUID, String reportNumber, String patientName, String patientSurname, String patientIdentificationNumber, String patientBirthYear, String patientBirthMonth, String patientBirthDay, String diagnoseTitle, String diagnoseDescription, String reportPhoto) {
        this.patientUUID = patientUUID;
        this.laborantUUID = laborantUUID;
        this.reportNumber = reportNumber;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientIdentificationNumber = patientIdentificationNumber;
        this.patientBirthYear = patientBirthYear;
        this.patientBirthMonth = patientBirthMonth;
        this.patientBirthDay = patientBirthDay;
        this.DiagnoseTitle = diagnoseTitle;
        this.DiagnoseDescription = diagnoseDescription;
        this.ReportPhoto = reportPhoto;
    }

    public void checkValues() {
        this.patientUUID = (this.patientUUID != null && this.patientUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.patientUUID : null;
        this.laborantUUID = (this.laborantUUID != null && this.laborantUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.laborantUUID : null;
        this.reportNumber = (this.reportNumber != null && this.reportNumber.length() > 0) ? this.reportNumber : null;
        this.patientName = (this.patientName != null && this.patientName.length() > 0 && this.patientName.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.patientName : null;
        this.patientSurname = (this.patientSurname != null && this.patientSurname.length() > 0 && this.patientSurname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.patientSurname : null;
        this.patientIdentificationNumber = (this.patientIdentificationNumber != null && this.patientIdentificationNumber.length() > 0 && this.patientIdentificationNumber.matches("^[1-9][0-9]{10}$")) ? this.patientIdentificationNumber : null;
        this.patientBirthYear = (this.patientBirthYear != null && this.patientBirthYear.length() > 0) ? this.patientBirthYear : null;
        this.patientBirthMonth = (this.patientBirthMonth != null && this.patientBirthMonth.length() > 0) ? this.patientBirthMonth : null;
        this.patientBirthDay = (this.patientBirthDay != null && this.patientBirthDay.length() > 0) ? this.patientBirthDay : null;
        this.DiagnoseTitle = (this.DiagnoseTitle != null && this.DiagnoseTitle.length() > 0 && this.DiagnoseTitle.length() <= 255) ? this.DiagnoseTitle : null;
        this.DiagnoseDescription = (this.DiagnoseDescription != null && this.DiagnoseDescription.length() > 0) ? this.DiagnoseDescription : null;
        this.ReportPhoto = (this.ReportPhoto != null && this.ReportPhoto.length() > 0) ? this.ReportPhoto : null;
    }

    public void setQueryValues() {
        checkValues();
        if (this.reportNumber == null || this.patientName == null || this.patientSurname == null || this.patientIdentificationNumber == null || this.patientBirthYear == null || this.patientBirthMonth == null || this.patientBirthDay == null || this.DiagnoseTitle == null || this.DiagnoseDescription == null || this.ReportPhoto == null) {
            this.isAcceptable = false;
        } else {
            this.isAcceptable = true;
        }
    }

    public void checkMonth() {
        Integer temp = Integer.parseInt(this.patientBirthMonth);
        if (temp < 1 || temp > 12) {
            this.patientBirthMonth = null;
        }
    }

    public void checkDay() {
        Integer temp = Integer.parseInt(this.patientBirthDay);
        if (temp < 1 || temp > 31) {
            this.patientBirthDay = null;
        }
    }

    public void checkYear() {
        Integer temp = Integer.parseInt(this.patientBirthYear);
        if (temp < 1900 || temp > (Year.now().getValue())){
            this.patientBirthYear = null;
        }
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

    public String getLaborantUUID() {
        return laborantUUID;
    }

    public void setLaborantUUID(String laborantUUID) {
        this.laborantUUID = laborantUUID;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientIdentificationNumber() {
        return patientIdentificationNumber;
    }

    public void setPatientIdentificationNumber(String patientIdentificationNumber) {
        this.patientIdentificationNumber = patientIdentificationNumber;
    }

    public String getPatientBirthYear() {
        return patientBirthYear;
    }

    public void setPatientBirthYear(String patientBirthYear) {
        this.patientBirthYear = patientBirthYear;
    }

    public String getPatientBirthMonth() {
        return patientBirthMonth;
    }

    public void setPatientBirthMonth(String patientBirthMonth) {
        this.patientBirthMonth = patientBirthMonth;
    }

    public String getPatientBirthDay() {
        return patientBirthDay;
    }

    public void setPatientBirthDay(String patientBirthDay) {
        this.patientBirthDay = patientBirthDay;
    }

    public String getDiagnoseTitle() {
        return DiagnoseTitle;
    }

    public void setDiagnoseTitle(String diagnoseTitle) {
        DiagnoseTitle = diagnoseTitle;
    }

    public String getDiagnoseDescription() {
        return DiagnoseDescription;
    }

    public void setDiagnoseDescription(String diagnoseDescription) {
        DiagnoseDescription = diagnoseDescription;
    }

    public String getReportPhoto() {
        return ReportPhoto;
    }

    public void setReportPhoto(String reportPhoto) {
        ReportPhoto = reportPhoto;
    }

    public Boolean getIsAcceptable() {
        return isAcceptable;
    }

    public void setIsAcceptable(Boolean isAcceptable) {
        this.isAcceptable = isAcceptable;
    }

    

}
