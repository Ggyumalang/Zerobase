//백준 - 택배배송 5972
package exercise_coding.backjun.backjun20230531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        @Override
        public String toString() {
            return "Node{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
        }
    }

    static int N, M;
    static List<List<Node>> graph;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        System.out.println(graph);

        int answer = dijkstra();
        System.out.println(answer == INF ? -1 : answer);
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (x, y) -> x.weight - y.weight);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        dist[1] = 0;

        boolean[] visited = new boolean[N + 1];

        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;

            for (Node adj : graph.get(cur.to)) {
                if (!visited[adj.to] && dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to , dist[adj.to]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        return dist[N];
    }
}
