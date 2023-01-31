//백준 2580번 스도쿠
package Programmers.backjun20230130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class exam01 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        board = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.deepToString(board));
        dfs(0,0);
    }

    public static void dfs(int row, int col){
        if(col == 9){
            dfs(row+1,0);
            return;
        }

        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if(board[row][col] == 0) {
            for (int i = 1; i <= 9 ; i++) {
                if(isPossible(row,col,i)){
                    board[row][col] = i;
                    dfs(row,col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        dfs(row,col+1);
    }

    private static boolean isPossible(int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            //가로 확인
            if(board[row][i] == num){
                return false;
            }

            //세로 확인
            if(board[i][col] == num){
                return false;
            }
        }
        int selRow = (row/3) * 3;
        int selCol = (col/3) * 3;

        for (int i = selRow; i < selRow+3; i++) {
            for (int j = selCol; j < selCol+3; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }


}
