package exercise_coding.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam01 {
    static int [][] img;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(0,0,N);
        System.out.println(sb);

    }

    public static void QuadTree(int x, int y, int size){
        if(isPossible(x,y,size)){
            sb.append(img[x][y]); //압축이 가능하면 하나의 색상으로 압축
            return;
        }

        int newSize = size/2; //압축 불가 시 사이즈를 절반으로 나눈다.
        sb.append('('); //각 레벨(depth)에서는 여는 괄호로 시작

        QuadTree(x,y,newSize); //왼쪽 위
        QuadTree(x,y+newSize,newSize); //오른쪽 위
        QuadTree(x+newSize,y,newSize); //왼쪽 아래
        QuadTree(x+newSize,y+newSize,newSize); //오른쪽 아래

        sb.append(')'); //해당 레벨이 끝나면 닫는 괄호도 닫아준다.
    }

    //압축이 가능한 지 해당 공간을 체크해주는 함수
    public static boolean isPossible(int x, int y, int size) {
        int value = img[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(value != img[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
