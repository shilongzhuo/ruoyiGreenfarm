package com.ruoyi.greenfarm.domain;

public class CartItem {
    private String itemid;
    private String cartid;
    private String customeid;
    private int number;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getCustomeid() {
        return customeid;
    }

    public void setCustomeid(String customeid) {
        this.customeid = customeid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
