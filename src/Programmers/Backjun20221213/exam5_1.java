//가장 긴 증가하는 부분 수열 (LIS)
//해당 문제는 LIS를 이용한다.
package Programmers.Backjun20221213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam5_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] LIS = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }


        LIS[0] = seq[0];
        int lastIdx = 0;

        for (int i = 1; i < N; i++) {
            if(seq[i] > LIS[lastIdx]){
                LIS[++lastIdx] = seq[i];
            }else {
                //seq[i] 가 LIS[lastIdx] 보다 작거나 같다면
                int key = seq[i];

                int left = 0;
                int right = lastIdx+1;

                while (left < right) {
                    int mid = (left+right) / 2;

                    if(key > LIS[mid]){
                        left = mid+1;
                    }else {
                        right = mid;
                    }
                }

                LIS[left] = key;
            }
        }

        System.out.println(lastIdx+1);



    }
}
