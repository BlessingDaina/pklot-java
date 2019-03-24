package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 13:15 2019/3/24
 */
public class SpecialCar {
    private String specialCarId;
    private String parkingLotId;
    private Integer specialType;
    private String categoryId;
    private String carLicense;
    private Integer restrictType;
    private String startDate;
    private String endDate;
    private String remarks;
    private Integer status;

    public String getSpecialCarId() {
        return specialCarId;
    }

    public void setSpecialCarId(String specialCarId) {
        this.specialCarId = specialCarId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getSpecialType() {
        return specialType;
    }

    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getRestrictType() {
        return restrictType;
    }

    public void setRestrictType(Integer restrictType) {
        this.restrictType = restrictType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
