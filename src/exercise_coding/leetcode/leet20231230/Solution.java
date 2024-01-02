package exercise_coding.leetcode.leet20231230;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0,n);
            System.out.println(Arrays.toString(nums1));
            return;
        }

        if (n == 0) {
            return;
        }

        List<Integer> numList = Arrays.stream(nums1).boxed().collect(Collectors.toList()).subList(0,m);

        numList.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));

        Collections.sort(numList);

//        nums1 = numList.stream().mapToInt(a -> a).toArray();

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numList.get(i);
        }
        System.out.println(Arrays.toString(nums1));
    }
}
