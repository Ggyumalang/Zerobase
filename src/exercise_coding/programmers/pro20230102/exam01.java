package exercise_coding.programmers.pro20230102;

import java.util.*;

public class exam01 {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N,number));
    }

    public static int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        if(N == number){
            return 1;
        }

        for (int i = 0; i <= 8; i++) {
           dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        int answer = 0;

        for (int i = 2; i <= 8; i++) {
            Set<Integer> set = dp.get(i);
            for (int j = 1; j < i; j++) {
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i - j);

                for(int preNum : preSet) {
                    for (int postNum : postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);

                        if(preNum != 0 && postNum != 0){
                            set.add(preNum / postNum);
                        }
                    }
                }
            }
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        System.out.println(dp);

        for(Set<Integer> item : dp){
            if(item.contains(number)){
                return dp.indexOf(item);
            }
        }

        return -1;
    }
}
