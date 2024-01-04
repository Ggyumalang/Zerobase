package exercise_coding.leetcode.leet20240104;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int endPos = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[endPos++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return endPos;
    }
}
