//Leetcode - Beautiful Arrangement
//내 풀이

package Programmers.leet20230104;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class exam02 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(countArrangement(n));
    }
    public static int countArrangement(int n) {
        List<Set<Integer>> dp= new ArrayList<>();

        for (int i = 0; i <= n ; i++) {
            dp.add(new HashSet<>());
        }
        IntStream.rangeClosed(1,n).forEach(x->dp.get(1).add(x));
        for (int i = 2; i <= n ; i++) {
            dp.get(i).add(i);
        }
        System.out.println(dp);
        for (int i = 2; i <= n/2 ; i++) {
            for (int j = i+1; j <= n ; j++) {
                if(j%i == 0){
                    dp.get(i).addAll(dp.get(j));
                }
            }
        }
        System.out.println(dp);
        int answer = 1;
        for (int i = 1; i < dp.size(); i++) {
            answer *= dp.get(i).size();
        }

        return answer;
    }
}
