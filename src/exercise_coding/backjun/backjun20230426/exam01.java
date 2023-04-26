package exercise_coding.backjun.backjun20230426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        if(set.contains(K)){
            System.out.println(1);
            return;
        }

        map.put(1, set);

        for (int i = 2; i <= 100; i++) {
            set = new HashSet<>();
            for (int j = 1; j <= i / 2; j++) {
                Set<Integer> setA = map.get(j);
                Set<Integer> setB = map.get(i - j);

                for(int a : setA) {
                    for(int b : setB) {
                        int addSet = a+b;

                        if(addSet == K) {
                            System.out.println(i);
                            return;
                        }

                        if(addSet < K) {
                            set.add(addSet);
                        }

                    }
                }
            }
            System.out.println("set = " + set);
            map.put(i,set);
        }
        System.out.println(-1);
    }

}
