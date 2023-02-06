package coding_test_exercise.backjun.backjun20230103;

import java.util.Scanner;

public class exam01_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 0;
        while (N%5 != 0){
            N -= 3;
            num++;
        }

        if(N < 0) System.out.println(-1);
        else {
            num += N/5;
            System.out.println(num);
        }
    }
}
