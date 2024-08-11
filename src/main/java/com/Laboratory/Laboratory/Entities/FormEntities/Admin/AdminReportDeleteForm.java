package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminReportDeleteForm {
    private String reportUUID;
    
    // Internal Fields
    private Boolean isAcceptable;
    private String queryReportUUID;

    public AdminReportDeleteForm(String reportUUID) {
        this.reportUUID = reportUUID;
    }

	// Default constructor
	public AdminReportDeleteForm() {
	}

    public void setQueryValues() {
		checkValues();
        if (reportUUID != null) {
            this.isAcceptable = true;
            this.queryReportUUID = this.reportUUID;
        } else {
			this.isAcceptable = false;
		}
    }

    public void checkValues() {
        this.reportUUID = (this.reportUUID != null && this.reportUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ? this.reportUUID : null;
    }

	public String getReportUUID() {
		return reportUUID;
	}

	public void setReportUUID(String reportUUID) {
		this.reportUUID = reportUUID;
	}

	public Boolean getIsAcceptable() {
		return isAcceptable;
	}

	public void setIsAcceptable(Boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
	}

	public String getQueryReportUUID() {
		return queryReportUUID;
	}

	public void setQueryReportUUID(String queryReportUUID) {
		this.queryReportUUID = queryReportUUID;
	}

    
    
}
