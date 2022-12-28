package Programmers.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam06_2 {
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        //초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min);
    }

    public static void dfs(int index, int cnt){
        if(cnt == N/2){
            diff();
            return;
        }

        for (int i = index; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(index+1 ,cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void diff(){
        int score = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]){
                    score += map[i][j];
                    score += map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    score -= map[i][j];
                    score -= map[j][i];
                }
            }
        }

        if(score == 0){
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min,Math.abs(score));
    }
}
