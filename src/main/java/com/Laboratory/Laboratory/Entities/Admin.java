package com.Laboratory.Laboratory.Entities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_hospital_id")
    private String hospitalId;

    @Column(name = "admin_identification_number", nullable = false, unique = true)
    private String identificationNumber;

    @Column(name = "admin_name", nullable = false)
    private String name;

    @Column(name = "admin_surname", nullable = false)
    private String surname;

    @Column(name = "admin_email", nullable = false)
    private String email;

    @Column(name = "admin_password", nullable = false)
    private String password;

    @Column(name = "admin_verification_code")
    private String verificationCode;

    @Column(name = "admin_is_verified", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "admin_uuid", nullable = false, unique = true)
    private String uuid;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    // Constructor
    public Admin(Long id, String hospitalId, String identificationNumber, String name, String surname, String email, String password, String verificationCode, Boolean isVerified, String uuid, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.hospitalId = hospitalId;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.isVerified = isVerified;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default constructor
    public Admin() {
    }
    
    // Getter and setter methods
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Verification Code
    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    // isVerified
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
