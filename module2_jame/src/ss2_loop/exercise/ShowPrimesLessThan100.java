package ss2_loop.exercise;

public class ShowPrimesLessThan100 {
    public static void main(String[] args) {
        int N = 2;
        while (N < 100){
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (N % i == 0){
                    count++;
                }
            }
            if(count == 2){
                System.out.print(N + "\t");
            }
            N++;
        }
    }
}
