//dfs
//프로그래머스 - 여행경로
package exercise_coding.programmers.pro20231101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class exam04 {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets)));

        tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static List<String> answers;
    public static boolean[] visited;
    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN", tickets,  "ICN", 0);
        Collections.sort(answers);
        return Arrays.stream(answers.get(0).split(" ")).toArray(String[]::new);
    }

    private static void dfs(String start, String[][] tickets, String routes, int depth) {
        if(depth == tickets.length) {
            answers.add(routes);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1] , tickets, routes + " " + tickets[i][1], depth+1);
                visited[i] = false;
            }
        }
    }

}
