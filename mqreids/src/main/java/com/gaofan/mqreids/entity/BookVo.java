package com.gaofan.mqreids.entity;

/**
 * @author gaofan
 * @create 2021-09-07 21:40
 */
public class BookVo {

    public BookVo() {

    }

    public BookVo(String name, String price) {
        this.bookName = name;
        this.price = price;
    }

    private String bookName;

    private String price;

    public void setName(String name) {
        this.bookName = name;
    }

    public String getName() {
        return this.bookName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return this.price;
    }
}
