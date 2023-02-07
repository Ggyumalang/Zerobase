package exercise_coding.year2022.pro20221130;

public class Exam5 {
    public static void main(String[] args) {
        int n = 3;
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n,computers));
    }


    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < computers.length ; i++) {
            if(!visited[i]){
                dfs(computers,visited,i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] computers , boolean[] visited , int node){
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if(computers[node][i] == 1 && !visited[i]){
                dfs(computers,visited
                        ,i);
            }
        }
    }


}
