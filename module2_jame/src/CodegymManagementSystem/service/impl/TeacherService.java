package CodegymManagementSystem.service.impl;

import CodegymManagementSystem.model.Student;
import CodegymManagementSystem.model.Teacher;
import CodegymManagementSystem.service.ITeacherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();
    @Override
    public void addTeacher() {
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllTeacher() {
        for (Teacher teacher : teacherList){
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        System.out.print("Mời bạn nhập mã giáo viên cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for(int i = 0 ; i< teacherList.size(); i++) {
            if(teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa giáo viên này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if(choice.equals("Y")) {
                    teacherList.remove(i);
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
    public Teacher infoTeacher(){
        System.out.print("Mời bạn nhập mã giáo viên: ");
        String code = scanner.nextLine();
        System.out.print("Mời bạn nhập tên giáo viên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính giáo viên (1.Nam. 2.Nữ: ");
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
        Teacher teacher = new Teacher(code,name,gender,specialize);
        return teacher;
    }
}
