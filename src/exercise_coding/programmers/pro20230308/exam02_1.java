//택시 합승
package exercise_coding.programmers.pro20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class exam02_1 {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));

        n = 7;
        s = 3;
        a = 4;
        b = 1;
        fares = new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        System.out.println(solution(n, s, a, b, fares));

        n = 6;
        s = 4;
        a = 5;
        b = 6;
        fares = new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
        System.out.println(solution(n, s, a, b, fares));
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<List<Node>> graph;
    static int INF = (int) 1000001;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];

        Arrays.fill(startA, INF);
        Arrays.fill(startB, INF);
        Arrays.fill(start, INF);

        startA = dijkstra(a, startA);//A가 혼자갔을때 나오는 비용
        startB = dijkstra(b, startB);//B가 혼자가는 비용
        start = dijkstra(s, start); //출발점부터의 비용
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }

        return answer;
    }

    private static int[] dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.to]) {
                continue;
            }

            for (Node adj : graph.get(cur.to)) {
                if (dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
        return dist;
    }
}
