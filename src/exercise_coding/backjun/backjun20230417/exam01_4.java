package exercise_coding.backjun.backjun20230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class exam01_4 {

    static final int ALPHABET_LEN = 26;
    static int N,K;
    static String[] subString;
    static boolean[] visited;
    static int maxVal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if( K < 5 ){
            System.out.println(0);
        }else if( K >= 26){
            System.out.println(N);
        }else {
            subString = new String[N];

            for (int i = 0; i < N; i++) {
                //앞에 4, 뒤에 4 제외하기
                String s = br.readLine();
                subString[i] = s.substring(4, s.length()-4);
            }

            visited = new boolean[ALPHABET_LEN];
            //a n t i c
            visited[0] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            backtrack(0,0);
            System.out.println(maxVal);
        }
        
    }

    private static void backtrack(int idx, int start) {

        if(idx == K-5){
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isPass = true;
                for (int j = 0; j < subString[i].length(); j++) {
                    if(!visited[subString[i].charAt(j) - 'a']){
                        isPass = false;
                        break;
                    }
                }
                if(isPass){
                    count++;
                }
            }
            maxVal = Math.max(maxVal, count);
            return;
        }

        for (int i = start; i < ALPHABET_LEN; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(idx+1, i+1);
                visited[i] = false;
            }
        }
    }

}
