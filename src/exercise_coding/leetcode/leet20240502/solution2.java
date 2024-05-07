//leetCode 45.JumpGame2
package exercise_coding.leetcode.leet20240502;

import java.util.Comparator;
import java.util.PriorityQueue;

public class solution2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));

        nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));

        nums = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int cnt = 0;
        int idx = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(nums[0]);

        while (!pq.isEmpty()) {
            int cur = pq.peek();
            cnt++;
            if(cur >= nums.length - 1) {
                return cnt;
            }

            pq.clear();
            for (int i = idx; cur < nums.length && i <= cur; i++) {
                pq.offer(i + nums[i]);
            }
        }

        return cnt;
    }

    public static int jump2(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int maxPos = 0;
        int maxVal = 0;

        for (int i = 0; i < n - 1; i++) {
            maxVal = Math.max(maxVal, i + nums[i]);

            if (i == maxPos) {
                jumps++;
                maxPos = maxVal;
            }
        }
        return jumps;
    }
}
