package com.Laboratory.Laboratory.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.Laboratory.Laboratory.DataAccess.Interfaces.ILaborantDataAccess;
import com.Laboratory.Laboratory.Entities.Laborant;
import com.Laboratory.Laboratory.Services.Interfaces.ILaborantService;

@Service
public class LaborantManager implements ILaborantService{

    private ILaborantDataAccess LaborantDataAccess;

    @Autowired
    public LaborantManager(ILaborantDataAccess LaborantDataAccess) {
        this.LaborantDataAccess = LaborantDataAccess;
    }

    @Override
    @Transactional
    public void add(Laborant laborant) {
        
        this.LaborantDataAccess.add(laborant);
    }

    @Override
    @Transactional
    public void update(Laborant laborant) {
        
        this.LaborantDataAccess.update(laborant);
    }

    @Override
    @Transactional
    public void delete(Laborant laborant) {
        
        this.LaborantDataAccess.delete(laborant);
    }

	@Override
	@Transactional
	public Boolean insertNewLaborant(Laborant laborant) {	
		return this.LaborantDataAccess.insertNewLaborant(laborant);
	}

	@Override
	@Transactional
	public Boolean updateLaborant(Laborant laborant) {
		return this.LaborantDataAccess.updateLaborant(laborant);
	}

	@Override
	@Transactional
	public Boolean deleteLaborant(Laborant laborant) {
		return this.LaborantDataAccess.deleteLaborant(laborant);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAll(clazz, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAll(clazz, offset, maxResult);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAll(clazz, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAll(clazz, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAll(clazz, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAll(clazz, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAll(Class<T> clazz, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAll(clazz, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult,
			String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult,
			String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult,
			Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType,
			Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByIsActiveWork(clazz, isActiveWork, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy,
			String orderType) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, Date fromDate,
			Date toDate) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.LaborantDataAccess.getAllByName(clazz, name, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy,
			String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset,
			Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurname(clazz, name, surname, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate,
			Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname,
			Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy,
			String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname,
			Boolean isVerified, Boolean isActiveWork, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllBySurname(clazz, surname, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, orderBy, orderType);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, offset, maxResult, fromDate, toDate);
	}

	@Override
	public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate) {
		
		return this.LaborantDataAccess.getAllByVerified(clazz, isVerified, orderBy, orderType, fromDate, toDate);
	}

	@Override
	public <T> T getByEmail(Class<T> clazz, String email) {
		
		return this.LaborantDataAccess.getByEmail(clazz, email);
	}

	@Override
	public <T> T getByEmailAndPassword(Class<T> clazz, String email, String password) {
		
		return this.LaborantDataAccess.getByEmailAndPassword(clazz, email, password);
	}

	@Override
	public <T> T getByHospitalID(Class<T> clazz, String hospitalId) {
		
		return this.LaborantDataAccess.getByHospitalID(clazz, hospitalId);
	}

	@Override
	public <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password) {
		
		return this.LaborantDataAccess.getByHospitalIDAndPassword(clazz, hospitalId, password);
	}

	@Override
	public <T> T getById(Class<T> clazz, Long id) {
		
		return this.LaborantDataAccess.getById(clazz, id);
	}

	@Override
	public <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber) {
		
		return this.LaborantDataAccess.getByIdentificationNumber(clazz, identificationNumber);
	}

	@Override
	public <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password) {
		
		return this.LaborantDataAccess.getByIdentificationNumberAndPassword(clazz, identificationNumber, password);
	}

	@Override
	public <T> T getByUUID(Class<T> clazz, String uuid) {
		
		return this.LaborantDataAccess.getByUUID(clazz, uuid);
	}

    

    
}
