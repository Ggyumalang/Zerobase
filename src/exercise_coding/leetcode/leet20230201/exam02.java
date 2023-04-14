package exercise_coding.leetcode.leet20230201;

public class exam02 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int V = Math.min(height[i], height[j]) * (j-i);

        while(i!=j){
            if(height[i]<height[j]){
                i++;
                if(height[i]>height[i-1] && i!=j){
                    V = Math.max(V , Math.min(height[i], height[j]) * (j-i));
                }
            }
            else{
                j--;
                if(height[j]>height[j+1] && i!=j){
                    V = Math.max(V , Math.min(height[i], height[j]) * (j-i));
                }
            }
        }
        return V;
    }
}
