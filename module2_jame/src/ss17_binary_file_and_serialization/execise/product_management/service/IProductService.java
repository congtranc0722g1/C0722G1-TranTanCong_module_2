package ss17_binary_file_and_serialization.execise.product_management.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IProductService {
    void addProduct() throws IOException;

    void displayProduct() throws IOException;

    void searchProduct();
}
