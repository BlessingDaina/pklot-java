package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 9:56 2019/4/10
 */
public class ParkingRecord {
    private String recordId;
    private String parkingLotId;
    private String parkingType;
    private Integer status;
    private Integer dateYear;
    private Integer dateMonth;
    private Integer dateDay;
    private String carId;
    private Integer carType;
    private String carLicense;
    private String entranceId;
    private String entranceTime;
    private String entrancePhoto;
    private String exitId;
    private String exitPhoto;
    private Integer freeType;
    private String freeReason;
    private Integer amountTotal;
    private Integer amountFinal;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Integer getDateDay() {
        return dateDay;
    }

    public void setDateDay(Integer dateDay) {
        this.dateDay = dateDay;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(String entranceId) {
        this.entranceId = entranceId;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getEntrancePhoto() {
        return entrancePhoto;
    }

    public void setEntrancePhoto(String entrancePhoto) {
        this.entrancePhoto = entrancePhoto;
    }

    public String getExitId() {
        return exitId;
    }

    public void setExitId(String exitId) {
        this.exitId = exitId;
    }

    public String getExitPhoto() {
        return exitPhoto;
    }

    public void setExitPhoto(String exitPhoto) {
        this.exitPhoto = exitPhoto;
    }

    public Integer getFreeType() {
        return freeType;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public String getFreeReason() {
        return freeReason;
    }

    public void setFreeReason(String freeReason) {
        this.freeReason = freeReason;
    }

    public Integer getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Integer amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Integer getAmountFinal() {
        return amountFinal;
    }

    public void setAmountFinal(Integer amountFinal) {
        this.amountFinal = amountFinal;
    }
}
