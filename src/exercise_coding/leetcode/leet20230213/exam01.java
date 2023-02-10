package exercise_coding.leetcode.leet20230213;

import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,0,1,4};
        int[] nums = {1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i+num; j > i ; j--) {
                if(j >= nums.length){
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[i] + 1);
                if(j == nums.length-1){
                    return dp[j];
                }

            }
        }
        return dp[nums.length-1];
    }

}
