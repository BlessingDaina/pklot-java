package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:42 2019/3/23
 */
public class Driveway {
    private String drivewayId;
    private String parkingLotId;
    private String drivewayName;
    private String drivewayType;
    private String nextParkingLotId;
    private Integer screenType;
    private String screenParams;
    private Integer isSub;
    private Integer noEntrance;
    private Integer openType;
    private Integer monthlyAutoOpen;
    private Integer tempAutoOpen;
    private Integer isAutoSound;
    private Integer isShowEmpty;
    private Integer dayStart;
    private Integer dayVolume;
    private Integer nightStart;
    private Integer nightVolume;
    private Integer drivewayStatus;

    public String getDrivewayId() {
        return drivewayId;
    }

    public void setDrivewayId(String drivewayId) {
        this.drivewayId = drivewayId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getDrivewayName() {
        return drivewayName;
    }

    public void setDrivewayName(String drivewayName) {
        this.drivewayName = drivewayName;
    }

    public String getDrivewayType() {
        return drivewayType;
    }

    public void setDrivewayType(String drivewayType) {
        this.drivewayType = drivewayType;
    }

    public String getNextParkingLotId() {
        return nextParkingLotId;
    }

    public void setNextParkingLotId(String nextParkingLotId) {
        this.nextParkingLotId = nextParkingLotId;
    }

    public Integer getScreenType() {
        return screenType;
    }

    public void setScreenType(Integer screenType) {
        this.screenType = screenType;
    }

    public String getScreenParams() {
        return screenParams;
    }

    public void setScreenParams(String screenParams) {
        this.screenParams = screenParams;
    }

    public Integer getIsSub() {
        return isSub;
    }

    public void setIsSub(Integer isSub) {
        this.isSub = isSub;
    }

    public Integer getNoEntrance() {
        return noEntrance;
    }

    public void setNoEntrance(Integer noEntrance) {
        this.noEntrance = noEntrance;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public Integer getMonthlyAutoOpen() {
        return monthlyAutoOpen;
    }

    public void setMonthlyAutoOpen(Integer monthlyAutoOpen) {
        this.monthlyAutoOpen = monthlyAutoOpen;
    }

    public Integer getTempAutoOpen() {
        return tempAutoOpen;
    }

    public void setTempAutoOpen(Integer tempAutoOpen) {
        this.tempAutoOpen = tempAutoOpen;
    }

    public Integer getIsAutoSound() {
        return isAutoSound;
    }

    public void setIsAutoSound(Integer isAutoSound) {
        this.isAutoSound = isAutoSound;
    }

    public Integer getIsShowEmpty() {
        return isShowEmpty;
    }

    public void setIsShowEmpty(Integer isShowEmpty) {
        this.isShowEmpty = isShowEmpty;
    }

    public Integer getDayStart() {
        return dayStart;
    }

    public void setDayStart(Integer dayStart) {
        this.dayStart = dayStart;
    }

    public Integer getDayVolume() {
        return dayVolume;
    }

    public void setDayVolume(Integer dayVolume) {
        this.dayVolume = dayVolume;
    }

    public Integer getNightStart() {
        return nightStart;
    }

    public void setNightStart(Integer nightStart) {
        this.nightStart = nightStart;
    }

    public Integer getNightVolume() {
        return nightVolume;
    }

    public void setNightVolume(Integer nightVolume) {
        this.nightVolume = nightVolume;
    }

    public Integer getDrivewayStatus() {
        return drivewayStatus;
    }

    public void setDrivewayStatus(Integer drivewayStatus) {
        this.drivewayStatus = drivewayStatus;
    }
}
