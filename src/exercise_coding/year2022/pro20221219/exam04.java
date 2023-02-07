package exercise_coding.year2022.pro20221219;

import java.util.Arrays;

public class exam04 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));
    }
    static boolean[] visited;
    public static int solution(int[][] routes) {
        int answer = 1;
        visited = new boolean[routes.length];
        Arrays.sort(routes, (x, y) -> x[1] - y[1]);
        int end = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if(end < routes[i][0]){
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}
