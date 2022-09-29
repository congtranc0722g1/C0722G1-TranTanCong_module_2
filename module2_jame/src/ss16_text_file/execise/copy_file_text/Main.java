package ss16_text_file.execise.copy_file_text;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src\\ss16_text_file\\execise\\copy_file_text\\source.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            File file1 = new File("src\\ss16_text_file\\execise\\copy_file_text\\targe.txt");
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        count += 1;
                    }
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            bufferedReader.close();
            System.out.println("Số ký tự trong file là: " + count);
        }catch (FileNotFoundException e){
            System.out.println("Nguồn không tồn tại");
        }



    }
}