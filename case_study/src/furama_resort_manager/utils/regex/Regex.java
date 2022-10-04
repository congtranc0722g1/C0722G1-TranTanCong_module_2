package furama_resort_manager.utils.regex;

public class Regex {
    public static boolean checkCodePerson(String codeEmployee){
        boolean check = codeEmployee.matches("^[N][V][-][0-9]{4}$");
        return check;
    }

    public static boolean checkIdentityNumber(String idNumbers){
        boolean check = idNumbers.matches("^[0-9]{12}$");
        return check;
    }

    public static boolean checkPhoneNumber (String phone){
        boolean check = phone.matches("^[0][0-9]{9}$");
        return check;
    }

    public static boolean checkEmail(String email){
        boolean check = email.matches("^[A-Za-z0-9]*[@][A-Za-z0-9]*[.][A-Za-z0-9]*$");
        return check;
    }

    public static boolean checkSalary(String salary){
        boolean check = salary.matches("[0-9]*[V][N][D]");
        return check;
    }
}
