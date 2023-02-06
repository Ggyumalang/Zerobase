package coding_test_exercise.backjun.backjun20230109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam01 {
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
    final static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
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

        dijkstra(v, start);

        for (int i = 1; i < v+1; i++) {
            if(dist[i] >= INF) {
                System.out.print("INF ");
            }else {
                System.out.print(dist[i] + " ");
            }
        }
    }

    public static void dijkstra(int v, int start){
        dist = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        boolean[] visited = new boolean[v+1];
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.weight > dist[cur.to]){
                continue;
            }

            if(visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(!visited[adj.to] && dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to,dist[adj.to]));
                }
            }
        }
    }
}
