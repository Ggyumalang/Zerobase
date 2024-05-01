//백준 5557번 1학년 - 골드5
package exercise_coding.backjun.back20240412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int limitNum = 20;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //총 n-1 개의 값을 확인해야하고, 그 값은 0 - 20 까지 담길 수 있으므로..
        long[][] dp = new long[n - 1][21];
        dp[0][arr[0]] = 1;
        //나오는 값들을 담을 set
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);

        for (int i = 1; i < n - 1; i++) {
            //새로이 추가되는 값들을 저장할 set
            Set<Integer> newSet = new HashSet<>();
            for (Integer val : set) {
                int plusVal = val + arr[i];
                int minusVal = val - arr[i];

                if (plusVal <= 20 && dp[i - 1][val] != 0) {
                    dp[i][plusVal] += dp[i - 1][val];
                    newSet.add(plusVal);
                }

                if (minusVal >= 0 && dp[i - 1][val] != 0) {
                    dp[i][minusVal] += dp[i - 1][val];
                    newSet.add(minusVal);
                }
            }
            //기존의 set을 지우고 newSet으로 값을 바꿔줍니다.
            set.clear();
            set.addAll(newSet);
        }
        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}
