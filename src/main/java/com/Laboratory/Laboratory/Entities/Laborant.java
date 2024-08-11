package com.Laboratory.Laboratory.Entities;

import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.*;

@Entity
@Table(name = "laborants")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laborant_id")
    private Long id;

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

    @Column(name = "laborant_password", nullable = true)
    private String password;

    @Column(name = "laborant_verification_code", nullable = true)
    private String verificationCode;

    @Column(name = "laborant_is_verified", nullable = true)
    private Boolean isVerified = false;

    @Column(name = "laborant_is_active_work", nullable = true)
    private Boolean isActiveWork = false;

    @Column(name = "laborant_uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;


    // Constructor
    public Laborant(Long id, String hospitalId, String identificationNumber, String name, String surname, String email, String password, String verificationCode, Boolean isVerified, Boolean isActiveWork, String uuid, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.hospitalId = hospitalId;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.verificationCode = verificationCode;
        this.isVerified = isVerified;
        this.isActiveWork = isActiveWork;
        this.uuid = uuid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default constructor
    public Laborant() {
    }

    public void maskAll() {
        maskIdentificationNumber();
        maskName();
        maskSurname();
        this.email = null;
        this.password = null;
        this.verificationCode = null;
        this.isVerified = false;
        this.isActiveWork = false;

    }

    public void maskName() {
        String name = this.name;
        if (name != null && name.length() > 2) {
            this.name = name.substring(0, 2) + name.substring(2).replaceAll(".", "*");
        }
    }

    public void maskSurname() {
        String surname = this.surname;
        if (surname != null && surname.length() > 2) {
            this.surname = surname.substring(0, 2) + surname.substring(2).replaceAll(".", "*");
        }
    }

    public void maskIdentificationNumber() {
        String identificationNumber = this.identificationNumber;
        if (identificationNumber != null && identificationNumber.length() > 6) {
            this.identificationNumber = identificationNumber.substring(0, 2) +
                   identificationNumber.substring(2, identificationNumber.length() - 4).replaceAll(".", "*") +
                   identificationNumber.substring(identificationNumber.length() - 4);
        }
    }

    public static String hashWithSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(input.getBytes());

            String hashedString = new String(Hex.encode(hashBytes));

            return hashedString;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algorithm not found: " + e.getMessage());
            return null;
        }
    }

    public void generateVerificationCode() {
        this.verificationCode = hashWithSHA256(
            this.name + hashWithSHA256(
                this.surname + hashWithSHA256(
                    this.identificationNumber + hashWithSHA256(
                        this.hospitalId + hashWithSHA256(
                            this.email + hashWithSHA256(this.identificationNumber)
                        )
                    )
                )
            )
        );
    }

    public void generateDummyPassword() {
        Random random = new Random();
        this.password = hashWithSHA256(
            this.email + hashWithSHA256(
                this.hospitalId + hashWithSHA256(
                    this.email + hashWithSHA256(
                        this.identificationNumber + hashWithSHA256(
                            Integer.toString(random.nextInt(101)) 
                        )
                    )
                )
            )
        );
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

    // isActiveWork
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