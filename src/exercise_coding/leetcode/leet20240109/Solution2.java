package exercise_coding.leetcode.leet20240109;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;

        System.out.println(Arrays.toString(rotate(nums, k)));

        nums = new int[]{1,2,3,4,5,6,7};
        k = 3;
        System.out.println(Arrays.toString(rotate(nums, k)));
    }

    public static int[] rotate(int[] nums, int k) {

        if(k == 0 || k == nums.length) {
            return nums;
        }

        int idx = k % nums.length;

        int[] arr = new int[nums.length];

        Queue<Integer> queue = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        while (!queue.isEmpty()) {
            arr[idx] = queue.poll();
            idx = (idx+1) % nums.length;
        }

        System.arraycopy(arr, 0, nums, 0, nums.length);
        return nums;
    }
}
