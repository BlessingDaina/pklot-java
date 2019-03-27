package com.example.daina.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:41 2019/3/27
 */
public class MonthlyExtend {
    private String extendId;
    private String parkingLotId;
    private String monthlyId;
    private String extendDate;
    private Integer monthlyType;
    private Integer expdateType;
    private String expdateStart;
    private String expdateEnd;
    private BigDecimal amountReceivable;
    private BigDecimal amountCollected;
    private String guid;

    public String getExtendId() {
        return extendId;
    }

    public void setExtendId(String extendId) {
        this.extendId = extendId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getMonthlyId() {
        return monthlyId;
    }

    public void setMonthlyId(String monthlyId) {
        this.monthlyId = monthlyId;
    }


    public Integer getMonthlyType() {
        return monthlyType;
    }

    public void setMonthlyType(Integer monthlyType) {
        this.monthlyType = monthlyType;
    }

    public Integer getExpdateType() {
        return expdateType;
    }

    public void setExpdateType(Integer expdateType) {
        this.expdateType = expdateType;
    }

    public BigDecimal getAmountReceivable() {
        return amountReceivable;
    }

    public void setAmountReceivable(BigDecimal amountReceivable) {
        this.amountReceivable = amountReceivable;
    }

    public BigDecimal getAmountCollected() {
        return amountCollected;
    }

    public void setAmountCollected(BigDecimal amountCollected) {
        this.amountCollected = amountCollected;
    }

    public String getExtendDate() {
        return extendDate;
    }

    public void setExtendDate(String extendDate) {
        this.extendDate = extendDate;
    }

    public String getExpdateStart() {
        return expdateStart;
    }

    public void setExpdateStart(String expdateStart) {
        this.expdateStart = expdateStart;
    }

    public String getExpdateEnd() {
        return expdateEnd;
    }

    public void setExpdateEnd(String expdateEnd) {
        this.expdateEnd = expdateEnd;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
