package com.Laboratory.Laboratory.DataAccess.Interfaces;

import com.Laboratory.Laboratory.Entities.Report;
import com.Laboratory.Laboratory.Entities.SafeEntities.ReportSafe;

import java.util.Date;
import java.util.List;

public interface IReportDataAccess {

    void add(Report report);
    void update(Report report);
    void delete(Report report);

    /**
     * Insert new report
     * Note uuid, createdAt, updatedAt fields are auto generated
     * @param report The report entity
     * @return Boolean <b>True</b> if the report is inserted, <b>False</b> if the report is not inserted
     */
    Boolean insertNewReport(Report report);


    /**
     * Update report by UUID
     * !! Important <b>Admin</b> user can change only visibility of report 
     * @param reportUUID The reportUUID of the entity
     * @param isVisible new Visibilty state 
     * @return Boolean <b>True</b> if the report is updated, <b>False</b> if the report is not updated 
     */
    Boolean updateReportByUUID(String reportUUID, Boolean isVisible);

    /**
     * Update report by UUID
     * @param reportUUID The reportUUID of the entity
     * @param report The report entity {@link Report}
     * @return Boolean <b>True</b> if the report is updated, <b>False</b> if the report is not updated
     */
    Boolean updateReportDetailByUUID(String reportUUID, Report report);

    /**
     * Delete report by UUID
     * @param reportUUID The reportUUID of the entity
     * @return Boolean <b>True</b> if the report is deleted, <b>False</b> if the report is not deleted
     */
    Boolean deleteReportByUUID(String reportUUID);
    
    // Unique queries
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param id The id of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportId(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id); // Variations 1
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param reportUUID The reportUUID of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID); // Variations 2
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportNumber); // Variations 3
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String photoUrl); // Variations 4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID); // Variations 1-2
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportNumber The reportNumber of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportNumber); // Variations 1-3
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String photoUrl); // Variations 1-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param reportUUID The reportUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String reportNumber); // Variations 2-3
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param reportUUID The reportUUID of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String photoUrl); // Variations 2-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportNumber, String photoUrl); // Variations 3-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String reportNumber); // Variations 1-2-3
    /**
    * Getting one reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param patientUUID The patientUUID of the entity
    * @param laborantUUID The laborantUUID of the entity
    * @param id The id of the entity
    * @param reportUUID The reportUUID of the entity
    * @param reportNumber The reportNumber of the entity
    * @param photoUrl The photoUrl of the entity
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    */
    <T> T getByIdAndReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String photoUrl); // Variations 1-2-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportNumber, String photoUrl); // Variations 1-3-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String reportNumber, String photoUrl); // Variations 2-3-4
    /**
     * Getting one reports.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param patientUUID The patientUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param id The id of the entity
     * @param reportUUID The reportUUID of the entity
     * @param reportNumber The reportNumber of the entity
     * @param photoUrl The photoUrl of the entity
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
     */
    <T> T getByIdAndReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String reportNumber, String photoUrl); // Variations 1-2-3-4


    // Get all reports by xyz
    
    // Get All 
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param offset The offset of the first result, <b>null</b>  for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult); // Variations 1
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType); // Variations 2
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Date fromDate, Date toDate); // Variations 3
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param offset The offset of the first result, <b>null</b>  for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param offset The offset of the first result, <b>null</b>  for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
* @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    /**
    * Getting all reports.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b> for no limit
    * @param toDate The date to end, <b>null</b> for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3
    // End of Get All 


    // Get All by UserUUID
    /** 
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult); // Variations 1
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy, String orderType); // Variations 2
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Date fromDate, Date toDate); // Variations 3
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    /**
    * Getting all reports by userUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param userUUID The userUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3
    // End of Get All by UserUUID


    // Get All by LaborantUUID
    /** 
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult); // Variations 1
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy, String orderType); // Variations 2
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Date fromDate, Date toDate); // Variations 3
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    /**
    * Getting all reports by laborantUUID.
    * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
    * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
    * @param laborantUUID The laborantUUID of the entity
    * @param offset The offset of the first result, <b>null</b> for no offset
    * @param maxResult The maximum number of results, <b>null</b> for no limit
    * @param orderBy The column to order by, <b>null</b> for no order
    * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
    * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
    * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
    * @param fromDate The date to start from, <b>null</b>  for no limit
    * @param toDate The date to end, <b>null</b>  for no limit
    * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
    */
    <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3
    // End of Get All by LaborantUUID


    // Get All by UserUUID and  LaborantUUID
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param offset The offset of the first result, <b>null</b> for no offset
     * @param maxResult The maximum number of results, <b>null</b> for no limit
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult); // Variations 1
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param orderBy The column to order by, <b>null</b> for no order
     * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
     * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
     * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, String orderBy, String orderType); // Variations 2
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param fromDate The date to start from, <b>null</b>  for no limit
     * @param toDate The date to end, <b>null</b>  for no limit
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Date fromDate, Date toDate); // Variations 3
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param offset The offset of the first result, <b>null</b> for no offset
     * @param maxResult The maximum number of results, <b>null</b> for no limit
     * @param orderBy The column to order by, <b>null</b> for no order
     * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
     * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
     * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType); // Variations 1-2
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param offset The offset of the first result, <b>null</b> for no offset
     * @param maxResult The maximum number of results, <b>null</b> for no limit
     * @param fromDate The date to start from, <b>null</b>  for no limit
     * @param toDate The date to end, <b>null</b>  for no limit
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate); // Variations 1-3
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param orderBy The column to order by, <b>null</b> for no order
     * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
     * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
     * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The date to start from, <b>null</b>  for no limit
     * @param toDate The date to end, <b>null</b>  for no limit
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 2-3
    /**
     * Getting all reports by userUUID and laborantUUID.
     * @param <T> clazz The class of the entity.<br> You can use only <ul><li>{@link Report}</li><li>{@link ReportSafe}</li></ul>
     * @param isVisible The isVisible of the entity, <b>True</b> for get hidden reports
     * @param userUUID The userUUID of the entity
     * @param laborantUUID The laborantUUID of the entity
     * @param offset The offset of the first result, <b>null</b> for no offset
     * @param maxResult The maximum number of results, <b>null</b> for no limit
     * @param orderBy The column to order by, <b>null</b> for no order
     * You can use only {@link Report} or {@link ReportSafe} fields for orderBy parameter
     * Usable fields are: <ul><li>reportNumber</li><li>patientIdentificationNumber</li><li>patientBirthYear</li><li>createdAt</li></ul>
     * @param orderType The order type, <b>null</b> for no order <ul><li>asc</li><li>desc</li></ul>
     * @param fromDate The date to start from, <b>null</b>  for no limit
     * @param toDate The date to end, <b>null</b>  for no limit
     * @return List of all reports with {@link Report} or {@link ReportSafe} entity
    * Default order by createdAt, desc
     */
    <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate); // Variations 1-2-3
    // End of Get All by UserUUID and LaborantUUID


}
