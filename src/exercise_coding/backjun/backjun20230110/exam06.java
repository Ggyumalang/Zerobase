//4386번 최소스패닝트리
package exercise_coding.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam06 {
    static class Point{
        int idx;
        double x;
        double y;

        public Point(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
    static class Node{
        int to;
        double weight;

        public Node(int to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        Point[] points = new Point[v];
        graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i+1,x,y);
        }

        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v-1; i++) {
            for (int j = i+1; j < v; j++) {
                double distance = Math.sqrt(Math.pow(points[i].x - points[j].x,2) + Math.pow(points[i].y - points[j].y,2));
                graph.get(points[i].idx).add(new Node(points[j].idx , distance));
                graph.get(points[j].idx).add(new Node(points[i].idx , distance));
            }
        }

        System.out.println(String.format("%.2f",prim(v,1)));
    }

    public static double prim(int v, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> (int) (x.weight - y.weight));
        pq.add(new Node(start,0));
        boolean[] visited = new boolean[v+1];
        double weightSum = 0;
        int cnt = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]){
                continue;
            }
            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(cnt == v){
                return weightSum;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(!visited[adj.to]){
                    pq.offer(adj);
                }
            }
        }
        return weightSum;
    }
}
