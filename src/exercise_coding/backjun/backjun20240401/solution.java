//백준 2505 - 바이러스
package exercise_coding.backjun.backjun20240401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    static Set<Integer> answer = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        boolean[][] bool = new boolean[n+1][n+1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            bool[k][l] = true;
            bool[l][k] = true;
        }

        bool[1][1] = true;
        answer.add(1);
        dfs(bool, 0 , 1);
        System.out.println(answer.size() - 1);
    }

    private static void dfs(boolean[][] arr, int cnt, int start) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][start] && !answer.contains(i)) {
                answer.add(i);
                dfs(arr, cnt + 1 , i);
            }
        }
    }
}
