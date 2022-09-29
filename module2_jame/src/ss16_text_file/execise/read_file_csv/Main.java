package ss16_text_file.execise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\ss16_text_file\\execise\\read_file_csv\\country.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        String[] info;
        Country country;
        List<Country> countryList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null){
            info = line.split(",");
            country = new Country(Integer.parseInt(info[0]), info[1], info[2]);
            countryList.add(country);
        }
        bufferedReader.close();
        System.out.println("Quốc gia: ");
        for (Country country1 : countryList) {
            System.out.println(country1);
        }
    }
}
