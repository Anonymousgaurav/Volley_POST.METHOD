package com.example.volley_post.Model;

import java.io.Serializable;

public class Room implements Serializable {

    private Integer propertyID;
    private String propertyName;
    private String propertyLocation;
    private String propertyType;
    private Integer propertyStatus;
    private String propertyLogoURL;
    private Integer roomsCount;
    private String createdBy;
    private String createdOn;

    public Room(Integer propertyid, String propertyname, String propertylocation, String propertytype, Integer roomscount, String createdby)
    {
        this.propertyID = propertyid;
        this.propertyName =propertyname;
        this.propertyLocation = propertylocation;
        this.propertyType = propertytype;
        this.roomsCount = roomscount;
        this.createdBy = createdby;
    }

    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(Integer propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getPropertyLogoURL() {
        return propertyLogoURL;
    }

    public void setPropertyLogoURL(String propertyLogoURL) {
        this.propertyLogoURL = propertyLogoURL;
    }

    public Integer getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(Integer roomsCount) {
        this.roomsCount = roomsCount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }


}