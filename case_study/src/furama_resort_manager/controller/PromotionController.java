package furama_resort_manager.controller;

import furama_resort_manager.service.IPromotionService;
import furama_resort_manager.service.impl.PromotionService;

import java.util.Scanner;

public class PromotionController {
    private static IPromotionService iPromotionService = new PromotionService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayPromotionMenu(){
        while (true){
            try {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Promotion Management");
                System.out.println("1. Display list customers use service");
                System.out.println("1. Display list customers get voucher");
                System.out.println("1. Return main menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        iPromotionService.displayListCustomersUseService();
                        break;
                    case 2:
                        iPromotionService.displayListCustomersGetVoucher();
                        break;
                    case 3:
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
