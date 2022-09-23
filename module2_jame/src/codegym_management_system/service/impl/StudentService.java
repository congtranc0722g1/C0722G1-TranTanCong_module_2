package codegym_management_system.service.impl;

import codegym_management_system.model.Student;
import codegym_management_system.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.infoStudent();

        studentList.add(student);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllStudent() {
        for(Student student: studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        System.out.print("Mời bạn nhập mã học sinh cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for(int i = 0 ; i< studentList.size(); i++) {
            if(studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa học sinh này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if(choice.equals("Y")) {
                    studentList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if(!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    @Override
    public void searchStudent() {
        System.out.print("Mời bạn nhập tên học sinh cần xem thông tin: ");
        String name = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(name)){
                System.out.println(studentList.get(i));
            }
        }
    }

    @Override
    public void sortStudent() {
        boolean isSwap = true;
        for (int i = 0; i < studentList.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                if (studentList.get(j).compareTo(studentList.get(j + 1)) > 0) {
                    isSwap = true;
                    Student temp = studentList.get(j + 1);
                    studentList.set(j + 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
        for(Student student: studentList) {
            System.out.println(student);
        }
    }

    public Student infoStudent() {
        System.out.print("Mời bạn nhập mã học sinh: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính học sinh (1.Nam. 2.Nữ: )");
        int tempGender = Integer.parseInt(scanner.nextLine());
        String gender;
        if(tempGender == 1) {
            gender = "Nam";
        } else if(tempGender == 2) {
            gender = "Nữ";
        } else {
            gender = null;
        }
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double score = Double.parseDouble(scanner.nextLine());
        Student student = new Student(code,name,gender,nameClass,score);
        return student;
    }
}
