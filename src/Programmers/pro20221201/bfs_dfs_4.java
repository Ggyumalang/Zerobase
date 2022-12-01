package Programmers.pro20221201;

import java.util.Arrays;

public class bfs_dfs_4 {
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words));
    }

    public static int solution(String begin, String target, String[] words) {
        if(!Arrays.stream(words).anyMatch(x -> x.equals(target))){
            return 0;
        }

        answer = 0;
        visited = new boolean[words.length];
        dfs(begin,target,words,0);
        return answer;
    }

    private static void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)){
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(visited[i]){
                //이미 바꾼 string이면 넘어간다.
                continue;
            }

            int k = 0; //같은 스펠링의 갯수
            for (int j = 0; j < begin.length(); j++) {
                if(begin.charAt(j) == words[i].charAt(j)){
                    k++;
                }
            }
            if(k == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i] , target, words, cnt+1);
                visited[i] = false;
            }
        }
    }

}
