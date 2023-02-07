//leetCode 최소신장트리
//포인트 연결 - 맨해튼거리

package exercise_coding.leetcode.leet20230206;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class exam01 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println("solution(points) = " + minCostConnectPoints(points));
    }
    public static int minCostConnectPoints(int[][] points) {

        List<List<Node>> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dist = getDistance(points[i], points[j]);
                edges.get(i).add(new Node(j,dist));
                edges.get(j).add(new Node(i,dist));
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        boolean[] visited = new boolean[points.length];
        pq.offer(new Node(0,0));
        int weightSum = 0;
        int cnt = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            System.out.println("weightSum = " + weightSum);

            if(visited[cur.to]){
                continue;
            }
            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(cnt == points.length){
                return weightSum;
            }

            for (int i = 0; i < edges.get(cur.to).size(); i++) {
                Node adj = edges.get(cur.to).get(i);
                if(!visited[adj.to]){
                    pq.offer(adj);
                }
            }
        }
        return weightSum;
    }

    private static int getDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
