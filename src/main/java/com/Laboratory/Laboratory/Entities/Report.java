package com.Laboratory.Laboratory.Entities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @Column(name = "report_number", nullable = false)
    private String reportNumber;

    @Column(name = "report_patient_name", nullable = false)
    private String patientName;
    
    @Column(name = "report_patient_surname", nullable = false)
    private String patientSurname;
    
    @Column(name = "report_patient_birth_day", nullable = false)
    private String patientBirthDay;
    
    @Column(name = "report_patient_birth_month", nullable = false)
    private String patientBirthMonth;

    @Column(name = "report_patient_birth_year", nullable = false)
    private String patientBirthYear;

    @Column(name = "report_patient_identification_number", nullable = false)
    private String patientIdentificationNumber;

    @Column(name = "report_patient_uuid", nullable = true)
    private String patientUUID;

    @Column(name = "report_laborant_uuid", nullable = false)
    private String laborantUUID;

    @Column(name = "report_diagnose_title", nullable = false)
    private String diagnoseTitle;

    @Column(name = "report_diagnose_content", columnDefinition = "TEXT", nullable = false)
    private String diagnoseContent;

    @Column(name = "report_photo_url", columnDefinition = "TEXT", nullable = false)
    private String photoUrl;

    @Column(name = "report_is_visible", nullable = false)
    private Boolean isVisible = true;

    @Column(name = "report_uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    // Constructor
    public Report(Long id, String reportNumber, String patientName, String patientSurname, String patientBirthDay, String patientBirthMonth, String patientBirthYear, String patientIdentificationNumber, String patientUUID, String laborantUUID, String diagnoseTitle, String diagnoseContent, String photoUrl, Boolean isVisible, String uuid, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.reportNumber = reportNumber;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientBirthDay = patientBirthDay;
        this.patientBirthMonth = patientBirthMonth;
        this.patientBirthYear = patientBirthYear;
        this.patientIdentificationNumber = patientIdentificationNumber;
        this.patientUUID = patientUUID;
        this.laborantUUID = laborantUUID;
        this.diagnoseTitle = diagnoseTitle;
        this.diagnoseContent = diagnoseContent;
        this.photoUrl = photoUrl;
        this.isVisible = isVisible;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    

    // Default constructor
    public Report() {
    }
    

    public void maskIdentificationNumber() {
        if (this.patientIdentificationNumber.length() > 6) {
            this.patientIdentificationNumber = this.patientIdentificationNumber.substring(0, 2) + "******" + this.patientIdentificationNumber.substring(this.patientIdentificationNumber.length() - 4);
        } else {
            this.patientIdentificationNumber = "********";
        }
    }

    // Getter and setter methods
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Report Number
    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    // Patient Name
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Patient Surname
    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    // Patient Birth Day
    public String getPatientBirthDay() {
        return patientBirthDay;
    }

    public void setPatientBirthDay(String patientBirthDay) {
        this.patientBirthDay = patientBirthDay;
    }

    // Patient Birth Month
    public String getPatientBirthMonth() {
        return patientBirthMonth;
    }

    public void setPatientBirthMonth(String patientBirthMonth) {
        this.patientBirthMonth = patientBirthMonth;
    }

    // Patient Birth Year
    public String getPatientBirthYear() {
        return patientBirthYear;
    }

    public void setPatientBirthYear(String patientBirthYear) {
        this.patientBirthYear = patientBirthYear;
    }


    // Patient Identification Number
    public String getPatientIdentificationNumber() {
        return patientIdentificationNumber;
    }

    public void setPatientIdentificationNumber(String patientIdentificationNumber) {
        this.patientIdentificationNumber = patientIdentificationNumber;
    }

    // Patient UUID
    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

    // Laborant UUID
    public String getLaborantUUID() {
        return laborantUUID;
    }
    
    public void setLaborantUUID(String laborantUUID) {
        this.laborantUUID = laborantUUID;
    }

    // Diagnose Title
    public String getDiagnoseTitle() {
        return diagnoseTitle;
    }

    public void setDiagnoseTitle(String diagnoseTitle) {
        this.diagnoseTitle = diagnoseTitle;
    }

    // Diagnose Content
    public String getDiagnoseContent() {
        return diagnoseContent;
    }

    public void setDiagnoseContent(String diagnoseContent) {
        this.diagnoseContent = diagnoseContent;
    }

    // Photo URL
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    // isVisible
    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    // UUID
    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    // createdAt
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // updatedAt
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}