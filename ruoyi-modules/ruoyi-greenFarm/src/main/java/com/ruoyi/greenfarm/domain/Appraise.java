package com.ruoyi.greenfarm.domain;

public class Appraise {
    private String appraiseid;
    private String customerid;
    private String itemid;
    private String time;
    private String details;
    private int grade;

    public String getAppraiseid() {
        return appraiseid;
    }

    public void setAppraiseid(String appraiseid) {
        this.appraiseid = appraiseid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
