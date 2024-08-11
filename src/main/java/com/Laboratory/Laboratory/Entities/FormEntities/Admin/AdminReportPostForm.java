package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

public class AdminReportPostForm {

    private String reportUUID;
    private Boolean isVisible;

    // Internal Fields
    private Boolean isAcceptable;
    private String queryReportUUID;
    private Boolean queryVisibilty;

    public AdminReportPostForm(String reportUUID, Boolean isVisible) {
        this.reportUUID = reportUUID;
        this.isVisible = isVisible;
    }

    //Default Constructor
    public AdminReportPostForm() {
    }

    public void checkValues() {
        this.queryReportUUID = (this.reportUUID != null && this.reportUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ? this.reportUUID : null;
        this.queryVisibilty = this.isVisible;
    }

    public void setQueryValues() {
        checkValues();
        if (this.queryReportUUID != null && this.queryVisibilty) {
            this.isAcceptable = true;
        } else {
            this.isAcceptable = false;
        }
    }

	public String getReportUUID() {
		return reportUUID;
	}

	public void setReportUUID(String reportUUID) {
		this.reportUUID = reportUUID;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
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

	public Boolean getQueryVisibilty() {
		return queryVisibilty;
	}

	public void setQueryVisibilty(Boolean queryVisibilty) {
		this.queryVisibilty = queryVisibilty;
	}

    

}
