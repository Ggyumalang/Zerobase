//해당문제는 진짜 어려웠다..

package coding_test_exercise.backjun.backjun20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam02 {
    static class Node{
        int idx;
        int len;

        public Node(int idx, int len) {
            this.idx = idx;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", len=" + len +
                    '}';
        }


    }
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] board;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 1){
                    board[i][j] = idx;
                    dfs(i,j,idx++);
                }
            }
        }
//        System.out.println(Arrays.deepToString(board));

        graph = new ArrayList<>();
        for (int i = 0; i < idx; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] != 0){
                    connectBridge(i,j,board[i][j]);
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            for(Node cur : graph.get(i)){
                System.out.println(i+"번째 섬 >> " + cur);
            }
        }

        int answer = prim(1,idx-1);
        System.out.println(answer == 0? -1 : answer);
    }

    public static int prim(int start , int v){
        int weightSum = 0;
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.len - y.len);
        boolean[] visited = new boolean[graph.size()];
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.idx]){
                continue;
            }
            cnt++;
            visited[cur.idx] = true;
            weightSum += cur.len;

            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node adj = graph.get(cur.idx).get(i);
                if(!visited[adj.idx]){
                    pq.add(adj);
                }
            }
        }
//        System.out.println(v);
//        System.out.println(cnt);
        return cnt == v-1 ? weightSum : 0;
    }

    public static void connectBridge(int x, int y, int idx){
        Queue<int[]> queue = new LinkedList<>();

        for(int[] dir : dirs){
            queue.offer(new int[]{x,y,0});

            while (!queue.isEmpty()){
                int[] cur = queue.poll();
                int xNext = cur[0] + dir[0];
                int yNext = cur[1] + dir[1];
                int moveCnt = cur[2];

                if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                    continue;
                }

                if(board[xNext][yNext] != idx){
                    if(board[xNext][yNext] != 0){
                        int from = idx-1;
                        int to = board[xNext][yNext]-1;
                        int len = moveCnt;
                        if(moveCnt > 1){
                            graph.get(from).add(new Node(to,len));
                        }
                    }else {
                        queue.add(new int[]{xNext,yNext,moveCnt+1});
                    }
                }


            }
        }
    }

    public static void dfs(int x, int y, int idx){
        for(int[] dir : dirs){
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                continue;
            }

            if(board[xNext][yNext] == 1){
                board[xNext][yNext] = idx;
                dfs(xNext,yNext,idx);
            }
        }

    }

}
