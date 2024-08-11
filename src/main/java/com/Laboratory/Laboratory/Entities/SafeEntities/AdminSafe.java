package com.Laboratory.Laboratory.Entities.SafeEntities;

import java.sql.Timestamp;
import jakarta.persistence.*;

// import com.Laboratory.Laboratory.Entities.Admin;
@Entity
@Table(name = "admins")
public class AdminSafe {

    

    @Column(name = "admin_hospital_id")
    private String hospitalId;

    @Column(name = "admin_identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "admin_name", nullable = false)
    private String name;

    @Column(name = "admin_surname", nullable = false)
    private String surname;

    @Column(name = "admin_email", nullable = false)
    private String email;

    @Column(name = "admin_is_verified", nullable = false)
    private Boolean isVerified = false;
    
    @Id
    @Column(name = "admin_uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;


    public AdminSafe(String hospitalId, String identificationNumber, String name, String surname, String email, Boolean isVerified, String uuid, Timestamp createdAt, Timestamp updatedAt) {
        this.hospitalId = hospitalId;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.isVerified = isVerified;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    // Default constructor
    public AdminSafe() {
    }

    public void maskIdentificationNumber() {
        String identificationNumber = this.identificationNumber;
        if (identificationNumber != null && identificationNumber.length() > 6) {
            this.identificationNumber = identificationNumber.substring(0, 2) +
                   identificationNumber.substring(2, identificationNumber.length() - 4).replaceAll(".", "*") +
                   identificationNumber.substring(identificationNumber.length() - 4);
        }
    }


    

    // Hospital ID
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    // Identification Number
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

    // Is Verified
    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    // UUID
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // Created At
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // Updated At
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    


}
