//택시 합승
package exercise_coding.programmers.pro20230308;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
다익스트라인데 한군데를 들리면서
또 따로 간다..? ㅅㅂ 개어렵네 가장 최소 비용으로..
a가 최적으로 갈때의 노선
b가 최적으로 갈때의 노선
a,b 조금씩 나눠서 갈 때의 노선
1차 dijkstra , dfs 사용해서 풀이.. 시간초과 나서 실패
 */
public class exam02 {
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
    static List<List<Integer>> routesA;
    static List<List<Integer>> routesB;
    static int A, B;
    static int INF = (int) 1e9;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        //다익스트라로 각각에 따로따로 도착하는 최선을 찾고..
        //dfs로 각각에 도착하는 모든 경우의 수를 찾아
        //합승해서 가는 경우를 찾아서 answer와 비교해본다.
        int[] dist = dijkstra(n, s);
        int answer = dist[a] + dist[b];
        A = a;
        B = b;
        routesA = new ArrayList<>();
        routesB = new ArrayList<>();
        dfs(s, new ArrayList<>());

        for (List<Integer> listA : routesA) {
            for (List<Integer> listB : routesB) {
                int sameIdx = -1;
                for (int i = 0; i < listA.size(); i++) {
                    if (i < listB.size() && listA.get(i) == listB.get(i)) {
                        sameIdx = i;
                    } else {
                        break;
                    }

                }
                if (sameIdx != -1) {
                    int weight = dist[listA.get(sameIdx)];
                    for (int i = sameIdx; i < listA.size() - 1; i++) {
                        for (Node adj : graph.get(listA.get(i))) {
                            if (adj.to == listA.get(i + 1)) {
                                weight += adj.weight;
                            }
                        }
                    }

                    for (int i = sameIdx; i < listB.size() - 1; i++) {
                        for (Node adj : graph.get(listB.get(i))) {
                            if (adj.to == listB.get(i + 1)) {
                                weight += adj.weight;
                            }
                        }
                    }
                    answer = Math.min(answer, weight);
                }
            }
        }
        return answer;
    }

    private static void dfs(int s, List<Integer> route) {
        route.add(s);

        if (s == A) {
            routesA.add(new ArrayList<>(route));
        }

        if (s == B) {
            routesB.add(new ArrayList<>(route));
        }

        for (Node adj : graph.get(s)) {
            if (!route.contains(adj.to)) {
                dfs(adj.to, route);
            }
        }
        route.remove(route.size() - 1);
    }

    private static int[] dijkstra(int n, int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[s] = 0;
        pq.add(new Node(s, 0));
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;

            for (Node adj : graph.get(cur.to)) {
                if (!visited[adj.to] && dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
        return dist;
    }
}
