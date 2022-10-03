package furama_resort_manager.model.person;

import java.time.LocalDate;

public class Employee extends Person{
    private String level;
    private String position;
    private String salary;

    public Employee() {

    }

    public Employee(String code, String name, LocalDate dateOfBirth, String gender, String identityNumber, String phoneNumber, String email, String level, String position, String salary) {
        super(code, name, dateOfBirth, gender, identityNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
