package furama_resort_manager.service.facility_service;

import furama_resort_manager.model.facilitys.House;
import furama_resort_manager.model.facilitys.Room;
import furama_resort_manager.service.i_facility.IRoomService;
import furama_resort_manager.utils.exception.AmountException;
import furama_resort_manager.utils.exception.AreaException;
import furama_resort_manager.utils.exception.CostException;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RoomService implements IRoomService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Room, Integer> roomList = new LinkedHashMap<>();
    @Override
    public void display() {
        roomList = readFileRoom();
        Set<Room> set = roomList.keySet();
        for (Room key : set){
            System.out.println(key);
        }
    }

    @Override
    public void add() {
        roomList = readFileRoom();
        Room room = this.infoRoom();
        roomList.put(room, 0);
        writeFileRoom(roomList);
        System.out.println("Successfully added new");
    }

    private Room infoRoom(){
        String code;
        while (true){
            try {
                System.out.println("Enter room code (Ex: SVRO-0000): ");
                code = scanner.nextLine();
                if (Regex.checkCodeRoom(code)){
                    break;
                }else {
                    System.out.println("Invalid room CODE format. Please re-enter");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: Room1): ");
                name = scanner.nextLine();
                if (Regex.checkNameFacility(name)){
                    break;
                }else {
                    System.out.println("Invalid service name format. Please re-enter");
                }
            } catch (Exception e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        double area;
        while (true){
            try {
                System.out.println("Enter room area (m2): ");
                area = Double.parseDouble(scanner.nextLine());
                if (area < 30){
                    throw new AreaException("Area must be more than 30. Please try again");
                }
                break;
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
            }
        }
        String type;
        adc3:
        while (true){
            try {
                System.out.println("Enter a rental type:\n1.Year\n2. Month\n3. Day\n4.Hour");
                int tempType = Integer.parseInt(scanner.nextLine());

                switch (tempType){
                    case 1:
                        type = "Year";
                        break adc3;
                    case 2:
                        type = "Month";
                        break adc3;
                    case 3:
                        type = "Day";
                        break adc3;
                    case 4:
                        type = "Hour";
                        break adc3;
                    default:
                        System.out.println("Please enter as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        String freeService = null;
        adc10:
        while (true){
            try {
                System.out.println("Please choose the free service:\nHairdressing tools (1. Agree, 2. Skip, 3. Done): ");
                int choice1 = Integer.parseInt(scanner.nextLine());
                switch (choice1){
                    case 1:
                        freeService = "Hairdressing tools ";
                        break;
                    case 2:
                        freeService = "";
                        break;
                    case 3:
                        break adc10;
                }
                System.out.println("Please choose the free service:\nPhone battery charger (1. Agree, 2. Skip, 3. Done): ");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2){
                    case 1:
                        freeService += "Phone battery charger ";
                        break;
                    case 2:
                        freeService = "";
                        break;
                    case 3:
                        break adc10;
                }
                System.out.println("Please choose the free service:\nSocks and bathrobes (1. Agree, 2. Skip, 3. Done): ");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3){
                    case 1:
                        freeService += "Socks and bathrobes ";
                        break;
                    case 2:
                        freeService = "";
                        break;
                    case 3:
                        break adc10;
                }
                System.out.println("Please choose the free service:\nSlippers, cotton towels and sun loungers (1. Agree, 2. Skip, 3. Done): ");
                int choice4 = Integer.parseInt(scanner.nextLine());
                switch (choice4){
                    case 1:
                        freeService += "Slippers, cotton towels and sun loungers ";
                        break;
                    case 2:
                        freeService = "";
                        break;
                    case 3:
                        break adc10;
                }
                System.out.println("Please choose the free service:\nYoga Mats (1. Agree, 2. Skip, 3. Done): ");
                int choice5 = Integer.parseInt(scanner.nextLine());
                switch (choice5){
                    case 1:
                        freeService += "Yoga Mats ";
                        break;
                    case 2:
                        freeService = "";
                        break;
                    case 3:
                        break adc10;
                }
                break adc10;
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
        Room room = new Room(code,name,area,cost,amount,type,freeService);
        return room;
    }

    private Map<Room, Integer> readFileRoom(){
        BufferedReader bufferedReader = null;
        String line;
        String[] info;
        Room room;

        try {
            roomList = new LinkedHashMap<>();
            File file = new File("src\\furama_resort_manager\\data\\facility\\room.csv");
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                info = line.split(",");
                room = new Room(info[0],info[1],Double.parseDouble(info[2]),Double.parseDouble(info[3]),Integer.parseInt(info[4]),info[5],info[6]);
                roomList.put(room, Integer.parseInt(info[7]));
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
        return roomList;
    }

    private void writeFileRoom(Map<Room, Integer> roomList){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("src\\furama_resort_manager\\data\\facility\\room.csv");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Room> set = roomList.keySet();
            for (Room key : set) {
                bufferedWriter.write(getInfo(key) + "," + roomList.get(key));
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
    private String getInfo(Room room){
        return String.format("%s,%s,%s,%s,%s,%s,%s",room.getCode(),room.getServiceName(),room.getArea(),room.getCost(),room.getAmount(),room.getType(),room.getFreeService());
    }
}
