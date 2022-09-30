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
    public void addProduct() throws IOException {
        Product product = this.infoProduct();
        productList.add(product);
        System.out.println("Thêm mới thành công");

        FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\execise\\product_management\\data\\product.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Product product1 : productList) {
            objectOutputStream.writeObject(product1.getInfo());
        }
        objectOutputStream.close();
    }

    @Override
    public void displayProduct() throws IOException {
            FileInputStream fileInputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\execise\\product_management\\data\\product.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


    }

    @Override
    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).getName().contains(name);
            System.out.println(productList.get(i));
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
}
