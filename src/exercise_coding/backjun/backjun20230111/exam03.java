//크루스칼
package exercise_coding.backjun.backjun20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class exam03 {
    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static int parents[];
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        //그래프 초기화
        edges = new ArrayList<>();

        StringTokenizer st;
        //그래프 연결
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(from != to){
                edges.add(new Edge(from,to,weight));
            }
        }
        Collections.sort(edges,(x,y) -> x.weight - y.weight);

        System.out.println(kruskal(v));
    }

    public static int kruskal(int n) {
        parents = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        int weightSum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if(find(edge.from) != find(edge.to)){
                union(edge.from,edge.to);
                weightSum += edge.weight;
            }
        }
        return weightSum;
    }

    public static void union(int a , int b) {
        int aP = find(a);
        int bP = find(b);

        if(aP != bP) {
            parents[aP] = bP;
        }
    }

    public static int find(int a) {
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }

}
