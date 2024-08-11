package com.Laboratory.Laboratory.DataAccess;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IAdminDataAccess;
import com.Laboratory.Laboratory.Entities.Admin;
import com.Laboratory.Laboratory.Entities.SafeEntities.AdminSafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class AdminData implements IAdminDataAccess {
    private EntityManager entityManager;

    @Autowired
    public AdminData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   @Override
   @Transactional
    public void add(Admin admin) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void update(Admin admin) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void delete(Admin admin) {
        // Session session = entityManager.unwrap(Session.class);
    }

    // -----*******************----- 
    //      Get one admin by xyz 
    // -----*******************----- 
    @Override
    @Transactional
    public Boolean updateAdmin(Admin admin) {
        try {
            Session session = entityManager.unwrap(Session.class);
            session.merge(admin);
            return true;

        } catch (Exception e) {
            return false;
        }
    }



    // -----*******************----- 
    //      Get one admin by xyz 
    // -----*******************----- 


    @Override
    public <T> T getById(Class<T> clazz, Long id) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }


    // hospitalId
    @Override
    public <T> T getByHospitalID(Class<T> clazz, String hospitalId) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("hospitalId"), hospitalId));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    // identificationNumber
    @Override
    public <T> T getByIdentificationNumber(Class<T> clazz, String identificationNumber) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    // email
    @Override
    public <T> T getByEmail(Class<T> clazz, String email) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    

    // uuid
    @Override
    public <T> T getByUUID(Class<T> clazz, String uuid) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("uuid"), uuid));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    // email and password
    @Override
    public <T> T getByEmailAndPassword(Class<T> clazz, String email, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("email"), email), criteriaBuilder.equal(root.get("password"), password)));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    // hospitalId and password
    @Override
    public <T> T getByHospitalIDAndPassword(Class<T> clazz, String hospitalId, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("hospitalId"), hospitalId), criteriaBuilder.equal(root.get("password"), password)));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    // identificationNumber and password
    @Override
    public <T> T getByIdentificationNumberAndPassword(Class<T> clazz, String identificationNumber, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber), criteriaBuilder.equal(root.get("password"), password)));

        T admin = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (admin != null && clazz == AdminSafe.class) {
            ((AdminSafe) admin).maskIdentificationNumber();
        }

        return admin;
    }

    
    // -----*******************----- 
    //      Get all admins by xyz 
    // -----*******************----- 

    // All admins
    @Override
    public <T> List<T> getAll(Class<T> clazz , Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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

    // All admins by name
    @Override
    public <T> List<T> getAllByName(Class<T> clazz, String name, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%" + name + "%"));

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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

    // All admins by surname
    @Override
    // make single where funv
    public <T> List<T> getAllBySurname(Class<T> clazz, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        // use only one where function 
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("surname"), "%" + surname + "%"));

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }

        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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

    // All admins by isVerified
    @Override
    public <T> List<T> getAllByVerified(Class<T> clazz, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isVerified"), isVerified));

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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


    // All admins by name and surname
    @Override
    public <T> List<T> getAllByNameAndSurname(Class<T> clazz, String name, String surname, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate surnamePredicate = criteriaBuilder.like(root.get("surname"), "%" + surname + "%");
        criteriaQuery.select(root).where(criteriaBuilder.and(namePredicate, surnamePredicate));

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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


    // All admins by name and surname and isVerified
    @Override
    public <T> List<T> getAllByNameAndSurnameAndVerified(Class<T> clazz, String name, String surname, Boolean isVerified, Integer offset, Integer maxResult, String orderBy, String orderType, Date fromDate, Date toDate) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
        Predicate surnamePredicate = criteriaBuilder.like(root.get("surname"), "%" + surname + "%");
        Predicate isVerifiedPredicate = criteriaBuilder.equal(root.get("isVerified"), isVerified);
        criteriaQuery.select(root).where(criteriaBuilder.and(namePredicate, surnamePredicate, isVerifiedPredicate));

        if (fromDate != null && toDate != null) {
            Predicate datePredicate = criteriaBuilder.between(root.get("date"), fromDate, toDate);
            criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), datePredicate));
        }

        if (orderBy != null && orderType != null) {
            if (orderType.equals("asc")) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
            }
        }

        TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<T> admins = typedQuery.getResultList();

        if (clazz == AdminSafe.class) {
            for (T admin : admins) {
                ((AdminSafe) admin).maskIdentificationNumber();
            }
        }

        return admins;
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
}
