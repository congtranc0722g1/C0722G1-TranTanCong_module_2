package furama_resort_manager.controller;

import furama_resort_manager.service.ICustomerService;
import furama_resort_manager.service.IService;
import furama_resort_manager.service.impl.CustomerService;

import java.util.Scanner;

public class CustomerController {
    private static ICustomerService iCustomerService = new CustomerService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayCustomerMenu(){
        while (true){
            try {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Customer Managemen");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        iCustomerService.displayListCustomers();
                        break;
                    case 2:
                        iCustomerService.add();
                        break;
                    case 3:
                        iCustomerService.editCustomer();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please enter correctly as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
    }
}
