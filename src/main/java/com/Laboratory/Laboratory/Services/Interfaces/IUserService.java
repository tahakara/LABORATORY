package com.Laboratory.Laboratory.Services.Interfaces;

import java.util.List;

import com.Laboratory.Laboratory.Entities.User;
import com.Laboratory.Laboratory.Entities.SafeEntities.UserSafe;

public interface IUserService {
    void add(User user);
    void update(User user);
    void delete(User user);
    
    // Unique queries
    User getById(Long id);
    UserSafe getByIdSafe(Long id);
    User getByIdentificationNumber(String identificationNumber);
    UserSafe getByIdentificationNumberSafe(String identificationNumber);
    User getByEmail(String email);
    UserSafe getByEmailSafe(String email);
    User getByEmailAndPassword(String email, String password);
    UserSafe getByEmailAndPasswordSafe(String email, String password);
    User getByIdentificationNumberAndPassword(String identificationNumber, String password);
    UserSafe getByIdentificationNumberAndPasswordSafe(String identificationNumber, String password);
    User getByUUID(String uuid);
    UserSafe getByUUIDSafe(String uuid);
    
    // Get all users by xyz
    List<User> getAll(Integer offset, Integer maxResult);
    List<UserSafe> getAllSafe(Integer offset, Integer maxResult);
    List<User> getAllByNames(String name, Integer offset, Integer maxResult);
    List<UserSafe> getAllByNamesSafe(String name, Integer offset, Integer maxResult);
    List<User> getAllBySurnames(String surname, Integer offset, Integer maxResult);
    List<UserSafe> getAllBySurnamesSafe(String surname, Integer offset, Integer maxResult);
    List<User> getAllByIsVerified(Boolean isVerified, Integer offset, Integer maxResult);
    List<UserSafe> getAllByIsVerifiedSafe(Boolean isVerified, Integer offset, Integer maxResult);
    List<User> getAllByNameAndSurname(String name, String surname, Integer offset, Integer maxResult);
    List<UserSafe> getAllByNameAndSurnameSafe(String name, String surname, Integer offset, Integer maxResult);
    
}
