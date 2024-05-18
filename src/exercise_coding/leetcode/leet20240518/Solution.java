//LeetCode - 167. Two Sum II - Input Array Is Sorted
package exercise_coding.leetcode.leet20240518;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));

        numbers = new int[]{2,3,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(numbers, target)));

        numbers = new int[]{-1,0};
        target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum > target) {
                right--;
            }else if(sum < target) {
                left++;
            }else {
                return new int[]{left + 1,right + 1};
            }
        }

        return new int[]{};
    }
}
