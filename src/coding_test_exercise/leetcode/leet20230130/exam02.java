package coding_test_exercise.leetcode.leet20230130;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            if(result[0] == -1){
                if(nums[left] == target) {
                    result[0] = left;
                }else if(nums[left] > target){
                    break;
                }else {
                    left++;
                }
            }
            if(result[1] == -1) {
                if (nums[right] == target) {
                    result[1] = right;
                } else if (nums[right] < target) {
                    break;
                } else {
                    right--;
                }
            }

            if(result[0] != -1 && result[1] != -1){
                return result;
            }
        }

        return result;
    }
}
