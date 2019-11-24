package com.example1.demo1;

import javax.persistence.*;

@Entity
@Table(name = "dustbin")
@Access(value=AccessType.PROPERTY)
public class Dustbin {
    public int id;
    public long areaCode;
    public double longitude;
    public double latitude;
    public String address;
    public String fillStatus;
    public String fireStatus;
    public String decomStatus;
    public Long ultraSonic;
    public Long mq2;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "area_code", nullable = false)
    public long getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(long areaCode) {
        this.areaCode = areaCode;
    }

    @Column(name = "longitude", nullable = false)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "latitude",nullable = false)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "filling_status")
    public String getFillStatus() {
        return fillStatus;
    }

    public void setFillStatus(String fillStatus) {
        this.fillStatus = fillStatus;
    }

    @Column(name = "fire_status")
    public String getFireStatus() {
        return fireStatus;
    }

    public void setFireStatus(String fireStatus) {
        this.fireStatus = fireStatus;
    }

    @Column(name = "decomp_status")
    public String getDecomStatus() {
        return decomStatus;
    }

    public void setDecomStatus(String decomStatus) {
        this.decomStatus = decomStatus;
    }

    @Column(name = "ultrasensor")
    public Long getUltraSonic() {
        return ultraSonic;
    }

    public void setUltraSonic(Long ultraSonic) {
        this.ultraSonic = ultraSonic;
    }

    @Column(name = "mq2")
    public Long getMq2() {
        return mq2;
    }

    public void setMq2(Long mq2) {
        this.mq2 = mq2;
    }
}
