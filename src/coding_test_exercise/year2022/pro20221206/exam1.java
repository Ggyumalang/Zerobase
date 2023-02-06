package coding_test_exercise.year2022.pro20221206;

import java.util.Arrays;
import java.util.PriorityQueue;

public class exam1 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville,K));
    }

    public static int solution(int[] scoville, int K) {
        if(scoville == null || scoville.length == 0 || K == 0) {
            return 0;
        }

        int answer = 0;
        PriorityQueue<Integer> pqSco = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(x->pqSco.offer(x));

        while (pqSco != null && pqSco.peek() < K) {

            if(pqSco.size() < 2){
                return -1;
            }

            int first = pqSco.poll();
            int second = pqSco.poll();
            answer++;
            pqSco.offer(first + (second*2));

            if(pqSco.peek() >= K) {
                return answer;
            }
        }


        return -1;
    }
}
