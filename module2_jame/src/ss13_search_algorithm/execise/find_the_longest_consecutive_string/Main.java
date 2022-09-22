package ss13_search_algorithm.execise.find_the_longest_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> linkedList = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập vào chuỗi: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) { 		//1 Vòng lặp
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear();
            }

            list.add(string.charAt(i));

            if (list.size() > linkedList.size()) {
                linkedList.clear();
                linkedList.addAll(list);
            }
        }

        for (Character character: linkedList) {
            System.out.print(character);
        }
        System.out.println();
    }

}
