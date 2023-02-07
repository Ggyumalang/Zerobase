package exercise_coding.year2022.backjun20221219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(num == M){
                cnt++;
                continue;
            }
            int idx = i+1;
            while (num < M && idx < arr.length){
                num += arr[idx++];
            }

            if(num == M){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
