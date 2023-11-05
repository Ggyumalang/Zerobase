//bfs
//프로그래머스 - 단어변환
package exercise_coding.programmers.pro20231101;

import java.util.*;

public class exam02 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin,target,words));

        begin = "hit";
        target = "cog";
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words));
    }

    public static int answer = Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).noneMatch(x -> x.equals(target))){
            return 0;
        }

        return  bfs(begin, target , words);
    }

    private static int bfs(String begin, String target, String[] words) {
        List<String> list = Arrays.asList(words);
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int[] visited = new int[words.length];

        while (!queue.isEmpty()) {
            String bg = queue.poll();

            if(bg.equals(target)) {
                return visited[list.indexOf(bg)];
            }

            for (int i = 0; i < list.size(); i++) {
                if(visited[i] == 0 && isPromising(bg, list.get(i))){
                    queue.offer(list.get(i));
                    if(bg.equals(begin)){
                        visited[i] = 1;
                    }else {
                        visited[i] = visited[list.indexOf(bg)] + 1;
                    }
                }
            }
        }

        return 0;
    }

    private static boolean isPromising(String begin, String str) {
        char[] bChr = begin.toCharArray();
        char[] sChr = str.toCharArray();
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if(bChr[i] != sChr[i]) {
                diff++;
                if(diff > 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
