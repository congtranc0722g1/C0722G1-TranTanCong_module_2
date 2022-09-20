package ss11_dsa_stack_queue.execise.count_occurrences_of_each_word_in_a_string_using_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CountOccurrencesUsingMap {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();

        str = str.replaceAll(",","");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            key = arr[i];
            if(map.containsKey(key)){
                value = map.get(key);
                map.remove(key);
                map.put(key, value+1);
            } else{
                map.put(key, 1);
            }
        }

        Set set = map.keySet();
        Iterator i = set.iterator();

        while(i.hasNext()){
            key = (String)i.next();
            System.out.println("Từ '" +key+ "' xuất hiện " + map.get(key) + " lần");
        }
    }
}
