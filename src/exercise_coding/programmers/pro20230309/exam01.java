//프로그래머스 징검다리
//이분탐색
package exercise_coding.programmers.pro20230309;

import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones,k));
    }

    public static int solution(int[] stones, int k) {
        int left = 0;
        int right = Arrays.stream(stones).max().getAsInt();

        while (left <= right){
            int mid = left+(right-left)/2;
            int jump = 0;
            for (int stone : stones) {
                if (stone < mid) {
                    jump++;
                    if (jump >= k) {
                        break;
                    }
                } else {
                    jump = 0;
                }
            }

            if(jump >= k){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return right;
    }
}
