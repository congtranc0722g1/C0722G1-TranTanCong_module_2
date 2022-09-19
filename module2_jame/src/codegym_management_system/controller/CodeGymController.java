package codegym_management_system.controller;

import java.util.Scanner;

public class CodeGymController {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCodegym(){
        while (true){
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý CodeGym");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giáo viên");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    StudentController.menuStudent();
                    break;
                case 2:
                    TeacherController.menuTeacher();
                    break;
                case 3:
                    return;
            }
        }
    }
}