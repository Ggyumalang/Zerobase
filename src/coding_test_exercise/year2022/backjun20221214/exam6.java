package coding_test_exercise.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] liquid = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;
        long min = Long.MAX_VALUE;

        int answer1 = 0;
        int answer2 = 0;

        while (left < right) {
            long sum = liquid[left] + liquid[right];
            long abs = Math.abs(sum);

            if(abs <= min) {
                min = abs;
                answer1 = left;
                answer2 = right;
            }

            if(sum >= 0){
                right--;
            }else {
                left++;
            }
        }

        System.out.println(liquid[answer1] + " " + liquid[answer2]);
    }
}
