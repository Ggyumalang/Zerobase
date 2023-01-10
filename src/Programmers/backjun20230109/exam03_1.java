//다익스트라 해볼라햇는데 실패..
package Programmers.backjun20230109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class exam03_1 {
    static class Node{
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
    final static int INF = 100000000;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i < K+2; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = N; i < K+2; i++) {
            if(i > 0){
                graph.get(i).add(new Node(i-1,1));
            }
            if(i < K+1) {
                graph.get(i).add(new Node(i + 1, 1));
            }
            if(i*2 <= K+1) {
                graph.get(i).add(new Node(i * 2, 0));
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i));
        }

        System.out.println(dijkstra(K,N));
    }

    public static int dijkstra(int n, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.add(new Node(start,0));
        int[] dist = new int[n+2];//0~18
        for (int i = 1; i < n+2; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.to] < cur.weight){
                continue;
            }
            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if( dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist[n];
    }
}
