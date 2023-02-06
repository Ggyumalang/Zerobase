//백준 1854번 다시 풀어볼 것!!
package coding_test_exercise.backjun.backjun20230112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam01 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Integer>[] result;
    static int v , k;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); //k번째의 최단경로..

        graph = new ArrayList<>();
        result = new PriorityQueue[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
            result[i] = new PriorityQueue<>(k);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }
        dijkstra(1);

        for (int i = 1; i <= v ; i++) {
            if(result[i].size() == k) System.out.println(result[i].peek() * -1);
            else System.out.println(-1);
        }
    }

    public static void dijkstra(int start) {
        int[] dist = new int[v + 1];
        result[start].add(0);
        for (int i = 1; i < v + 1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);

                if(result[adj.to].size() < k){
                    //저장된 최단 비용의 수가 k개 이하이면
                    result[adj.to].add((cur.weight + adj.weight) * -1);
                    pq.offer(new Node(adj.to, cur.weight + adj.weight));
                }else if (result[adj.to].peek() * -1 > cur.weight + adj.weight) {
                    result[adj.to].poll();
                    result[adj.to].add((cur.weight + adj.weight) * -1);
                    pq.offer(new Node(adj.to, cur.weight + adj.weight));
                }
            }
        }
    }
}
