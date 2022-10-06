package furama_resort_manager.model.facilitys;

public abstract class Facility {
    private String code;
    private String serviceName;
    private double area;
    private double cost;
    private int amount;
    private String type;

    public Facility() {

    }

    public Facility(String code, String serviceName, double area, double cost, int amount, String type) {
        this.code = code;
        this.serviceName = serviceName;
        this.area = area;
        this.cost = cost;
        this.amount = amount;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Service Code: " + code + ",\t" +
                "Service Name: " + serviceName + ",\t" +
                "Area: " + area + ",\t" +
                "Rental Cost: " + cost + ",\t" +
                "Maximum number of people: " + amount + ",\t" +
                "Rental Type: " + type + ",";
    }
}
