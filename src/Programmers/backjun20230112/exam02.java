//백준 1854번 다시 풀어볼 것!!
package Programmers.backjun20230112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam02 {

    static class Point{
        int idx;
        int x;
        int y;
        int z;

        public Point(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
    static ArrayList<Edge> edges;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Point[] points = new Point[N];
        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[i] = new Point(i,x,y,z);
        }

        //x축기준
        Arrays.sort(points, (p1,p2) -> p1.x - p2.x); //x축 기준 오름차순 정렬
        for (int i = 0; i < N-1 ; i++) {
            int weight = Math.abs(points[i].x - points[i+1].x);
            edges.add(new Edge(points[i].idx , points[i+1].idx , weight));
        }

        //y축기준
        Arrays.sort(points, (p1,p2) -> p1.y - p2.y); //y축 기준 오름차순 정렬
        for (int i = 0; i < N-1; i++) {
            int weight = Math.abs(points[i].y - points[i+1].y);
            edges.add(new Edge(points[i].idx , points[i+1].idx , weight));
        }
        //z축기준
        Arrays.sort(points, (p1,p2) -> p1.z - p2.z); //z축 기준 오름차순 정렬
        for (int i = 0; i < N-1; i++) {
            int weight = Math.abs(points[i].z - points[i+1].z);
            edges.add(new Edge(points[i].idx , points[i+1].idx , weight));
        }
        Collections.sort(edges,(x,y) -> x.weight - y.weight);

        System.out.println(kruskal(N));
    }

    public static int kruskal(int n){
        parents = new int[n];
        int weightSum = 0;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            if(find(cur.to) != find(cur.from)){
                union(cur.to, cur.from);
                weightSum += cur.weight;
            }
        }
        return weightSum;
    }

    public static void union(int a , int b){
        int aP = find(a);
        int bP = find(b);

        if(aP != bP){
            parents[aP] = bP;
        }
    }

    public static int find(int a){
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }

}
