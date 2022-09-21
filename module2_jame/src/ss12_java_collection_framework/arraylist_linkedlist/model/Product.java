package ss12_java_collection_framework.arraylist_linkedlist.model;

import java.util.Comparator;

public class Product {
    private int id;
    private String name;
    private double price;
    private String day;

    public Product(){

    }

    public Product(int id, String name, double price, String day) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Tên sản phẩm: " + getName() + "|\t"
        + "Mã sản phẩm: " + getId() + "|\t"
        + "Giá sản phẩm: " + getPrice() + "|\t"
        + "Ngày nhập sản phẩm: " + getDay();
    }
}
