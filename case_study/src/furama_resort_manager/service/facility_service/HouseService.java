package furama_resort_manager.service.facility_service;

import furama_resort_manager.model.facilitys.House;
import furama_resort_manager.service.i_facility.IHouseService;
import furama_resort_manager.utils.exception.*;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HouseService implements IHouseService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<House, Integer> houseList = new LinkedHashMap<>();

    @Override
    public void display() {
        houseList = readFileHouse();
        Set<House> set = houseList.keySet();
        for (House key : set){
            System.out.println(key);
        }
    }

    @Override
    public void add() {
        houseList = readFileHouse();
        House house = this.infoHouse();
        houseList.put(house, 0);
        writeFileHouse(houseList);
        System.out.println("Successfully added new");
    }

    public House infoHouse(){
        String code;
        while (true){
            try {
                System.out.println("Enter house code (Ex: SVHO-0000): ");
                code = scanner.nextLine();
                if (!Regex.checkCodeHouse(code)){
                    throw new Exception("Invalid house CODE format. Please re-enter");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: House1): ");
                name = scanner.nextLine();
                if (!Regex.checkNameFacility(name)){
                    throw new Exception("Invalid service name format. Please re-enter");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        double area;
        while (true){
            try {
                System.out.println("Enter house area (m2): ");
                area = Double.parseDouble(scanner.nextLine());
                if (area < 30){
                    throw new AreaException("Area must be more than 30. Please try again");
                }
                break;
            } catch (AreaException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        double cost;
        while (true){
            try {
                System.out.println("Cost of rent (vnd):");
                cost = Double.parseDouble(scanner.nextLine());
                if (cost < 0){
                    throw new CostException("Rental cost must be greater than 0. Please try again");
                }
                break;
            } catch (CostException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        int amount;
        while (true){
            try {
                System.out.println("Maximum number of people (Greater than 0 and less than 20): ");
                amount = Integer.parseInt(scanner.nextLine());
                if (amount < 0 || amount >20){
                    throw new AmountException("Greater than 0 and less than 20. Please try again");
                }
                break;
            } catch (AmountException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String type;
        adc1:
        while (true){
            try {
                System.out.println("Enter a rental type:\n1. Year\n2. Month\n3. Day\n4.Hour");
                int tempType = Integer.parseInt(scanner.nextLine());

                switch (tempType){
                    case 1:
                        type = "Year";
                        break adc1;
                    case 2:
                        type = "Month";
                        break adc1;
                    case 3:
                        type = "Day";
                        break adc1;
                    case 4:
                        type = "Hour";
                        break adc1;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }

        String houseStandard;
        adc2:
        while (true){
            try {
                System.out.println("Enter standard:\n1. Standard\n2. Superior\n3. Deluxe\n4. Suite");
                int tempHouseStandard = Integer.parseInt(scanner.nextLine());
                switch (tempHouseStandard){
                    case 1:
                        houseStandard = "Standard";
                        break adc2;
                    case 2:
                        houseStandard = "Superior";
                        break adc2;
                    case 3:
                        houseStandard = "Deluxe";
                        break adc2;
                    case 4:
                        houseStandard = "Suite";
                        break adc2;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        int floor;
        while (true){
            try {
                System.out.println("Enter the number of floors (greater than 0): ");
                floor = Integer.parseInt(scanner.nextLine());
                if (floor < 0){
                    throw new FloorException("The number of floors must be greater than 0. Please try again");
                }
                break;
            } catch (FloorException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        House house = new House (code,name,area,cost,amount,type,houseStandard,floor);
        return house;
    }

    private Map<House, Integer> readFileHouse(){
        BufferedReader bufferedReader = null;
        String line;
        String[] info;
        House house;

        try {
            houseList = new LinkedHashMap<>();
            File file = new File("src\\furama_resort_manager\\data\\facility\\house.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                house = new House(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6],Integer.parseInt(info[7]));
                houseList.put(house, Integer.parseInt(info[8]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    private void writeFileHouse(Map<House, Integer> houseList){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\furama_resort_manager\\data\\facility\\house.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<House> set = houseList.keySet();
            for (House key : set) {
                bufferedWriter.write(getInfo(key) + "," + houseList.get(key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getInfo (House house){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",house.getCode(),house.getServiceName(),house.getArea(),house.getCost(),house.getAmount(),house.getType(),house.getHouseStandard(),house.getFloor());
    }
}
