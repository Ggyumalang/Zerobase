//타겟의 수만큼 과제를 하는 시간을 이분탐색하는 방법으로..
package coding_test_exercise.programmers.pro20230125;

import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        int n = 6;
        int[] cores = {1,2,3};
        System.out.println(solution(n,cores));
    }

    public static int solution(int n, int[] cores) {
        if(n < cores.length){
            return n;
        }
        int answer = 0;
        int min = 0; //시간의 최소값
        int max = n * Arrays.stream(cores).max().getAsInt(); //시간의 최대값
        int curTime = 0;
        int m = 0; //time까지 처리한 작업량

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = calculate(mid, cores);

            // 해당시간까지 처리한 작업량이 n보다 크거나 같다면 time과 m갱신
            if(cnt >= n) {
                max = mid-1;
                curTime = mid;
                m = cnt;
            }else {
                min = mid+1;
            }
        }

        System.out.println(curTime);
        System.out.println(m);

        m -= n; //처리한 작업량과 n의 차이 갱신
        //curTime 시 처리하는 작업
        //맨 마지막 작업을 뽑아내야하므로 끝에서부터 찾는다.
        for (int i = cores.length - 1; i >= 0 ; i--) {
            if( curTime % cores[i] == 0) {
                if( m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }
        return answer;

    }

    private static int calculate(int time, int[] cores) {
        int cnt = cores.length;
        if(time == 0) { //시간이 0일때 처리할 수 있는 코어의 갯수
            return cnt;
        }

        //해당 시간에 얼마나 많은 작업을 처리할 수 있는지 작업량 합산
        for (int i = 0; i < cores.length; i++) {
            cnt += time / cores[i];
        }
        
        return cnt;
    }
}
