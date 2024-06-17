//프로그래머스 - 입국심사
package exercise_coding.programmers.pro20240617;

import java.util.Arrays;

//각각의 심사대를 따로 두고 생각하면 된다.
//각각의 심사대에서 주어진 시간에 처리할 수 있는 최대의 사람의 수가 n에 도달할 때까지 lowBound 방식으로 진행하면 된다.
public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = times[0];
        long right = (long) times[times.length - 1] * n;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = calc(mid, times);

            if(count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private static long calc(long mid, int[] times) {
        long sum = 0;
        for (int time : times) {
            sum += mid / time;
        }
        return sum;
    }
}
