//백준 14889번 스타트와 링크
package Programmers.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam06 {
    static int min = Integer.MAX_VALUE;
    static int[][] ability;
    static boolean[] visited;
    static int totalCnt;
    static int[] out;
    static int[] noVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = N/2;
        out = new int[r];
        noVisit = new int[r];

        //nCr 갯수 찾기
        int pResult = 1;
        //nPr 구현
        for (int i = N; i >= N-r+1 ; i--) {
            pResult *= i;
        }

        int rResult = 1;
        //r! 구현
        for (int i = 1; i <= r ; i++) {
            rResult *= i;
        }

        totalCnt = (pResult / rResult) / 2;

        ability = new int[N+1][N+1];
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(N,r,0);
        System.out.println(min);
    }

    public static void backTracking(int n , int r , int depth ){
        if(r == 0){
            totalCnt--;
            if(totalCnt < 0){
                return;
            }
            int idx = 0;
            int nIdx = 0;
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    out[idx++] = i+1;
                }else {
                    noVisit[nIdx++] = i+1;
                }
            }
            min = Math.min(min,cal());
            return;
        }

        if(depth == n){
            return;
        }

        visited[depth] = true;
        backTracking(n,r-1,depth+1);
        visited[depth] = false;
        backTracking(n,r,depth+1);
    }

    public static int cal(){
        int sum = 0;
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out.length; j++) {
                if(i==j) continue;
                sum += ability[out[i]][out[j]];
                sum -= ability[noVisit[i]][noVisit[j]];
            }
        }
        return Math.abs(sum);
    }
}
