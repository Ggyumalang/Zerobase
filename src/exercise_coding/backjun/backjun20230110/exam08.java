package exercise_coding.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam08 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        while (v!=0 && e!=0){
            System.out.println("시작합니다.");
            graph = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }
            //그래프 연결하기
            int totalWeight = 0;
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                totalWeight += weight;
                graph.get(from).add(new Node(to,weight));
                graph.get(to).add(new Node(from,weight));
            }

            System.out.println(totalWeight - prim(v,0));
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
        }
    }

    public static long prim(int v, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(start,0));
        boolean[] visited = new boolean[v];
        long weightSum = 0;
        int cnt = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]){
                continue;
            }
            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(cnt == v){
                return weightSum;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(!visited[adj.to]){
                    pq.offer(adj);
                }
            }
        }
        return weightSum;
    }
}
