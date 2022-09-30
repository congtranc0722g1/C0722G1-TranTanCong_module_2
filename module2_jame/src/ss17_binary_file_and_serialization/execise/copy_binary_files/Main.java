package ss17_binary_file_and_serialization.execise.copy_binary_files;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\source.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_binary_file_and_serialization\\execise\\copy_binary_files\\target.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
