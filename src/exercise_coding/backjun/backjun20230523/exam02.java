//백준 - 11003 최솟값 찾기
//PriorityQueue는 정렬이 들어가서 실패..
package exercise_coding.backjun.backjun20230523;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{i, num});

            while (!pq.isEmpty() && pq.peek()[0] < i - L + 1) {
                pq.poll();
            }

            bw.write(pq.peek()[1] + " ");
        }
        bw.flush();
        bw.close();
    }

}
