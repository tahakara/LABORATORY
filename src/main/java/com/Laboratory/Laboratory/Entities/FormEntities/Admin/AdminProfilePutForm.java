package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminProfilePutForm {
    private String adminName;
    private String adminSurname;
    private String adminEmail;
    private String adminPassword;
    private String adminUUID;

    // Internal Fields
    private Boolean isAcceptable;

    private String queryAdminName;
    private String queryAdminSurname;
    private String queryAdminEmail;
    private String queryAdminPassword;
    private String queryAdminUUID;


    public AdminProfilePutForm(String adminName, String adminSurname, String adminEmail, String adminPassword, String adminUUID) {
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminUUID = adminUUID;
    }

    public AdminProfilePutForm() {
    }

    public void checkValues() {
        this.queryAdminName = (this.adminName != null && this.adminName.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.adminName.toLowerCase() : null;
        this.queryAdminSurname = (this.adminSurname != null && this.adminSurname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.adminSurname.toLowerCase() : null;
        this.queryAdminEmail = (this.adminEmail != null && this.adminEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) ? this.adminEmail : null;
        this.queryAdminPassword = (this.adminPassword != null && this.adminPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) ? this.adminPassword : null;
        this.queryAdminUUID = (this.adminUUID != null && this.adminUUID.matches("^[0-9A-Z]{1,7}$")) ? this.adminUUID : null;
    }

    public void setQueryValues() {
        checkValues();
        if (this.adminName != null && this.adminSurname != null && this.adminEmail != null && this.adminPassword != null && this.adminUUID != null) {
            this.isAcceptable = true;
        } else {
            this.isAcceptable = false;
        }
    }

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminSurname() {
		return adminSurname;
	}

	public void setAdminSurname(String adminSurname) {
		this.adminSurname = adminSurname;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminUUID() {
		return adminUUID;
	}

	public void setAdminUUID(String adminUUID) {
		this.adminUUID = adminUUID;
	}

	public Boolean getIsAcceptable() {
		return isAcceptable;
	}

	public void setIsAcceptable(Boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}

	public String getQueryAdminName() {
		return queryAdminName;
	}

	public void setQueryAdminName(String queryAdminName) {
		this.queryAdminName = queryAdminName;
	}

	public String getQueryAdminSurname() {
		return queryAdminSurname;
	}

	public void setQueryAdminSurname(String queryAdminSurname) {
		this.queryAdminSurname = queryAdminSurname;
	}

	public String getQueryAdminEmail() {
		return queryAdminEmail;
	}

	public void setQueryAdminEmail(String queryAdminEmail) {
		this.queryAdminEmail = queryAdminEmail;
	}

	public String getQueryAdminPassword() {
		return queryAdminPassword;
	}

	public void setQueryAdminPassword(String queryAdminPassword) {
		this.queryAdminPassword = queryAdminPassword;
	}

	public String getQueryAdminUUID() {
		return queryAdminUUID;
	}

	public void setQueryAdminUUID(String queryAdminUUID) {
		this.queryAdminUUID = queryAdminUUID;
	}


    
}
