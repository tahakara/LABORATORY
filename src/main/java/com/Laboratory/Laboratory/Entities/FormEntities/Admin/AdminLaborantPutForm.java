package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminLaborantPutForm {
    
        private String laborantUUID;
        private String laborantName;
        private String laborantSurname;
        private String laborantEmail;
        private String laborantHospitalId;
        private String laborantIdentificationNumber;
        private Boolean laborantIsActiveWork;
    
        // Internal Fields
        private String queryLaborantUUID;
        private String queryLaborantName;
        private String queryLaborantSurname;
        private String queryLaborantEmail;
        private String queryLaborantHospitalId;
        private String queryLaborantIdentificationNumber;
        private Boolean queryLaborantIsActiveWork;

        private Boolean isAcceptable;
    
        public AdminLaborantPutForm(String laborantUUID, String laborantName, String laborantSurname, String laborantEmail, String laborantHospitalId, String laborantIdentificationNumber, Boolean laborantIsActiveWork) {
            this.laborantUUID = laborantUUID;
            this.laborantName = laborantName;
            this.laborantSurname = laborantSurname;
            this.laborantEmail = laborantEmail;
            this.laborantHospitalId = laborantHospitalId;
            this.laborantIdentificationNumber = laborantIdentificationNumber;
            this.laborantIsActiveWork = laborantIsActiveWork;
        }

        //Default Constructor
        public AdminLaborantPutForm() {
        }
    
        public void checkValues() {
            this.queryLaborantUUID = (this.laborantUUID != null && this.laborantUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ? this.laborantUUID : null;
            this.queryLaborantName = (this.laborantName != null && this.laborantName.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantName : null;
            this.queryLaborantSurname = (this.laborantSurname != null && this.laborantSurname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.laborantSurname : null;
            this.queryLaborantEmail = (this.laborantEmail != null && this.laborantEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) ? this.laborantEmail : null;
            this.queryLaborantHospitalId = (this.laborantHospitalId != null && this.laborantHospitalId.matches("^[0-9A-Z]{1,7}$")) ? this.laborantHospitalId : null;
            this.queryLaborantIdentificationNumber = (this.laborantIdentificationNumber != null && this.laborantIdentificationNumber.matches("^[1-9][0-9]{10}$")) ? this.laborantIdentificationNumber : null;
            this.queryLaborantIsActiveWork = this.laborantIsActiveWork;
        }

        public void setQueryValues() {
            checkValues();
            if (this.queryLaborantUUID != null) {
                this.isAcceptable = true;
            } else {
                this.isAcceptable = false;
            }
        }

		public String getLaborantUUID() {
			return laborantUUID;
		}

		public void setLaborantUUID(String laborantUUID) {
			this.laborantUUID = laborantUUID;
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

		public String getLaborantHospitalId() {
			return laborantHospitalId;
		}

		public void setLaborantHospitalId(String laborantHospitalId) {
			this.laborantHospitalId = laborantHospitalId;
		}

		public String getLaborantIdentificationNumber() {
			return laborantIdentificationNumber;
		}

		public void setLaborantIdentificationNumber(String laborantIdentificationNumber) {
			this.laborantIdentificationNumber = laborantIdentificationNumber;
		}

		public Boolean getLaborantIsActiveWork() {
			return laborantIsActiveWork;
		}

		public void setLaborantIsActiveWork(Boolean laborantIsActiveWork) {
			this.laborantIsActiveWork = laborantIsActiveWork;
		}

		public String getQueryLaborantUUID() {
			return queryLaborantUUID;
		}

		public void setQueryLaborantUUID(String queryLaborantUUID) {
			this.queryLaborantUUID = queryLaborantUUID;
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

		public String getQueryLaborantHospitalId() {
			return queryLaborantHospitalId;
		}

		public void setQueryLaborantHospitalId(String queryLaborantHospitalId) {
			this.queryLaborantHospitalId = queryLaborantHospitalId;
		}

		public String getQueryLaborantIdentificationNumber() {
			return queryLaborantIdentificationNumber;
		}

		public void setQueryLaborantIdentificationNumber(String queryLaborantIdentificationNumber) {
			this.queryLaborantIdentificationNumber = queryLaborantIdentificationNumber;
		}

		public Boolean getQueryLaborantIsActiveWork() {
			return queryLaborantIsActiveWork;
		}

		public void setQueryLaborantIsActiveWork(Boolean queryLaborantIsActiveWork) {
			this.queryLaborantIsActiveWork = queryLaborantIsActiveWork;
		}

		public Boolean getIsAcceptable() {
			return isAcceptable;
		}

		public void setIsAcceptable(Boolean isAcceptable) {
			this.isAcceptable = isAcceptable;
		}

        
}
