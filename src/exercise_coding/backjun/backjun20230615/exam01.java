//백준 - 소문난 칠공주
package exercise_coding.backjun.backjun20230615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam01 {

    static int[] checked;
    static char[][] room;
    static int answer;

    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        room = new char[5][5];
        checked = new int[7];

        for (int i = 0; i < 5; i++) {
            room[i] = br.readLine().toCharArray();
        }

        combination(0,0,0);

        System.out.println(answer);
    }

    private static void combination(int idx, int start, int sCnt) {
        if(idx - sCnt > 3) {
            return;
        }

        if(idx == 7) {
            bfs(checked[0]/5 , checked[0]%5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5 , col = i % 5;
            checked[idx] = i;
            combination(idx+1 , i + 1 , room[row][col] == 'S' ? sCnt + 1 : sCnt);
        }
    }

    private static void bfs(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[] visited = new boolean[7];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0] , b = cur[1];

            for(int[] dir : dirs) {
                int nA = a + dir[0];
                int nB = b + dir[1];

                if(nA < 0 || nB < 0 || nA >= 5 || nB >= 5) {
                    continue;
                }

                int next = nA * 5 + nB % 5;

                for (int i = 0; i < 7; i++) {
                    if(!visited[i] && checked[i] == next) {
                        visited[i] = true;
                        cnt++;
                        queue.add(new int[]{nA , nB});
                    }
                }
            }
        }

        if(cnt == 7) {
            answer++;
        }
    }
}
