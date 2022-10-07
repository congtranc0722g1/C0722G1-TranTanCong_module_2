package furama_resort_manager.service.facility_service;

import furama_resort_manager.model.facilitys.House;
import furama_resort_manager.model.facilitys.Villa;
import furama_resort_manager.service.i_facility.IVillaService;
import furama_resort_manager.utils.exception.AmountException;
import furama_resort_manager.utils.exception.AreaException;
import furama_resort_manager.utils.exception.CostException;
import furama_resort_manager.utils.exception.FloorException;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VillaService implements IVillaService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Villa, Integer> villaList = new LinkedHashMap<>();
    @Override
    public void display() {
        villaList = readFileVilla();
        Set<Villa> set = villaList.keySet();
        for (Villa key : set){
            System.out.println(key);
        }
    }

    @Override
    public void add() {
        villaList = readFileVilla();
        Villa villa = this.infoVilla();
        villaList.put(villa, 0);
        writeFileVilla(villaList);
        System.out.println("Successfully added new");
    }

    private Villa infoVilla(){
        String code;
        while (true){
            try {
                System.out.println("Enter villa code (Ex: SVVL-0000): ");
                code = scanner.nextLine();
                if (!Regex.checkCodeVilla(code)){
                    throw new Exception("Invalid villa CODE format. Please re-enter");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: Villa1): ");
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
                System.out.println("Enter villa area (m2): ");
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
                System.out.println("Invalid syntax. Please try again");
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
                System.out.println("Invalid syntax. Please try again");
            } catch (Exception e){
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String type;
        adc4:
        while (true){
            try {
                System.out.println("Enter a rental type:\n1.Year\n2. Month\n3. Day\n4.Hour");
                int tempType = Integer.parseInt(scanner.nextLine());

                switch (tempType){
                    case 1:
                        type = "Year";
                        break adc4;
                    case 2:
                        type = "Month";
                        break adc4;
                    case 3:
                        type = "Day";
                        break adc4;
                    case 4:
                        type = "Hour";
                        break adc4;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String villaStandard;
        adc5:
        while (true){
            try {
                System.out.println("Enter standard:\n1. Standard\n2. Superior\n3. Deluxe\n4. Suite");
                int tempHouseStandard = Integer.parseInt(scanner.nextLine());
                switch (tempHouseStandard){
                    case 1:
                        villaStandard = "Standard";
                        break adc5;
                    case 2:
                        villaStandard = "Superior";
                        break adc5;
                    case 3:
                        villaStandard = "Deluxe";
                        break adc5;
                    case 4:
                        villaStandard = "Suite";
                        break adc5;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        double poolArea;
        while (true){
            try {
                System.out.println("Enter the pool area (m2): ");
                poolArea = Double.parseDouble(scanner.nextLine());
                if (poolArea < 30){
                    throw new AreaException("Area must be more than 30. Please try again");
                }
                break;
            } catch (AreaException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
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
        Villa villa = new Villa(code,name,area,cost,amount,type,villaStandard,poolArea,floor);
        return villa;
    }


    private Map<Villa, Integer> readFileVilla(){
        BufferedReader bufferedReader = null;
        String line;
        String[] info;
        Villa villa;

        try {
            villaList = new LinkedHashMap<>();
            File file = new File("src\\furama_resort_manager\\data\\facility\\villa.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                villa = new Villa(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6],Double.parseDouble(info[7]),Integer.parseInt(info[8]));
                villaList.put(villa, Integer.parseInt(info[9]));
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
        return villaList;
    }

    private void writeFileVilla(Map<Villa, Integer> villaList){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\furama_resort_manager\\data\\facility\\villa.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Villa> set = villaList.keySet();
            for (Villa key : set) {
                bufferedWriter.write(getInfo(key) + "," + villaList.get(key));
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
    public String getInfo(Villa villa){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",villa.getCode(),villa.getServiceName(),villa.getArea(),villa.getCost(),villa.getAmount(),villa.getType(),villa.getVillaStandard(),villa.getPoolArea(),villa.getFloor());
    }
}
