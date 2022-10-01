package ss19_string_and_regex.execise.validate_the_name_of_the_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String name = scanner.nextLine();

        ClassNameExample classNameExample1 = new ClassNameExample(name);
        if (classNameExample1.classNameExample()){
            System.out.println("Tên lớp hợp lệ");
        }else {
            System.out.println("Tên lớp không hợp lệ");
        }
    }
}
