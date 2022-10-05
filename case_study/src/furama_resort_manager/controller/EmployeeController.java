package furama_resort_manager.controller;

import furama_resort_manager.service.IEmployeeService;
import furama_resort_manager.service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static IEmployeeService iEmployeeService = new EmployeeService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayEmployeeMenu(){
        while (true){
            try {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Employee Managemen");
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Return main menu");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        iEmployeeService.displayListEmployees();
                        break;
                    case 2:
                        iEmployeeService.add();
                        break;
                    case 3:
                        iEmployeeService.editEmployees();
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
