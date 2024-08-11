package com.Laboratory.Laboratory.Entities.SafeEntities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "laborants")
public class LaborantSafe {

    @Column(name = "laborant_hospital_id", nullable = false)
    private String hospitalId;

    @Column(name = "laborant_identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "laborant_name", nullable = false)
    private String name;

    @Column(name = "laborant_surname", nullable = false)
    private String surname;

    @Column(name = "laborant_email", nullable = false)
    private String email;

    @Column(name = "laborant_is_verified", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "laborant_is_active_work", nullable = false)
    private Boolean isActiveWork = false;

    @Id
    @Column(name = "laborant_uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    // Constructor
    public LaborantSafe(String hospitalId, String identificationNumber, String name, String surname, String email, Boolean isVerified, Boolean isActiveWork, String uuid, Timestamp createdAt, Timestamp updatedAt) {
        this.hospitalId = hospitalId;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isVerified = isVerified;
        this.isActiveWork = isActiveWork;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default constructor
    public LaborantSafe() {
    }
 
    public void maskIdentificationNumber() {
        String identificationNumber = this.identificationNumber;
        if (identificationNumber != null && identificationNumber.length() > 6) {
            this.identificationNumber = identificationNumber.substring(0, 2) +
                   identificationNumber.substring(2, identificationNumber.length() - 4).replaceAll(".", "*") +
                   identificationNumber.substring(identificationNumber.length() - 4);
        }
    }

    // Getters and setters

    // HospitalId
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    // IdentificationNumber
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // IsVerified
    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    // IsActiveWork
    public Boolean getIsActiveWork() {
        return isActiveWork;
    }

    public void setIsActiveWork(Boolean isActiveWork) {
        this.isActiveWork = isActiveWork;
    }

    // UUID
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // CreatedAt
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // UpdatedAt
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    
}
