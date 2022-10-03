package furama_resort_manager.controller;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu(){
        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Welcome to Furama Resort Management System");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    EmployeeController.displayEmployeeMenu();
                    break;
                case 2:
                    CustomerController.displayCustomerMenu();
                    break;
                case 3:
                    FacilityController.displayFacilityMenu();
                    break;
                case 4:
                    BookingController.displayBookingMenu();
                    break;
                case 5:
                    PromotionController.displayPromotionMenu();
                    break;
                case 6:
                    return;
            }
        }
    }
}
