package com.Laboratory.Laboratory.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IAdminDataAccess;
import com.Laboratory.Laboratory.Entities.Admin;
import com.Laboratory.Laboratory.Services.Interfaces.IAdminService;

@Service
public class AdminManager implements IAdminService{

    private IAdminDataAccess AdminDataAccess;

    @Autowired
    public AdminManager(IAdminDataAccess AdminDataAccess) {
        this.AdminDataAccess = AdminDataAccess;
    }

    @Override
    @Transactional
    public void add(Admin admin) {
        
        this.AdminDataAccess.add(admin);
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        
        this.AdminDataAccess.update(admin);
    }

    @Override
    @Transactional
    public void delete(Admin admin) {
        
        this.AdminDataAccess.delete(admin);
    }

	@Override
	@Transactional
	public Boolean updateAdmin(Admin admin) {
		
		return this.AdminDataAccess.updateAdmin(admin);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, String orderBy, String orderType,
			Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAll(clazz, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult) {
		
		return this.AdminDataAccess.getAll(clazz, offset, maxResult);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAll(clazz, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAll(clazz, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAll(clazz, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAll(clazz, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAll(clazz, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy,
			String orderType) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, Date fromDate,
			Date toDate) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.AdminDataAccess.getAllByName(clazz, name, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy,
			String orderType) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurname(clazz, name, surname, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult,
			String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult,
			String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, Date fromDate,
			Date toDate) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.AdminDataAccess.getAllBySurname(clazz, surname, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult,
			String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult,
			String orderBy, String orderType) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult,
			Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType,
			Date fromDate, Date toDate) {
		
		return this.AdminDataAccess.getAllByVerified(clazz, isVerified, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> T getByEmail(Class<T> clazz, String email) {
		
		return this.AdminDataAccess.getByEmail(clazz, email);
	}

	@Override
	public <T> T getByEmailAndPassword(Class<T> clazz, String email, String password) {
		
		return this.AdminDataAccess.getByEmailAndPassword(clazz, email, password);
	}

	@Override
	public <T> T getByHospitalID(Class<T> clazz, String hospitalId) {
		
		return this.AdminDataAccess.getByHospitalID(clazz, hospitalId);
	}

	@Override
	public <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password) {
		
		return this.AdminDataAccess.getByHospitalIDAndPassword(clazz, hospitalId, password);
	}

	@Override
	public <T> T getById(Class<T> clazz, Long id) {
		
		return this.AdminDataAccess.getById(clazz, id);
	}

	@Override
	public <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber) {
		
		return this.AdminDataAccess.getByIdentificationNumber(clazz, identificationNumber);
	}

	@Override
	public <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password) {
		
		return this.AdminDataAccess.getByIdentificationNumberAndPassword(clazz, identificationNumber, password);
	}

	@Override
	public <T> T getByUUID(Class<T> clazz, String uuid) {
		
		return this.AdminDataAccess.getByUUID(clazz, uuid);
	}

   
    
}
