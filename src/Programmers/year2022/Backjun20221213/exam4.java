package Programmers.year2022.Backjun20221213;

import java.util.Scanner;
//오름차순했을 때 B의 K번째 값이므로 접근 방법을
//B[K]보다 작거나 같은 수는 최소 11개라는의미이다.

public class exam4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//배열의 크기 N
        int K = sc.nextInt();//정답의 위치 K

        int[] B = new int[N*N];

        if(K==1){
            System.out.println(1);
            return;
        }

        if(K==N*N){
            System.out.println(N*N);
            return;
        }

        long left = 1;
        long right = K;

        while (left <= right) {
            long mid = (left+right) / 2;
            long cnt = 0;

            /*
             *  임의의 mid에 대해 i번 째 행을 나눔으로써 mid보다 작거나 같은 원소의 개수
             *  누적 합을 구한다.
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N,mid/i);
            }
            //count가 더 크다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻이므로 줄여줘야한다?
            if(cnt >= K) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
