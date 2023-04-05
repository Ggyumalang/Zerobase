//백준 - 개똥벌레
package exercise_coding.backjun.backjun20230405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] heights = new int[N][2];

        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(br.readLine());
            if(i%2 == 0){
                heights[i] = new int[]{0, size};
            }else {
                heights[i] = new int[]{H-size, H};
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            int passCnt = 0;
            double section = (double) (i+i+1) / 2;
            for (int j = 0; j < N; j++) {
                if(heights[j][0] < section && heights[j][1] > section ){
                    passCnt++;
                }
            }
            list.add(passCnt);
        }

        int min = Collections.min(list);

        System.out.print(min + " ");
        System.out.println(list.stream().filter(x -> x == min).count());
    }
}
