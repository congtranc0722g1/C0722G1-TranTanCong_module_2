package ss1_introduction_to_java.assignments;

import java.util.Scanner;

public class ReadNumbersIntoWords {
    public static void main(String[] args) {
        int num;
        Scanner num1 = new Scanner(System.in);
        System.out.print("Nhập vào một số: ");
        num = num1.nextInt();
        int ones = num % 10;
        int tens = num % 100;
        int hundred = num % 1000;
        if (num >= 0 && num < 10){
            switch (num) {
                case 0:
                    System.out.print("zero");
                    break;
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("nine");
                    break;
            }
        }
        else if (num < 20) {
            switch (ones){
                case 0:
                    System.out.print("ten");
                    break;
                case 1:
                    System.out.print("eleven");
                    break;
                case 2:
                    System.out.print("twelve");
                    break;
                case 3:
                    System.out.print("thirteen");
                    break;
                case 4:
                    System.out.print("fourteen");
                    break;
                case 5:
                    System.out.print("fifteen");
                    break;
                case 6:
                    System.out.print("sixteen");
                    break;
                case 7:
                    System.out.print("seventeen");
                    break;
                case 8:
                    System.out.print("eighteen");
                    break;
                case 9:
                    System.out.print("nineteen");
                    break;
            }
        }
        if (num < 100){
            switch (num / 10){
                case 2:
                    System.out.print("twenty" + " ");
                    break;
                case 3:
                    System.out.print("thirty" + " ");
                    break;
                case 4:
                    System.out.print("fourty" + " ");
                    break;
                case 5:
                    System.out.print("fifty" + " ");
                    break;
                case 6:
                    System.out.print("sixty" + " ");
                    break;
                case 7:
                    System.out.print("seventy" + " ");
                    break;
                case 8:
                    System.out.print("eighty" + " ");
                    break;
                case 9:
                    System.out.print("ninety" + " ");
                    break;
            }
            switch (ones){
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("nine");
                    break;
            }
        }
        else if(num < 1000){
            switch (num / 100 ){
                case 1:
                    System.out.print("one hundred");
                    break;
                case 2:
                    System.out.print("two hundred");
                    break;
                case 3:
                    System.out.print("three hundred");
                    break;
                case 4:
                    System.out.print("four hundred");
                    break;
                case 5:
                    System.out.print("five hundred");
                    break;
                case 6:
                    System.out.print("six hundred");
                    break;
                case 7:
                    System.out.print("seven hundred");
                    break;
                case 8:
                    System.out.print("eight hundred");
                    break;
                case 9:
                    System.out.print("nine hundred");
                    break;
            }
            if (tens > 0 && tens < 20){
                switch (tens){
                    case 1:
                        System.out.print("one");
                        break;
                    case 2:
                        System.out.print("two");
                        break;
                    case 3:
                        System.out.print("three");
                        break;
                    case 4:
                        System.out.print("four");
                        break;
                    case 5:
                        System.out.print("five");
                        break;
                    case 6:
                        System.out.print("six");
                        break;
                    case 7:
                        System.out.print("seven");
                        break;
                    case 8:
                        System.out.print("eight");
                        break;
                    case 9:
                        System.out.print("nine");
                        break;
                    case 10:
                        System.out.print("ten");
                        break;
                    case 11:
                        System.out.print("eleven");
                        break;
                    case 12:
                        System.out.print("twelve");
                        break;
                    case 13:
                        System.out.print("thirteen");
                        break;
                    case 14:
                        System.out.print("fourteen");
                        break;
                    case 15:
                        System.out.print("fifteen");
                        break;
                    case 16:
                        System.out.print("sixteen");
                        break;
                    case 17:
                        System.out.print("seventeen");
                        break;
                    case 18:
                        System.out.print("eighteen");
                        break;
                    case 19:
                        System.out.print("ninteen");
                        break;
                }
            }
            else {
                switch (tens){
                    case 2:
                        System.out.print(" twenty");
                        break;
                    case 3:
                        System.out.print(" thirty");
                        break;
                    case 4:
                        System.out.print(" forty");
                        break;
                    case 5:
                        System.out.print(" fifty");
                        break;
                    case 6:
                        System.out.print(" sixty");
                        break;
                    case 7:
                        System.out.print(" seventy");
                        break;
                    case 8:
                        System.out.print(" eighty");
                        break;
                    case 9:
                        System.out.print(" ninety");
                        break;
                }

            }
        }
        switch (tens % 10){
            case 1:
                System.out.println("one");
            case 2:
                System.out.print("two");
                break;
            case 3:
                System.out.print("three");
                break;
            case 4:
                System.out.print("four");
                break;
            case 5:
                System.out.print("five");
                break;
            case 6:
                System.out.print("six");
                break;
            case 7:
                System.out.print("seven");
                break;
            case 8:
                System.out.print("eight");
                break;
            case 9:
                System.out.print("nine");
                break;
        }
    }
}
