//leetCode - 238.Product of Array Except Self
package exercise_coding.leetcode.leet20240502;

import java.util.Arrays;

public class solution3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return nums;
        }

        if (Arrays.stream(nums).anyMatch(x -> x == 0)) {
            if (Arrays.stream(nums).filter(x -> x == 0).count() > 1) {
                return result;
            }
            int productVal = Arrays.stream(nums).filter(x -> x != 0).reduce((x, y) -> x * y).getAsInt();

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = productVal;
                } else {
                    result[i] = 0;
                }
            }
        } else {
            int productVal = Arrays.stream(nums).reduce((x, y) -> x * y).getAsInt();
            for (int i = 0; i < nums.length; i++) {
                result[i] = productVal / nums[i];
            }
        }

        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return nums;
    }
}
