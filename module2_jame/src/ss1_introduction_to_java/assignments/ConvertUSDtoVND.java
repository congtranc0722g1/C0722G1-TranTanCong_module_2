package ss1_introduction_to_java.assignments;

import java.util.Scanner;

public class ConvertUSDtoVND {
    public static void main(String[] args) {
        double rate = 23000;
        double usd;
        Scanner money = new Scanner(System.in);
        System.out.print("Nhập vào số tiền cần chuyển đổi ( USD): ");
        usd = money.nextDouble();
        double vnd = usd * rate;
        System.out.print("Số tiền (VNĐ): " + vnd);
    }

}
