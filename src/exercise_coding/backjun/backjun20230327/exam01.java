//백준 7576 - 토마토
package exercise_coding.backjun.backjun20230327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam01 {
    static int[][] boxCopy;
    static List<Tomato> tomatoList;
    static int answer,N,M,unripe;

    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];
        tomatoList = new ArrayList<>();
        answer = 0;
        unripe = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    tomatoList.add(new Tomato(i,j,0));
                }

                if(box[i][j] == 0) {
                    unripe++;
                }
            }
        }
        if(unripe == 0){
            System.out.println(0);
            return;
        }
        boxCopy = box;
        bfs();
        System.out.println(answer==0?-1:answer);
    }

    private static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(Tomato t : tomatoList){
            queue.offer(t);
            visited[t.x][t.y] = true;
        }

        while (!queue.isEmpty()){
            Tomato tomato = queue.poll();
            System.out.println("tomato = " + tomato);

            for(int[] dir : dirs) {
                int nx = tomato.x + dir[0];
                int ny = tomato.y + dir[1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M ){
                    continue;
                }

                if(visited[nx][ny] || boxCopy[nx][ny] == -1){
                    continue;
                }

                if(boxCopy[nx][ny] == 0){
                    unripe--;
                }

                if(unripe == 0) {
                    answer = tomato.day+1;
                    return;
                }

                visited[nx][ny] = true;

                queue.offer(new Tomato(nx,ny, tomato.day+1));
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "x=" + x +
                    ", y=" + y +
                    ", day=" + day +
                    '}';
        }
    }
}
