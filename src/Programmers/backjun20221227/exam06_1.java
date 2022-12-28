//백준 14889번 스타트와 링크
package Programmers.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam06_1 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0,0);
        System.out.println(min);

    }

    public static void combination(int idx , int cnt) {
        //팀 조합이 완성되었을 때..
        if(cnt == N/2){
            /*
            * 방문한 팀과 방문하지 않은 팀을 각각 나누어
            * 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
            * */
            diff();
            return;

        }

        for (int i = idx; i < N; i++) {
            if(!visited[i]){
                visited[i] = true; //방문으로 변경
                combination(i+1,cnt+1); //재귀 호출 인덱스 증가, cnt 증가
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int score = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                //i번째 사람과 j번째 사람이 방문 true 라면 start 팀
                if(visited[i]  && visited[j]){
                    score += map[i][j];
                    score += map[j][i];
                    //i번째 사람과 j번째 사람이 방문 false 라면 link팀
                } else if (!visited[i] && !visited[j]) {
                    score -= map[i][j];
                    score -= map[j][i];
                }
            }
        }

        if(score == 0) {
            System.out.println(0);
            System.exit(0); //시스템 강제정상종료 status : 1이면 강제 비정상종료
        }

        min = Math.min(Math.abs(score),min);
    }

}
