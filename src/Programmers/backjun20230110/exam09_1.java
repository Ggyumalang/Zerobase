//사례를 따라 풀어보았지만
//답은 알겠으나.. 수정이 필요함
//머리아파서 잠시 멈춤
//내일하자..
package Programmers.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam09_1 {

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
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] board;
    static Queue<int[]> q;
    static int r,c,cnt;
    static boolean[][] visited;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        visited = new boolean[r][c];
        graph = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        for (int i = 0; i < cnt+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(board[i][j] != 0){
                    makeBridge(i,j,board[i][j]);
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.println((i)+"번째 섬 >> " + graph.get(i).get(j));
            }
        }

        int answer = prim(1);
        System.out.println(answer == 0 ? -1 : answer);
    }

    public static void bfs(int x, int y){
        q = new LinkedList<>();

        q.add(new int[]{x,y});
        board[x][y] = cnt;
        visited[x][y] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int px = cur[0];
            int py = cur[1];

            for(int[] dir : dirs){
                int xNext = px + dir[0];
                int yNext = py + dir[1];

                if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                    continue;
                }

                if(visited[xNext][yNext]){
                    continue;
                }
                visited[xNext][yNext] = true;
                if(board[xNext][yNext] == 1){
                    board[xNext][yNext] = cnt;
                    q.offer(new int[]{xNext,yNext});
                }
            }
        }
    }

    public static void makeBridge(int x, int y , int idx){
        q = new LinkedList<>();
        visited = new boolean[r][c];
        for(int[] dir : dirs) {
            q.offer(new int[]{x, y, 0});
            visited[x][y] = true;

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int move = p[2];

                int xNext = px + dir[0];
                int yNext = py + dir[1];

                if (xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length) {
                    continue;
                }

                if (visited[xNext][yNext]) {
                    continue;
                }
                visited[xNext][yNext] = true;
                if (board[xNext][yNext] != idx) {
                    if(board[xNext][yNext] != 0){
                        int from = idx; //출발섬
                        int to = board[xNext][yNext]; //도착섬
                        int weight = move;
                        if(weight > 1){
                            graph.get(from).add(new Node(to,weight));
                            break;
                        }
                    }else {
                        q.add(new int[]{xNext,yNext,move+1});
                    }
                }
            }
            q.clear();
        }
    }
    
    public static int prim(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(start,0));
        boolean[] visited = new boolean[cnt+1];
        int weightSum = 0;
        int connCnt = 0;
        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]){
                continue;
            }

            if(weightSum == -1){
                continue;
            }
            connCnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(connCnt == cnt){
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
