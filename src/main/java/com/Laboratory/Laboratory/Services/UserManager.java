package com.Laboratory.Laboratory.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IUserDataAccess;
import com.Laboratory.Laboratory.Entities.User;
import com.Laboratory.Laboratory.Entities.SafeEntities.UserSafe;
import com.Laboratory.Laboratory.Services.Interfaces.IUserService;

@Service
public class UserManager implements IUserService {

    private IUserDataAccess UserDataAccess;

    @Autowired
    public UserManager(IUserDataAccess UserDataAccess) {
        this.UserDataAccess = UserDataAccess;
    }

    @Override
    @Transactional
    public void add(User user) {
        
        this.UserDataAccess.add(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        
        this.UserDataAccess.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        
        this.UserDataAccess.delete(user);
    }

    // -----*******************-----
    //      Get one user by xyz
    // -----*******************-----

    // id
    @Override
    public User getById(Long id) {
        
        return this.UserDataAccess.getById(id);
    }

    @Override
    public UserSafe getByIdSafe(Long id) {
        
        return this.UserDataAccess.getByIdSafe(id);
    }

    // identificationNumber
    @Override
    public User getByIdentificationNumber(String identificationNumber) {
        
        return this.UserDataAccess.getByIdentificationNumber(identificationNumber);
    }

    @Override
    public UserSafe getByIdentificationNumberSafe(String identificationNumber) {
        
        return this.UserDataAccess.getByIdentificationNumberSafe(identificationNumber);
    }

    // email
    @Override
    public User getByEmail(String email) {
        
        return this.UserDataAccess.getByEmail(email);
    }

    @Override
    public UserSafe getByEmailSafe(String email) {
        
        return this.UserDataAccess.getByEmailSafe(email);
    }

    // email and password
    @Override
    public User getByEmailAndPassword(String email, String password) {
        
        return this.UserDataAccess.getByEmailAndPassword(email, password);
    }

    @Override
    public UserSafe getByEmailAndPasswordSafe(String email, String password) {
        
        return this.UserDataAccess.getByEmailAndPasswordSafe(email, password);
    }

    // identificationNumber and password
    @Override
    public User getByIdentificationNumberAndPassword(String identificationNumber, String password) {
        
        return this.UserDataAccess.getByIdentificationNumberAndPassword(identificationNumber, password);
    }

    @Override
    public UserSafe getByIdentificationNumberAndPasswordSafe(String identificationNumber, String password) {
        
        return this.UserDataAccess.getByIdentificationNumberAndPasswordSafe(identificationNumber, password);
    }

    // uuid
    @Override
    public User getByUUID(String uuid) {
        
        return this.UserDataAccess.getByUUID(uuid);
    }

    @Override
    public UserSafe getByUUIDSafe(String uuid) {
        
        return this.UserDataAccess.getByUUIDSafe(uuid);
    }

    // -----*******************-----
    //      Get all users by xyz
    // -----*******************-----

    @Override
    public List<User> getAll(Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAll(offset, maxResult);
    };
    @Override
    public List<UserSafe> getAllSafe(Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllSafe(offset, maxResult);
    };
    @Override
    public List<User> getAllByNames(String name, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByNames(name, offset, maxResult);
    };
    @Override
    public List<UserSafe> getAllByNamesSafe(String name, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByNamesSafe(name, offset, maxResult);
    };
    @Override
    public List<User> getAllBySurnames(String surname, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllBySurnames(surname, offset, maxResult);
    };
    @Override
    public List<UserSafe> getAllBySurnamesSafe(String surname, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllBySurnamesSafe(surname, offset, maxResult);
    };
    @Override
    public List<User> getAllByIsVerified(Boolean isVerified, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByIsVerified(isVerified, offset, maxResult);
    };
    @Override
    public List<UserSafe> getAllByIsVerifiedSafe(Boolean isVerified, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByIsVerifiedSafe(isVerified, offset, maxResult);
    };
    @Override
    public List<User> getAllByNameAndSurname(String name, String surname, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByNameAndSurname(name, surname, offset, maxResult);
    };
    @Override
    public List<UserSafe> getAllByNameAndSurnameSafe(String name, String surname, Integer offset, Integer maxResult) {
        
        return this.UserDataAccess.getAllByNameAndSurnameSafe(name, surname, offset, maxResult);
    };

    
}
