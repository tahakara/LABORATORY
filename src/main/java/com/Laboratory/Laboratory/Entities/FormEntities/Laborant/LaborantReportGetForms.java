package com.Laboratory.Laboratory.Entities.FormEntities.Laborant;

import java.util.Date;

public class LaborantReportGetForms {

    // List
    private String patientUUID;
    private String laborantUUID;
    
    // One
    private Long reportID;
    private String reportNumber;
    private String reportUUID;

    // Filter
    private Integer offset;
    private Integer limit;
    private Integer orderBy; // 0: createdAt, 1: reportNumber, 2: patientIdentificationNumber, 3: patientBirthYear
    private Byte orderType;  // 0: asc, 1: desc
    private Date fromDate;
    private Date toDate;


    // Internal fields  
    private Boolean isRequestedOne;
    private Boolean isRequestedList;

    private Boolean queryIsVisible;
    private String queryPatientUUID;
    private String queryLaborantUUID;

    private Integer queryOffset;
    private Integer queryLimit;
    private String queryOrderBy; // 0: createdAt, 1: reportNumber, 2: patientIdentificationNumber, 3: patientBirthYear
    private String queryOrderType;  // 0: asc, 1: desc

    private Date queryFromDate;
    private Date queryToDate;

    private Long queryReportID;
    private String queryReportNumber;
    private String queryReportUUID;


    public LaborantReportGetForms(String patientUUID, String laborantUUID, Integer offset, Integer limit, Integer orderBy, Byte orderType, Date fromDate, Date toDate, Long reportID, String reportNumber, String reportUUID) {
        this.patientUUID = patientUUID;
        this.laborantUUID = laborantUUID;
        this.offset = offset;
        this.limit = limit;
        this.orderBy = orderBy;
        this.orderType = orderType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reportID = reportID;
        this.reportNumber = reportNumber;
        this.reportUUID = reportUUID;
    }

    // Default constructor
    public LaborantReportGetForms() {
    }

    public void checkValues() {
        this.patientUUID = (this.patientUUID !=null && this.patientUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.patientUUID : null ;
        this.laborantUUID = (this.laborantUUID !=null && this.laborantUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.laborantUUID : null ;
        this.reportID = (this.reportID != null && this.reportID > 0) ? this.reportID : null ;
        this.reportUUID = (this.reportUUID != null && this.reportUUID.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}") == true) ? this.reportUUID : null ;
        this.offset = (this.offset != null && this.offset > 0) ? this.offset : null;
        this.limit = (this.limit != null && (this.limit <= 100 && this.limit > 0 && this.limit != null)) ? this.limit : 1;
        this.orderBy = (this.orderBy != null && (this.orderBy >= 0 && this.orderBy <= 4)) ? this.orderBy : null;
        this.orderType = (this.orderType !=null && (this.orderType == 0 || this.orderType == 1)) ? this.orderType : null;
    }

    public void RequestedHowMany() {
        if (this.reportID != null || this.reportUUID !=null || this.reportNumber !=null) {
            this.isRequestedOne = true;
            this.isRequestedList = false;
        } else {
            this.isRequestedList = true;
            this.isRequestedOne = false;
        }
    }

    public void setQueryValues() {
        checkValues();
        RequestedHowMany();
        this.queryIsVisible = true;
        this.queryPatientUUID = this.patientUUID;
        this.queryPatientUUID = this.laborantUUID;
        this.queryOffset = this.offset;
        this.queryLimit = this.limit;
        
        this.queryOrderBy = this.orderBy == 0 ? "createdAt" : (this.orderBy == 1) ? "reportNumber" : (this.orderBy == 2) ? "patientIdentificationNumber" : (this.orderBy == 3) ? "patientBirthYear" : null;
        this.queryOrderType = this.orderType == 0 ? "asc" : (this.orderType == 1) ? "desc" : null;
        this.queryFromDate = this.fromDate;
        this.queryToDate = this.toDate;
        if (this.reportID != null) {
            this.queryReportID = this.reportID;
        }
        this.queryReportUUID = this.reportUUID;
        this.queryReportNumber = this.reportNumber;
    }

    public String getPatientUUID() {
        return patientUUID;
    }

    public void setPatientUUID(String patientUUID) {
        this.patientUUID = patientUUID;
    }

    public String getLaborantUUID() {
        return laborantUUID;
    }

    public void setLaborantUUID(String laborantUUID) {
        this.laborantUUID = laborantUUID;
    }

    public Long getReportID() {
        return reportID;
    }

    public void setReportID(Long reportID) {
        this.reportID = reportID;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getReportUUID() {
        return reportUUID;
    }

    public void setReportUUID(String reportUUID) {
        this.reportUUID = reportUUID;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getIsRequestedOne() {
        return isRequestedOne;
    }

    public void setIsRequestedOne(Boolean isRequestedOne) {
        this.isRequestedOne = isRequestedOne;
    }

    public Boolean getIsRequestedList() {
        return isRequestedList;
    }

    public void setIsRequestedList(Boolean isRequestedList) {
        this.isRequestedList = isRequestedList;
    }

    public Boolean getQueryIsVisible() {
        return queryIsVisible;
    }

    public void setQueryIsVisible(Boolean queryIsVisible) {
        this.queryIsVisible = queryIsVisible;
    }

    public String getQueryPatientUUID() {
        return queryPatientUUID;
    }

    public void setQueryPatientUUID(String queryPatientUUID) {
        this.queryPatientUUID = queryPatientUUID;
    }

    public String getQueryLaborantUUID() {
        return queryLaborantUUID;
    }

    public void setQueryLaborantUUID(String queryLaborantUUID) {
        this.queryLaborantUUID = queryLaborantUUID;
    }

    public Integer getQueryOffset() {
        return queryOffset;
    }

    public void setQueryOffset(Integer queryOffset) {
        this.queryOffset = queryOffset;
    }

    public Integer getQueryLimit() {
        return queryLimit;
    }

    public void setQueryLimit(Integer queryLimit) {
        this.queryLimit = queryLimit;
    }

    public String getQueryOrderBy() {
        return queryOrderBy;
    }

    public void setQueryOrderBy(String queryOrderBy) {
        this.queryOrderBy = queryOrderBy;
    }

    public String getQueryOrderType() {
        return queryOrderType;
    }

    public void setQueryOrderType(String queryOrderType) {
        this.queryOrderType = queryOrderType;
    }

    public Date getQueryFromDate() {
        return queryFromDate;
    }

    public void setQueryFromDate(Date queryFromDate) {
        this.queryFromDate = queryFromDate;
    }

    public Date getQueryToDate() {
        return queryToDate;
    }

    public void setQueryToDate(Date queryToDate) {
        this.queryToDate = queryToDate;
    }

    public Long getQueryReportID() {
        return queryReportID;
    }

    public void setQueryReportID(Long queryReportID) {
        this.queryReportID = queryReportID;
    }

    public String getQueryReportNumber() {
        return queryReportNumber;
    }

    public void setQueryReportNumber(String queryReportNumber) {
        this.queryReportNumber = queryReportNumber;
    }

    public String getQueryReportUUID() {
        return queryReportUUID;
    }

    public void setQueryReportUUID(String queryReportUUID) {
        this.queryReportUUID = queryReportUUID;
    }

    
    
    

    
}
