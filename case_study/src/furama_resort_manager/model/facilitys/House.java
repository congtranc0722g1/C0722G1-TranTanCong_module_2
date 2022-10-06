package furama_resort_manager.model.facilitys;

public class House extends Facility{
    private String houseStandard;
    private int floor;

    public House() {

    }

    public House(String code, String name, double area, double cost, int amount, String type, String houseStandard, int floor) {
        super(code, name, area, cost, amount, type);
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

    @Override
    public String toString() {
        return super.toString() + "House Standard: " + houseStandard + ",\t" +
                "Number Of Floors: " + floor;
    }
}
