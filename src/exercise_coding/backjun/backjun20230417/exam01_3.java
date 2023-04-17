//백준 - 1062 가르침
package exercise_coding.backjun.backjun20230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class exam01_3 {

    static int N,K;
    static int maxVal;
    static String[] subString;
    static boolean visited[] = new boolean[26];
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        subString = new String[N];

        if(K < 5) { //a , n , t , i , c
            System.out.println(0);
        }else if(K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                subString[i] = str.substring(4, str.length()-4);//앞에 anta , tica 제거
            }
            //a,n,t,i,c 방문 처리
            visited[0] = true;
            visited['n'-'a'] = true;
            visited['t'-'a'] = true;
            visited['i'-'a'] = true;
            visited['c'-'a'] = true;
            //조합 -> dfs
            numbers = new int[K-5];
            combination(0,0);
            System.out.println(maxVal);
        }
    }

    private static void combination(int idx, int start) {

        //총 단어 6개라면 a n t i c 를 제외 한 조합 1개
        if(idx == K-5){
            int count = 0;

            for (int i = 0; i < N; i++) {
                boolean isValid = true;

                for (int j = 0; j < subString[i].length(); j++) {
                    if(!visited[subString[i].charAt(j) - 'a']){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    count++;
                }
            }
            maxVal = Math.max(maxVal, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if(!visited[i]){
                visited[i] = true;
                combination(idx+1, i+1);
                visited[i] = false;
            }
        }
    }

}
