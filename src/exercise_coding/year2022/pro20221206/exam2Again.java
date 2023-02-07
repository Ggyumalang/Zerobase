package exercise_coding.year2022.pro20221206;

import java.util.Arrays;
import java.util.PriorityQueue;

public class exam2Again {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs,(x,y) -> x[0] - y[0]); //요청 시점으로 오름차순

        int idx = 0; // jobs의 idx 를 저장할 변수
        int count = 0; //계산 완료한 수
        int end = 0; //종료시점들을 저장함.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[1] - y[1]); // 소요시간으로 오름차순

        while (count < jobs.length) {

            //어떤 작업이 완료되기 전에 작업을 요청하고 기다리는 아이들을 pq에 넣어준다.
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.offer(jobs[idx++]);
            }
            //pq가 empty 라는 말은 작업 종료가 이뤄진 이후에 새로운 작업이 요청되었다는 의미이다.
            if(pq.isEmpty()) {
                end = jobs[idx][0];
            }else {
                //pq가 empty가 아닐떄!
                int[] job = pq.poll();
                answer += job[1] + end - job[0];
                count++;
                end += job[1];
            }

        }


        return answer / jobs.length;
    }
}
