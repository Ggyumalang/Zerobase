package coding_test_exercise.year2022.Backjun20221213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //집의 개수
        int C = Integer.parseInt(st.nextToken()); //공유기의 개수
        int[] homeLoc = new int[N];
        for (int i = 0; i < N; i++) {
            homeLoc[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(homeLoc);
        int answer = Integer.MAX_VALUE;
        int left = 0; //가장 최소로
        int right = homeLoc[homeLoc.length-1]; //가장 최대로

        while (left <= right) {
            int mid = (left+right) / 2; //최소거리로 잡는다
            int cnt = 1;
            int pre = homeLoc[0];

            System.out.println("mid = " + mid);

            for (int i = 1; i < N; i++) {
                if(homeLoc[i] - pre >= mid){
                    System.out.println("공유기 설치합니다 >> " + homeLoc[i]);
                    cnt++;
                    pre = homeLoc[i];
                }
            }

            if(cnt < C){
                right = mid - 1;
            }else {
                left = mid + 1;
                if(cnt == C) {
                    answer = mid;
                    System.out.println(answer);
                }
            }
        }

        System.out.println(right);


    }
}
