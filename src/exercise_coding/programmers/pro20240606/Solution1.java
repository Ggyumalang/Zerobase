//그래프 - 순위 = 플로이드워셜 FloydWarshall
package exercise_coding.programmers.pro20240606;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n, result));
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n+1][n+1];
        int INF = (int) 1e9;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if( i == j) floyd[i][j] = 0;
                else {
                    floyd[i][j] = INF;
                }
            }
        }

        for(int[] result : results) {
            floyd[result[0]][result[1]] = 1;
            floyd[result[1]][result[0]] = -1;
        }

        System.out.println(Arrays.deepToString(floyd));

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if(i==j) {
                        continue;
                    }

                    if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(floyd));
        answer = (int) Arrays.stream(floyd)
                .filter(row -> Arrays.stream(row).allMatch(value -> value != INF))
                .count() - 1;

        return answer;
    }

}
