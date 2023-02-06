package coding_test_exercise.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam02 {
    static boolean[] visited;
    static int[] arr;
    final static int LOTTO = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            if(str.equals("0")) {
                System.out.println();
                break;
            }
            StringTokenizer st = new StringTokenizer(str);

            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
        }
    }

    public static void dfs(int idx , int cnt){
        if(cnt == LOTTO){
            int rCnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    rCnt++;
                    if(rCnt == LOTTO){
                        System.out.print(arr[i]);
                    }else {
                        System.out.print(arr[i] + " ");
                    }
                }
                if(rCnt == LOTTO){
                    break;
                }
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1,cnt+1);
                visited[i] = false;
            }
        }
    }

}
