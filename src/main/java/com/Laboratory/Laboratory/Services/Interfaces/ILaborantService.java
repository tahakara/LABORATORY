package com.Laboratory.Laboratory.Services.Interfaces;

import java.util.Date;
import java.util.List;

import com.Laboratory.Laboratory.Entities.Laborant;
import com.Laboratory.Laboratory.Entities.SafeEntities.LaborantSafe;

public interface ILaborantService {
 
    void add(Laborant laborant);
    void update(Laborant laborant);
    void delete(Laborant laborant);

    //---------------------- //    
    //--- Insert Laborant -- //    
    //---------------------- // 

    /**
     * Add a new laborant to the database.<br>
     * @param laborant  The laborant to be added {@link Laborant}.
     * @return Return <ul><li>true</li><li>false</li></ul>
     */
    Boolean insertNewLaborant(Laborant laborant);


    //---------------------- //    
    //--- Update Laborant -- //    
    //---------------------- // 

    /**
     * Update a laborant in the database.<br>
     * @param laborant  The laborant to be updated {@link Laborant}.
     * @return Return <ul><li>true</li><li>false</li></ul>
     */
    Boolean updateLaborant(Laborant laborant);



    //---------------------- //    
    //--- Update Laborant -- //    
    //---------------------- // 

    /**
     * Delete a laborant from the database.<br>
     * Important This methot not complate delete. 
     * <ul><li>Update isActiveWork to false.</li>
     * <li>Update isVerified to false.</li>
     * <li>Update VerificationCode to null.</li>
     * <li>Update Email to null.</li>
     * <li>Update Password to null.</li>
     * <li>Update Masking Name And Surname.</li>
     * <li>Update Masking IdentificationNumber.</li>
     * @param laborant  The laborant to be deleted {@link Laborant}.
     * @return  Return <ul><li>true</li><li>false</li></ul>
     */
    Boolean deleteLaborant(Laborant laborant);
    
    
    
    //---------------------- //    
    //------ Get One ------- //    
    //---------------------- //     

    /**
     * Get an entity by id.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param id The id of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getById(Class<T> clazz, Long id);
    /**
     * Get an entity by hospitalId.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param hospitalId The hospitalId of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByHospitalID(Class<T> clazz, String hospitalId);
    /**
     * Get an entity by identificationNumber.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param identificationNumber The identificationNumber of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber);
    /**
     * Get an entity by email.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param email The email of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByEmail(Class<T> clazz, String email);
    /**
     * Get an entity by UUID.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param uuid The UUID of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByUUID(Class<T> clazz, String uuid);
    /**
     * Get an entity by email and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param email The email of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByEmailAndPassword(Class<T> clazz, String email, String password);
    /**
     * Get an entity by hospitalId and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param hospitalId The hospitalId of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password);
    /**
     * Get an entity by identificationNumber and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param identificationNumber The identificationNumber of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Laborant}.
     */
    <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password);


    //---------------------- //    
    //-------- More -------- //    
    //---------------------- //    
    
    // Get All
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3 
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    
    // Get All By Name
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant}.
     */  
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant}.
     */   
    <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Surname
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */   
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    
    // Get All By Verified
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */   
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By IsActiveWork
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */    
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */    
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by isActiveWork and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param isActiveWork The active work status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By CreatedDate
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Verified
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Verified
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isActiveWork The working status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Verified
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and surname and verified and isActiveWork.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Laborant}</li><li>{@link LaborantSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param isActiveWork The working status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>isActiveWork</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Laborant} or {@link LaborantSafe}.
    */
    <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3




}

