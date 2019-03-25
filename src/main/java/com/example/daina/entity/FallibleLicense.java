package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 14:12 2019/3/25
 */
public class FallibleLicense {
    private String fallibleId;
    private String parkingLotId;
    private String errorLicense;
    private String trueLicense;
    private String remarks;

    public String getFallibleId() {
        return fallibleId;
    }

    public void setFallibleId(String fallibleId) {
        this.fallibleId = fallibleId;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getErrorLicense() {
        return errorLicense;
    }

    public void setErrorLicense(String errorLicense) {
        this.errorLicense = errorLicense;
    }

    public String getTrueLicense() {
        return trueLicense;
    }

    public void setTrueLicense(String trueLicense) {
        this.trueLicense = trueLicense;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
