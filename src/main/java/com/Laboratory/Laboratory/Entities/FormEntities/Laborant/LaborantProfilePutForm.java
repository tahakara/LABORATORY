package com.Laboratory.Laboratory.Entities.FormEntities.Laborant;

public class LaborantProfilePutForm {
    private String laborantName;
    private String laborantSurname;
    private String laborantEmail;
    private String laborantPassword;
    private String laborantUUID;

    // Internal Fields
    private Boolean isAcceptable;

    private String queryLaborantName;
    private String queryLaborantSurname;
    private String queryLaborantEmail;
    private String queryLaborantPassword;
    private String queryLaborantUUID;

    public LaborantProfilePutForm(String laborantName, String laborantSurname, String laborantEmail, String laborantPassword, String laborantUUID) {
        this.laborantName = laborantName;
        this.laborantSurname = laborantSurname;
        this.laborantEmail = laborantEmail;
        this.laborantPassword = laborantPassword;
        this.laborantUUID = laborantUUID;
    }

    public LaborantProfilePutForm() {
    }

    public void checkValues() {
        this.queryLaborantName = (this.laborantName != null && this.laborantName.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantName.toLowerCase() : null;
        this.queryLaborantSurname = (this.laborantSurname != null && this.laborantSurname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantSurname.toLowerCase() : null;
        this.queryLaborantEmail = (this.laborantEmail != null && this.laborantEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) ? this.laborantEmail : null;
        this.queryLaborantPassword = (this.laborantPassword != null && this.laborantPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) ? this.laborantPassword : null;
        this.queryLaborantUUID = (this.laborantUUID != null && this.laborantUUID.matches("^[0-9A-Z]{1,7}$")) ? this.laborantUUID : null;
    }

    public void setQueryValues() {
        checkValues();
        if (this.laborantName != null && this.laborantSurname != null && this.laborantEmail != null && this.laborantPassword != null && this.laborantUUID != null) {
            this.isAcceptable = true;
        } else {
            this.isAcceptable = false;
        }
    }

    public String getLaborantName() {
        return laborantName;
    }

    public void setLaborantName(String laborantName) {
        this.laborantName = laborantName;
    }

    public String getLaborantSurname() {
        return laborantSurname;
    }

    public void setLaborantSurname(String laborantSurname) {
        this.laborantSurname = laborantSurname;
    }

    public String getLaborantEmail() {
        return laborantEmail;
    }

    public void setLaborantEmail(String laborantEmail) {
        this.laborantEmail = laborantEmail;
    }

    public String getLaborantPassword() {
        return laborantPassword;
    }

    public void setLaborantPassword(String laborantPassword) {
        this.laborantPassword = laborantPassword;
    }

    public String getLaborantUUID() {
        return laborantUUID;
    }

    public void setLaborantUUID(String laborantUUID) {
        this.laborantUUID = laborantUUID;
    }

    public Boolean getIsAcceptable() {
        return isAcceptable;
    }

    public void setIsAcceptable(Boolean isAcceptable) {
        this.isAcceptable = isAcceptable;
    }

    public String getQueryLaborantName() {
        return queryLaborantName;
    }

    public void setQueryLaborantName(String queryLaborantName) {
        this.queryLaborantName = queryLaborantName;
    }

    public String getQueryLaborantSurname() {
        return queryLaborantSurname;
    }

    public void setQueryLaborantSurname(String queryLaborantSurname) {
        this.queryLaborantSurname = queryLaborantSurname;
    }

    public String getQueryLaborantEmail() {
        return queryLaborantEmail;
    }

    public void setQueryLaborantEmail(String queryLaborantEmail) {
        this.queryLaborantEmail = queryLaborantEmail;
    }

    public String getQueryLaborantPassword() {
        return queryLaborantPassword;
    }

    public void setQueryLaborantPassword(String queryLaborantPassword) {
        this.queryLaborantPassword = queryLaborantPassword;
    }

    public String getQueryLaborantUUID() {
        return queryLaborantUUID;
    }

    public void setQueryLaborantUUID(String queryLaborantUUID) {
        this.queryLaborantUUID = queryLaborantUUID;
    }

    
}
