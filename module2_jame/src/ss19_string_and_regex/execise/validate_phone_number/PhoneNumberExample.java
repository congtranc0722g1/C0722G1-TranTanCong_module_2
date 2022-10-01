package ss19_string_and_regex.execise.validate_phone_number;

public class PhoneNumberExample {
    String phone;
    private static final String PHONE_NUMBER_REGEX = "^[(][0-9]{2}[)][-][(]0[0-9]{9}[)]$";

    public PhoneNumberExample(){

    }

    public PhoneNumberExample(String phone){
        this.phone = phone;
    }

    public boolean PhoneNumberExample(){
        if (this.phone.matches(PHONE_NUMBER_REGEX)){
            return true;
        }
        return false;
    }
}
