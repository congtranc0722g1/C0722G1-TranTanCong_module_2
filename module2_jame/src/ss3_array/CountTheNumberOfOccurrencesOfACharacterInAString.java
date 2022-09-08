package ss3_array;

import java.util.Scanner;

public class CountTheNumberOfOccurrencesOfACharacterInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        System.out.print("Nhập vào ký tự: ");
        char charac = scanner.next().charAt(0);
        String characters = Character.toString(charac);
        String[] arr = str.split("");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(characters)){
                count++;
            }
        }
        System.out.print("Số lần suất hiện của " + charac + " là "+ count + " lần.");
    }
}