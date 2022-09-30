package codegym_management_system.model;

public class Teacher extends Person implements Comparable<Teacher>{
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
        return super.toString() + " | Giáo viên: " +
                "Trình độ: " + getSpecialize();
    }

    @Override
    public int compareTo(Teacher o) {
        if (this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        }
        return this.getCode().compareTo(o.getCode());
    }

//    public String getInfo(){
//        return String.format("%s,%s,%s,%s",getCode(),getName(),getGender(),getSpecialize());
//    }
}
