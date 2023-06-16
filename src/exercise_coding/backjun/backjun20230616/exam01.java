//백준 - 행성 연결
package exercise_coding.backjun.backjun20230616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    static List<List<Node>> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if( i == j) {
                    st.nextToken();
                    continue;
                }
                edges.get(i).add(new Node(j , Integer.parseInt(st.nextToken())));
            }
        }

        System.out.println(prim(N));

    }

    private static long prim(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        long weightSum = 0;
        boolean[] visited = new boolean[n];
        pq.offer(new Node(0,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;
            weightSum += cur.weight;

            for(Node adj : edges.get(cur.to)) {
                if(!visited[adj.to]) {
                    pq.offer(adj);
                }
            }
        }

        return weightSum;
    }
}
