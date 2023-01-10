package Programmers.backjun20230109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam02 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    final static int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
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
            graph.get(to).add(new Node(from,weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int case1 = 0;
        int case2 = 0;
        //1번 1 -> v1 -> v2 -> n
        case1 += dijkstra(v,1,v1);
        case1 += dijkstra(v,v1,v2);
        case1 += dijkstra(v,v2,v);

        //2번 1-> v2 -> v1 -> n
        case2 += dijkstra(v,1,v2);
        case2 += dijkstra(v,v2,v1);
        case2 += dijkstra(v,v1,v);

        if(case1 >= INF && case2 >= INF){
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(case1,case2));
    }

    public static int dijkstra(int v, int start , int end){
        dist = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to,dist[adj.to]));
                }
            }
        }
        return dist[end];
    }
}
