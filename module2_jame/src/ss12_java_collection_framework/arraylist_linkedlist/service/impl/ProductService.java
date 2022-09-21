package ss12_java_collection_framework.arraylist_linkedlist.service.impl;

import ss12_java_collection_framework.arraylist_linkedlist.model.Product;
import ss12_java_collection_framework.arraylist_linkedlist.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct() {
        Product product = this.infoProduct();
        productList.add(product);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void editProduct() {
        System.out.print("Mời bạn nhập mã sản phẩm cần chỉnh sửa: ");
        int id1 = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id1){
                System.out.println("Nhập id sản phẩm mới: ");
                int id2 = Integer.parseInt(scanner.nextLine());
                productList.get(i).setId(id2);
                System.out.println("Nhập tên sản phẩm mới: ");
                String name2 = scanner.nextLine();
                productList.get(i).setName(name2);
                System.out.println("Nhập giá sản phẩm mới: ");
                double price2 = Double.parseDouble(scanner.nextLine());
                productList.get(i).setPrice(price2);
                System.out.println("Nhập ngày nhập sản phẩm mới: ");
                String day2 = scanner.nextLine();
                productList.get(i).setDay(day2);
                System.out.println("Thay đổi thành công");
            }
        }
    }

    @Override
    public void removeProduct() {
        System.out.print("Mời bạn nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean flagDelete = false;
        for(int i = 0 ; i< productList.size(); i++) {
            if(productList.get(i).getId()== id) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if(choice.equals("Y")) {
                    productList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if(!flagDelete) {
            System.out.println("Không tìm thấy sản phẩm cần xóa.");
        }
    }

    @Override
    public void displayProduct() {
        for (Product product : productList) {
            System.out.println(product);
        }

    }

    @Override
    public void searchProduct() {
        System.out.println("Nhập id sản phẩm bạn muốn tìm kiếm");
        int id1 = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if (id1 == productList.get(i).getId()){
                System.out.println(productList.get(i));
            }
        }

    }

    @Override
    public void arrangeProduct() {
        int choice1;
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("1. Sắp xếp tăng dần theo giá");
            System.out.println("2. Sắp xếp giảm dần theo giá");
            choice1 = scanner.nextInt();
            if (choice1 != 1 && choice1 != 2){
                System.out.println("Chỉ được nhập 1 hoặc 2");
            } else if (choice1 == 1){
                Product product = new Product();
            }
        } while (choice1 != 1 && choice1 != 2);
        }

    public Product infoProduct() {
        System.out.print("nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Ngày nhập sản phẩm: ");
        String day = scanner.nextLine();
        Product product = new Product (id, name, price, day);
        return product;
    }
}

