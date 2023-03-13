//무지의 먹방 라이브
//그냥 해봤는데 실패..
//TODO
package exercise_coding.programmers.pro20230313;

import java.util.*;

public class exam01_1 {

    public static void main(String[] args) {
        int[] food_times = {5, 1, 4};
        long k = 6;
        System.out.println(solution(food_times,k));
    }

    static class Food implements Comparable<Food> {
        int time;
        int idx;

        public Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }
    public static int solution(int[] food_times, long k) {
        if(Arrays.stream(food_times).sum() <= k){
            return -1;
        }
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long total = 0; //먹기 위해서 사용한 시간
        long previous = 0; //직전에 음식을 다 먹는데 걸린 시간
        long length = food_times.length; //남은 음식의 개수

        while (total + ((pq.peek().time - previous) * length) <= k){
            int now = pq.poll().time;
            total += (now - previous) * length;
            length--;
            previous = now;
        }

        List<Food> result = new ArrayList<>();
        while (!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result, (x,y) -> x.idx - y.idx);

        return result.get((int) ((k-total) % length)).idx;
    }
}
