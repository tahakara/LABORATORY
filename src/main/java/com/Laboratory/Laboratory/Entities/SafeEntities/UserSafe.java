package com.Laboratory.Laboratory.Entities.SafeEntities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserSafe {

    @Column(name = "user_identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_surname", nullable = false)
    private String surname;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_is_verified", nullable = false)
    private Boolean isVerified = false;

    @Id
    @Column(name = "user_uuid", unique = true, nullable = false)
    private String uuid;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    // Constructors
    public UserSafe(String identificationNumber, String name, String surname, String email, Boolean isVerified, String uuid, Timestamp createdAt, Timestamp updatedAt) {
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
    public UserSafe() {
    }

    public void maskIdentificationNumber() {
        String identificationNumber = this.identificationNumber;
        if (identificationNumber != null && identificationNumber.length() > 6) {
            this.identificationNumber = identificationNumber.substring(0, 2) +
                   identificationNumber.substring(2, identificationNumber.length() - 4).replaceAll(".", "*") +
                   identificationNumber.substring(identificationNumber.length() - 4);
        }
    }

    public void maskEmail() {
        String email = this.email;
        if (email != null && email.length() > 6) {
            int atIndex = email.indexOf('@');

            if (atIndex > 2) { 
                String maskedPrefix = email.substring(0, 2) + "****"; 
                String domain = email.substring(atIndex); 
                this.email = maskedPrefix + domain; 
            }
        }
    }

    public void maskName() {
        String name = this.name;
        if (name != null && name.length() > 2) {
            this.name = name.substring(0, 2) + "**";
        }
    }

    public void maskSurname() {
        String surname = this.surname;
        if (surname != null && surname.length() > 2) {
            this.surname = surname.substring(0, 2) + "**";
        }
    }

    public void maskNameAndSurname() {
        maskName();
        maskSurname();
    }

    public void maskIdentificationNumberAndSurname() {
        maskIdentificationNumber();
        maskSurname();
    }

    public void maskIdentificationNumberAndEmail() {
        maskIdentificationNumber();
        maskEmail();
    }

    public void maskIdentificationNumberAndEmailAndSurname() {
        maskIdentificationNumber();
        maskEmail();
        maskSurname();
    }

    public void maskAll() {
        maskIdentificationNumber();
        maskEmail();
        maskName();
        maskSurname();
    }

    //Region Getters and setters

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

    // IsVerified
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
    
    //EndRegion Getters and setters
    
}
