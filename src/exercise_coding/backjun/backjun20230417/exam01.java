package exercise_coding.backjun.backjun20230417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] words = new String[N];
        int[][] checkAlpha = new int[N][26];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            for (int j = 0; j < words[i].length(); j++) {
                checkAlpha[i][words[i].charAt(j)-'a']++;
            }
        }

        System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
        System.out.println("Arrays.deepToString(checkAlpha) = " + Arrays.deepToString(checkAlpha));

    }

}
