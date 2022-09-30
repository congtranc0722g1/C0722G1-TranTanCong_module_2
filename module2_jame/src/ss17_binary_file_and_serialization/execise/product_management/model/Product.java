package ss17_binary_file_and_serialization.execise.product_management.model;

public class Product {
    private String code;
    private String name;
    private String company;
    private double price;
    private String describe;

    public Product(){

    }

    public Product(String code, String name, String company, double price, String describe){
        this.code = code;
        this.name = name;
        this.company = company;
        this.price = price;
        this.describe = describe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s",getCode(),getName(),getCompany(),getPrice(),getDescribe());
    }

    @Override
    public String toString() {
        return "Mã: " + getCode() + ",\t" +
                "Tên: " + getName() + ",\t" +
                "Hãng: " + getCompany() + ",\t" +
                "Giá: " + getPrice() + ",\t" +
                "Mô tả: " + getDescribe();
    }
}
