//백준 - 로봇청소기
//dfs
//정해진 방향과
//후진관련

package exercise_coding.backjun.backjun20230327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam02_1 {

    static class Robot{
        int x;
        int y;

        public Robot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] room;
    static int clean,N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean = 1;
        dfs(x,y,dir);
        System.out.println(clean);
        System.out.println(Arrays.deepToString(room));
    }

    private static void dfs(int x, int y, int direction) {
        room[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            direction = (direction+3) % 4;
            int nx = x + dirs[direction][0];
            int ny = y + dirs[direction][1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M ){
                continue;
            }

            if(room[nx][ny] != 0){
                continue;
            }

            clean++;
            dfs(nx,ny,direction);
            return;
        }

        //네 방향 모두 청소가 이미 되어 있거나 벽인 경우 바라보는 방향을 유지한 채로 한칸 후진
        int back = (direction+2) % 4;
        int bx = x + dirs[back][0];
        int by = y + dirs[back][1];

        //후진이 가능할 경우 후진한 포지션을 기준으로 dfs
        if(bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1 ){
            dfs(bx,by,direction);
        }

        //후진한 위치에 벽이 있었다면 그대로 끝나게 된다.
    }
}
