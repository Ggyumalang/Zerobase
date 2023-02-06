package coding_test_exercise.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam01 {
    static int zeroCnt;
    static int plusCnt;
    static int minusCnt;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        zeroCnt = 0;
        plusCnt = 0;
        minusCnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        thirdPaper(0,0,N);
        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(plusCnt);
    }

    public static void thirdPaper(int x, int y, int size){
        if(isSame(x,y,size)){
            switch (arr[x][y]){
                case 0:
                    zeroCnt++;
                    break;
                case 1:
                    plusCnt++;
                    break;
                case -1:
                    minusCnt++;
                    break;
            }
            return;
        }

        int newSize = size / 3;
        thirdPaper(x,y,newSize); //첫번째줄 왼쪽
        thirdPaper(x,y+newSize,newSize); //첫번째줄 중간
        thirdPaper(x,y+(newSize*2),newSize); //첫번째줄 마지막
        thirdPaper(x+newSize,y,newSize); //두번째줄 왼쪽
        thirdPaper(x+newSize,y+newSize,newSize); //두번째줄 중간
        thirdPaper(x+newSize,y+(newSize*2),newSize); //두번째줄 마지막
        thirdPaper(x+(newSize*2),y,newSize); //세번째줄 왼쪽
        thirdPaper(x+(newSize*2),y+newSize,newSize); //세번째줄 중간
        thirdPaper(x+(newSize*2),y+(newSize*2),newSize); //세번째줄 마지막
    }

    public static boolean isSame(int x, int y, int size){
        int val = arr[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(arr[i][j] != val){
                    return false;
                }
            }
        }
        return true;
    }
}
