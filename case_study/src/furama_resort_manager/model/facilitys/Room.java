package furama_resort_manager.model.facilitys;

public class Room extends Facility{
    private String freeService;

    public Room() {

    }

    public Room(String code, String name, double area, String cost, int amount, String type, String freeService) {
        super(code, name, area, cost, amount, type);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
