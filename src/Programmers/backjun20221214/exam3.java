package Programmers.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquid = new int[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;
        if((liquid[left] <= 0 && liquid[right] <= 0) ||
                (liquid[left] >= 0 && liquid[right] >= 0)){
            System.out.println(liquid[right-1] + " " + liquid[right]);
            return;
        }
        int min = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;
        while (left < right) {
            int sum = liquid[left] + liquid[right];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer1 = liquid[left];
                answer2 = liquid[right];
            }
            //두 개의 부호가 다른 경우..
            if(sum > 0) {
                right--;
            }else {
                left++;
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
