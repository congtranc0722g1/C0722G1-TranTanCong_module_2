package furama_resort_manager.service.impl;

import furama_resort_manager.model.Booking;
import furama_resort_manager.model.facilitys.Facility;
import furama_resort_manager.model.facilitys.House;
import furama_resort_manager.model.facilitys.Room;
import furama_resort_manager.model.facilitys.Villa;
import furama_resort_manager.service.IFacilityService;
import furama_resort_manager.service.i_facility.IHouseService;
import furama_resort_manager.service.i_facility.IRoomService;
import furama_resort_manager.service.i_facility.IVillaService;
import furama_resort_manager.utils.exception.*;
import furama_resort_manager.utils.regex.Regex;

import java.io.*;
import java.util.*;

public class FacilityService implements IHouseService, IRoomService, IVillaService, IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Facility> maintenanceList = new ArrayList<>();
    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static Map<House, Integer> houseList = new LinkedHashMap<>();
    private static Map<Room, Integer> roomList = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaList = new LinkedHashMap<>();
    @Override
    public void displayListFacility() {
        while (true){
            try {
                System.out.println("Display list of facilities: \n1. Display all\n2. Display house list\n3. Display room list\n4. Display villa list\n5. Back");
                int choiceDisplay = Integer.parseInt(scanner.nextLine());
                switch (choiceDisplay){
                    case 1:
                        displayHouse();
                        displayRoom();
                        displayVilla();
                        break;
                    case 2:
                        displayHouse();
                        break;
                    case 3:
                        displayRoom();
                        break;
                    case 4:
                        displayVilla();
                    case 5:
                        return;
                    default:
                        System.out.println("Please enter correctly as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
    }

    @Override
    public void displayListFacilityMaintenance() {
        houseList = readFileHouse();
        roomList = readFileRoom();
        villaList = readFileVilla();
        for (House house : houseList.keySet()) {
            facilityList.put(house, 0);
        }
        for (Room room : roomList.keySet()) {
            facilityList.put(room, 0);
        }
        for (Villa villa : villaList.keySet()) {
            facilityList.put(villa, 0);
        }

        List<Booking> bookingList = BookingService.readFileBooking();
        for (int i = 0; i < bookingList.size(); i++) {
            for (Facility facility : facilityList.keySet()) {
                if (bookingList.get(i).getCodeBooking().equals(facility.getCode())){
                    facilityList.replace(facility, facilityList.get(facility) + 1);
                    if (facilityList.get(facility) == 5){
                        maintenanceList.add(facility);
                    }
                }
            }
        }

    }

    @Override
    public void add() {
        while (true) {
            try {
                System.out.println("Add new facilities: \n1. Add new house \n2. Add new room \n3. Add new villa \n4. Back ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                switch (choiceAdd){
                    case 1:
                        addHouse();
                        break;
                    case 2:
                        addRoom();
                        break;
                    case 3:
                        addVilla();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please enter correctly as required");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid syntax. Please try again");
            }
        }
    }

    private House infoHouse(){
        String code;
        while (true){
            try {
                System.out.println("Enter house code (Ex: SVHO-0000): ");
                code = scanner.nextLine();
                if (!Regex.checkCodeHouse(code)){
                    throw new FacilityException("Invalid house CODE format. Please re-enter");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: House1): ");
                name = scanner.nextLine();
                if (!Regex.checkNameFacility(name)){
                    throw new FacilityException("Invalid service name format. Please re-enter");
                }
                break;
            } catch (FacilityException e) {
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

    private Room infoRoom(){
        String code;
        while (true){
            try {
                System.out.println("Enter room code (Ex: SVRO-0000): ");
                code = scanner.nextLine();
                if (!Regex.checkCodeRoom(code)){
                    throw new FacilityException("Invalid room CODE format. Please re-enter");

                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: Room1): ");
                name = scanner.nextLine();
                if (!Regex.checkNameFacility(name)){
                    throw new FacilityException("Invalid service name format. Please re-enter");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
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

    private Villa infoVilla(){
        String code;
        while (true){
            try {
                System.out.println("Enter villa code (Ex: SVVL-0000): ");
                code = scanner.nextLine();
                if (!Regex.checkCodeVilla(code)){
                    throw new FacilityException("Invalid villa CODE format. Please re-enter");
                }
                break;
            } catch (FacilityException e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true){
            try {
                System.out.println("Enter service name (Ex: Villa1): ");
                name = scanner.nextLine();
                if (!Regex.checkNameFacility(name)){
                    throw new FacilityException("Invalid service name format. Please re-enter");
                }
                break;
            } catch (FacilityException e) {
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
                System.out.println("Enter a rental type:\n1. Year\n2. Month\n3. Day\n4. Hour");
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
                bufferedWriter.write(getInfoHouse(key) + "," + houseList.get(key));
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

    private String getInfoHouse (House house){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",house.getCode(),house.getServiceName(),house.getArea(),house.getCost(),house.getAmount(),house.getType(),house.getHouseStandard(),house.getFloor());
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
                bufferedWriter.write(getInfoRoom(key) + "," + roomList.get(key));
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
    private String getInfoRoom(Room room){
        return String.format("%s,%s,%s,%s,%s,%s,%s",room.getCode(),room.getServiceName(),room.getArea(),room.getCost(),room.getAmount(),room.getType(),room.getFreeService());
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
                bufferedWriter.write(getInfoVilla(key) + "," + villaList.get(key));
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
    public String getInfoVilla(Villa villa){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",villa.getCode(),villa.getServiceName(),villa.getArea(),villa.getCost(),villa.getAmount(),villa.getType(),villa.getVillaStandard(),villa.getPoolArea(),villa.getFloor());
    }

    @Override
    public void addHouse() {
        houseList = readFileHouse();
        House house = this.infoHouse();
        houseList.put(house, 0);
        writeFileHouse(houseList);
        System.out.println("Successfully added new");
    }

    @Override
    public void displayHouse() {
        houseList = readFileHouse();
        Set<House> set = houseList.keySet();
        for (House key : set){
            System.out.println(key);
        }
    }

    @Override
    public void addRoom() {
        roomList = readFileRoom();
        Room room = this.infoRoom();
        roomList.put(room, 0);
        writeFileRoom(roomList);
        System.out.println("Successfully added new");
    }

    @Override
    public void displayRoom() {
        roomList = readFileRoom();
        Set<Room> set = roomList.keySet();
        for (Room key : set){
            System.out.println(key);
        }
    }

    @Override
    public void addVilla() {
        villaList = readFileVilla();
        Villa villa = this.infoVilla();
        villaList.put(villa, 0);
        writeFileVilla(villaList);
        System.out.println("Successfully added new");
    }

    @Override
    public void displayVilla() {
        villaList = readFileVilla();
        Set<Villa> set = villaList.keySet();
        for (Villa key : set){
            System.out.println(key);
        }
    }
}
