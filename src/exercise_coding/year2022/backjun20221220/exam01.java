//백준 1946번 신입사원
package exercise_coding.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score,(x,y)->x[0]-y[0]); //첫번째 인덱스를 가지고 오름차순한 다음
            Stack<Integer> stack = new Stack<>();
            stack.push(score[0][1]);
            for (int j = 1; j < N; j++) {
                //첫번째 친구는 무조건 통과다. 1등이기 때문에.
                if(score[j][1] < stack.peek()){
                    stack.push(score[j][1]);
                }
            }
            System.out.println(stack.size());
        }
    }
}
