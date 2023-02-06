package coding_test_exercise.year2022.pro20221201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bfs_dfs_6 {
    static ArrayList<String> list;
    static boolean[] visited;
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN","ICN",tickets,0);
        System.out.println(list);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    public static void dfs(String start, String route, String[][] tickets , int depth){
        if(depth == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1],route + " " + tickets[i][1],tickets,depth+1);
                visited[i] = false;
            }
        }
    }
}
