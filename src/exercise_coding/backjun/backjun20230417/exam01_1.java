package exercise_coding.backjun.backjun20230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class exam01_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] words = new String[N];
        List<Set<Character>> listSet = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            listSet.add(new HashSet<>());
            for (int j = 0; j < words[i].length(); j++) {
                listSet.get(i).add(words[i].charAt(j));
            }
        }

        System.out.println("listSet = " + listSet);
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < listSet.size(); i++) {
            Set<Character> charactersA = listSet.get(i);
            if(K < charactersA.size()){
                continue;
            }
            int count = 1;
            for (int j = i+1; j < listSet.size(); j++) {
                Set<Character> charactersB = listSet.get(j);
                if(K < charactersB.size()){
                    continue;
                }

                if(charactersA.size() > charactersB.size() && charactersA.containsAll(charactersB)){
                        count++;
                } else if(charactersA.size() == charactersB.size() && charactersA.containsAll(charactersB)) {
                        count++;
                }
            }
            maxVal = Math.max(maxVal, count);
        }

        System.out.println(maxVal==Integer.MIN_VALUE ? 0 : maxVal);

    }

}
