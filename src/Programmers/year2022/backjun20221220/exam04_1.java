//백준 합이 0인 네 정수
//AB / CD 두개로 나눠서 합을 비교해야함..
//풀이 2. 이분탐색
//UpperBound 는 find 보다 큰 첫번째 원소의 위치를 반환하고
//LowerBound 는 find 보다 크거나 같은 첫번째 원소의 위치를 반환한다.
package Programmers.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam04_1 {
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
        int[] CD = new int[N*N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                CD[idx++] = matrix[i][2] + matrix[j][3];
            }
        }
        Arrays.sort(CD);

        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = matrix[i][0] + matrix[j][1];
                int upper = upperBound(-tmp, CD);
                int lower = lowerBound(-tmp, CD);
                answer += (upper-lower);
            }
        }
        System.out.println(answer);
    }

    public static int upperBound(int key, int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start+end) / 2;
            if(arr[mid] > key) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return end;
    }

    public static int lowerBound(int key, int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = (start+end) / 2;
            if(arr[mid] >= key){
                end = mid-1;
            }else {
                start=mid+1;
            }
        }
        return end;
    }
}
