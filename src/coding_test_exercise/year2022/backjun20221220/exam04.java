//백준 합이 0인 네 정수
//AB / CD 두개로 나눠서 합을 비교해야함..
//풀이 1. 투포인터
package coding_test_exercise.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            matrix[i][2] = Integer.parseInt(st.nextToken());
            matrix[i][3] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.deepToString(matrix));

        int[] AB = new int[N*N];
        int[] CD = new int[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = matrix[i][0] + matrix[j][1];
                CD[idx] = matrix[i][2] + matrix[j][3];
                idx++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        System.out.println(Arrays.toString(AB));
        System.out.println(Arrays.toString(CD));

        long answer = 0;
        int left = 0;
        int right = N*N-1;

        while (left < N*N && right >= 0){
            if(AB[left] + CD[right] < 0){
                left++;
            }else if(AB[left] + CD[right] > 0){
                right--;
            }else {
                long leftCount = 1;
                long rightCount = 1;
                while (left+1 < N*N && AB[left] == AB[left+1]){
                    leftCount++;
                    left++;
                }

                while (right > 0 && CD[right] == CD[right-1]){
                    rightCount++;
                    right--;
                }
                answer += leftCount * rightCount;
                left++;
            }
        }
        System.out.println(answer);
    }
}
