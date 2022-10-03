package furama_resort_manager.model.facilitys;

public class Villa extends Facility {
    private String villaStandard;

    public Villa() {

    }

    public Villa(String serviceName, double area, String cost, int amount, String type, String villaStandard) {
        super(serviceName, area, cost, amount, type);
        this.villaStandard = villaStandard;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }
}
