package furama_resort_manager.model.person;

import java.time.LocalDate;

public class Customer extends Person{
    private String guestType;
    private String address;

    public Customer() {
    }

    public Customer(String code, String name, LocalDate dateOfBirth, String gender, String identityNumber, String phoneNumber, String email, String guestType, String address) {
        super(code, name, dateOfBirth, gender, identityNumber, phoneNumber, email);
        this.guestType = guestType;
        this.address = address;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
