package ss5_Access_modifier_static_method_static_property.execise.BuildWriteOnlyClassesInJava;

public class Student {
    private String name = "John";
    private String classes = "C02";
    public Student(){

    }
    public String setName (String name){
        return this.name = name;
    }
    public String setClasses (String classes){
        return this.classes = classes;
    }
    public  String toString(){
        return "Tên: " + this.name + "\nLớp: " + this.classes;
    }
}
