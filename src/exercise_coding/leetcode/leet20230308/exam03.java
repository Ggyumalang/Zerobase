package exercise_coding.leetcode.leet20230308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class exam03 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m , nums2, n);

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m , nums2, n);

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        merge(nums1, m , nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(nums1[i]);
        }

        for (int i = 0; i < n; i++) {
            list.add(nums2[i]);
        }


        Collections.sort(list);
        System.out.println(list);

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums1));
    }
}
