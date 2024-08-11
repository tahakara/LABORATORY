package com.Laboratory.Laboratory.Entities.FormEntities.Laborant;

public class LaborantReportDeleteForm {

    private String reportUUID;
    private String laborantUUID;

    private Boolean isAcceptable;

    private String queryReportUUID;
    private String queryLaborantUUID;

    public LaborantReportDeleteForm(String reportUUID, String laborantUUID) {
        this.reportUUID = reportUUID;
        this.laborantUUID = laborantUUID;
    }

    public void checkValues() {
        this.laborantUUID = (this.laborantUUID !=null && this.laborantUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.laborantUUID : null ;
        this.reportUUID = (this.reportUUID != null && this.reportUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.reportUUID : null ;
    }

    public void setQueryValues() {
        if (this.reportUUID == null || this.laborantUUID == null) {
            this.isAcceptable = false;
        } else {
            this.isAcceptable = true;
        }

        this.queryLaborantUUID = this.laborantUUID;
        this.queryReportUUID = this.reportUUID;
    }

    public String getReportUUID() {
        return reportUUID;
    }

    public void setReportUUID(String reportUUID) {
        this.reportUUID = reportUUID;
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

    public String getQueryReportUUID() {
        return queryReportUUID;
    }

    public void setQueryReportUUID(String queryReportUUID) {
        this.queryReportUUID = queryReportUUID;
    }

    public String getQueryLaborantUUID() {
        return queryLaborantUUID;
    }

    public void setQueryLaborantUUID(String queryLaborantUUID) {
        this.queryLaborantUUID = queryLaborantUUID;
    }

    

}
