package coding_test_exercise.backjun.backjun20230103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items, (x,y) -> x[0] - y[0]);
        System.out.println(Arrays.deepToString(items));
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if(items[i][0] <= j){
                    //한계무게와 비등할때
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-items[i][0]] + items[i][1]);
                }else {
                    //한계무게보다 클때..
                    dp[i][j] = dp[i-1][j];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        System.out.println(Arrays.stream(dp[N]).max().getAsInt());
    }
}
