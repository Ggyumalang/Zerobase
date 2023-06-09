//leetCode => First Missing Positive

package exercise_coding.leetcode.leet20230609;

import java.util.Arrays;

public class exam02 {

    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{2147483647};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{-5};
        System.out.println(firstMissingPositive(nums));

        nums = new int[]{1,2,3,10,2147483647,9};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);

        int k = 1;

        for (int num : nums) {
            if (num == k) {
                k++;
            }
        }
        return k;
    }
}
