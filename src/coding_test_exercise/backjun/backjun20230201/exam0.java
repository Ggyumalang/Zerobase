//백준 13904번 - 과제
package coding_test_exercise.backjun.backjun20230201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> assigns = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            assigns.add(new int[]{day, score});
            maxDay = Math.max(maxDay , day);
        }

        int result = 0;

        for (int i = maxDay ; i >= 1 ; i--) {
            int[] ints = {0,0};
            for(int[] assign : assigns){
                if(assign[0] >= i && assign[1] > ints[1]){
                    ints = assign;
                }
            }
            result += ints[1];
            assigns.remove(ints);
        }
        System.out.println(result);
    }
}
