package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminLaborantDeleteForm {

    private String laborantUUID;

    // Internal Fields
    private Boolean isAcceptable;
    private String queryLaborantUUID;

    public AdminLaborantDeleteForm(String laborantUUID) {
        this.laborantUUID = laborantUUID;
    }

    public AdminLaborantDeleteForm() {
    }

    public void checkValues() {
        this.queryLaborantUUID = (this.laborantUUID != null && this.laborantUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ? this.laborantUUID : null;
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

	public Boolean getIsAcceptable() {
		return isAcceptable;
	}

	public void setIsAcceptable(Boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}

	public String getQueryLaborantUUID() {
		return queryLaborantUUID;
	}

	public void setQueryLaborantUUID(String queryLaborantUUID) {
		this.queryLaborantUUID = queryLaborantUUID;
	}


    
}
