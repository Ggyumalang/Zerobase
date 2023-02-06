package coding_test_exercise.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam03 {
    static int[] board;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[Integer.parseInt(br.readLine())];
        cnt = 0;
        nQueen(0);
        System.out.println(cnt);
    }

    public static void nQueen(int row){
        if(row == board.length){
            cnt++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row] = i;

            if(isMatch(row)){

                nQueen(row+1);
            }
        }
    }

    public static boolean isMatch(int row){
        for (int i = 0; i < row; i++) {
            if(board[i] == board[row] || row - i == Math.abs(board[i] - board[row])){
                return false;
            }
        }
        return true;
    }
}
