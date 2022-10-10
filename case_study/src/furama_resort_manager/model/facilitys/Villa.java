package furama_resort_manager.model.facilitys;

public class Villa extends Facility {
    private String villaStandard;
    private double poolArea;
    private int floor;

    public Villa() {

    }

    public Villa(String code, String serviceName, double area, double cost, int amount, String type, String villaStandard, double poolArea, int floor) {
        super(code, serviceName, area, cost, amount, type);
        this.villaStandard = villaStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString() + "Villa Standard: " + villaStandard + ",\t" +
                "Pool Area: " + poolArea + ",\t" + "Number Of Floors: " + floor;
    }
}
