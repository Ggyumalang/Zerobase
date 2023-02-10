package exercise_coding.leetcode.leet20230213;

import java.util.Arrays;

public class exam01_1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,3,0,1,4};
//        int[] nums = {1};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        int max = 0;
        int curr = 0;
        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max , i + nums[i]);
            if(curr == i){
                curr = max;
                count++;
            }

            if(curr > nums.length-1){
                return count;
            }
        }
        return count;
    }

}
