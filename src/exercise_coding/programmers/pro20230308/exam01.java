//몸짱 트레이너 라이언
//TODO
package exercise_coding.programmers.pro20230308;

import java.util.Arrays;

/*
KeyPoint : 가장 먼 거리에 사람들을 배치하도록 해야하는데..
 */
public class exam01 {
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[][] timetable = {{1170,1210},{1200,1260}};
        System.out.println(solution(n,m,timetable));
    }

    public static int solution(int n, int m, int[][] timetable) {
        //혼자 왔으면 겹치는 경우 x이므로 0
        if(m == 1){
            return 0;
        }

        //2명 이용 시 이용 시간이 겹치면 조정 / 겹치지 않으면 0
        if(m == 2){
            if(timetable[0][1] >= timetable[1][0]){
                return 2 * (n-1);
            }else {
                return 0;
            }
        }
        int[][] locker = new int[n][n];

        int answer = 0;
        Arrays.sort(timetable,(x,y) -> x[0] - y[0]);
//        for (int i = 0; i < timetable.length; i++) {
//
//        }

        return answer;
    }
}
