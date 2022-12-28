package Programmers.backjun20221227;

import java.io.IOException;
import java.util.Scanner;

public class exam05 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(zVisit((int)Math.pow(2,N),r,c,0));
    }

    public static int zVisit(int size , int r , int c , int cnt){
        if(size == 2) {
            if(r == 0 && c == 0){ //좌측상단
                return cnt;
            }else if(r == 0 && c == 1){ //우측상단
                return cnt + 1; 
            }else if(r == 1 && c == 0) { //좌측하단
                return cnt + 2;
            }else {
                //우측 하단
                return cnt + 3;
            }
        }

        int nextSize = size/2;
        if(r < nextSize && c < nextSize){ //좌측 상단 내에 있음.
            return zVisit(nextSize,r,c,cnt);
        }else if(r < nextSize && c >= nextSize) { //우측 상단 내
            cnt += nextSize * nextSize;
            return zVisit(nextSize,r,c-nextSize,cnt);
        } else if (r >= nextSize && c < nextSize) { //좌측 하단
            cnt += nextSize * nextSize * 2;
            return zVisit(nextSize,r-nextSize,c,cnt);
        } else {
            //우측 하단
            cnt += nextSize * nextSize * 3;
            return zVisit(nextSize,r-nextSize,c-nextSize,cnt);
        }
        //r의 위치를 알면..
    }
}
