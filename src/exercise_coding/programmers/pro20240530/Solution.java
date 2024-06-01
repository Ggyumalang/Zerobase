package exercise_coding.programmers.pro20240530;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(solution(n,lost,reserve));

        n = 5;
        lost = new int[]{2,4};
        reserve = new int[]{3};
        System.out.println(solution(n,lost,reserve));

        n = 5;
        lost = new int[]{5,3};
        reserve = new int[]{4,2};
        System.out.println(solution(n,lost,reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] num = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            num[i] = 1;
        }

        for(int l : lost) {
            num[l]--;
        }

        for(int r : reserve) {
            num[r]++;
        }

        System.out.println(Arrays.toString(num));
        int[] ints = Arrays.copyOf(num, n+1);

        for (int i = 1; i <= n ; i++) {
            if(num[i] == 0) {
                if(i < n && num[i+1] == 2) {
                    num[i+1]--;
                    num[i]++;
                }else if(i > 1 && num[i-1] == 2) {
                    num[i-1]--;
                    num[i]++;
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            if(ints[i] == 0) {
                if(i > 1 && ints[i-1] == 2) {
                    ints[i-1]--;
                    ints[i]++;
                }else if(i < n && ints[i+1] == 2) {
                    ints[i+1]--;
                    ints[i]++;
                }
            }
        }
        return (int) Math.max(Arrays.stream(num).filter(a -> a >= 1).count(), Arrays.stream(ints).filter(x -> x >= 1).count());
    }
}
