package com.Laboratory.Laboratory.DataAccess;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IReportDataAccess;
import com.Laboratory.Laboratory.Entities.Report;
import com.Laboratory.Laboratory.Entities.SafeEntities.ReportSafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

@Service
public class ReportData implements IReportDataAccess{

    private EntityManager entityManager;

    @Autowired
    public ReportData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Report report) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void update(Report report) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void delete(Report report) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public Boolean insertNewReport(Report report) {
        try {
            Session session = entityManager.unwrap(Session.class);

            NativeQuery<Timestamp> query = session.createNativeQuery("SELECT CURRENT_TIMESTAMP as timestamp", Timestamp.class);
            Timestamp date = query.getSingleResult();

            NativeQuery<String> queryUUID = session.createNativeQuery("SELECT GEN_RANDOM_UUID() as uuid", String.class);
            String uuid = queryUUID.getSingleResult();
        
            report.setCreatedAt(date);
            report.setUpdatedAt(date);
            report.setUUID(uuid);

            session.persist(report);
            return true;            
        
        } catch (Exception e) {
            return false;
        }

    }


    // -----*******************-----
    //      Update report by xyz
    // -----*******************-----
    @Override
    @Transactional
    public Boolean updateReportByUUID(String reportUUID, Boolean isVisible) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Report> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Report.class);
        Root<Report> root = criteriaUpdate.from(Report.class);
        
        Session session = entityManager.unwrap(Session.class);     
        NativeQuery<Timestamp> query = session.createNativeQuery("SELECT CURRENT_TIMESTAMP as timestamp", Timestamp.class);
        Timestamp date = query.getSingleResult();

        criteriaUpdate.set(root.get("isVisible"), isVisible);
        criteriaUpdate.set(root.get("updatedAt"), date);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("uuid"), reportUUID));

        int rowsUpdated = entityManager.createQuery(criteriaUpdate).executeUpdate();
        return rowsUpdated > 0;
    }


    @Override
    public Boolean updateReportDetailByUUID(String reportUUID, Report report) {
        // update report by reportUUID
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Report> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Report.class);
        Root<Report> root = criteriaUpdate.from(Report.class);
        
        Session session = entityManager.unwrap(Session.class);     
        NativeQuery<Timestamp> query = session.createNativeQuery("SELECT CURRENT_TIMESTAMP as timestamp", Timestamp.class);
        Timestamp date = query.getSingleResult();

        criteriaUpdate.set(root.get("patientName"), report.getPatientName());
        criteriaUpdate.set(root.get("patientSurname"), report.getPatientSurname());
        criteriaUpdate.set(root.get("patientBirthDay"), report.getPatientBirthDay());
        criteriaUpdate.set(root.get("patientBirthMonth"), report.getPatientBirthMonth());
        criteriaUpdate.set(root.get("patientBirthYear"), report.getPatientBirthYear());
        criteriaUpdate.set(root.get("diagnoseTitle"), report.getDiagnoseTitle());
        criteriaUpdate.set(root.get("diagnoseContent"), report.getDiagnoseContent());
        criteriaUpdate.set(root.get("photoUrl"), report.getPhotoUrl());
        criteriaUpdate.set(root.get("updatedAt"), date);

        criteriaUpdate.where(criteriaBuilder.equal(root.get("uuid"), reportUUID));

        int rowsUpdated = entityManager.createQuery(criteriaUpdate).executeUpdate();
        return rowsUpdated > 0;
    }
    // -----*******************-----
    //      Delete report by xyz
    // -----*******************-----

    @Override
    @Transactional
    public Boolean deleteReportByUUID(String reportUUID) {
        // delete report by reportUUID
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Report> criteriaDelete = criteriaBuilder.createCriteriaDelete(Report.class);
        Root<Report> root = criteriaDelete.from(Report.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("uuid"), reportUUID));
        
        int result = entityManager.createQuery(criteriaDelete).executeUpdate();

        return result > 0;
    }


    // -----*******************-----
    //      Get one report by xyz
    // -----*******************-----

    @Override // Variations 1
    public <T> T getByReportId(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, null, null, null);
    }
    @Override // Variations 2
    public <T> T getByReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, reportUUID, null, null);
    }
    @Override // Variations 3
    public <T> T getByReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportNumber){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, null, reportNumber, null);
    }
    @Override // Variations 4
    public <T> T getByPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, null, null, photoUrl);
    }
    @Override // Variations 1-2
    public <T> T getByIdAndReportUUID(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, null, null);
    }
    @Override // Variations 1-3
    public <T> T getByIdAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportNumber){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, null, reportNumber, null);
    }
    @Override // Variations 1-4
    public <T> T getByIdAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, null, null, photoUrl);
    }
    @Override // Variations 2-3
    public <T> T getByReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String reportNumber){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, reportUUID, reportNumber, null);
    }
    @Override // Variations 2-4
    public <T> T getByReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, reportUUID, null, photoUrl);
    }
    @Override // Variations 3-4
    public <T> T getByReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportNumber, String photoUrl){
       return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, null, reportNumber, photoUrl);
    }
    @Override // Variations 1-2-3
    public <T> T getByIdAndReportUUIDAndReportNumber(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String reportNumber){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, reportNumber, null);
    }
    @Override // Variations 1-2-4
    public <T> T getByIdAndReportUUIDAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, reportUUID, null, photoUrl);
    }
    @Override // Variations 1-3-4
    public <T> T getByIdAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportNumber, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, id, null, reportNumber, photoUrl);
    }
    @Override // Variations 2-3-4
    public <T> T getByReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, String reportUUID, String reportNumber, String photoUrl){
        return getByIdAndReportUUIDAndReportNumberAndPhotoUrl(clazz, isVisible, patientUUID, laborantUUID, null, reportUUID, reportNumber, photoUrl);
    }
    @Override // Variations 1-2-3-4
    public <T> T getByIdAndReportUUIDAndReportNumberAndPhotoUrl(Class<T> clazz, Boolean isVisible, String patientUUID, String laborantUUID, Long id, String reportUUID, String reportNumber, String photoUrl) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        Boolean isFirstEquality = true;
    
        Predicate mainPredicate = criteriaBuilder.conjunction();
        if (id != null) {
            mainPredicate = (isFirstEquality) ? 
                criteriaBuilder.equal(root.get("id"), id) : criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("id"), id));
            isFirstEquality = false;
        }
        if (reportUUID != null) {
            mainPredicate = (isFirstEquality) ? 
                criteriaBuilder.equal(root.get("uuid"), reportUUID) : 
                criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("uuid"), reportUUID));
            isFirstEquality = false;
        }
        if (reportNumber != null) {
            mainPredicate = (isFirstEquality) ? 
                criteriaBuilder.equal(root.get("reportNumber"), reportNumber) : 
                criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("reportNumber"), reportNumber));
            isFirstEquality = false;
        }
        if (photoUrl != null) {
            mainPredicate = (isFirstEquality) ? 
                criteriaBuilder.equal(root.get("photoUrl"), photoUrl) : 
                criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("photoUrl"), photoUrl));
            isFirstEquality = false;
        }
        if (isVisible != null) {
            mainPredicate = (isFirstEquality) ? 
                criteriaBuilder.equal(root.get("isVisible"), isVisible) : 
                criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("isVisible"), isVisible));
                isFirstEquality = false;
            }
    
            
        if (patientUUID != null && !patientUUID.isEmpty()) {
            mainPredicate = criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("patientUUID"), patientUUID));
        }
    
        if (laborantUUID != null && !laborantUUID.isEmpty()) {
            mainPredicate = criteriaBuilder.and(mainPredicate, criteriaBuilder.equal(root.get("laborantUUID"), laborantUUID));
        }
    
        criteriaQuery.select(root).where(mainPredicate);
    
        T report = session.createQuery(criteriaQuery).getSingleResultOrNull();
    
        if (clazz == ReportSafe.class && report != null) {
            ((ReportSafe) report).maskIdentificationNumber();
        }
    
        return report;
    }

    // -----*******************-----
    // Get all reports by xyz
    // -----*******************-----

    // All
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
	@Override // Variations 1-2-3
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        
        if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else if (orderType.equals("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdAt")));
        }
        
        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("createdAt"), fromDate, toDate);
            Predicate visibilityPredicate = isVisible != null ? criteriaBuilder.equal(root.get("isVisible"), isVisible) : null;
            
            Predicate combinedPredicate = visibilityPredicate != null ? criteriaBuilder.and(datePredicate, visibilityPredicate) : datePredicate;
            
            criteriaQuery.where(combinedPredicate);
        } else {
            Predicate visibilityPredicate = isVisible != null ? criteriaBuilder.equal(root.get("isVisible"), isVisible) : null;
            
            criteriaQuery.where(visibilityPredicate);
        }
        
        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);
        
        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }
        
        List<T> result = typedQuery.getResultList();
        
        if (clazz == ReportSafe.class) {
            for (ReportSafe report : (List<ReportSafe>) result) {
                report.maskIdentificationNumber();
            }
        }
    
        return result;
    };
    
    @Override // Variations 1
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult){ 
        return getAll(clazz, isVisible, offset, maxResult, null, null, null, null);
    }
    @Override // Variations 2
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType){
        return getAll(clazz, isVisible, null, null, orderBy, orderType, null, null);
    }
    @Override // Variations 3
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Date fromDate, Date toDate){
        return getAll(clazz, isVisible, null, null, null, null, fromDate, toDate);
    }
    @Override // Variations 1-2
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, String orderBy, String orderType){
        return getAll(clazz, isVisible, offset, maxResult, orderBy, orderType, null, null);
    }
    @Override // Variations 1-3
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, Integer offset, Integer maxResult, Date fromDate, Date toDate){
        return getAll(clazz, isVisible, offset, maxResult, null, null, fromDate, toDate);
    }
    @Override // Variations 2-3
    public <T> List<T> getAll(Class<T> clazz, Boolean isVisible, String orderBy, String orderType, Date fromDate, Date toDate){
        return getAll(clazz, isVisible, null, null, orderBy, orderType, fromDate, toDate);
    }
    
    // userUUID
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override // Variations 1-2-3
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
        
        if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else if (orderType.equals("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdAt")));
        }
        
        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("createdAt"), fromDate, toDate);
            Predicate userPredicate = criteriaBuilder.equal(root.get("patientUUID"), userUUID);
            Predicate visibilityPredicate = isVisible != null ? criteriaBuilder.equal(root.get("isVisible"), isVisible) : null;
            
            Predicate combinedPredicate = visibilityPredicate != null ? criteriaBuilder.and(datePredicate, userPredicate, visibilityPredicate) : criteriaBuilder.and(datePredicate, userPredicate);
            
            criteriaQuery.where(combinedPredicate);
        } else {
            // isVisible kontrolüne göre koşulların belirlenmesi
            Predicate userPredicate = criteriaBuilder.equal(root.get("patientUUID"), userUUID);
            Predicate visibilityPredicate = isVisible != null ? criteriaBuilder.equal(root.get("isVisible"), isVisible) : null;
            
            // isVisible olup olmadığına göre koşulların birleştirilmesi
            Predicate combinedPredicate = visibilityPredicate != null ? criteriaBuilder.and(userPredicate, visibilityPredicate) : userPredicate;
            
            criteriaQuery.where(combinedPredicate);
        }
        
        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);
        
        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }
        
        List<T> result = typedQuery.getResultList();
        
        if (clazz == ReportSafe.class) {
            for (ReportSafe report : (List<ReportSafe>) result) {
                report.maskIdentificationNumber();
            }
        }
        
        return result;
    }
    
    @Override // Variations 1
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult){ 
        return getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, null, null, null, null);
    }
    @Override // Variations 2
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy, String orderType){
        return getAllByUserUUID(clazz, isVisible, userUUID, null, null, orderBy, orderType, null, null);
    }
    @Override // Variations 3
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Date fromDate, Date toDate){
        return getAllByUserUUID(clazz, isVisible, userUUID, null, null, null, null, fromDate, toDate);
    }
    @Override // Variations 1-2
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, String orderBy, String orderType){
        return getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, orderBy, orderType, null, null);
    }
    @Override // Variations 1-3
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate){
        return getAllByUserUUID(clazz, isVisible, userUUID, offset, maxResult, null, null, fromDate, toDate);
    }
    @Override // Variations 2-3
    public <T> List<T> getAllByUserUUID(Class<T> clazz, Boolean isVisible, String userUUID, String orderBy, String orderType, Date fromDate, Date toDate){
        return getAllByUserUUID(clazz, isVisible, userUUID, null, null, orderBy, orderType, fromDate, toDate);
    }


    // laborantUUID
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override // Variations 1-2-3
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
    
        List<Predicate> predicates = new ArrayList<>();
    
        if (fromDate != null && toDate != null) {
            if (isVisible != null && isVisible) {
                predicates.add(criteriaBuilder.between(root.get("createdAt"), fromDate, toDate));
            } else {
                predicates.add(criteriaBuilder.between(root.get("createdAt"), fromDate, toDate));
            }
        }
    
        if (isVisible != null && isVisible) {
            predicates.add(criteriaBuilder.equal(root.get("isVisible"), isVisible));
        }
    
        if (laborantUUID != null && !laborantUUID.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("laborantUUID"), laborantUUID));
        }
    
        Predicate finalPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        criteriaQuery.where(finalPredicate);
    
        if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else if (orderType.equals("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdAt")));
        }
    
        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);
    
        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
    
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }
    
        List<T> result = typedQuery.getResultList();
    
        if (clazz == ReportSafe.class) {
            for (ReportSafe report : (List<ReportSafe>) result) {
                report.maskIdentificationNumber();
            }
        }
    
        return result;
    }

    @Override // Variations 1
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult){ 
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, null, null, null, null);
    }
    @Override // Variations 2
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy, String orderType){
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, null, null, orderBy, orderType, null, null);
    }
    @Override // Variations 3
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Date fromDate, Date toDate){
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, null, null, null, null, fromDate, toDate);
    }
    @Override // Variations 1-2
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType){
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, orderBy, orderType, null, null);
    }
    @Override // Variations 1-3
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate){
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, offset, maxResult, null, null, fromDate, toDate);
    }
    @Override // Variations 2-3
    public <T> List<T> getAllByLaborantUUID(Class<T> clazz, Boolean isVisible, String laborantUUID, String orderBy, String orderType, Date fromDate, Date toDate){
        return getAllByLaborantUUID(clazz, isVisible, laborantUUID, null, null, orderBy, orderType, fromDate, toDate);
    }


    // Get All by UserUUID and  LaborantUUID
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override // Variations 1-2-3
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);
    
        if (orderBy != null && !orderBy.isEmpty() && orderType != null && !orderType.isEmpty()) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else if (orderType.equals("desc")) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdAt")));
        }
    
        List<Predicate> predicates = new ArrayList<>();
    
        if (fromDate != null && toDate != null) {
            predicates.add(criteriaBuilder.between(root.get("createdAt"), fromDate, toDate));
        }
    
        if (isVisible != null && isVisible) {
            predicates.add(criteriaBuilder.equal(root.get("isVisible"), isVisible));
        }
    
        predicates.add(criteriaBuilder.equal(root.get("patientUUID"), userUUID));
        predicates.add(criteriaBuilder.equal(root.get("laborantUUID"), laborantUUID));
    
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
    
        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);
    
        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
    
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }
    
        List<T> result = typedQuery.getResultList();
    
        if (clazz == ReportSafe.class) {
            for (ReportSafe report : (List<ReportSafe>) result) {
                report.maskIdentificationNumber();
            }
        }
    
        return result;
    };
    @Override // Variations 1
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult){ 
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, null, null, null, null);
    }
    @Override // Variations 2
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, String orderBy, String orderType){
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, null, null, orderBy, orderType, null, null);
    }
    @Override // Variations 3
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Date fromDate, Date toDate){
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, null, null, null, null, fromDate, toDate);
    }
    @Override // Variations 1-2
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, String orderBy, String orderType){
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, orderBy, orderType, null, null);
    }
    @Override // Variations 1-3
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, Integer offset, Integer maxResult, Date fromDate, Date toDate){
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, offset, maxResult, null, null, fromDate, toDate);
    }
    @Override // Variations 2-3
    public <T> List<T> getAllByUserUUIDAndLaborantUUID(Class<T> clazz, Boolean isVisible, String userUUID, String laborantUUID, String orderBy, String orderType, Date fromDate, Date toDate){
        return getAllByUserUUIDAndLaborantUUID(clazz, isVisible, userUUID, laborantUUID, null, null, orderBy, orderType, fromDate, toDate);
    }

}
