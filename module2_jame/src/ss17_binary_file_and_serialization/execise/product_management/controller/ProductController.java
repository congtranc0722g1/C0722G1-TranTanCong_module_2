package ss17_binary_file_and_serialization.execise.product_management.controller;

import ss17_binary_file_and_serialization.execise.product_management.service.IProductService;
import ss17_binary_file_and_serialization.execise.product_management.service.impl.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private  static IProductService iProductService = new ProductService();
    private  static Scanner scanner = new Scanner(System.in);
    public static void menuProduct() throws IOException {
        while (true){
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chương trình quản lý sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                   iProductService.addProduct();
                   break;
                case 2:
                   iProductService.displayProduct();
                   break;
                case 3:
                    iProductService.searchProduct();
                    break;
                case 4:
                    return;
            }
        }
    }
}
