package exercise_coding.backjun.backjun20230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class exam01_2 {

    static int N,K;
    static int maxVal;
    static List<Set<Character>> listSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        String[] words = new String[N];
        listSet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            listSet.add(new HashSet<>());
            for (int j = 0; j < words[i].length(); j++) {
                listSet.get(i).add(words[i].charAt(j));
            }
        }
        maxVal = Integer.MIN_VALUE;

        backtracking(0, 0, new HashSet<>());

        System.out.println(maxVal==Integer.MIN_VALUE ? 0 : maxVal);

    }

    private static void backtracking(int idx, int count, HashSet<Character> set) {
        if(idx >= N-1){
            maxVal = Math.max(maxVal, count);
            return;
        }

        HashSet<Character> preSet = new HashSet<>(set);
        for (int i = idx; i < listSet.size(); i++) {
            if(listSet.get(i).size() > K){
                continue;
            }
            set.addAll(listSet.get(i));
            if(set.size() > K){
                set = preSet;
                continue;
            }

            backtracking(i+1 , count + 1 , set);

            set = new HashSet<>(preSet);
        }
    }

}
