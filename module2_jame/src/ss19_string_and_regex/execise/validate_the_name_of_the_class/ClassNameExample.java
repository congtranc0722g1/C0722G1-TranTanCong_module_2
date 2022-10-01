package ss19_string_and_regex.execise.validate_the_name_of_the_class;

public class ClassNameExample {
    private static final String CLASS_NAME_REGEX = "[CAP][0-9]{4}[G-M]";
    String name;

    public ClassNameExample(){

    }

    public ClassNameExample(String name) {
        this.name = name;
    }

    public boolean classNameExample(){
        if (this.name.matches(CLASS_NAME_REGEX)){
            return true;
        }
        return false;
    }

}
