//백준 2564 경비원 문제
package Programmers.pro20221207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1 {
    public static class Position{
        int direction;
        int distance;

        public Position(int direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int store = Integer.parseInt(br.readLine());

        Position[] posArr = new Position[store+1];

        for (int i = 0; i < posArr.length; i++) {
            st = new StringTokenizer(br.readLine());
            posArr[i] = new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        //동근의 위치
        int posDirection = posArr[posArr.length-1].direction;
        int posDistance = posArr[posArr.length-1].distance;

        int cnt = 0;

        for (int i = 0; i < store; i++) {
            if(posDirection == posArr[i].direction) {
                cnt += Math.abs(posDistance - posArr[i].distance);
            }else {
                if(posDirection == 1){
                    switch (posArr[i].direction) {
                        case 2:
                            if(posDistance <= row/2 && posArr[i].distance <= row/2) {
                                cnt += posDistance + posArr[i].distance + col;
                            } else if (posDistance > row/2 && posDistance > row/2) {
                                cnt += row - posDistance + row - posArr[i].distance + col;
                            } else {
                                if(posDistance + posArr[i].distance > row - posDistance + row - posArr[i].distance){
                                    cnt += row - posDistance + row - posArr[i].distance + col;
                                }else {
                                    cnt += posDistance + posArr[i].distance + col;
                                }
                            }
                            break;
                        case 3:
                            cnt += posDistance + posArr[i].distance;
                            break;
                        case 4:
                            cnt += row-posDistance + posArr[i].distance;
                            break;
                    }
                }else if(posDirection == 2){
                    switch (posArr[i].direction) {
                        case 1:
                            if(posDistance <= row/2 && posArr[i].distance <= row/2) {
                                cnt += posDistance + posArr[i].distance + col;
                            } else if (posDistance > row/2 && posDistance > row/2) {
                                cnt += row - posDistance + row - posArr[i].distance + col;
                            } else {
                                if(posDistance + posArr[i].distance > row - posDistance + row - posArr[i].distance){
                                    cnt += row - posDistance + row - posArr[i].distance + col;
                                }else {
                                    cnt += posDistance + posArr[i].distance + col;
                                }
                            }
                            break;
                        case 3:
                            cnt += posDistance + col-posArr[i].distance;
                            break;
                        case 4:
                            cnt += row-posDistance + col-posArr[i].distance;
                            break;
                    }
                }else if(posDirection == 3){
                    switch (posArr[i].direction) {
                        case 1:
                            cnt += posDistance + posArr[i].distance;
                            break;
                        case 2:
                            cnt += col - posDistance + posArr[i].distance;
                            break;
                        case 4:
                            if(posDistance <= col/2 && posArr[i].distance <= col/2) {
                                cnt += posDistance + posArr[i].distance + row;
                            } else if (posDistance > col/2 && posDistance > col/2) {
                                cnt += col - posDistance + col - posArr[i].distance + row;
                            } else {
                                if(posDistance + posArr[i].distance > col - posDistance + col - posArr[i].distance){
                                    cnt += col - posDistance + col - posArr[i].distance + row;
                                }else {
                                    cnt += posDistance + posArr[i].distance + row;
                                }
                            }
                            break;
                    }
                }else {
                    switch (posArr[i].direction) {
                        case 1:
                            cnt += posDistance + row-posArr[i].distance;
                            break;
                        case 2:
                            cnt += col - posDistance + row-posArr[i].distance;
                            break;
                        case 3:
                            if(posDistance <= col/2 && posArr[i].distance <= col/2) {
                                cnt += posDistance + posArr[i].distance + row;
                            } else if (posDistance > col/2 && posDistance > col/2) {
                                cnt += col - posDistance + col - posArr[i].distance + row;
                            } else {
                                if(posDistance + posArr[i].distance > col - posDistance + col - posArr[i].distance){
                                    cnt += col - posDistance + col - posArr[i].distance + row;
                                }else {
                                    cnt += posDistance + posArr[i].distance + row;
                                }
                            }
                            break;
                    }
                }
            }
        }

        System.out.println(cnt);

        
    }
}
