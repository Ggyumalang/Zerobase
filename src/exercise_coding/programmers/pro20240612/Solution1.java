// 프로그래머스 - K번째수
package exercise_coding.programmers.pro20240612;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1] ; i++) {
                list.add(array[i]);
            }

            Collections.sort(list);
            answer[idx++] = list.get(command[2] - 1);
        }

        return answer;
    }
}
