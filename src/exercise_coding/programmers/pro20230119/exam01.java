//문제가 내 생각대로 하기엔 너무 복잡한데... 어떻게 해야할까
package exercise_coding.programmers.pro20230119;

import java.util.*;
import java.util.stream.IntStream;

public class exam01 {
    public static void main(String[] args) {
        int target = 21;
        System.out.println(Arrays.toString(solution(target)));
    }

    public static int[] solution(int target) {
        int[] answer = {};
        Map<Integer , Set<Integer>> singleDp = new HashMap<>();
        Map<Integer , Set<Integer>> doubleDp = new HashMap<>();
        Map<Integer , Set<Integer>> tripleDp = new HashMap<>();
        singleDp.put(1, new HashSet<>());
        doubleDp.put(1, new HashSet<>());
        tripleDp.put(1, new HashSet<>());
        IntStream.rangeClosed(1,20).forEach(x -> singleDp.get(1).add(x));
        IntStream.rangeClosed(1,20).map(x -> x*2).forEach(x -> doubleDp.get(1).add(x));
        IntStream.rangeClosed(1,20).map(x ->  x*3).forEach(x -> tripleDp.get(1).add(x));
        singleDp.get(1).add(50);

        if(singleDp.get(1).contains(target)){
           return new int[]{1,1};
        }

        if(doubleDp.get(1).contains(target)){
            return new int[]{1,0};
        }

        if(tripleDp.get(1).contains(target)){
            return new int[]{1,0};
        }
        int idx = 2;
        int cnt = 0;
        int score = 0;

        while (target == score) {
            score = 0;
            singleDp.put(idx,new HashSet<>());
            doubleDp.put(idx,new HashSet<>());
            tripleDp.put(idx,new HashSet<>());
            getInts(singleDp, idx);

            if(singleDp.get(idx).contains(target)){
                return new int[]{idx, idx};
            }

            for (int j = idx-1; j > 0 ; j--) {
                Set<Integer> setA = singleDp.get(j);
                Set<Integer> setB = doubleDp.get(idx - j);

                for(int a : setA){
                    for(int b : setB){
                        singleDp.get(idx).add(a+b);
                    }
                }
            }

            if(doubleDp.get(idx).contains(target)){
                return new int[]{idx, 0};
            }

            if(tripleDp.get(idx).contains(target)){
                return new int[]{idx, 0};
            }
        }
        return answer;
    }

    private static void getInts(Map<Integer, Set<Integer>> singleDp, int idx) {
        for (int j = idx-1; j > 0 ; j--) {
            Set<Integer> setA = singleDp.get(j);
            Set<Integer> setB = singleDp.get(idx - j);

            for(int a : setA){
                for(int b : setB){
                    singleDp.get(idx).add(a+b);
                }
            }
        }
    }
}
