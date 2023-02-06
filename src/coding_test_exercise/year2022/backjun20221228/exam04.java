//백준 1182번 부분수열의 합
package coding_test_exercise.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam04 {
    static int[] numbers;
    static boolean[] visited;
    static int S;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        visited = new boolean[N];
        cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(S == 0 ? cnt - 1 : cnt);

    }

    private static void dfs(int idx, int sum) {
        if(idx == numbers.length){
            if(sum == S){
                cnt++;
            }
            return;
        }

        dfs(idx+1,sum+numbers[idx]);
        dfs(idx+1,sum);
    }
}
