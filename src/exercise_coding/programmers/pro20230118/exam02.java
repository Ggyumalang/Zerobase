package exercise_coding.programmers.pro20230118;

import java.util.*;

public class exam02 {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N,number));
    }

    public static int solution(int N, int number) {

        if(N == number){
            return 1;
        }

        Map<Integer , Set<Integer>> dp = new HashMap<>();
        dp.put(1, Set.of(5));

        for (int i = 2; i < 9; i++) {
            dp.put(i, new HashSet<>());
            for (int j = i-1; j > 0 ; j--) {
                Set<Integer> setA = dp.get(j);
                Set<Integer> setB = dp.get(i-j);

                for(int a : setA){
                    for(int b : setB){
                        dp.get(i).add(a+b);
                        if(a-b > 0){
                            dp.get(i).add(a-b);
                        }
                        dp.get(i).add(a*b);
                        if(a/b > 0){
                            dp.get(i).add(a/b);
                        }
                        dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
                    }
                }
            }
            System.out.println(dp);
            if(dp.get(i).contains(number)){
                return i;
            }
        }
        
        return -1;
    }
}
