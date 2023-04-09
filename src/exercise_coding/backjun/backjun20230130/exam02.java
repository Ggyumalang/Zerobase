//스도쿠 다시한번 풀기 2580번
package exercise_coding.backjun.backjun20230130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam02 {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    public static void sudoku(int row , int col){
        if(col == 9){
            sudoku(row+1 , 0);
            return;
        }

        if(row == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
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
                    sudoku(row,col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }

    private static boolean isPossible(int row, int col, int num) {
        for (int i = 0; i < 9 ; i++) {
            if(board[row][i] == num) {
                return false;
            }

            if(board[i][col] == num) {
                return false;
            }
        }

        int firstRow = (row/3) * 3;
        int firstCol = (col/3) * 3;

        for (int i = firstRow; i < firstRow+3; i++) {
            for (int j = firstCol; j < firstCol+3; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
