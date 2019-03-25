package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 15:32 2019/3/25
 */
public class TempCar {
    private String tempCarId;
    private String parkingLotId;
    private String carLicense;
    private String categoryId;
    private String remarks;

    public String getTempCarId() {
        return tempCarId;
    }

    public void setTempCarId(String tempCarId) {
        this.tempCarId = tempCarId;
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
