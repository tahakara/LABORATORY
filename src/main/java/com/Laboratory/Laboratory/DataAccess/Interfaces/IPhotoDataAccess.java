package com.Laboratory.Laboratory.DataAccess.Interfaces;

import com.Laboratory.Laboratory.Entities.Photo;
import java.util.List;

public interface IPhotoDataAccess {
    
    void add(Photo photo);
    void update(Photo photo);
    void delete(Photo photo);
    
    // Unique queries
    Photo getById(Long id);
    Photo getByUUID(String uuid);
    
    // Get all photos by xyz
    List<Photo> getAll(Integer offset, Integer maxResult);
    List<Photo> getAllByIsVisible(Boolean isVisible, Integer offset, Integer maxResult);
}
