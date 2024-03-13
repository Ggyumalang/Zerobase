package exercise_coding.backjun.backjun20240309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(Arrays.toString(coins));

        for (int i = n-1; i >= 0 ; i--) {
            if(k > 0 && k >= coins[i]) {
                answer = answer + ( k / coins[i]);
                k %= coins[i];
            }
        }
        System.out.println(answer);
    }
}
