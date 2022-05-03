package com.ruoyi.greenfarm.domain;

import javax.xml.crypto.Data;

public class OrderStatus {
    private String orderid;
    private Data timestamp;
    private int status;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Data getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Data timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
