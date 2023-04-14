//leetCode - Container With Most Water
package exercise_coding.leetcode.leet20230201;

import java.io.IOException;

public class exam02_1 {
    public static void main(String[] args) throws IOException {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = Math.min(height[left],height[right]) * (right-left);

        while (left != right){
            if(height[left] < height[right]){
                left++;
                if(height[left] > height[left-1] && left != right){
                    area = Math.max(area, Math.min(height[left],height[right]) * (right-left));
                }
            }else {
                right--;
                if(height[right] > height[right+1] && left != right){
                    area = Math.max(area, Math.min(height[left],height[right]) * (right-left));
                }
            }
        }
        return area;
    }


}
