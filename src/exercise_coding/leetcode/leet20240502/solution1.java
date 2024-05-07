//leetCode 55.JumpGame
package exercise_coding.leetcode.leet20240502;

public class solution1 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));

        nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));

        nums = new int[]{1,1,1,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }

        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = i + nums[i];
            if(val >= maxVal && maxVal >= i) {
                maxVal = val;
            }

            if(maxVal >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJump2(int[] nums) {
        int reachablePos = 0;
        for (int i = 0; i < nums.length && reachablePos < nums.length - 1; i++) {
            if( i > reachablePos) return false;
            reachablePos = Math.max(i + nums[i] , reachablePos);
        }

        return true;
    }
}
