package ss10_List.execise.ImplementMethodsOfArrayList;

public class MyListTest {
    public static class  Student{
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"Cong1");
        Student student2 = new Student(2,"Cong2");
        Student student3 = new Student(3,"Cong3");
        Student student4 = new Student(4,"Cong4");
        Student student5 = new Student(5,"Cong5");
        Student student6 = new Student(6,"Cong6");
        Student student7 = new Student(7,"Cong7");
        Student student8 = new Student(8,"Tran");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        studentMyList.add(student5);
        studentMyList.add(student6);
        studentMyList.add(student7);
        studentMyList.add(student8, 6);
        studentMyList.size();
//        for (int i = 0; i < studentMyList.size(); i++) {
//            Student student = (Student) studentMyList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//            System.out.println(studentMyList.size());
//            System.out.println(studentMyList.get(2).getName());
            System.out.println(studentMyList.contains(student3));
        }
    }
//}

