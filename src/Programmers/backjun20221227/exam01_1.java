package Programmers.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam01_1 {
    static int[][] scanner;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        scanner = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                scanner[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(Arrays.deepToString(scanner));
        QuadTree(N, 0, 0);
        System.out.println(sb);
    }

    public static void QuadTree(int size , int x , int y){
        if(isPressed(size,x,y)){
            sb.append(scanner[x][y]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        QuadTree(newSize,x,y); //왼쪽위
        QuadTree(newSize,x,y+newSize); //오른쪽 위
        QuadTree(newSize,x+newSize,y); //왼쪽 아래
        QuadTree(newSize,x+newSize,y+newSize); //오른쪽 아래
        sb.append(")");
    }

    public static boolean isPressed(int size, int x, int y){
        int num = scanner[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(scanner[i][j] != num){
                    return false;
                }
            }
        }
        return true;
    }

}
