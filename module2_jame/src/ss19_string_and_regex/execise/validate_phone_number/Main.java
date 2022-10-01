package ss19_string_and_regex.execise.validate_phone_number;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        PhoneNumberExample phoneNumberExample1 = new PhoneNumberExample(phone);
        if (phoneNumberExample1.PhoneNumberExample()){
            System.out.println("Số điện thoại hợp lệ");
        }else {
            System.out.println("Số điện thoại không hợp lệ");
        }
    }
}
