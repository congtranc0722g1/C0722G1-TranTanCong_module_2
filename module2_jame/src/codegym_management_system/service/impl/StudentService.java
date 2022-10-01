package codegym_management_system.service.impl;

import codegym_management_system.model.Student;
import codegym_management_system.service.IStudentService;
import codegym_management_system.utils.StudentException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();
    final String NAME_REGEX = "[[A-Z][a-z][\\s]]+";

    @Override
    public void addStudent() {
        // thêm vào từ bàn phím
//        Student student = this.infoStudent();
//
//        studentList.add(student);
//        System.out.println("Thêm mới thành công");

        //cách tiểu học
//        Student student = this.infoStudent();
//        studentList.add(student);
//        System.out.println("Thêm mới thành công");
//
//        try {
//            File file = new File("src\\codegym_management_system\\data\\student.csv");
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
//
//            for (Student st : studentList) {
//                bufferedWriter.write(st.getInfo());
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        }catch (IOException e){
//            System.out.println("sai rồi");
//        }
            studentList = readFileStudent();
            Student student = this.infoStudent();
            studentList.add(student);
            writeFileStudent(studentList);
            System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayAllStudent() {
        //        Hiển thị không từ file
//        for(Student student: studentList) {
//            System.out.println(student);
//        }

        //Cách tiểu học
//        studentList = new ArrayList<>();
//        File file = new File("src\\codegym_management_system\\data\\student.csv");
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String line;
//        String[] info;
//        Student student1;
//        while ((line = bufferedReader.readLine()) != null){
//            info = line.split(",");
//            student1 = new Student(info[0], info[1], info[2], info[3], Double.parseDouble(info[4]));
//            studentList.add(student1);
//        }
//        bufferedReader.close();
//
//        for(Student student: studentList) {
//            System.out.println(student);
//        }

        studentList = readFileStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        studentList = readFileStudent();
        System.out.print("Mời bạn nhập mã học sinh cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa học sinh này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    studentList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }else {
            writeFileStudent(studentList);
        }
    }

    @Override
    public void searchStudent() {
        System.out.print("Mời bạn nhập tên học sinh cần xem thông tin: ");
        String name = scanner.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(name)) {
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
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public Student infoStudent() {
        String code;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã học sinh: ");
                code = scanner.nextLine();
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getCode().equals(code)) {
                        throw new StudentException("Id này đã tồn tại. Vui lòng nhập mã khác.");
                    }
                }
                break;
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên học sinh: ");
                name = scanner.nextLine();
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    System.out.println("Tên nhập chưa đúng định dạng");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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

            String nameClass;
            while (true){
                System.out.print("Mời bạn nhập tên lớp của học sinh: ");
                nameClass = scanner.nextLine();
                if (nameClass.matches("[C][0-9]{6}[G][12]")){
                    break;
                }else {
                    System.out.println("Tên lớp sai định dạng");
                }
            }

        double score;
        while (true){
         try {
            System.out.print("Mời bạn nhập điểm: ");
            score = Integer.parseInt(scanner.nextLine());
            if (score < 0 || score > 100) {
                throw new StudentException("Bạn không thể nhập điểm nhỏ hơn 0 và lớn hơn 100");
            }
            break;
         } catch (NumberFormatException e) {
            System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
         } catch (StudentException e) {
            System.out.println(e.getMessage());
         }
    }

        Student student = new Student(code,name,gender,nameClass,score);
            return student;
    }


        private List<Student> readFileStudent() {
        BufferedReader bufferedReader = null;

        String line;
        String[] info;
        Student student1;

        try {
            studentList = new ArrayList<>();
            File file = new File("src\\codegym_management_system\\data\\student.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                student1 = new Student(info[0], info[1], info[2], info[3], Double.parseDouble(info[4]));
                studentList.add(student1);
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
        return studentList;
    }

    private void writeFileStudent(List<Student> students) {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\codegym_management_system\\data\\student.csv");
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Student st : studentList) {
        bufferedWriter.write(getInfo(st));
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

        private String getInfo(Student student){
            return String.format("%s,%s,%s,%s,%s", student.getCode(), student.getName(), student.getGender(), student.getNameClass(), student.getScore());
        }

        private void nameExample(){

        }
}