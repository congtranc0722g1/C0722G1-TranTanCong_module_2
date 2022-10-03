package furama_resort_manager.controller;

import furama_resort_manager.service.IFacilityService;
import furama_resort_manager.service.impl.FacilityService;

import java.util.Scanner;

public class FacilityController {
    private static IFacilityService iFacilityService = new FacilityService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayFacilityMenu(){
        while (true){
            System.out.println("-------------------------------------------------------------");
            System.out.println("Facility Management");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    iFacilityService.displayListFacility();
                    return;
                case 2:
                    iFacilityService.add();
                    return;
                case 3:
                    iFacilityService.displayListFacilityMaintenance();
                    return;
                case 4:
                    return;
            }
        }
    }
}
