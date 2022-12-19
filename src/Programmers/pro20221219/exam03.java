package Programmers.pro20221219;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class exam03 {
    static class Node{
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(n,costs));
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < costs.length; i++) {
            graph.get(costs[i][0]).add(new Node(costs[i][1],costs[i][2]));
            graph.get(costs[i][1]).add(new Node(costs[i][0],costs[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight-y.weight);
        pq.offer(new Node(0,0));
        boolean[] visited = new boolean[n];
        int cnt = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.next]){
                continue;
            }
            cnt+=1;
            visited[cur.next] = true;
            answer += cur.weight;

            if(cnt == n){
                return answer;
            }

            for (int i = 0; i < graph.get(cur.next).size(); i++) {
                Node adj = graph.get(cur.next).get(i);
                if(!visited[adj.next]){
                    pq.offer(new Node(adj.next,adj.weight));
                }
            }
        }
        return answer;
    }
}
