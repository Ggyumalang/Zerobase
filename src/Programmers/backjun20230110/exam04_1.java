package Programmers.backjun20230110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam04_1 {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[v+1][v+1];
        for (int i = 1; i < v+1 ; i++) {
            for (int j = 1; j < v+1; j++){
                    dist[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[from][to] = weight; //출발지 => 도착지 weight
        }

        for (int k = 1; k < v+1; k++) {
            //i -> j (k를 거쳐서 가는 경우가 짧을 때 업데이트)
            for (int i = 1; i < v+1; i++) {
                for (int j = 1; j < v+1; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < v+1; i++) {
            if(dist[i][i] != INF){
                result = Math.min(result,dist[i][i]);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

}
