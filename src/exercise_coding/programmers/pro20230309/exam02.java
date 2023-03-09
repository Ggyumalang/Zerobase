package exercise_coding.programmers.pro20230309;

import java.util.*;

public class exam02 {
    public static void main(String[] args) {
        int[] a = {0, 3, 3, 0, 7, 2, 0, 2, 2, 0};
        System.out.println(solution(a));
    }
    public static int solution(int[] a) {
        if(a.length == 1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> mapSort = new ArrayList<>(map.entrySet());
        mapSort.sort((x,y) -> y.getValue() - x.getValue());
        int maxVal = -1;
        for (Map.Entry<Integer, Integer> entry : mapSort) {
            if (entry.getValue() < maxVal) {
                continue;
            }
            int cnt = 0;
            int val = entry.getKey();
            boolean[] selected = new boolean[a.length];

            for (int j = 0; j < a.length; j++) {
                if (val == a[j]) {
                    if (j == 0) {
                        if (a[j] != a[j + 1]) {
                            cnt += 2;
                            selected[j + 1] = true;
                            j++;
                        }
                    } else if (j == a.length - 1) {
                        if (a[j - 1] != a[j] && !selected[j - 1]) {
                            cnt += 2;
                        }
                    } else {
                        if (a[j - 1] != a[j] && !selected[j - 1]) {
                            cnt += 2;
                            selected[j - 1] = true;
                        } else if (a[j] != a[j + 1] && !selected[j + 1]) {
                            cnt += 2;
                            selected[j + 1] = true;
                            j++;
                        }
                    }
                }
            }
            maxVal = Math.max(maxVal, cnt);
        }

        return maxVal;
    }
}
