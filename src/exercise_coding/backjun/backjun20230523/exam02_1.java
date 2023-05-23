//백준 - 11003 최솟값 찾기
//Deque는 정렬이 들어가지 않기 때문에 성공
package exercise_coding.backjun.backjun20230523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class exam02_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast()[0] > num) {
                deque.pollLast();
            }

            deque.offer(new int[]{num, i});
            if (Objects.requireNonNull(deque.peek())[1] < i - (L - 1)) {
                deque.poll();
            }
            bw.write(deque.getFirst()[0] + " ");
        }
        bw.flush();
        bw.close();
    }

}
