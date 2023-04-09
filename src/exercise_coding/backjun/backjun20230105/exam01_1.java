//백준 9251 자바 LCS
package exercise_coding.backjun.backjun20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam01_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[][] dp = new int[first.length()+1][second.length()+1];

        for (int i = 0; i < first.length(); i++) {
            char f = first.charAt(i);
            for (int j = 0; j < second.length(); j++) {
                if(f==second.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        System.out.println(dp[first.length()][second.length()]);
    }
}
