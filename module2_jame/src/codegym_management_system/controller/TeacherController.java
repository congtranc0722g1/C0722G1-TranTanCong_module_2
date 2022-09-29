package codegym_management_system.controller;

import codegym_management_system.service.ITeacherService;
import codegym_management_system.service.impl.TeacherService;
import codegym_management_system.utils.TeacherException;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    private static ITeacherService iTeacherService = new TeacherService();
    private static Scanner scanner = new Scanner(System.in);
    public static void menuTeacher() throws TeacherException, IOException {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Quản lý giáo viên CodeGym");
            System.out.println("1. Thêm mới giáo viên");
            System.out.println("2. Hiển thị danh sách giáo viên");
            System.out.println("3. Xóa giáo viên");
            System.out.println("4. Tìm kiếm giáo viên");
            System.out.println("5. Sắp xếp giáo viên");
            System.out.println("6. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iTeacherService.addTeacher();
                    break;
                case 2:
                    iTeacherService.displayAllTeacher();
                    break;
                case 3:
                    iTeacherService.removeTeacher();
                    break;
                case 4:
                    iTeacherService.searchTeacher();
                    break;
                case 5:
                    iTeacherService.sortTeacher();
                    break;
                case 6:
                    return;
            }
        }
    }
}
