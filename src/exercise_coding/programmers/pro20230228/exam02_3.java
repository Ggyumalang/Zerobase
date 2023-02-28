//완호네회사
package exercise_coding.programmers.pro20230228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam02_3 {

    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores) {
        int answer = 0;

        //완호의 점수 저장
        int[] wanho = scores[0];

        //근무 태도 점수 내림차순 ( 같으면 동료평가 오름차순 )
        Arrays.sort(scores, (x,y) ->{
            if(x[0] == y[0]){
                return x[1] - y[1];
            }
            return y[0] - x[0];
        });

        System.out.println(Arrays.deepToString(scores));

        //동료 평가 점수 저장
        int tempB = Integer.MIN_VALUE;
        for (int[] score : scores) {
            boolean isDrop = false;

            if(tempB < score[1]){
                tempB = score[1];
            } else if (tempB > score[1]) {
                isDrop = true;
            }

            if(isDrop){
                if(score[0] == wanho[0] && score[1] == wanho[1]){
                    return -1;
                }
                continue;
            }

            if(score[0] + score[1] > wanho[0] + wanho[1]){
                answer++;
            }
        }
        return answer+1;
    }
}
