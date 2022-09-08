package ss2_loop.exercise;

public class ShowFirst20Primes {
    public static void main(String[] args) {
        int n = 2;
        int times = 0;
        while (times < 20){
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0){
                    count++;
                }

            }
            if(count == 2){
                System.out.print(n + "\t");
                times++;
            }
            n++;
        }
    }
}
