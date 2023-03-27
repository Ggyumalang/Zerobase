//백준 - 연구소3
//블로그 참고
//조합식..이 다르넹 ㅎ
package exercise_coding.backjun.backjun20230321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class exam01_1 {
    static int N,M;
    static int[][] labCopy;
    static int answer;
    static List<Virus> viruses;
    static Virus[] active;
    static int originEmptySpace = 0;

    static class Virus {
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

    final static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][N];
        answer = Integer.MAX_VALUE;
        viruses = new ArrayList<>();
        active = new Virus[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0) {
                    originEmptySpace++;
                } else if (lab[i][j] == 2) {
                    viruses.add(new Virus(i,j,0));
                }
            }
        }
        labCopy = lab;

        if(originEmptySpace == 0) {
            System.out.println(0);
        } else {
            combination(0,0);
            System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
        }
    }

    static void combination(int start, int selectCount) {
        if(selectCount == M){
            bfs(originEmptySpace);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            active[selectCount] = viruses.get(i);
            combination(i+1, selectCount+1);
        }
    }
    private static void bfs(int emptySpace) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];

        for(Virus virus : active){
            infected[virus.x][virus.y] = true;
            queue.add(virus);
        }

        while (!queue.isEmpty()){
            Virus cur = queue.poll();

            for(int[] dir : dirs){
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if(nx < 0 || ny < 0 || nx >= labCopy.length || ny >= labCopy.length){
                    continue;
                }

                if(labCopy[nx][ny] == 1 || infected[nx][ny]){
                    continue;
                }

                if(labCopy[nx][ny] == 0) {
                    emptySpace--;
                }

                if(emptySpace == 0) {
                    answer = Math.min(answer, cur.time + 1);
                    return;
                }

                infected[nx][ny] = true;
                queue.add(new Virus(nx, ny, cur.time+1));
            }
        }
    }


}
