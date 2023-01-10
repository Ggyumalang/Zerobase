package Programmers.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam03 {
    public static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] dist = new int[v+1][v+1];
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if(i!=j){
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(dist[from][to],distance);
        }

        for (int k = 1; k < v+1; k++) {
            for (int i = 1; i < v+1; i++) {
                for (int j = 1; j < v+1; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if(dist[i][j] >= INF) {
                    System.out.print("0"+ " ");
                }else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }


    }
}
