//leetCode - 80. Remove Duplicates from Sorted Array II
package exercise_coding.leetcode.leet20240722;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int[] expectedNums = new int[length];
        expectedNums[0] = nums[0];
        int prev = nums[0];
        int cnt = 0;
        for (int i = 1; i < length; i++) {
            int now = nums[i];
            if(now == prev) {
                cnt++;
                if(cnt >= 2) {
                    expectedNums[i] = Integer.MAX_VALUE;
                } else {
                    expectedNums[i] = now;
                }
            } else {
                expectedNums[i] = now;
                prev = now;
                cnt = 0;
            }
        }

        for (int i = 0, j = 0; i < length && j < length ; i++, j++) {
            if(expectedNums[j] != Integer.MAX_VALUE) {
                nums[i] = expectedNums[j];
            } else {
                while (j+1 < length && expectedNums[j+1] == Integer.MAX_VALUE) {
                    j++;
                }
                if(j+1 < length) {
                    nums[i] = expectedNums[++j];
                }
            }
        }

        return length - (int) Arrays.stream(expectedNums).asLongStream().filter(x -> x == Integer.MAX_VALUE).count();
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0; // Pointer for the position to place the next element
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n; // Place the current element and increment i
            }
        }
        System.out.println(Arrays.toString(nums));
        return i; // Return the length of the modified array
    }
}
