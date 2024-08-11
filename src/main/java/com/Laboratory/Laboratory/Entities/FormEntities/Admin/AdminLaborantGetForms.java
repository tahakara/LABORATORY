package com.Laboratory.Laboratory.Entities.FormEntities.Admin;

import java.util.Date;

public class AdminLaborantGetForms {
	// uniq
    private String uuid;
	private String hospitalId;
	private String identificationNumber;
	

	// not uniq
	private String name;
	private String surname;
	private String email;
    private Boolean isVerified;
    private Boolean isActiveWork;

	// filter
	private Integer offset; 
	private Integer limit; 
	private Integer orderBy; // 0: createdAt, 1: name, 2: surname, 3: email, 4: identificationNumber
	private Integer orderType; // 0: asc, 1: desc
	private Date fromDate; 
	private Date toDate;

	// internal fields
    private Boolean isAcceptable;
	private Boolean isRequestedOne;
	private Boolean isRequestedList;

	private String queryUUID;
	private String queryHospitalId;
	private String queryIdentificationNumber;
	private String queryName;
	private String querySurname;
	private String queryEmail;
	private Boolean queryIsVerified;
	private Boolean queryIsActiveWork;
	private Integer queryOffset;
	private Integer queryLimit;
	private String queryOrderBy;
	private String queryOrderType;
	private Date queryFromDate;
	private Date queryToDate;

    public AdminLaborantGetForms(String uuid, String hospitalId, String identificationNumber, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer limit, Integer orderBy, Integer orderType, Date fromDate, Date toDate) {
        this.uuid = uuid;
		this.hospitalId = hospitalId; 
		this.identificationNumber = identificationNumber;
        this.isVerified = isVerified;
        this.isActiveWork = isActiveWork;
		this.offset = offset;
		this.limit = limit;
		this.orderBy = orderBy; 
		this.orderType = orderType; 
		this.fromDate = fromDate;
		this.toDate = toDate;


    }

    public void checkValues() {
		this.name = (this.name != null && this.name.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.name : null;
		this.surname = (this.surname != null && this.surname.matches("^[a-zA-Z]+(([ -][a-zA-Z ])?[a-zA-Z]*){0,254}$")) ? this.surname : null;
		this.email = (this.email != null && this.email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) ? this.email : null;
		this.hospitalId = (this.hospitalId != null && this.hospitalId.matches("^[0-9A-Z]{1,7}$")) ? this.hospitalId : null; 
		this.identificationNumber = (this.identificationNumber != null && this.identificationNumber.matches("^[1-9][0-9]{10}$")) ? this.identificationNumber : null;
        this.uuid = (this.uuid != null && this.uuid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) ? this.uuid : null;
		this.offset = (this.offset != null && this.offset > 0) ? this.offset : null;
        this.limit = (this.limit <= 100 && this.limit > 0 && this.limit != null) ? this.limit : 1;
        this.orderBy = (this.orderBy != null && (this.orderBy >= 0 && this.orderBy <= 4)) ? this.orderBy : null;
        this.orderType = (this.orderType !=null && (this.orderType == 0 || this.orderType == 1)) ? this.orderType : null;
    }

    public void isAcceptable() {
		if (this.uuid != null || this.hospitalId != null || this.identificationNumber != null || this.name != null || this.surname != null || this.email != null || this.isVerified != null || this.isActiveWork != null) {
			if (this.uuid != null || this.hospitalId != null || this.identificationNumber != null || this.email != null) {
				this.isAcceptable = true;
				this.isRequestedOne = true;
			} else if (this.name != null || this.surname != null || this.isVerified != null || this.isActiveWork != null) {
				this.isAcceptable = true;
				this.isRequestedList = true;
			} else {
				this.isAcceptable = false;
			}
		} else {
			this.isAcceptable = false;
		}
	}

	public void setQueryValues() {
		checkValues();
        isAcceptable();
		this.queryUUID = this.uuid;
		this.queryHospitalId = this.hospitalId;
		this.queryIdentificationNumber = this.identificationNumber;
		this.queryName = this.name;
		this.querySurname = this.surname;
		this.queryEmail = this.email;
		this.queryIsVerified = this.isVerified;
		this.queryIsActiveWork = this.isActiveWork;
		this.queryOffset = this.offset;
		this.queryLimit = this.limit;
		this.queryOrderBy = (this.orderBy == 0) ? "createdAt" : (this.orderBy == 1) ? "name" : (this.orderBy == 2) ? "surname" : (this.orderBy == 3) ? "email" : (this.orderBy == 4) ? "identificationNumber" : null;
		this.queryOrderType = (this.orderType == 0) ? "asc" : (this.orderType == 1) ? "desc" : null;
		this.queryFromDate = this.fromDate;
		this.queryToDate = this.toDate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Boolean getIsActiveWork() {
		return isActiveWork;
	}

	public void setIsActiveWork(Boolean isActiveWork) {
		this.isActiveWork = isActiveWork;
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

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
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

	public Boolean getIsAcceptable() {
		return isAcceptable;
	}

	public void setIsAcceptable(Boolean isAcceptable) {
		this.isAcceptable = isAcceptable;
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

	public String getQueryUUID() {
		return queryUUID;
	}

	public void setQueryUUID(String queryUUID) {
		this.queryUUID = queryUUID;
	}

	public String getQueryHospitalId() {
		return queryHospitalId;
	}

	public void setQueryHospitalId(String queryHospitalId) {
		this.queryHospitalId = queryHospitalId;
	}

	public String getQueryIdentificationNumber() {
		return queryIdentificationNumber;
	}

	public void setQueryIdentificationNumber(String queryIdentificationNumber) {
		this.queryIdentificationNumber = queryIdentificationNumber;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQuerySurname() {
		return querySurname;
	}

	public void setQuerySurname(String querySurname) {
		this.querySurname = querySurname;
	}

	public String getQueryEmail() {
		return queryEmail;
	}

	public void setQueryEmail(String queryEmail) {
		this.queryEmail = queryEmail;
	}

	public Boolean getQueryIsVerified() {
		return queryIsVerified;
	}

	public void setQueryIsVerified(Boolean queryIsVerified) {
		this.queryIsVerified = queryIsVerified;
	}

	public Boolean getQueryIsActiveWork() {
		return queryIsActiveWork;
	}

	public void setQueryIsActiveWork(Boolean queryIsActiveWork) {
		this.queryIsActiveWork = queryIsActiveWork;
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

	
	
    
}
