//백준 3190 뱀
package exercise_coding.backjun.backjun20230518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class exam02 {
    static int[][] board, moves;
    final static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    static int answer , moveIdx;
    static List<List<Integer>> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        moves = new int[L][2];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i][0] = Integer.parseInt(st.nextToken());
            int dir = 1;
            if(st.nextToken().equals("L")){
                dir = -1;
            }
            moves[i][1] = dir;
        }

        Arrays.sort(moves, (x,y) -> x[0] - y[0]);

        snake = new ArrayList<>();
        snake.add(List.of(1,1));
        dummy(1,2,1,0);

        System.out.println(answer);

    }

    private static void dummy(int x, int y, int time, int dir) {

        if(snake.contains(List.of(x,y)) || x <= 0 || y <= 0 || x >= board.length || y >= board.length){
            answer = time;
            return;
        }

        snake.add(List.of(x,y));

        //사과가 없는 곳이라면
        if(board[x][y] == 0){
            snake.remove(0);
        }else {
            board[x][y] = 0;
        }

        // 시간이 지나 방향 전환을 해야한다면
        if(moveIdx < moves.length && time == moves[moveIdx][0]){
            dir = dir + moves[moveIdx][1] < 0 ? 3 : (dir+moves[moveIdx][1]) % 4;
            moveIdx++;
        }

        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];
        dummy(nx, ny, time+1, dir);
    }
}
