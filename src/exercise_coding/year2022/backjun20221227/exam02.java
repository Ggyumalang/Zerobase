package exercise_coding.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam02 {
    static int[][] color;
    static int white;
    static int blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        color = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        folding(0,0,N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void folding(int x, int y, int size){
        if(isSameColor(x,y,size)){
            if(color[x][y] == 0){
                white++;
            }else {
                blue++;
            }
            return;
        }

        int nextSize = size / 2;

        folding(x,y,nextSize);
        folding(x,y+nextSize,nextSize);
        folding(x+nextSize,y,nextSize);
        folding(x+nextSize,y+nextSize,nextSize);


    }

    public static boolean isSameColor(int x, int y, int size){
        int val = color[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(val != color[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
