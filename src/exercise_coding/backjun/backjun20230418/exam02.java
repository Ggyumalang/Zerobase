//백준 개똥벌레
package exercise_coding.backjun.backjun20230418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H+2];
        int[] top = new int[H+2];

        for (int i = 0; i < N/2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[H-Integer.parseInt(br.readLine())+1]++;
        }

        for (int i = H; i >= 0; i--) {
            bottom[i] += bottom[i+1];
        }

        for (int i = 1; i <= H; i++) {
            top[i] += top[i-1];
        }
        int minBreak = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            int breakCount = 0;

            breakCount += bottom[i];
            breakCount += top[i];

            if(breakCount == minBreak){
                count++;
            }else if(breakCount < minBreak){
                minBreak = breakCount;
                count = 1;
            }
        }
        System.out.println(minBreak + " " + count);

    }
}
