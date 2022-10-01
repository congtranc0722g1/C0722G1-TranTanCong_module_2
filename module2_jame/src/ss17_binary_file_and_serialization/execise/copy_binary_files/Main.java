package ss17_binary_file_and_serialization.execise.copy_binary_files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\source.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("Cong");
        stringList.add("Tan");
        stringList.add("Tran");
        stringList.add("17dcn1b");
        stringList.add("alo");
        try {
            objectOutputStream.writeObject(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\source.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stringList = (List<String>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectOutputStream objectOutputStream1 = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\target.dat");
            objectOutputStream1 = new ObjectOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream1.writeObject(stringList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream1 = null;
        ObjectInputStream objectInputStream1 = null;
        List<String> stringList1;

        try {
            fileInputStream1 = new FileInputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\target.dat");
            objectInputStream1 = new ObjectInputStream(fileInputStream1);
            stringList1 = (List<String>) objectInputStream1.readObject();
            for (int i = 0; i < stringList1.size(); i++) {
                System.out.println(stringList1.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
