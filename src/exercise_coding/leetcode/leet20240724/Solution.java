package exercise_coding.leetcode.leet20240724;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        System.arraycopy(nums, 0, newNums, 0, length);

        for (int i = 0; i < length; i++) {
            int val = i + k;
            int pos = val < length ? val : val % length;
            newNums[pos] = nums[i];
        }
        System.out.println(Arrays.toString(newNums));
        System.arraycopy(newNums, 0, nums, 0, length);
    }

}
