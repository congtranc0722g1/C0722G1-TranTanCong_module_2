package codegym_management_system.service.impl;

import codegym_management_system.model.Student;
import codegym_management_system.model.Teacher;
import codegym_management_system.service.ITeacherService;
import codegym_management_system.utils.StudentException;
import codegym_management_system.utils.TeacherException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() throws TeacherException {
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.print("Mời bạn nhập mã giáo viên cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa giáo viên này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    @Override
    public void searchTeacher() {
        System.out.print("Mời bạn nhập tên giáo viên cần xem thông tin: ");
        String name = scanner.nextLine();
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getName().contains(name)) {
                System.out.println(teacherList.get(i));
            }
        }
    }

    @Override
    public void sortTeacher() {
        boolean isSwap = true;
        for (int i = 0; i < teacherList.size() - 1; i++) {
            isSwap = false;
            for (int j = i + 1; j < teacherList.size() - i - 1; j++) {
                if (teacherList.get(j).compareTo(teacherList.get(j + 1)) > 0) {
                    isSwap = true;
                    Teacher temp = teacherList.get(j + 1);
                    teacherList.set(j + 1, teacherList.get(j));
                    teacherList.set(j, temp);
                }

            }

        }
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public Teacher infoTeacher() throws TeacherException {
        String name;
        System.out.print("Mời bạn nhập mã giáo viên: ");
        String code = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Mời bạn nhập tên giáo viên: ");
                name = scanner.nextLine();
                for (int i = 0; i < name.length(); i++) {
                    if (name.charAt(i) <= '9' && name.charAt(i) >= '0'){
                        throw new TeacherException("Tên không được chứa số");
                    }

                }
                break;
            } catch (TeacherException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Mời bạn nhập giới tính giáo viên (1.Nam. 2.Nữ: )");
        int tempGender = Integer.parseInt(scanner.nextLine());
        String gender;
        if(tempGender == 1) {
            gender = "Nam";
        } else if(tempGender == 2) {
            gender = "Nữ";
        } else {
            gender = null;
        }
            System.out.print("Mời bạn trình dộ giáo viên: ");
            String specialize = scanner.nextLine();

            Teacher teacher = new Teacher(code, name, gender, specialize);
            return teacher;
    }
}