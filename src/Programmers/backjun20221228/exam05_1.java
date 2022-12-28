package Programmers.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class exam05_1 {
    public static final Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public static char[] pwd;
    public static char[] out;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        pwd = new char[C];
        visited = new boolean[C];
        out = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            pwd[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(pwd);

        System.out.println(Arrays.toString(pwd));
        dfs(L,0,0);
    }

    public static void dfs(int L, int depth, int cnt){
        if(cnt == L){
            Arrays.sort(out);
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = depth; i < pwd.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                out[depth] = pwd[i];
                dfs(L,depth+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
