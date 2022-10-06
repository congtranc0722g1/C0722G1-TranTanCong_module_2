package furama_resort_manager.service.impl;

import furama_resort_manager.service.IFacilityService;
import furama_resort_manager.service.IService;
import furama_resort_manager.service.facility_service.HouseService;
import furama_resort_manager.service.facility_service.RoomService;
import furama_resort_manager.service.facility_service.VillaService;
import furama_resort_manager.service.i_facility.IHouseService;
import furama_resort_manager.service.i_facility.IRoomService;
import furama_resort_manager.service.i_facility.IVillaService;

import java.util.Scanner;

public class FacilityService implements IService, IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static IHouseService iHouseService = new HouseService();
    private static IVillaService iVillaService = new VillaService();
    private static IRoomService iRoomService = new RoomService();
    @Override
    public void displayListFacility() {
        while (true){
            try {
                System.out.println("Display list of facilities: \n1. Display all\n2. Display house list\n3. Display room list\n4. Display villa list\n5. Back");
                int choiceDisplay = Integer.parseInt(scanner.nextLine());
                switch (choiceDisplay){
                    case 1:
                        iHouseService.display();
                        iRoomService.display();
                        iVillaService.display();
                        break;
                    case 2:
                        iHouseService.display();
                        break;
                    case 3:
                        iRoomService.display();
                        break;
                    case 4:
                        iVillaService.display();
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

    }

    @Override
    public void add() {
        while (true) {
            try {
                System.out.println("Add new facilities: \n1. Add new house \n2. Add new room \n3. Add new villa \n4. Back ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                switch (choiceAdd){
                    case 1:
                        iHouseService.add();
                        break;
                    case 2:
                        iRoomService.add();
                        break;
                    case 3:
                        iVillaService.add();
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
}
