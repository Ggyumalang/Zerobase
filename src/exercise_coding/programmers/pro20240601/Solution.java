//프로그래머스 dp N으로 표현
package exercise_coding.programmers.pro20240601;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        System.out.println(solution(N,number));

        N = 2;
        number = 11;

        System.out.println(solution(N,number));
        N = 4;
        number = 31;

        System.out.println(solution(N,number));

        N = 5;
        number = 31168;

        System.out.println(solution(N,number));

        N = 4;
        number = 17;

        System.out.println(solution(N,number));

        N = 5;
        number = 555;

        System.out.println(solution(N,number));

        N = 5;
        number = 5;

        System.out.println(solution(N,number));
    }

    public static int solution(int N, int number) {
        if(N == number) {
            return 1;
        }

        if(N * 10 + N == number) {
            return 2;
        }

        if(N > number) {
            return 0;
        }

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Set<Integer> firstSet = new HashSet<>();
        firstSet.add(N+N);
        firstSet.add(N*N);
        firstSet.add(N * 10 + N);
        firstSet.add(1);
        dp.put(1, Set.of(N));
        dp.put(2, firstSet);

        System.out.println("dp >>>" + dp);

        for (int i = 3; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= i/2; j++) {
                Set<Integer> setA = dp.get(i - j);
                Set<Integer> setB = dp.get(j);

                for(int valA : setA) {
                    for(int valB : setB) {

                        int plus = valA + valB;
                        int multiply = valA * valB;

                        set.add(plus);

                        if(valA > valB) {
                            set.add(valA - valB);
                            set.add(valA / valB);
                        } else if(valB > valA) {
                            set.add(valB - valA);
                            set.add(valB / valA);
                        }

                        set.add(multiply);
                    }
                }
            }

            set.add(getNum(i, N));
            System.out.println(set);

            if(set.contains(number)) {
                return i;
            }
            dp.put(i, set);
        }

        return -1;
    }

    private static Integer getNum(int idx, int n) {
        int num = n;
        for (int i = 1; i < idx; i++) {
            num += n * Math.pow(10, i);
        }

        System.out.println("num >>> " + num);
        return num;
    }
}
