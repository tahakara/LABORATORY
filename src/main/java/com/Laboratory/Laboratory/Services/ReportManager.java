package com.Laboratory.Laboratory.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IReportDataAccess;
import com.Laboratory.Laboratory.Entities.Report;
import com.Laboratory.Laboratory.Services.Interfaces.IReportService;

@Service
public class ReportManager implements IReportService{

    private IReportDataAccess ReportDataAccess;

    @Autowired
    public ReportManager(IReportDataAccess ReportDataAccess) {
        this.ReportDataAccess = ReportDataAccess;
    }

    @Override
    @Transactional
    public void add(Report report) {
        
        this.ReportDataAccess.add(report);
    }

    @Override
    @Transactional
    public void update(Report report) {
        
        this.ReportDataAccess.update(report);
    }

    @Override
    @Transactional
    public void delete(Report report) {
        
        this.ReportDataAccess.delete(report);
    }

	@Override
	@Transactional
	public Boolean insertNewReport(Report report) {
		return this.ReportDataAccess.insertNewReport(report);
	}

	@Override
	@Transactional
	public Boolean updateReportByUUID(String reportUUID, Boolean isVisible) {
		return this.ReportDataAccess.updateReportByUUID(reportUUID, isVisible);
	}

	@Override
	@Transactional
	public Boolean updateReportDetailByUUID(String reportUUID, Report report) {
		return this.ReportDataAccess.updateReportDetailByUUID(reportUUID, report);
	}

	@Override
	@Transactional
	public Boolean deleteReportByUUID(String reportUUID) {
		return this.ReportDataAccess.deleteReportByUUID(reportUUID);
	}

    
    // -----*******************----- 
    //      Get one report by xyz 
    // -----*******************-----
    
	@Override
	public <T> T getByReportId(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id) {
		
		return this.ReportDataAccess.getByReportId(clazz, isVisible, patientUUID, laborantUUID, id);
	}

	@Override
	public <T> T getByIdAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id,
			String photoUrl) {
		
		return this.ReportDataAccess.getByIdAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, photoUrl);
	}

	@Override
	public <T> T getByIdAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			Long id, String reportNumber) {
		
		return this.ReportDataAccess.getByIdAndReportNumber(clazz, isVisible, patientUUID, laborantUUID, id, reportNumber);
	}

	@Override
	public <T> T getByIdAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, Long id, String reportNumber, String photoUrl) {
		
		return this.ReportDataAccess.getByIdAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportNumber, photoUrl);
	}

	@Override
	public <T> T getByIdAndReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			Long id, String reportUUID) {
		
		return this.ReportDataAccess.getByIdAndReportUUID(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID);
	}

	@Override
	public <T> T getByIdAndReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, Long id, String reportUUID, String photoUrl) {
		
		return this.ReportDataAccess.getByIdAndReportUUIDAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, photoUrl);
	}

	@Override
	public <T> T getByIdAndReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, Long id, String reportUUID, String reportNumber) {
		
		return this.ReportDataAccess.getByIdAndReportUUIDAndReportNumber(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, reportNumber);
	}

	@Override
	public <T> T getByIdAndReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, Long id, String reportUUID, String reportNumber, String photoUrl) {
		
		return this.ReportDataAccess.getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, reportNumber, photoUrl);
	}

	@Override
	public <T> T getByPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			String photoUrl) {
		
		return this.ReportDataAccess.getByPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, photoUrl);
	}

	@Override
	public <T> T getByReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			String reportNumber) {
		
		return this.ReportDataAccess.getByReportNumber(clazz, isVisible, patientUUID, laborantUUID, reportNumber);
	}

	@Override
	public <T> T getByReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, String reportNumber, String photoUrl) {
		
		return this.ReportDataAccess.getByReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, reportNumber, photoUrl);
	}

	@Override
	public <T> T getByReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			String reportUUID) {
		
		return this.ReportDataAccess.getByReportUUID(clazz, isVisible, patientUUID, laborantUUID, reportUUID);
	}

	@Override
	public <T> T getByReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID,
			String reportUUID, String photoUrl) {
		
		return this.ReportDataAccess.getByReportUUIDAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, reportUUID, photoUrl);
	}

	@Override
	public <T> T getByReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, String reportUUID, String reportNumber) {
		
		return this.ReportDataAccess.getByReportUUIDAndReportNumber(clazz, isVisible, patientUUID, laborantUUID, reportUUID, reportNumber);
	}

	@Override
	public <T> T getByReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID,
			String laborantUUID, String reportUUID, String reportNumber, String photoUrl) {
		
		return this.ReportDataAccess.getByReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, reportUUID, reportNumber, photoUrl);
	}



    // -----*******************----- 
    //      Get List of reports by xyz 
    // -----*******************-----

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, offset, maxResult);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy,
			String orderType) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, Date fromDate,
			Date toDate) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAll(clazz, isVisible, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset,
			Integer maxResult) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy,
			String orderType) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Date fromDate,
			Date toDate) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset,
			Integer maxResult, String orderBy, String orderType) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset,
			Integer maxResult, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset,
			Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset,
			Integer maxResult) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy,
			String orderType) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Date fromDate,
			Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset,
			Integer maxResult, String orderBy, String orderType) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset,
			Integer maxResult, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset,
			Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, Integer offset, Integer maxResult) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, String orderBy, String orderType) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID,
			String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.ReportDataAccess.getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}





    
}
