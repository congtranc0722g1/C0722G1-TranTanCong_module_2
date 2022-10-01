package codegym_management_system.service.impl;

import codegym_management_system.model.Student;
import codegym_management_system.model.Teacher;
import codegym_management_system.service.ITeacherService;
import codegym_management_system.utils.StudentException;
import codegym_management_system.utils.TeacherException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void addTeacher() {
//        Teacher teacher = infoTeacher();
//        teacherList.add(teacher);
//        System.out.println("Thêm mới thành công");
//
//        try {
//            File file = new File("src\\codegym_management_system\\data\\teacher.csv");
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//
//            for (Teacher tc : teacherList) {
//                bufferedWriter.write(tc.getInfo());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        }catch (IOException e){
//            System.out.println("sai rồi");
//        }
        try {
            teacherList = readFileTeacher();
            Teacher teacher = infoTeacher();
            teacherList.add(teacher);
            writeFileTeacher(teacherList);
            System.out.println("Thêm mới thành công");
        } catch (TeacherException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayAllTeacher() {
//        for (Teacher teacher : teacherList) {
//            System.out.println(teacher);
//        }

        //Cách tiểu học
//        teacherList = new ArrayList<>();
//        File file = new File("src\\codegym_management_system\\data\\teacher.csv");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String line;
//        String[] info;
//        Teacher teacher;
//        while ((line = bufferedReader.readLine()) != null){
//            info = line.split(",");
//            teacher = new Teacher(info[0], info[1], info[2], info[3]);
//            teacherList.add(teacher);
//        }
//        bufferedReader.close();
//
//        for(Teacher teacher1: teacherList) {
//            System.out.println(teacher1);
//        }
        teacherList = readFileTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        teacherList = readFileTeacher();
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
        }else {
            writeFileTeacher(teacherList);
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
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")){
                        break;
                    }else {
                    System.out.println("Tên nhập chưa đúng định dạng");
                }
            } catch (Exception e) {
                e.printStackTrace();
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

    private List<Teacher> readFileTeacher(){
        BufferedReader bufferedReader = null;

        String line;
        String[] info;
        Teacher teacher;

        try {
            teacherList = new ArrayList<>();
            File file= new File("src\\codegym_management_system\\data\\teacher.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                teacher = new Teacher(info[0], info[1], info[2],info[3]);
                teacherList.add(teacher);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherList;
    }
    private void writeFileTeacher(List<Teacher> teachers){
        BufferedWriter bufferedWriter = null;

        try {
            File file = new File("src\\codegym_management_system\\data\\teacher.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Teacher teacher : teacherList) {
                bufferedWriter.write(getInfo(teacher));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String getInfo(Teacher teacher){
        return String.format("%s,%s,%s,%s",teacher.getCode(),teacher.getName(),teacher.getGender(),teacher.getSpecialize());
    }

}