//프로그래머스 트리 트리오 중간값

package exercise_coding.programmers.pro20230428;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class exam02 {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution(n, edges));

        n = 5;
        edges = new int[][]{{1, 5}, {2, 5}, {3, 5}, {4, 5}};
        System.out.println(solution(n, edges));
    }

    static int maxVal;
    static List<List<Integer>> graph;
    static Set<List<Integer>> set;
    static int N;

    public static int solution(int n, int[][] edges) {
        N = n;
        maxVal = Integer.MIN_VALUE;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        set = new HashSet<>();

        dfs(new ArrayList<>());
        return maxVal;
    }

    private static void dfs(List<Integer> nodes) {
        int n = nodes.size();
        if (n == 3) {
            nodes.sort(Comparator.naturalOrder());
            if(set.add(nodes)){
                int dist = calDist(nodes);
                maxVal = Math.max(maxVal, dist);
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!nodes.contains(i)) {
                nodes.add(i);
                dfs(nodes);
                nodes.remove(Integer.valueOf(i));
            }
        }
    }

    private static int calDist(List<Integer> nodes) {
        int dist = 0;
        dist += checkDistance(nodes.get(0), nodes.get(1));
        dist += checkDistance(nodes.get(1), nodes.get(2));
        dist += checkDistance(nodes.get(0), nodes.get(2));
        return dist/3;
    }

    private static int checkDistance(int node1, int node2) {
        List<Integer> connectedNodes = graph.get(node1);
        if(connectedNodes.contains(node2)){
            return 1;
        }

        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node1, count});
        boolean[] visited = new boolean[N+1];
        visited[node1] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int currNode = cur[0] , cnt = cur[1];

            if(currNode == node2){
                return cnt;
            }

            List<Integer> connected = graph.get(currNode);
            for (Integer integer : connected) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    q.offer(new int[]{integer, cnt + 1});
                }
            }
        }
        return count;
    }

}
