package com.example.daina.entity;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:22 2019/4/1
 */
public class SentryBox {
    private String sentryBoxId;
    private String parkingLotId;
    private String passagewayId;
    private String sentryBoxName;
    private String dutyUserId;
    private List<Driveway> driveways;

    public String getSentryBoxId() {
        return sentryBoxId;
    }

    public void setSentryBoxId(String sentryBoxId) {
        this.sentryBoxId = sentryBoxId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getPassagewayId() {
        return passagewayId;
    }

    public void setPassagewayId(String passagewayId) {
        this.passagewayId = passagewayId;
    }

    public String getSentryBoxName() {
        return sentryBoxName;
    }

    public void setSentryBoxName(String sentryBoxName) {
        this.sentryBoxName = sentryBoxName;
    }

    public String getDutyUserId() {
        return dutyUserId;
    }

    public void setDutyUserId(String dutyUserId) {
        this.dutyUserId = dutyUserId;
    }

    public List<Driveway> getDriveways() {
        return driveways;
    }

    public void setDriveways(List<Driveway> driveways) {
        this.driveways = driveways;
    }
}
