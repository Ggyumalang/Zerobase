//풀어보았으나.. 
//섬의 형태가 무조건 사각형이면 해결되나
//섬의 형태가 가지각색이 되므로.. 실패함 
//다른 코드를 참조하여 풀이
package coding_test_exercise.backjun.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam09 {
    static class Islands{
        int num;
        int maX;
        int miX;
        int maY;
        int miY;

        public Islands(int num, int maX, int miX, int maY, int miY) {
            this.num = num;
            this.maX = maX;
            this.miX = miX;
            this.maY = maY;
            this.miY = miY;
        }

        @Override
        public String toString() {
            return "Islands{" +
                    "num=" + num +
                    ", maX=" + maX +
                    ", miX=" + miX +
                    ", maY=" + maY +
                    ", miY=" + miY +
                    '}';
        }
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
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] board;
    static int cnt;
    static boolean[][] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        visited = new boolean[r][c];
        graph = new ArrayList<>();
        ArrayList<Islands> list = new ArrayList<>();

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
                    visited[i][j] = true;
                    board[i][j] = cnt;
                    dfs(i,j);
                    list.add(new Islands(cnt,maxX,minX,maxY,minY));
                    //다시 초기화
                    maxX = Integer.MIN_VALUE;
                    maxY = Integer.MIN_VALUE;
                    minX = Integer.MAX_VALUE;
                    minY = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < list.size()+1; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Arrays.deepToString(board) = " + Arrays.deepToString(board));
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size() ; j++) {
                //거리 계산하기
                int weight = getDistance(list.get(i), list.get(j));
                if(weight < 2){
                    continue;
                }
                graph.get(list.get(i).num).add(new Node(list.get(j).num,weight));
                graph.get(list.get(j).num).add(new Node(list.get(i).num,weight));
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.println((i)+"번째 섬 >> " + graph.get(i).get(j));
            }
        }


        System.out.println(graph.get(1).size() == 0 ? -1 : prim(1));
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

    public static void dfs(int x, int y){
        maxX = Math.max(maxX,x);
        maxY = Math.max(maxY,y);
        minX = Math.min(minX,x);
        minY = Math.min(minY,y);
        for(int[] dir : dirs){
            int xNext = x+dir[0];
            int yNext = y+dir[1];

            if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                continue;
            }

            if(visited[xNext][yNext]){
                continue;
            }

            visited[xNext][yNext] = true;
            
            if(board[xNext][yNext] == 1){
                board[xNext][yNext] = cnt;
                dfs(xNext,yNext);
            }

        }
    }

    public static int getDistance(Islands i1, Islands i2){
        int dist = 0;
        if(i1.maX >= i2.miX){
          //첫번째 값의 maxX 가 두번째 값의 minX 보다 크거나 같으면 범위 내 이므로.. y 값으로 계산
            if(i1.maY < i2.miY){
                //즉 i1보다 i2 가 더 오른쪽에 있으면
                dist = i2.miY - i1.maY - 1;
            }else if(i1.miY > i2.maY){
                //즉 i1보다 i2 가 더 왼쪽에 있으면
                dist = i1.miY - i2.maY - 1;
            }else {
                dist = -1;
            }
        } else if (i1.maY >= i2.miY){
            //첫번째 값의 maxY 가 두번째 값의 minY 보다 크거나 같으면 범위 내 이므로..
            if(i1.maX < i2.miX){
                //즉 i1보다 i2 가 더 아래쪽에 있으면
                dist = i2.miX - i1.maX - 1;
            }else if(i1.miX > i2.maX){
                //즉 i1보다 i2 가 더 위쪽에 있으면
                dist = i1.miX - i2.maX - 1;
            }else {
                dist = -1;
            }
        }
        return dist;
    }
}
