package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 11:01 2019/3/26
 */
public class MonthlyOccupy {
    private String occupyId;
    private String monthlyId;
    private String parkingLotId;
    private Integer occupyType;
    private Integer occupyNum;

    public String getOccupyId() {
        return occupyId;
    }

    public void setOccupyId(String occupyId) {
        this.occupyId = occupyId;
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

    public Integer getOccupyType() {
        return occupyType;
    }

    public void setOccupyType(Integer occupyType) {
        this.occupyType = occupyType;
    }

    public Integer getOccupyNum() {
        return occupyNum;
    }

    public void setOccupyNum(Integer occupyNum) {
        this.occupyNum = occupyNum;
    }
}
