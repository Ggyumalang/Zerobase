package Programmers.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 1;
        int right = K;
        while (left < right) {
            int mid = (left+right) / 2;
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += Math.min(N,mid/i);
            }

            if(sum < K){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
