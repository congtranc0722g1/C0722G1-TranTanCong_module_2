package ss1_introduction_to_java.assignments;

import java.util.Scanner;

public class ConvertUSDtoVND {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner money = new Scanner(System.in);
        System.out.print("Nhập vào số tiền cần chuyển đổi ( USD): ");
        usd = money.nextDouble();
        double exchange = usd * vnd;
        System.out.print("Số tiền (VNĐ): " + exchange);
    }

}
