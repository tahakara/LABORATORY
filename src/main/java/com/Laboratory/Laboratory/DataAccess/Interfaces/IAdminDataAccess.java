package com.Laboratory.Laboratory.DataAccess.Interfaces;

import com.Laboratory.Laboratory.Entities.Admin;
import com.Laboratory.Laboratory.Entities.SafeEntities.AdminSafe;

import java.util.Date;
import java.util.List;


public interface IAdminDataAccess {
    void add(Admin admin);
    void update(Admin admin);
    void delete(Admin admin);
    
    //----------------------- //    
    //---- Update Admin ----- //    
    //----------------------- //

    /**
     * Update the entity {@link Admin}.<br>
     * @param admin The entity {@link Admin} to update.
     * @return  The result of the operation.
     */
    Boolean updateAdmin(Admin admin);



    //---------------------- //    
    //-------- One --------- //    
    //---------------------- //    

    /**
     * Get an entity by id.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param id The id of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getById(Class<T> clazz, Long id);
    /**
     * Get an entity by hospitalId.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param hospitalId The hospitalId of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByHospitalID(Class<T> clazz, String hospitalId);
    /**
     * Get an entity by identificationNumber.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param identificationNumber The identificationNumber of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber);
    /**
     * Get an entity by email.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param email The email of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByEmail(Class<T> clazz, String email);
    /**
     * Get an entity by UUID.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param uuid The UUID of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByUUID(Class<T> clazz, String uuid);
    /**
     * Get an entity by email and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param email The email of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByEmailAndPassword(Class<T> clazz, String email, String password);
    /**
     * Get an entity by hospitalId and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param hospitalId The hospitalId of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password);
    /**
     * Get an entity by identificationNumber and password.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param identificationNumber The identificationNumber of the entity.
     * @param password The password of the entity.
     * @return The entity {@link Admin} or {@link AdminSafe}.
     */
    <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password);


    //---------------------- //    
    //-------- More -------- //    
    //---------------------- //    
    
    // Get All
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3 
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    
    // Get All By Name
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */  
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */   
    <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li></ul>
     * @param name The name of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Surname
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
    */
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */ 
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */   
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    
    // Get All By Verified
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */   
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */    
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    // Get All By Name And Surname
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by name and surname.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and surname and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param surname The surname of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

    // Get All By Name And Surname And Verified
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variation 1-2-3 
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult); // Variations 1
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType); // Variations 2
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Date fromDate, Date toDate); // Variations 3
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param offset The offset of the result list.
     * @param maxResult The maximum number of results.
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Get all entities by name and verified.<br>
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Admin}</li><li>{@link AdminSafe}</li></ul>
     * @param name The name of the entity.
     * @param isVerified The verification status of the entity.
     * @param orderBy The column name to order the result list. You can use only <ul><li>name</li><li>surname</li><li>hospitalId</li><li>identificationNumber</li><li>isVerified</li><li>createdDate</li></ul>
     * @param orderType The order type of the result list. You can use only <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The start date of the result list.
     * @param toDate The end date of the result list.
     * @return The list of entities {@link Admin} or {@link AdminSafe}.
     */
    <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3

}
