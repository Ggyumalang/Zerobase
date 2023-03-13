//사다리놓기
package exercise_coding.programmers.pro20230313;

import java.util.*;

public class exam02 {
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;
        System.out.println(solution(land,height));

        land = new int[][]{{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
        height = 3;
        System.out.println(solution(land,height));
    }

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
    static List<List<Node>> graph;
    public static int solution(int[][] land, int height) {
        graph = new ArrayList<>();

        int v = land.length * land[0].length;
        System.out.println("v = " + v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }


        link(land, height);
        System.out.println(graph);

        return prim(v, 0);
    }

    private static int prim(int v, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        boolean[] visited = new boolean[v];
        int weightSum = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;
            weightSum += cur.weight;
            System.out.println("weightSum = " + weightSum);

            for(Node adj : graph.get(cur.to)){
                if(!visited[adj.to]){
                    pq.add(adj);
                }
            }
        }
        return weightSum;
    }

    private static void link(int[][] land, int height) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        queue.add(new int[]{0,0});


        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;

            for(int[] dir : dirs){
                int nX = x + dir[0];
                int nY = y + dir[1];

                if(nX < 0 || nY < 0 || nX >= land.length || nY >= land[0].length){
                    continue;
                }

                if(visited[nX][nY]){
                    continue;
                }

                queue.add(new int[]{nX,nY});

                int idx = x * (land.length-1) + y;
                if(x!=0){
                   idx+= x;
                }

                int nIdx = nX * (land.length-1) + nY;
                if(nX!=0){
                    nIdx+= nX;
                }

                int weight = 0;
                if(Math.abs(land[x][y] - land[nX][nY]) > height){
                    weight = Math.abs(land[x][y] - land[nX][nY]);
                }
                graph.get(idx).add(new Node(nIdx, weight));
                graph.get(nIdx).add(new Node(idx, weight));
            }

        }

    }
}
