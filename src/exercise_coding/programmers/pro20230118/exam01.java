package exercise_coding.programmers.pro20230118;

import java.util.*;

public class exam01 {
    public static void main(String[] args) {
        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        System.out.println(solution(n,lighthouse));

        n = 10;
        lighthouse = new int[][] {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
        System.out.println(solution(n,lighthouse));
    }


    public static int solution(int n, int[][] lighthouse) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lighthouse.length; i++) {
            map.put(lighthouse[i][1], map.getOrDefault(lighthouse[i][1],0)+1);
            map.put(lighthouse[i][0], map.getOrDefault(lighthouse[i][0],0)+1);
        }
        System.out.println(map);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(map.get(i) > 1){
                result++;
            }
        }
        return  result;
    }
}
