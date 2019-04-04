package com.example.daina.entity;

import java.math.BigDecimal;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:27 2019/3/17
 */
public class ParkingLot {
    private String parkingLotId;
    private Integer parkingLotType;
    private String parkingLotName;
    private String parkingLotCode;
    private BigDecimal lon;
    private BigDecimal lat;
    private Integer isSub;
    private String parentParkingLotId;
    private Integer paidFreeTime;
    private Integer monthlyOver;
    private Integer monthlyFreeTime;
    private Integer isFreeParking;
    private String address;
    private Integer totalPlaces;
    private Integer emptyPlaces;
    private Integer isOutdoor;
    private Integer isSearchable;
    private Integer isTempParking;
    private Integer isZeroEnter;
    private BigDecimal defaultPrice;
    private Integer isExitAuto;
    private String freeStartTime;
    private String freeEndTime;
    private Integer delFlag;
    private String unitId;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getParkingLotType() {
        return parkingLotType;
    }

    public void setParkingLotType(Integer parkingLotType) {
        this.parkingLotType = parkingLotType;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public String getParkingLotCode() {
        return parkingLotCode;
    }

    public void setParkingLotCode(String parkingLotCode) {
        this.parkingLotCode = parkingLotCode;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public Integer getIsSub() {
        return isSub;
    }

    public void setIsSub(Integer isSub) {
        this.isSub = isSub;
    }

    public String getParentParkingLotId() {
        return parentParkingLotId;
    }

    public void setParentParkingLotId(String parentParkingLotId) {
        this.parentParkingLotId = parentParkingLotId;
    }

    public Integer getPaidFreeTime() {
        return paidFreeTime;
    }

    public void setPaidFreeTime(Integer paidFreeTime) {
        this.paidFreeTime = paidFreeTime;
    }

    public Integer getMonthlyOver() {
        return monthlyOver;
    }

    public void setMonthlyOver(Integer monthlyOver) {
        this.monthlyOver = monthlyOver;
    }

    public Integer getMonthlyFreeTime() {
        return monthlyFreeTime;
    }

    public void setMonthlyFreeTime(Integer monthlyFreeTime) {
        this.monthlyFreeTime = monthlyFreeTime;
    }

    public Integer getIsFreeParking() {
        return isFreeParking;
    }

    public void setIsFreeParking(Integer isFreeParking) {
        this.isFreeParking = isFreeParking;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalPlaces() {
        return totalPlaces;
    }

    public void setTotalPlaces(Integer totalPlaces) {
        this.totalPlaces = totalPlaces;
    }

    public Integer getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(Integer emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }

    public Integer getIsOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(Integer isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    public Integer getIsSearchable() {
        return isSearchable;
    }

    public void setIsSearchable(Integer isSearchable) {
        this.isSearchable = isSearchable;
    }

    public Integer getIsTempParking() {
        return isTempParking;
    }

    public void setIsTempParking(Integer isTempParking) {
        this.isTempParking = isTempParking;
    }

    public Integer getIsZeroEnter() {
        return isZeroEnter;
    }

    public void setIsZeroEnter(Integer isZeroEnter) {
        this.isZeroEnter = isZeroEnter;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Integer getIsExitAuto() {
        return isExitAuto;
    }

    public void setIsExitAuto(Integer isExitAuto) {
        this.isExitAuto = isExitAuto;
    }

    public String getFreeStartTime() {
        return freeStartTime;
    }

    public void setFreeStartTime(String freeStartTime) {
        this.freeStartTime = freeStartTime;
    }

    public String getFreeEndTime() {
        return freeEndTime;
    }

    public void setFreeEndTime(String freeEndTime) {
        this.freeEndTime = freeEndTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}
