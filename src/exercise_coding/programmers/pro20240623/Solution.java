//프로그래머스 - 더 맵게
package exercise_coding.programmers.pro20240623;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        while (!pq.isEmpty() && pq.peek() < K) {
            int min = pq.poll();
            int nextMin = 0;
            if(!pq.isEmpty()) {
                nextMin = pq.poll();
            } else {
                return -1;
            }

            int val = min + (nextMin * 2);
            pq.offer(val);
            answer++;
            System.out.println(pq);
            System.out.println(answer);
        }
        return answer;
    }
}
