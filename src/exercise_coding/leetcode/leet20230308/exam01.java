package exercise_coding.leetcode.leet20230308;

public class exam01 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
