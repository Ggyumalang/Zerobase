package exercise_coding.leetcode.leet20230307;

public class exam01 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int max = Integer.MIN_VALUE;

        while (left <= right){
            int sum = 0;
            for (int i = left; i <= right ; i++) {
                sum += nums[i];
            }

            if(sum > max){
                max = sum;
            }

            if(nums[left] < nums[right]){
                left++;
            }else {
                right--;
//                if(nums[left+1] - nums[left] > nums[right-1] - nums[right]){
//                    left++;
//                }else {
//                    right--;
//                }
            }
        }
        return max;
    }
}
