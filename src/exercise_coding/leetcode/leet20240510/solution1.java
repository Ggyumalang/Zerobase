package exercise_coding.leetcode.leet20240510;

import java.util.Arrays;

public class solution1 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));

        ratings = new int[]{1,2,2};
        System.out.println(candy(ratings));

        ratings = new int[]{29,51,87,87,72,12};
        System.out.println(candy(ratings));
        ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
        ratings = new int[]{1,3,4,5,2};
        System.out.println(candy(ratings));
        ratings = new int[]{1,6,10,8,7,3,2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] answer = new int[length];

        Arrays.fill(answer, 1);

        for (int i = 1; i < length; i++) {
            if(ratings[i] > ratings[i-1]) {
                answer[i] = answer[i-1] + 1;
            }
        }

        System.out.println(Arrays.toString(answer));

        for (int i = length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                answer[i] = Math.max(answer[i], answer[i+1] + 1);
            }
        }

        System.out.println(Arrays.toString(answer));

        return Arrays.stream(answer).sum();
    }
}
