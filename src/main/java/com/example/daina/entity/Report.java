package com.example.daina.entity;

/**
 * @author: Daina
 * @description:
 * @date: Created in 21:46 2019/5/30
 */
public class Report {
    private Integer dailyId;
    private Integer monthlyAmount;
    private Integer amountCount;
    private String reportDate;

    public Integer getDailyId() {
        return dailyId;
    }

    public void setDailyId(Integer dailyId) {
        this.dailyId = dailyId;
    }

    public Integer getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(Integer monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public Integer getAmountCount() {
        return amountCount;
    }

    public void setAmountCount(Integer amountCount) {
        this.amountCount = amountCount;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
}
