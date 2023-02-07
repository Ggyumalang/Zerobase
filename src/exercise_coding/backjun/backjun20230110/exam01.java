package exercise_coding.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
    static int v;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //출발지
            int g = Integer.parseInt(st.nextToken()); //이 사이를 범인이..!!
            int h = Integer.parseInt(st.nextToken()); //이 사이를 범인이..!!
            ArrayList<Integer> resultList = new ArrayList<>();

            //그래프 초기화
            graph = new ArrayList<>();

            for (int j = 0; j < v+1; j++) {
                graph.add(new ArrayList<>());
            }

            //그래프 연결
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Node(to,weight));
                graph.get(to).add(new Node(from,weight));
            }

            for (int j = 0; j < target; j++) {
                int target_candidate = Integer.parseInt(br.readLine());
                int result1 = dijkstra(s,target_candidate);
                int result2 = dijkstra(s,g);
                result2 += dijkstra(g,h);
                result2 += dijkstra(h,target_candidate);
                int result3 = dijkstra(s,h);
                result3 += dijkstra(h,g);
                result3 += dijkstra(g,target_candidate);

                if(result1 >= result2 || result1 >= result3){
                    resultList.add(target_candidate);
                }
            }
            Collections.sort(resultList);
            for (int j = 0; j < resultList.size(); j++) {
                System.out.print(resultList.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static int dijkstra(int start , int end){
        int[] dist = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.add(new Node(start,0));
        boolean[] visited = new boolean[v+1];
        while (!pq.isEmpty()){
            Node cur = pq.poll();
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
        return dist[end];
    }
}
