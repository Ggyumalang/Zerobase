package exercise_coding.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class exam02 {

    public static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<Edge> edges;
    static final long INF = (long)Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from,to,weight));
        }
        bellmanFord(v,e,1);
    }

    public static void bellmanFord(int v, int e, int start) {

        //최단 경로 계산을 위한 배열
        long[] dist = new long[v+1];

        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }

        dist[start] = 0;
        boolean isMinusCycle = false;

        for (int i = 0; i < v+1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edges.get(j);

                if(dist[cur.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if(dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    if( i == v ) {
                        isMinusCycle = true;
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for (int i = 2; i < v+1 ; i++) {
            if(dist[i] >= INF) {
                System.out.println(-1);
            }else {
                System.out.println(dist[i]);
            }
        }
    }
}
