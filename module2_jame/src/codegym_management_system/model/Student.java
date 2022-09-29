package codegym_management_system.model;

public class Student extends Person implements Comparable<Student> {
    private String nameClass;
    //wrapper class
    private double score;

    public Student(String code, String name, String gender, String nameClass, double score) {
        super(code, name, gender);
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student(String nameClass, double score) {
        this.nameClass = nameClass;
        this.score = score;
    }

    public Student() {
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return super.toString() + " | Học sinh: " +
                "Tên lớp: " + getNameClass() + ",\t" +
                "Điểm: " + getScore();
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s",this.getCode(),this.getName(), this.getGender(),this.getNameClass(),this.getScore());
    }
    @Override
    public int compareTo(Student o) {
        if (this.getName().compareTo(o.getName()) != 0){
            return this.getName().compareTo(o.getName());
        }
        return this.getCode().compareTo(o.getCode());
    }
}
