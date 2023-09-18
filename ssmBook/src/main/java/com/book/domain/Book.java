package com.book.domain;

public class Book {
    private String no;
    private String name;
    private Integer price;
    private String publish;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publish='" + publish + '\'' +
                '}';
    }
}
