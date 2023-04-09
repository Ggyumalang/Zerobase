package exercise_coding.backjun.backjun20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) throws IOException {
        int p1 = 0;
        int p2 = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[] dp = new int[first.length()];
        int idx = 1;
        boolean isChanged = false;
        while (p1 < first.length() && p2 < second.length()){
            System.out.println("p1 >> " + first.charAt(p1));
            System.out.println("p2 >> " + second.charAt(p2));
            if(first.charAt(p1) == second.charAt(p2)){
                dp[idx-1]++;
                p1++;
                p2++;
            }else {
                if(isChanged){
                    p1++;
                }else {
                    p2++;
                }
            }

            if(p2 == second.length() && !isChanged){
                System.out.println("턴체인지1");
                p2 = p1-1;
                isChanged = true;
            } else if(p1 == first.length() && isChanged){
                System.out.println("턴체인지2");
                p2 = 0;
                p1 = idx++;
                isChanged = false;
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
