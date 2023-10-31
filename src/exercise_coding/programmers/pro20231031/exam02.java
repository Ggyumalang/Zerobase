//bfs
package exercise_coding.programmers.pro20231031;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class exam02 {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n,computers));
    }

    public static int[] visited;
    public static int solution(int n, int[][] computers) {
        visited = new int[n];
        int val = 0;
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                val++;
                bfs(computers, n, val, i);
            }
        }


        return Arrays.stream(visited).max().getAsInt();
    }

    private static void bfs(int[][] computers, int n, int value, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = value;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < n; i++) {
                if(cur == i) {
                    continue;
                }

                if(computers[cur][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[cur];
                    queue.add(i);
                }
            }
        }
    }
}
