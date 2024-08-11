package com.Laboratory.Laboratory.DataAccess;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.DataAccess.Interfaces.ILaborantDataAccess;
import com.Laboratory.Laboratory.Entities.Laborant;
import com.Laboratory.Laboratory.Entities.SafeEntities.LaborantSafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class LaborantData implements ILaborantDataAccess{

    private EntityManager entityManager;

    @Autowired
    public LaborantData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Laborant laborant) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void update(Laborant laborant) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void delete(Laborant laborant) {
        // Session session = entityManager.unwrap(Session.class);
    }

    // -----*******************----- 
    //        Insert Laborant 
    // -----*******************----- 

    @Override
    @Transactional
    public Boolean insertNewLaborant(Laborant laborant) {
        try {
            Session session = entityManager.unwrap(Session.class);        

            NativeQuery<String> query = session.createNativeQuery("SELECT GEN_RANDOM_UUID() as uuid", String.class);
            NativeQuery<Timestamp> query2 = session.createNativeQuery("SELECT CURRENT_TIMESTAMP as timestamp", Timestamp.class);
            
            String uuid = query.getSingleResult();
            Timestamp date = query2.getSingleResult();
            laborant.setUuid(uuid);
            laborant.setCreatedAt(date);
            laborant.setUpdatedAt(date);

            session.persist(laborant);
            return true;
        
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }


    // -----*******************----- 
    //        Update Laborant 
    // -----*******************----- 
    @Override
    @Transactional
    public Boolean updateLaborant(Laborant laborant) {
        try {
            Session session = entityManager.unwrap(Session.class);
            laborant.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            session.merge(laborant);
            return true;
        
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }


    // -----*******************----- 
    //        Delete Laborant 
    // -----*******************----- 
    @Override
    @Transactional
    public Boolean deleteLaborant(Laborant laborant) {
        try {
            laborant.maskAll();
            laborant.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

            Session session = entityManager.unwrap(Session.class);
            session.merge(laborant);
            return true;
        
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }


    // -----*******************----- 
    //      Get one Laborant by xyz 
    // -----*******************----- 

    // id
    @Override
    public <T> T getById(Class<T> clazz, Long id) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("id"), id));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }


        return result;
    }
    
    // hospitalId
    @Override
    public <T> T getByHospitalID(Class<T> clazz, String hospitalId) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("hospitalId"), hospitalId));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }
        
        return result;
    }

    // identificationNumber
    @Override
    public <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("identificationNumber"), identificationNumber));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }
        
        return result;
    }

    
    // email
    @Override
    public <T> T getByEmail(Class<T> clazz, String email) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("email"), email));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }

        return result;
    }

   // uuid
    @Override
    public <T> T getByUUID(Class<T> clazz, String uuid) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("uuid"), uuid));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }

        return result;
    }

    // email and password
    @Override
    public <T> T getByEmailAndPassword(Class<T> clazz, String email, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("email"), email), builder.equal(root.get("password"), password));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }
        
        return result;
    }

    // hospitalId and password
    @Override
    public <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("hospitalId"), hospitalId), builder.equal(root.get("password"), password));

        T result = session.createQuery(query).getSingleResultOrNull();

        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }
        
        return result;
    }

    // identificationNumber and password
    @Override
    public <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.equal(root.get("identificationNumber"), identificationNumber), builder.equal(root.get("password"), password));

        T result = session.createQuery(query).getSingleResultOrNull();
        
        if (clazz == LaborantSafe.class && result != null) {
            ((LaborantSafe) result).maskIdentificationNumber();
        }

        return result;
    }
    
   

    



    // -----*******************-----
    //      Get all laborants by xyz
    // -----*******************-----

    // All
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult) {
        return getAll(clazz, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType) {
        return getAll(clazz, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAll(Class<T> clazz , Date fromDate, Date toDate) {
        return getAll(clazz, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAll(clazz, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAll(clazz, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAll(Class<T> clazz , String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAll(clazz, null, null, orderBy, orderType, fromDate, toDate);
    }
    
    // Name
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%" + name + "%"));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult) {
        return getAllByName(clazz, name, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType) {
        return getAllByName(clazz, name, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByName(Class<T> clazz, String name, Date fromDate, Date toDate) {
        return getAllByName(clazz, name, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByName(clazz, name, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByName(clazz, name, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByName(Class<T> clazz, String name, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByName(clazz, name, null, null, orderBy, orderType, fromDate, toDate);
    }
    // Surames
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("surname"), "%" + surname + "%"));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult) {
        return getAllBySurname(clazz, surname, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType) {
        return getAllBySurname(clazz, surname, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Date fromDate, Date toDate) {
        return getAllBySurname(clazz, surname, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllBySurname(clazz, surname, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllBySurname(clazz, surname, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllBySurname(clazz, surname, null, null, orderBy, orderType, fromDate, toDate);
    }


    // isVerified
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isVerified"), isVerified));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult) {
        return getAllByVerified(clazz, isVerified, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType) {
        return getAllByVerified(clazz, isVerified, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Date fromDate, Date toDate) {
        return getAllByVerified(clazz, isVerified, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByVerified(clazz, isVerified, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByVerified(clazz, isVerified, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByVerified(clazz, isVerified, null, null, orderBy, orderType, fromDate, toDate);
    }

    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isActiveWork"), isActiveWork));

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
        
    }

    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult) {
        return getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType) {
        return getAllByIsActiveWork(clazz, isActiveWork, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Date fromDate, Date toDate) {
        return getAllByIsActiveWork(clazz, isActiveWork, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByIsActiveWork(clazz, isActiveWork, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByIsActiveWork(Class<T> clazz, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByIsActiveWork(clazz, isActiveWork, null, null, orderBy, orderType, fromDate, toDate);
    }


    // Name and Surname
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%"), criteriaBuilder.like(root.get("surname"), "%" + surname + "%")));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult) {
        return getAllByNameAndSurname(clazz, name, surname, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType) {
        return getAllByNameAndSurname(clazz, name, surname, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Date fromDate, Date toDate) {
        return getAllByNameAndSurname(clazz, name, surname, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByNameAndSurname(clazz, name, surname, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByNameAndSurname(clazz, name, surname, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByNameAndSurname(clazz, name, surname, null, null, orderBy, orderType, fromDate, toDate);
    }


    // Name And Surname And Verified
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%"), criteriaBuilder.like(root.get("surname"), "%" + surname + "%"), criteriaBuilder.equal(root.get("isVerified"), isVerified)));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerified(clazz, name, surname, isVerified, null, null, orderBy, orderType, fromDate, toDate);
    }


    // Get All By Name And Surname And IsActiveWork
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%"), criteriaBuilder.like(root.get("surname"), "%" + surname + "%"), criteriaBuilder.equal(root.get("isActiveWork"), isActiveWork)));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult) {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, String orderBy, String orderType)  {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndIsActiveWork(clazz, name, surname, isActiveWork, null, null, orderBy, orderType, fromDate, toDate);
    }


    // Name And Surname And Verified And IsActiveWork
    @SuppressWarnings("unchecked") // Suppressing unchecked cast warning
    @Override
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + name + "%"), criteriaBuilder.like(root.get("surname"), "%" + surname + "%"), criteriaBuilder.equal(root.get("isVerified"), isVerified), criteriaBuilder.equal(root.get("isActiveWork"), isActiveWork)));

        if (orderBy != null && !orderBy.isEmpty()) {
            if (orderType != null && !orderType.isEmpty()) {
                if (orderType.equals("asc")) {
                    criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
                } else if (orderType.equals("desc")) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
                }
            }
        }

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> result = typedQuery.getResultList();

        if (clazz == LaborantSafe.class ) {
            for (LaborantSafe laborant : (List<LaborantSafe>) result) {
                laborant.maskIdentificationNumber();
            }
        }

        return result;
    }

    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, null, null, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, null, null, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, null, null, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, String orderBy, String orderType) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, orderBy, orderType, null, null);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, Integer offset, Integer maxResult, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, offset, maxResult, null, null, fromDate, toDate);
    }
    public <T> List<T> getAllByNameAndSurnameAndVerifiedAndIsActiveWork(Class<T> clazz, String name, String surname, Boolean isVerified, Boolean isActiveWork, String orderBy, String orderType, Date fromDate, Date toDate) {
        return getAllByNameAndSurnameAndVerifiedAndIsActiveWork(clazz, name, surname, isVerified, isActiveWork, null, null, orderBy, orderType, fromDate, toDate);
    }
}
