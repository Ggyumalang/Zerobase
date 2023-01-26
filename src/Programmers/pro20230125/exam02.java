package Programmers.pro20230125;

import java.util.Arrays;
import java.util.PriorityQueue;

public class exam02 {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pqJob = new PriorityQueue<>((x, y) -> x[1] - y[1]); //끝나는 시간을 기준으로 오름차순

        Arrays.sort(jobs,(x,y) -> x[0] - y[0]);
        int end = 0;
        int idx = 0;
        int cnt = 0;
        while (cnt < jobs.length){

            while (idx < jobs.length && jobs[idx][0] <= end){
                pqJob.offer(jobs[idx++]);
            }

            if(pqJob.isEmpty()){
                end = jobs[idx][0];
            }else {
                int[] tmp = pqJob.poll();
                answer += end - tmp[0] + tmp[1];
                end += tmp[1];
                cnt++;
            }
        }
        return answer/cnt;
    }
}
