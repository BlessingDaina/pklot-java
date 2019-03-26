package com.example.daina.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 17:33 2019/3/25
 */
public class Monthly {
    private String monthlyId;
    private String parkingLotId;
    private String roomNumber;
    private String ownerName;
    private String phone;
    private Integer monthlyType;
    private String timeRuleId;
    private String carLicense;
    private Integer occupyNum;
    private BigDecimal monthlyAmount;
    private String monthlySpace;
    private String categoryId;
    private String remarks;
    private String occupyList;

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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMonthlyType() {
        return monthlyType;
    }

    public void setMonthlyType(Integer monthlyType) {
        this.monthlyType = monthlyType;
    }

    public String getTimeRuleId() {
        return timeRuleId;
    }

    public void setTimeRuleId(String timeRuleId) {
        this.timeRuleId = timeRuleId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getOccupyNum() {
        return occupyNum;
    }

    public void setOccupyNum(Integer occupyNum) {
        this.occupyNum = occupyNum;
    }

    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public String getMonthlySpace() {
        return monthlySpace;
    }

    public void setMonthlySpace(String monthlySpace) {
        this.monthlySpace = monthlySpace;
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

    public String getOccupyList() {
        return occupyList;
    }

    public void setOccupyList(String occupyList) {
        this.occupyList = occupyList;
    }
}
