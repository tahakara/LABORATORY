package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminLaborantPostForm {
    String laborantName;
    String laborantSurname;
    String laborantIdentificationNumber;
    String laborantHospitalID;
    String laborantEmail;
    Boolean laborantIsActiveWork;

    // Internal Fields
    Boolean isAcceptable;


    public AdminLaborantPostForm(String laborantName, String laborantSurname, String laborantIdentificationNumber, String laborantHospitalID, String laborantEmail, Boolean laborantIsActiveWork) {
        this.laborantName = laborantName;
        this.laborantSurname = laborantSurname;
        this.laborantIdentificationNumber = laborantIdentificationNumber;
        this.laborantHospitalID = laborantHospitalID;
        this.laborantEmail = laborantEmail;
        this.laborantIsActiveWork = laborantIsActiveWork;
    }

    public AdminLaborantPostForm() {
    }

    public void checkValues() {
        this.laborantName = (this.laborantName != null && this.laborantName.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantName.toLowerCase() : null;
        this.laborantSurname = (this.laborantSurname != null && this.laborantSurname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantSurname.toLowerCase() : null;
        this.laborantIdentificationNumber = (this.laborantIdentificationNumber != null && this.laborantIdentificationNumber.matches("^[1-9][0-9]{10}$")) ? this.laborantIdentificationNumber : null;
        this.laborantHospitalID = (this.laborantHospitalID != null && this.laborantHospitalID.matches("^[0-9A-Z]{1,7}$")) ? this.laborantHospitalID : null;
        this.laborantEmail = (this.laborantEmail != null && this.laborantEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) ? this.laborantEmail : null;
        this.laborantIsActiveWork = this.laborantIsActiveWork !=null ? this.laborantIsActiveWork : false;
    }

    public void setQueryValues() {
        checkValues();
        if (this.laborantName != null && this.laborantSurname != null && this.laborantIdentificationNumber != null && this.laborantHospitalID != null && this.laborantEmail != null) {
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

	public String getLaborantIdentificationNumber() {
		return laborantIdentificationNumber;
	}

	public void setLaborantIdentificationNumber(String laborantIdentificationNumber) {
		this.laborantIdentificationNumber = laborantIdentificationNumber;
	}

	public String getLaborantHospitalID() {
		return laborantHospitalID;
	}

	public void setLaborantHospitalID(String laborantHospitalID) {
		this.laborantHospitalID = laborantHospitalID;
	}

	public String getLaborantEmail() {
		return laborantEmail;
	}

	public void setLaborantEmail(String laborantEmail) {
		this.laborantEmail = laborantEmail;
	}

	public Boolean getLaborantIsActiveWork() {
		return laborantIsActiveWork;
	}

	public void setLaborantIsActiveWork(Boolean laborantIsActiveWork) {
		this.laborantIsActiveWork = laborantIsActiveWork;
	}

	public Boolean getIsAcceptable() {
		return isAcceptable;
	}

	public void setIsAcceptable(Boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}

    
}
