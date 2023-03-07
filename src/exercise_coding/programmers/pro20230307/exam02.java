//자물쇠와 열쇠 복습
package exercise_coding.programmers.pro20230307;

import java.util.Arrays;

public class exam02 {

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    static boolean isFit;

    public static boolean solution(int[][] key, int[][] lock) {
        isFit = false;
        int len = lock.length;
        int[][] board = new int[len*3][len*3];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i+len][j+len] = lock[i][j];
            }
        }
        dfs(board,key,0);
        return isFit;
    }

    private static void dfs(int[][] board, int[][] key, int cnt) {
        isMatched(board,key,0,0);
        System.out.println(isFit);
        if(isFit){
            return;
        }
        if(cnt >= 4){
            return;
        }

        int[][] temp = rotate(key);

        dfs(board,temp,cnt+1);
    }

    private static void isMatched(int[][] board, int[][] key, int x, int y) {
        if(isFit){
            return;
        }
        if(y + key.length > board.length){
            y = 0;
            x++;
        }

        if(x + key.length > board.length){
            return;
        }

        int[][] boardCopy = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i],0,boardCopy[i],0,board[i].length);
        }

        boolean isFail = false;
        Loop:
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(key[i][j] == 1){
                    if(boardCopy[i+x][j+y] == 1){
                        isFail = true;
                        break Loop;
                    }
                    boardCopy[i+x][j+y] = key[i][j];
                }
            }
        }

        if(!isFail){
            int len = board.length/3;
            Loop:
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if(boardCopy[i+len][j+len] != 1){
                        isFail = true;
                        break Loop;
                    }
                }
            }
        }

        if(!isFail){
            isFit = true;
        }

        isMatched(board,key,x,y+1);
    }

    //90도 회전시키기
    private static int[][] rotate(int[][] key) {
        int len = key.length;
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = key[j][len - (i + 1)];
            }
        }
        return temp;
    }


}
