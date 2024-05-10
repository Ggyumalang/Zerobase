package exercise_coding.leetcode.leet20240510;

import java.util.Arrays;

public class solution {
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
        int[] left = new int[length];
        int[] right = new int[length];
        int[] answer = new int[length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        left[0] = ratings[0] > ratings[1] ? 2 : 1;
        right[length - 1] = ratings[length - 1] > ratings[length - 2] ? 2 : 1;

        for (int i = 0; i < length - 1; i++) {
            if(ratings[i] > ratings[i+1]) {
                left[i+1] = left[i] - 1;
            } else if(ratings[i] < ratings[i+1]) {
                left[i+1] = left[i] + 1;
            } else {
                left[i+1] = 1;
            }
        }

        for (int i = length - 1; i > 0; i--) {
            if(ratings[i] > ratings[i-1]) {
                right[i-1] = right[i] - 1;
            } else if(ratings[i] < ratings[i-1]) {
                right[i-1] = right[i] + 1;
            } else {
                right[i-1] = 1;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        answer[0] = left[0];
        answer[length - 1] = right[length -1];
        for (int i = 1; i < length - 1; i++) {
            answer[i] = Math.max(left[i], right[i]);
        }

        System.out.println(Arrays.toString(answer));

        return Arrays.stream(answer).sum();
    }
}
