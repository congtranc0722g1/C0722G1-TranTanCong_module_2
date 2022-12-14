package codegym_management_system.model;

public abstract class Person {
    private String code;
    private String name;
    private String gender;

    public Person(String code, String name, String gender) {
        this.code = code;
        this.name = name;
        this.gender = gender;
    }

    public Person() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Mã: " + getCode() + ",\t"
                + "Tên: " + getName() + ",\t"
                + "Giới tính: " + getGender() + ',';
    }
}
