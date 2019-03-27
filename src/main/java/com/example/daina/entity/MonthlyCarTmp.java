package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:12 2019/3/27
 */
public class MonthlyCarTmp {
    private String guid;
    private String monthlyCarId;
    private String monthlyId;
    private String parkingLotId;
    private String carLicense;
    private String startDate;
    private String endDate;
    private String remarks;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMonthlyCarId() {
        return monthlyCarId;
    }

    public void setMonthlyCarId(String monthlyCarId) {
        this.monthlyCarId = monthlyCarId;
    }

    public String getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(String monthlyId) {
        this.monthlyId = monthlyId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
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
}
