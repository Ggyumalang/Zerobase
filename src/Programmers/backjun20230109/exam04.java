package Programmers.backjun20230109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class exam04 {
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
    static ArrayList<Edge> edges;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a,b,1));
                edges.add(new Edge(b,a,1));
            }
            Collections.sort(edges,(x,y) -> x.weight - y.weight);
            System.out.println(kruskal(N));
        }
    }
    public static int kruskal(int n){
        int weightSum = 0;
        parents = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edges.size(); i++) {
            if(find(edges.get(i).from) != find(edges.get(i).to) ){
                union(edges.get(i).from, edges.get(i).to );
                weightSum++;
            }
        }
        return weightSum;
    }

    public static void union(int a , int b){
        int aP = find(a);
        int bP = find(b);

        if(aP!=bP){
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
