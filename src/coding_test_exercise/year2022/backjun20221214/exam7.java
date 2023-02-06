package coding_test_exercise.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()); //총 판수
        int Y = Integer.parseInt(st.nextToken()); //총 이긴게임
        int Z =  (int)((long)Y* 100/ X);
        System.out.println(Z);
        if(X==Y){
            System.out.println(-1);
            return;
        }
        int left = 1;
        int right = Y;

        while (left<=right){
            int mid = (left+right) / 2;
            int changed = (int)((long)(Y + mid)*100/ (X+mid));
            System.out.println("changed >> " + changed);
            if( changed > Z){
                System.out.println("rightmid = " + mid);
                right = mid-1;
            }else {
                System.out.println("leftmid = " + mid);
                left = mid+1;
            }
        }

        System.out.println(left);

    }
}
