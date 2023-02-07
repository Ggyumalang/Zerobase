package exercise_coding.year2022.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class exam1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1,7,3}};
        System.out.println(Arrays.toString(solution(array,commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        if(array == null || array.length == 0 || commands == null || commands.length == 0 || commands[0].length == 0) {
            return null;
        }

        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = command[0]-1; i < command[1]; i++) {
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[idx++] = list.get(command[2]-1);
        }

        return answer;
    }
}
