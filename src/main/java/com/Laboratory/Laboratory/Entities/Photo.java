package com.Laboratory.Laboratory.Entities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @Column(name = "photo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_uuid", unique = true)
    private String uuid;

    @Column(name = "photo_is_visible")
    private Boolean isVisible;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updateedAt;



    public Photo(Long id, String uuid, Boolean isVisible, Timestamp createdAt, Timestamp updateedAt) {
        this.id = id;
        this.uuid = uuid;
        this.isVisible = isVisible;
        this.createdAt = createdAt;
        this.updateedAt = updateedAt;
    }

    // Default constructor
    public Photo() {
    }

    // Region Getters and Setters
    // ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    // UUID
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // isVisible
    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    // createdAt
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // updateedAt
    public Timestamp getUpdateedAt() {
        return updateedAt;
    }

    public void setUpdateedAt(Timestamp updateedAt) {
        this.updateedAt = updateedAt;
    }
}
