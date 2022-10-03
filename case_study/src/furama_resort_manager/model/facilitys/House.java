package furama_resort_manager.model.facilitys;

public class House extends Facility{
    private String houseStandard;
    private int floor;

    public House() {

    }

    public House(String name, double area, String cost, int amount, String type, String houseStandard, int floor) {
        super(name, area, cost, amount, type);
        this.houseStandard = houseStandard;
        this.floor = floor;
    }

    public String getHouseStandard() {
        return houseStandard;
    }

    public void setHouseStandard(String houseStandard) {
        this.houseStandard = houseStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
