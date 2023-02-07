package exercise_coding.year2022.sorting;

import java.util.*;

public class exam2_1 {
    public static void main(String[] args) {
        //        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
        int[] numbers = {3, 30, 34, 5, 9 , 19};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        boolean isZero = true;
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
            if(numbers[i] != 0) isZero = false;
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            answer += nums[i];
            if(isZero) answer = "0";
        }


        return answer;
    }
}
