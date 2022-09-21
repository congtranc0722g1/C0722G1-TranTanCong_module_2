package ss12_java_collection_framework.arraylist_linkedlist.controller;

import ss12_java_collection_framework.arraylist_linkedlist.service.IProductService;
import ss12_java_collection_framework.arraylist_linkedlist.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private  static  IProductService iProductService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);
    public static void menuProduct(){
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Quản lý sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm");
            System.out.println("7. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iProductService.addProduct();
                    break;
                case 2:
                    iProductService.editProduct();
                    break;
                case 3:
                    iProductService.removeProduct();
                    break;
                case 4:
                    iProductService.displayProduct();
                    break;
                case 5:
                    iProductService.searchProduct();
                    break;
                case 6:
                    iProductService.arrangeProduct();
                    break;
                case 7:
                    return;
            }
        }
    }
}
