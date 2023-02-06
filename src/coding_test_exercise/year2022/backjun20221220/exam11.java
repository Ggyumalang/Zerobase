//백준 2230번 수 고르기
package coding_test_exercise.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 1;

        if(M==0){
            System.out.println(0);
            return;
        }

        while (right < N) {
            int diff = arr[right] - arr[left];
            if(diff == M){
                System.out.println(M);
                return;
            }else if(diff > M){
                result = Math.min(result,diff);
                left++;
            }else {
                right++;
            }
        }
        System.out.println(result);
    }
}
