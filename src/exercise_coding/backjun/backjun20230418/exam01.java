//백준 1062 가르침
package exercise_coding.backjun.backjun20230418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam01 {

    static final int ALPHABET_LEN = 26;
    static int N, K, answer;
    static String[] midWords;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //접두 접미 => a , n , t , i , c 는 무조건 배워야 하니 k 가 5 이상이어야 한다.
        if(K < 5){
            System.out.println(0);
        } else if (K >= ALPHABET_LEN) {
            //알파벳의 갯수인 26이라면 모든 단어를 배울 수 있다.
            System.out.println(N);
        } else {
            midWords = new String[N];
            visited = new boolean[ALPHABET_LEN];
            answer = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                midWords[i] = input.substring(4, input.length()-4); //접두, 접미 빼고 중간 단어들만 저장힌다.
            }
            //a, n , t, i ,c 는 방문 처리
            visited[0] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            backtrack(0,0);
            System.out.println(answer);
        }

    }

    private static void backtrack(int count, int start) {

        //K에 도달했을 때.. a, n , t , i ,c 는 제외하고의 숫자이므로 K-5로 한다.
        if(count == K-5){
            int containedCnt = 0;
            for (int i = 0; i < N; i++) {
                boolean isContained = true;
                for (int j = 0; j < midWords[i].length(); j++) {
                    if(!visited[midWords[i].charAt(j) - 'a']){
                        isContained = false;
                        break;
                    }
                }
                if(isContained){
                    containedCnt++;
                }
            }
            answer = Math.max(answer, containedCnt);
        }

        for (int i = start; i < ALPHABET_LEN; i++) {
            if(!visited[i]){
                visited[i] = true;
                backtrack(count+1 , i+1);
                visited[i] = false;
            }
        }
    }

}
