// 프로그래머스 - 섬 연결하기 (prim)
package exercise_coding.programmers.pro20240612;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n, costs));
    }

    static List<List<Edge>> edges;
    public static int solution(int n, int[][] costs) {
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for(int[] cost : costs) {
            edges.get(cost[0]).add(new Edge(cost[1], cost[2]));
            edges.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }

        return (int)prim(n, 0);
    }

    private static long prim(int n, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.add(new Edge(start, 0));
        boolean[] visited = new boolean[n];
        long costSum = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(visited[cur.to]) {
                continue;
            }
            cnt++;
            visited[cur.to] = true;
            costSum += cur.cost;

            if(cnt == n) {
                return costSum;
            }

            for(Edge adj : edges.get(cur.to)) {
                pq.offer(adj);
            }
        }

        return costSum;
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }
}
