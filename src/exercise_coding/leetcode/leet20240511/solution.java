package exercise_coding.leetcode.leet20240511;

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }

    private static int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) {
            return 0;
        }

        int[] answer = new int[len];
        Arrays.fill(answer, 1);

        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]) {
                answer[i] = answer[i-1] + 1;
            }
        }

        for (int i = len - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]) {
                answer[i] = Math.max(answer[i] , answer[i + 1] + 1);
            }
        }

        System.out.println(Arrays.toString(answer));
        return Arrays.stream(answer).sum();
    }

}
