package exercise_coding.programmers.pro20230419;

import java.util.Arrays;

/**
 * 중요한 점
 * 1. a의 모든 열의 1의 개수와 b의 모든 열의 개수가 같다는 것.
 * 2. b의 각 행에 들어 있는 1의 개수가 짝수여야한다는 것(0도 가능)
 * 내가 봤을 때는 백트래킹으로 모든 경우의 수 구하면서 조건에 맞지 않는 것은 쳐내는 것 같다.
 * 일단 전부다 돌아서 맞긴 하는데.. 시간초과가 난다.
 */
public class exam02 {

    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {1, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solution(a));

        a = new int[][]{{1, 0, 0}, {1, 0, 0}};
        System.out.println(solution(a));

        a = new int[][]{{1, 0, 0, 1, 1}, {0, 0, 0, 0, 0},{1, 1, 0, 0, 0},{0, 0, 0, 0, 1}};
        System.out.println(solution(a));
    }
    
    static int[][] aCopy;
    static int[][] b;
    static int[] sumACol;
    static int N,M,answer;
    public static int solution(int[][] a) {
        answer = 0;

        N = a.length;
        M = a[0].length;

        sumACol = new int[M];
        
        aCopy = a;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sumACol[i] += a[j][i];
            }
        }

        System.out.println("sumACol = " + Arrays.toString(sumACol));

        b = new int[N][M];
        
        backtrack(0,0, 0);

        return answer;
    }

    private static void backtrack(int x, int y, int cnt) {

        if(x >= N && y >= M){
            if(checkRowAndCol(b)){
                answer++;
            }
            return;
        }

        if(cnt > Arrays.stream(sumACol).sum() ){
            return;
        }
        if(y < M && Arrays.stream(b[y]).sum() >= sumACol[y]){

        }

        if(x >= N){
            if(!checkCol(b,y)){
                return;
            }
            backtrack(x,y+1, cnt);
        }

        if(y >= M){
            if(!checkRow(b[x])){
                return;
            }
            backtrack(x+1, 0, cnt);
        }

        if(x < N && y < M) {
            if (b[x][y] == 0) {
                b[x][y] = 1;
                backtrack(x, y + 1, cnt + 1);
                b[x][y] = 0;
                backtrack(x, y + 1 , cnt - 1);
            }
        }
    }

    private static boolean checkRowAndCol(int[][] b) {
        for (int i = 0; i < N; i++) {
            if(!checkRow(b[i])){
                return false;
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += b[j][i];
            }
            if(sum != sumACol[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int[] ints) {
        int count = 0;
        for (int anInt : ints) {
            if (anInt == 1) {
                count++;
            }
        }

        return count % 2 == 0;
    }

    private static boolean checkCol(int[][] b, int y) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += b[i][y];
        }

        return sum == sumACol[y];
    }

}
