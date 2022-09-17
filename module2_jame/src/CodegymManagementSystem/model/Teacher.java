package CodegymManagementSystem.model;

public class Teacher extends Person {
    String specialize;

    public Teacher() {
    }

    public Teacher(String specialize) {
        this.specialize = specialize;
    }

    public Teacher(String code, String name, String gender, String specialize) {
        super(code,name,gender);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "specialize = " + getSpecialize() +
                "} " + super.toString();
    }
}
