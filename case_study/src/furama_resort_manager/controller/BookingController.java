package furama_resort_manager.controller;

import furama_resort_manager.service.IBookingService;
import furama_resort_manager.service.impl.BookingService;

import java.util.Scanner;

public class BookingController {
    private static IBookingService iBookingService = new BookingService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayBookingMenu(){
        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Booking Managerment");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    iBookingService.add();
                    return;
                case 2:
                    iBookingService.displayListBooking();
                    return;
                case 3:
                    iBookingService.createNewContracts();
                    return;
                case 4:
                    iBookingService.displayListContracts();
                    return;
                case 5:
                    iBookingService.editContracts();
                    return;
                case 6:
                    return;
            }
        }
    }
}
