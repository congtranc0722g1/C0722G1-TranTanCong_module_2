package furama_resort_manager.controller;

import furama_resort_manager.service.IEmployeeService;
import furama_resort_manager.service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static IEmployeeService iEmployeeService = new EmployeeService();
    private static Scanner scanner = new Scanner(System.in);
    public static void displayEmployeeMenu(){
        while (true){
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
                    return;
                case 2:
                    iEmployeeService.add();
                    return;
                case 3:
                    iEmployeeService.editEmployees();
                    return;
                case 4:
                    return;
            }
        }
    }
}
