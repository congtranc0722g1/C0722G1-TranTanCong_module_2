package ss5_Access_modifier_static_method_static_property.practise.StaticProperty;

public class TestStaticProperty {
    public static void main(String[] args) {

        Car car1 = new Car("Mazda 3","Skyactiv 3");

        System.out.println(Car.numberOfCars);

        Car car2 = new Car("Mazda 6","Skyactiv 6");

        System.out.println(Car.numberOfCars);

        Car car3 = new Car("Mazda 7","Skyactiv 7");

        System.out.println(Car.numberOfCars);

        Car car4 = new Car("Mazda 8","Skyactiv 999");

        System.out.println(Car.numberOfCars);

    }
}
