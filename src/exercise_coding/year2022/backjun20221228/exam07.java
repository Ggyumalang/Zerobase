//백준 15686번 치킨 배달 골드 5
package exercise_coding.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class exam07 {
    static List<int[]> home;
    static List<int[]> chicken;
    static boolean[] open;
    static int answer;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num== 1){
                    home.add(new int[]{i,j});
                } else if (num == 2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }
        open = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt){
        if(cnt == M){
            int subResult = 0;
            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if(open[j]){
                        int distance = Math.abs(home.get(i)[0] - chicken.get(j)[0]) + Math.abs(home.get(i)[1] - chicken.get(j)[1]);
                        temp = Math.min(temp,distance);
                    }
                }
                subResult += temp;
            }
            answer = Math.min(answer, subResult);
        }

        for (int i = idx; i < chicken.size(); i++) {
            if(!open[i]){
                open[i] = true;
                dfs(i+1,cnt+1);
                open[i] = false;
            }
        }
    }
}
