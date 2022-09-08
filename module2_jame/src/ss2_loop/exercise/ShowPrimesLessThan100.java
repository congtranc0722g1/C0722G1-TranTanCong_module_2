package ss2_loop.exercise;

public class ShowPrimesLessThan100 {
    public static void main(String[] args) {
        int n = 2;
        while (n < 100){
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0){
                    count++;
                }
            }
            if(count == 2){
                System.out.print(n + "\t");
            }
            n++;
        }
    }
}
