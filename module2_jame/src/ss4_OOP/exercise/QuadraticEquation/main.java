package ss4_OOP.exercise.QuadraticEquation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquations = new QuadraticEquation(a,b,c);
        if (quadraticEquations.getDiscriminant() > 0){
            System.out.print(" Phương trình có 2 nghiệm phân biệt là: " + quadraticEquations.getRoot1() + " và " + quadraticEquations.getRoot2());
        }
        else if (quadraticEquations.getDiscriminant() == 0){
            System.out.print("Phương trình có nghiệm kép là: " + quadraticEquations.getRoot());
        }else {
            System.out.print("Phương trình vô nghiệm");
        }
    }
}
