package exercise_coding.leetcode.leet20240102;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OtherSolution {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println((removeElement(nums, val)));

        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println((removeElement(nums, val)));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1 && nums[0] == val) {
            nums = new int[0];
            return 0;
        }

        List<Integer> collect = Arrays.stream(nums).filter(x -> x != val).boxed().collect(Collectors.toList());

        for (int i = 0; i < collect.size(); i++) {
            nums[i] = collect.get(i);
        }

        return collect.size();
    }
}
