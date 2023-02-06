package coding_test_exercise.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam08 {
    static int[][] dirs = {{-1,1},{0,1},{1,1}};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[][] matrix = new String[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = br.readLine().split("");
        }
        cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            //첫열부터 무조건 시작이므로..
                dfs(matrix, i, 0);
        }
        System.out.println(cnt);
    }

    private static boolean dfs(String[][] matrix , int x, int y) {
        System.out.println("x >> " + x);
        System.out.println("y >> " + y);
        if (y == matrix[0].length-1) {
            cnt++;
            return true;
        }

        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];


            if (xNext >= matrix.length || xNext < 0 || yNext < 0 || yNext >= matrix[0].length) {
                continue;
            }

            if (matrix[xNext][yNext].equals("x")) {
                continue;
            }else {
                matrix[xNext][yNext] = "x";
                //다음 라인 검사
                //라인의 가지치기를 방지하기 위해 true를 리턴한다.
                //true 리턴 시 다음 분기문으로 넘어가지 않는다. 꿀팁이다.
                if(dfs(matrix, xNext, yNext)){
                    return true;
                }
            }

        }
        return false;
    }
}
