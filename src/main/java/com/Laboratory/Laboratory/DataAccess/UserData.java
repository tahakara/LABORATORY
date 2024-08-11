package com.Laboratory.Laboratory.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IUserDataAccess;
import com.Laboratory.Laboratory.Entities.User;
import com.Laboratory.Laboratory.Entities.SafeEntities.UserSafe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class UserData implements IUserDataAccess{

    private EntityManager entityManager;

    @Autowired
    public UserData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(User user) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void update(User user) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void delete(User user) {
        // Session session = entityManager.unwrap(Session.class);
    }

    // -----*******************-----
    //      Get one user by xyz
    // -----*******************-----

    // id
    @Override
    public User getById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return user;
    }

    @Override
    public UserSafe getByIdSafe(Long id) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // identificationNumber
    @Override
    public User getByIdentificationNumber(String identificationNumber) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return user;
    }

    @Override
    public UserSafe getByIdentificationNumberSafe(String identificationNumber) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // email
    @Override
    public User getByEmail(String email) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return user;
    }

    @Override
    public UserSafe getByEmailSafe(String email) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // email and password
    @Override
    public User getByEmailAndPassword(String email, String password) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email), criteriaBuilder.equal(root.get("password"), password));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return user;
    }

    @Override
    public UserSafe getByEmailAndPasswordSafe(String email, String password) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email), criteriaBuilder.equal(root.get("password"), password));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // identificationNumber and password
    @Override
    public User getByIdentificationNumberAndPassword(String identificationNumber, String password) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber), criteriaBuilder.equal(root.get("password"), password));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();
        
        return user;
    }

    @Override
    public UserSafe getByIdentificationNumberAndPasswordSafe(String identificationNumber, String password) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("identificationNumber"), identificationNumber), criteriaBuilder.equal(root.get("password"), password));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // uuid
    @Override
    public User getByUUID(String uuid) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("uuid"), uuid));

        User user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return user;
    }

    @Override
    public UserSafe getByUUIDSafe(String uuid) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("uuid"), uuid));

        UserSafe user = session.createQuery(criteriaQuery).getSingleResultOrNull();

        if (user != null) {
            user.maskIdentificationNumber();
        }

        return user;
    }

    // -----*******************-----
    //      Get all users by xyz
    // -----*******************-----

    // All
    @Override
    public List<User> getAll(Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        
        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<User> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<UserSafe> getAllSafe(Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root);
         
        TypedQuery<UserSafe> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<UserSafe> result = typedQuery.getResultList();

        for (UserSafe user : result) {
            user.maskIdentificationNumberAndEmailAndSurname();
        }

        return result;
    }

    // name
    @Override
    public List<User> getAllByNames(String name, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
         
        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<User> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<UserSafe> getAllByNamesSafe(String name, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
         
        TypedQuery<UserSafe> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<UserSafe> result = typedQuery.getResultList();

        for (UserSafe user : result) {
            user.maskIdentificationNumberAndEmailAndSurname();
        }

        return result;
    }

    // surname
    @Override
    public List<User> getAllBySurnames(String surname, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("surname"), surname));
         
        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<User> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<UserSafe> getAllBySurnamesSafe(String surname, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("surname"), surname));
         
        TypedQuery<UserSafe> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<UserSafe> result = typedQuery.getResultList();

        for (UserSafe user : result) {
            user.maskIdentificationNumberAndEmailAndSurname();
        }

        return result;
    }

    // isVerified
    @Override
    public List<User> getAllByIsVerified(Boolean isVerified, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isVerified"), isVerified));
         
        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<User> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<UserSafe> getAllByIsVerifiedSafe(Boolean isVerified, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isVerified"), isVerified));
         
        TypedQuery<UserSafe> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<UserSafe> result = typedQuery.getResultList();

        for (UserSafe user : result) {
            user.maskIdentificationNumberAndEmailAndSurname();
        }

        return result;
    }

    // name and surname
    @Override
    public List<User> getAllByNameAndSurname(String name, String surname, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name), criteriaBuilder.equal(root.get("surname"), surname));
         
        TypedQuery<User> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<User> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<UserSafe> getAllByNameAndSurnameSafe(String name, String surname, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserSafe> criteriaQuery = criteriaBuilder.createQuery(UserSafe.class);
        Root<UserSafe> root = criteriaQuery.from(UserSafe.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name), criteriaBuilder.equal(root.get("surname"), surname));
         
        TypedQuery<UserSafe> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<UserSafe> result = typedQuery.getResultList();

        for (UserSafe user : result) {
            user.maskIdentificationNumberAndEmailAndSurname();
        }

        return result;
    }
}
