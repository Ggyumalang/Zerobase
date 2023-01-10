package Programmers.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam04 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int v;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to,weight));
        }
        System.out.println(dijkstra(1));
    }

    public static int dijkstra(int start){
        int[] dist = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(start,0));
        boolean[] visited = new boolean[v+1];
        int cycleNum = Integer.MAX_VALUE;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.to]){
                continue;
            }
            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(visited[adj.to]){
                    cycleNum = Math.min(cycleNum,(Math.abs(dist[adj.to]-dist[cur.to]) + adj.weight));
                }
                if(dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to,dist[adj.to]));
                }
            }

        }

        //출력부분
        return cycleNum == Integer.MAX_VALUE ? -1 : cycleNum;
    }
}
