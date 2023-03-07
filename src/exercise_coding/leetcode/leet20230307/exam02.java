package exercise_coding.leetcode.leet20230307;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        int cnt = (int) Arrays.stream(nums).distinct().count();
        return cnt == nums.length;
    }
}
