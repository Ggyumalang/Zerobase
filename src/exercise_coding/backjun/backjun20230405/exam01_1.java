//백준 - 개똥벌레
//누적합과 이분탐색 이용하기
package exercise_coding.backjun.backjun20230405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class exam01_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int minBreak = N;
        int minSectionCount = 0;

        //종유석
        int[] stalactite = new int[H+1];

        //석순
        int[] stalagmite = new int[H+1];

        for (int i = 0; i < N/2; i++) {
            stalagmite[Integer.parseInt(br.readLine())]++;
            stalactite[Integer.parseInt(br.readLine())]++;
        }

        System.out.println(Arrays.toString(stalagmite));
        System.out.println(Arrays.toString(stalactite));

        //각 인덱스(높이)까지의 종유석 수들을 저장한다.
        int[] stalactite_sum = new int[H+1];

        //각 인덱스까지의 석순 수들을 저장한다.
        int[] stalagmite_sum = new int[H+1];

        for (int i = 1; i < H+1; i++) {
            stalactite_sum[i] = stalactite_sum[i-1] + stalactite[i];
            stalagmite_sum[i] = stalagmite_sum[i-1] + stalagmite[i];
        }

        System.out.println(Arrays.toString(stalactite_sum));
        System.out.println(Arrays.toString(stalagmite_sum));

        for (int i = 1; i < H+1; i++) {
            int broken = 0;

            broken += stalactite_sum[H] - stalactite_sum[H-i];
            broken += stalagmite_sum[H] - stalagmite_sum[i-1];

            if(minBreak > broken){
                minBreak = broken;
                minSectionCount = 1;
            } else if (minBreak == broken) {
                minSectionCount++;
            }
        }

        System.out.println(minBreak + " " + minSectionCount);

    }
}
