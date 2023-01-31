//백준 2580번 스도쿠
//내일 다시 풀어볼 것
package Programmers.backjun20230118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void sudoku(int row, int col){
        //해당 행이 다 채워지면 다음 행의 첫번째 열부터 시작
        if(col == 9) {
            sudoku(row+1, 0);
            return;
        }

        //행과 열이 다 채워지면 출력 후 종료
        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.println(sb);
            //출력 뒤 시스템 종료
            System.exit(0);
        }

        //만약 해당 위치의 값이 0이라면 1부터 9까지 중 가능한 수를 탐색해서 변환해준다.
        if(board[row][col] == 0){
            for (int i = 1; i <= 9; i++) {
                if(possibility(row,col,i)){
                    board[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            board[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }

    private static boolean possibility(int x , int y , int value) {
        
        // 같은 행에 있는 원소 중 겹치는 열 원소가 있는 지 검사한다.
        for (int i = 0; i < 9 ; i++) {
            if(board[x][i] == value){
                return false;
            }
        }
        
        // 같은 열에 있는 원소 중 겹치는 행의 원소가 있는지 검사한다.
        for (int i = 0; i < 9 ; i++) {
            if(board[i][y] == value){
                return false;
            }
        }
        //value가 속한 3x3에 자신과 똑같은 값이 있는 지 확인
        //value가 속한 3x3의 행의 첫 위치.
        int setRow = (x/3) * 3;
        int setCol = (y/3) * 3;

        for (int i = setRow; i < setRow + 3 ; i++) {
            for (int j = setCol; j < setCol + 3; j++) {
                if(board[i][j] == value){
                    return false;
                }
            }
        }
        return true; //중복된 값이 하나도 없을 경우 true 반환
    }
}
