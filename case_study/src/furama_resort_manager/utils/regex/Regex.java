package furama_resort_manager.utils.regex;

public class Regex {
    public static boolean checkName(String name){
        boolean check = name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$");
        return check;
    }
    public static boolean checkCodeEmployee(String codeEmployee){
        boolean check = codeEmployee.matches("^NV[-][0-9]{4}$");
        return check;
    }

    public static boolean checkIdentityNumber(String idNumbers){
        boolean check = idNumbers.matches("^[0-9]{12}$");
        return check;
    }

    public static boolean checkPhoneNumber (String phone){
        boolean check = phone.matches("^[+][0-9]{2,3}[0-9]{9}$");
        return check;
    }

    public static boolean checkEmail(String email){
        boolean check = email.matches("^[A-Za-z0-9]*[@][A-Za-z0-9]*[.][A-Za-z0-9]*$");
        return check;
    }

    public static boolean checkSalary(String salary){
        boolean check = salary.matches("^[0-9]*[V][N][D]$");
        return check;
    }

    public static boolean checkCodeCustomer (String codeCustomer){
        boolean check = codeCustomer.matches("^KH[-][0-9]{4}$");
        return check;
    }

    public static boolean checkCodeVilla(String codeVilla){
        boolean check = codeVilla.matches("^SVVL[-][0-9]{4}$");
        return check;
    }

    public static boolean checkCodeHouse(String codeHouse){
        boolean check = codeHouse.matches("^SVHO[-][0-9]{4}$");
        return check;
    }

    public static boolean checkCodeRoom(String codeRoom){
        boolean check = codeRoom.matches("^SVRO[-][0-9]{4}$");
        return check;
    }
    public static boolean checkNameFacility (String nameFacility){
        boolean check = nameFacility.matches("^[A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ0-9]*$");
        return check;
    }
}
