//binarySearch
package exercise_coding.leetcode.leet20230206;

import java.util.Arrays;

public class exam02 {

    public static void main(String[] args) {
//        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int[] weights = {1,2,3,1,1};
//        int days = 5;
        int days = 4;
        System.out.println("shipWithinDays(we) = " + shipWithinDays(weights,days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        //무게를..
        int left = Arrays.stream(weights).min().getAsInt();
        int right = Arrays.stream(weights).sum();
        int answer = Integer.MAX_VALUE;


        while (left <= right){
            int mid = left + (right - left)/2;
            if(mid < Arrays.stream(weights).max().getAsInt()){
                left = mid+1;
                continue;
            }
            int val = mid;
            int day = 1;
            for(int weight : weights){
                if(val < weight){
                    day++;
                    val = mid - weight;
                    continue;
                }
                val -= weight;
            }
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            System.out.println("day = " + day);
            if(day > days){
                left = mid+1;
            }else {
                answer = Math.min(answer, mid);
                right = mid-1;
            }
        }
        return answer;
    }
}
