package Programmers.backjun20230111;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exam01 {
    static class Loc{
        int idx;
        int time;

        public Loc(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static final int INF = 100_001;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new int[INF];

        System.out.println(dijkstra(N,K));
    }

    public static int dijkstra(int start , int end){
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(start,1));//시작 time을 1로 해놓고 결과 출력시 1 뺀다.
        visited[start] = 1;
        while (!q.isEmpty()) {
            Loc cur = q.poll();
            if(cur.idx +1 >= 0 && cur.idx + 1 < INF){
                if(visited[cur.idx+1] == 0 || visited[cur.idx+1] > cur.time+1){
                    visited[cur.idx+1] = cur.time+1;
                    q.add(new Loc(cur.idx+1,cur.time+1));
                }
            }

            if(cur.idx -1 >= 0 && cur.idx -1 < INF){
                if(visited[cur.idx-1] == 0 || visited[cur.idx-1] > cur.time+1){
                    visited[cur.idx-1] = cur.time+1;
                    q.add(new Loc(cur.idx-1,cur.time+1));
                }
            }

            if(cur.idx*2 >= 0 && cur.idx*2 < INF){
                if(visited[cur.idx*2] == 0 || visited[cur.idx*2] > cur.time){
                    visited[cur.idx*2] = cur.time;
                    q.add(new Loc(cur.idx*2,cur.time));
                }
            }
        }
        return visited[end]-1;
    }
}
