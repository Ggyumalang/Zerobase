//그래프 - 가장 먼 노드 (dijkstra)
package exercise_coding.programmers.pro20240606;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n,edge));
    }

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

    static List<List<Node>> graph;
    public static int solution(int n, int[][] edge) {
        graph = new ArrayList<>();

        for (int i = 1; i <= n + 1 ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] arr : edge) {
            graph.get(arr[0]).add(new Node(arr[1], 1));
            graph.get(arr[1]).add(new Node(arr[0], 1));
        }

        return dijkstra(n);
    }

    private static int dijkstra(int n) {
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        pq.offer(new Node(1,0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(!visited[adj.to] && dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, cur.weight + adj.weight));
                }
            }
        }
        int maxVal = Arrays.stream(dist).max().getAsInt();
        return (int) Arrays.stream(dist).filter(x -> x == maxVal).count();
    }
}
