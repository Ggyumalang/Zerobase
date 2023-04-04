//백준 -
package exercise_coding.backjun.backjun20230404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class exam01 {

    static List<List<Integer>> graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(graph);

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            answer = 0;
            dfs(i, visited);
            System.out.println("answer = " + answer);
            if(answer >= 4){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int start, boolean[] visited) {

        if(answer == 4){
            return;
        }

        for (int i = 0; i < graph.get(start).size(); i++) {
            if(!visited[graph.get(start).get(i)]){
                visited[graph.get(start).get(i)] = true;
                answer++;
                dfs(graph.get(start).get(i), visited);
                if(answer == 4){
                    return;
                }
                visited[graph.get(start).get(i)] = false;
                answer--;

            }
        }

    }

}
