package ss17_binary_file_and_serialization.execise.product_management.service.impl;

import ss17_binary_file_and_serialization.execise.product_management.model.Product;
import ss17_binary_file_and_serialization.execise.product_management.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();
    @Override
    public void addProduct() {
        productList = readFileProduct();
        Product product = this.infoProduct();

        productList.add(product);
        writeFileList(productList);
        System.out.println("Nhập thành công");
    }

    @Override
    public void displayProduct() {
        productList = readFileProduct();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void searchProduct() {
        productList = readFileProduct();
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();
        boolean check = false;
        for (Product product : productList) {
            if (product.getName().contains(name)){
                check = true;
                System.out.println(product);
            }
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    public Product infoProduct(){
        System.out.print("Nhập mã sản phẩm: ");
        String code = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String company = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mô tả sản phẩm: ");
        String describe = scanner.nextLine();
        Product product = new Product(code, name, company, price, describe);
        return  product;
    }

    private List<Product> readFileProduct(){
        List<Product> productList = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\execise\\product_management\\data\\product.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private void writeFileList(List<Product> productList){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\execise\\product_management\\data\\product.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
