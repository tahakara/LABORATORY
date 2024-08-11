package com.Laboratory.Laboratory.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IPhotoDataAccess;
import com.Laboratory.Laboratory.Entities.Photo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
public class PhotoData implements IPhotoDataAccess{

    private EntityManager entityManager;

    @Autowired
    public PhotoData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Photo photo) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void update(Photo photo) {
        // Session session = entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void delete(Photo photo) {
        // Session session = entityManager.unwrap(Session.class);
    }



    // -----*******************-----
    //      Get one photo by xyz
    // -----*******************-----

    @Override
    public Photo getById(Long id) {
        Session session = entityManager.unwrap(Session.class);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = criteriaBuilder.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        Photo photo = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return photo;
    }

    @Override
    public Photo getByUUID(String uuid) {
        Session session = entityManager.unwrap(Session.class);
        
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = criteriaBuilder.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("uuid"), uuid));

        Photo photo = session.createQuery(criteriaQuery).getSingleResultOrNull();

        return photo;
    }

    // -----*******************-----
    //      Get all photos by xyz
    // -----*******************-----

    @Override
    public List<Photo> getAll(Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = criteriaBuilder.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);
        criteriaQuery.select(root);

        TypedQuery<Photo> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<Photo> result = typedQuery.getResultList();

        return result;
    }

    @Override
    public List<Photo> getAllByIsVisible(Boolean isVisible, Integer offset, Integer maxResult) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = criteriaBuilder.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("isVisible"), isVisible));

        TypedQuery<Photo> typedQuery = session.createQuery(criteriaQuery);

        if (offset != null && offset > 0) {
            typedQuery.setFirstResult((offset - 1) * maxResult);
        }
        if (maxResult != null && maxResult > 0) {
            typedQuery.setMaxResults(maxResult);
        }

        List<Photo> result = typedQuery.getResultList();
        
        return result;
    }

}
