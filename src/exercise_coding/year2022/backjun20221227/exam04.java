package exercise_coding.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam04 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(nums, operators, nums[0], 1);


        System.out.println(max);
        System.out.println(min);
    }

    public static void backTracking(int[] nums , int[] operators , int num , int idx) {
        if (idx == nums.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        backTracking(nums, operators, num + nums[idx], idx + 1);
                        break;
                    case 1:
                        backTracking(nums, operators, num - nums[idx], idx + 1);
                        break;
                    case 2:
                        backTracking(nums, operators, num * nums[idx], idx + 1);
                        break;
                    case 3:
                        backTracking(nums, operators, num / nums[idx], idx + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
