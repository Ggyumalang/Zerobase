//고속도로 카메라 설치
package exercise_coding.programmers.pro20230228;

import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes,(x,y)-> x[1] - y[1]);
        int answer = 1;
        int finish = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if(routes[i][0] > finish){
                answer++;
                finish = routes[i][1];
            }
        }
        return answer;
    }
}
