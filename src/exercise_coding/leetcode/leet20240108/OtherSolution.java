package exercise_coding.leetcode.leet20240108;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class OtherSolution {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int cnt = 0;
        int idx = 1;

        if(nums.length == 0) {
            return 0;
        }
        Queue<Integer> queue = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue);
        int val = queue.remove();

        while (!queue.isEmpty()) {
            if(val == queue.peek()) {
                cnt++;
                if(cnt > 1) {
                    queue.remove();
                } else {
                    nums[idx++] = val;
                }
            } else {
                cnt = 0;
                nums[idx++] = queue.peek();
                val = queue.remove();
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(idx);
        return idx-1;
    }
}
