//갇히는 물의 양 구하기
package exercise_coding.leetcode.leet20230314;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        System.out.println(Arrays.toString(maxLeft));
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        System.out.println(Arrays.toString(maxRight));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    public static int trap2(int[] height) {

        //Two pointer (Most Optimal)
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        int res=0;

        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax) leftMax=height[left];
                else res+=leftMax-height[left];
                left++;
            }
            else{
                if(height[right]>=rightMax) rightMax=height[right];
                else res+=rightMax-height[right];
                right--;
            }
        }
        return res;
    }
}
