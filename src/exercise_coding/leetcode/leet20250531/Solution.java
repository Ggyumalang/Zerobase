package exercise_coding.leetcode.leet20250531;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLen = nums1.length - 1;
        int bLen = nums2.length - 1;
        int[] newNums = new int[aLen + bLen + 2];

        int aIdx = 0;
        int bIdx = 0;
        int idx = 0;
        int length = newNums.length;
        while (idx < length && aIdx < nums1.length && bIdx < nums2.length) {
            System.out.println(aIdx);
            System.out.println(bIdx);
            System.out.println(idx);

            if(nums1[aIdx] <= nums2[bIdx]) {
                newNums[idx] = nums1[aIdx];
                aIdx++;
            } else {
                newNums[idx] = nums2[bIdx];
                bIdx++;
            }

            idx++;
        }

        System.out.println(aIdx);
        System.out.println(bIdx);
        System.out.println(idx);

        while (aIdx <= nums1.length-1) {
            newNums[idx++] = nums1[aIdx++];
        }

        while (bIdx <= nums2.length-1) {
            newNums[idx++] = nums2[bIdx++];
        }

        System.out.println(Arrays.toString(newNums));

        int halfLen = length / 2;
        if(length % 2 == 0) {
            return (double) (newNums[halfLen - 1] + newNums[halfLen]) / 2;
        } else {
            return newNums[halfLen];
        }
    }

    private int p1 = 0, p2 = 0;

    // Get the smaller value between nums1[p1] and nums2[p2] and move the pointer forwards.
    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }


}
