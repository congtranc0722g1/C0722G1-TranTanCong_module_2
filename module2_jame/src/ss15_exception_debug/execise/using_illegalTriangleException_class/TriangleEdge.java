package ss15_exception_debug.execise.using_illegalTriangleException_class;

import java.util.Scanner;

public class TriangleEdge {
    public static void triangleEdge() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int c;
        while (true) {
            try {
                System.out.print("Nhập vào cạnh a: ");
                a = Integer.parseInt(scanner.nextLine());
                if (a <= 0) {
                    throw new IllegalTriangleException("Định dạng cạnh không hợp lệ");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Định dạng cạnh không hợp lệ");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập vào cạnh b: ");
                b = Integer.parseInt(scanner.nextLine());
                if (b <= 0) {
                    throw new IllegalTriangleException("Định dạnh cạnh không hợp lệ");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Định dạng cạnh không hợp lệ");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập vào cạnh c: ");
                c = Integer.parseInt(scanner.nextLine());
                if (c <= 0) {
                    throw new IllegalTriangleException("Định dạnh cạnh không hợp lệ");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            }
            catch (NumberFormatException e){
                System.out.println("Định dạng cạnh không hợp lệ");
            }
        }
        checkEdge(a,b,c);

    }
    public static void checkEdge(int a, int b, int c) throws IllegalTriangleException{
        try {
            if (!(a + b >= c && b + c >= a && c + a >= b)){
                throw new IllegalTriangleException("Định dạng cạnh không hợp lệ");
            }
        }catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
            triangleEdge();
        }
        System.out.print("Tam giác có 3 cạnh: " + a +"," +  b +","+ c);
    }

}
