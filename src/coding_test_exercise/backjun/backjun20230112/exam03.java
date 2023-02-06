//pre 배열로 이전의 값을 기록하고
//스택으로 출력하는 것
package coding_test_exercise.backjun.backjun20230112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam03 {
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

    static ArrayList<ArrayList<Node>> graph;
    static List<Integer> list;
    static int INF = (int)1e9;
    static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(v,start,end));

        //경로 역추적
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int cnt = 1;
        while (pre[end] != 0){
            cnt++;
            stack.push(pre[end]);
            end = pre[end];
        }

        System.out.println(cnt);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static int dijkstra(int v, int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int[] dist = new int[v+1];
        pre = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.to == end){
                break;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                if(dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pre[adj.to] = cur.to;
                    pq.offer(new Node(adj.to,dist[adj.to]));
                }
            }
        }

        return dist[end];
    }

}
