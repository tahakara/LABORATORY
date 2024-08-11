package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

import java.util.regex.Pattern;

public class AdminLoginPostForm {
    private Boolean identificationAndPassword;
    private Boolean hospitalIdAndPassword;
    private Boolean emailAndPassword;

    private Boolean isAcceptable;

    private String identificationNumber;
    private String hospitalId;
    private String email;
    private String password;

    public AdminLoginPostForm(String identificationNumber, String email, String hospitalId, String password) {
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.hospitalId = hospitalId;
        this.password = password;
        
        trimAll();
        checkValues();     
        regexCheck();
        isAcceptable();   
    }

    public void trimAll() {
        this.identificationNumber = this.identificationNumber == null ? null : this.identificationNumber;
        this.email = this.email == null ? null : this.email;
        this.hospitalId = this.hospitalId == null ? null : this.hospitalId;
        this.password = this.password == null ? null : this.password;
    }

    public void checkValues() {
        this.identificationAndPassword = this.identificationNumber != null ? this.identificationNumber.length() == 11 : false;
        this.hospitalIdAndPassword = this.hospitalId != null ? this.hospitalId.length() == 7 : false;
        this.emailAndPassword  = this.email != null ? (this.email.contains("@") && this.email.contains(".")) : false;
    }

    public void regexCheck() {
        if ((this.identificationNumber != null ) && (!Pattern.matches("^[1-9][0-9]{10}$", this.identificationNumber))) {
            this.hospitalIdAndPassword = false;
        }
        if ((this.hospitalId != null ) && (!Pattern.matches("^[0-9A-Z]{1,7}$\"", this.hospitalId))) {
            this.hospitalIdAndPassword = false;
        }
        if ((this.email != null ) && (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$", this.email))) {
            this.emailAndPassword = false;
        }
        
    }

    public void isAcceptable() {
        this.isAcceptable = (this.identificationAndPassword && !this.hospitalIdAndPassword && !this.emailAndPassword) ||
                    (!this.identificationAndPassword && this.hospitalIdAndPassword && !this.emailAndPassword) ||
                    (!this.identificationAndPassword && !this.hospitalIdAndPassword && this.emailAndPassword);

    }

    public Boolean getIdentificationAndPassword() {
        return identificationAndPassword;
    }

    public Boolean getHospitalIdAndPassword() {
        return hospitalIdAndPassword;
    }
    public Boolean getEmailAndPassword() {
        return emailAndPassword;
    }

    public Boolean getIsAcceptable() {
        return isAcceptable;
    }


    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    

    
}
