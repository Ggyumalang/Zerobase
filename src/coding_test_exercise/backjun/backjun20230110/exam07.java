package coding_test_exercise.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class exam07 {
    static class Loc{
        int idx;
        int x;
        int y;

        public Loc(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight > o.weight){
                return 1;
            }
            return -1;
        }
    }

    static int[] parents;
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int connectedCnt = Integer.parseInt(st.nextToken());
        Loc[] locs = new Loc[v+1];
        parents = new int[v+1];
        edges = new ArrayList<>();

        for (int i = 1; i < v+1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < v+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locs[i] = new Loc(i,x,y);
        }

        for (int i = 0; i < connectedCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken());
            int idx2 = Integer.parseInt(st.nextToken());
            union(idx1, idx2); //이미 연결된 통로는 union을 통해 합친다.
        }

        //연결가능한 것들을 edges에 저장
        for (int i = 1; i <= v; i++) {
            for (int j = i+1; j <= v; j++) {
                double weight = getDist(locs[i],locs[j]);
                edges.add(new Edge(locs[i].idx,locs[j].idx,weight));
            }
        }
        Collections.sort(edges);
        double result = 0;

        for (int i = 0; i < edges.size(); i++) {
            Edge cur = edges.get(i);
            if(find(cur.start) != find(cur.end)){
                union(cur.start,cur.end);
                result+= cur.weight;
            }
        }

        System.out.println(String.format("%.2f", result));
    }

    public static double getDist(Loc l1 , Loc l2){
        return Math.sqrt(Math.pow(l1.x-l2.x,2) + Math.pow(l1.y-l2.y,2));
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if(aP!=bP){
            parents[aP] = bP;
        }
    }

    public static int find(int a){
        if( a == parents[a]){
            return a;
        }
        return parents[a] = find(parents[a]);
    }
}
