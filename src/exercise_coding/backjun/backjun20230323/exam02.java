package exercise_coding.backjun.backjun20230323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam02 {

    static class Virus{
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }

    static int[][] lab;
    static int N,M;
    static List<Virus> viruses;
    static Virus[] selectedViruses;
    static int emptyNum;
    static int answer;
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        viruses = new ArrayList<>();
        selectedViruses = new Virus[M];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0){
                    emptyNum++;
                }

                if(lab[i][j] == 2){
                    viruses.add(new Virus(i,j,0));
                }
            }
        }

        if(emptyNum == 0){
            System.out.println(0);
            return;
        }
        combination(0,0);


        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void combination(int start, int cnt) {
        if(cnt == M){
            bfs(emptyNum);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            selectedViruses[cnt] = viruses.get(i);
            combination(i+1, cnt+1);
        }
    }

    private static void bfs(int emptySpace) {

        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (Virus virus : selectedViruses) {
            visited[virus.x][virus.y] = true;
            queue.add(virus);
        }
        while (!queue.isEmpty()){
            Virus cur = queue.poll();

            for(int[] dir : dirs){
                int xNext = cur.x + dir[0];
                int yNext = cur.y + dir[1];

                if(xNext < 0 || yNext < 0 || xNext >= N || yNext >= N){
                    continue;
                }

                if(visited[xNext][yNext] || lab[xNext][yNext] == 1){
                    continue;
                }

                if(lab[xNext][yNext] == 0){
                    emptySpace--;
                }

                if(emptySpace == 0){
                    answer = Math.min(answer, cur.time+1);
                    return;
                }

                visited[xNext][yNext] = true;

                queue.offer(new Virus(xNext,yNext,cur.time+1));

            }
        }
    }
}
