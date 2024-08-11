package com.Laboratory.Laboratory.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.Laboratory.Laboratory.DataAccess.Interfaces.IPhotoDataAccess;
import com.Laboratory.Laboratory.Entities.Photo;
import com.Laboratory.Laboratory.Services.Interfaces.IPhotoService;

@Service
public class PhotoManager implements IPhotoService{

    private IPhotoDataAccess photoDataAccess;

    @Autowired
    public PhotoManager(IPhotoDataAccess photoDataAccess) {
        this.photoDataAccess = photoDataAccess;
    }

    @Override
    @Transactional
    public void add(Photo photo) {
   
        this.photoDataAccess.add(photo);
    }

    @Override
    @Transactional
    public void update(Photo photo) {
   
        this.photoDataAccess.update(photo);
    }

    @Override
    @Transactional
    public void delete(Photo photo) {
   
        this.photoDataAccess.delete(photo);
    }

    // -----*******************-----
    //      Get one photo by xyz
    // -----*******************-----

    @Override
    public Photo getById(Long id) {
   
        return this.photoDataAccess.getById(id);
    }

    @Override
    public Photo getByUUID(String uuid) {
   
        return this.photoDataAccess.getByUUID(uuid);
    }

    // -----*******************-----
    //      Get all photos by xyz
    // -----*******************-----

    @Override
    public List<Photo> getAll(Integer offset, Integer maxResult) {
   
        return this.photoDataAccess.getAll(offset, maxResult);
    }

    @Override
    public List<Photo> getAllByIsVisible(Boolean isVisible, Integer offset, Integer maxResult) {
   
        return this.photoDataAccess.getAllByIsVisible(isVisible, offset, maxResult);
    }


}
