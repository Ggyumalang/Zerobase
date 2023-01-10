package Programmers.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam09_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right) {
                if(arr[left] + arr[right] == arr[i]){
                    if(left == i){
                        left++;
                    }else if(right == i){
                        right--;
                    }else {
                        cnt++;
                        break;
                    }
                }else if(arr[left] + arr[right] < arr[i]){
                    left++;
                }else {
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
