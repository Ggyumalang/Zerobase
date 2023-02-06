package coding_test_exercise.year2022.backjun20221219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lecture = new int[N][2];
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(lecture,(x, y) -> {
            if(x[0]==y[0]){
                return x[1] - y[1];
            }
            return x[0] - y[0];
        }); //시작 시간으로 정렬후 시작시간이 같다면 끝나는 시간 순으로 정렬한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //끝나는 시간을 오름차순으로..
        pq.offer(lecture[0][1]);

        for (int i = 1; i < N; i++) {
            if(pq.peek() <= lecture[i][0]){
                pq.poll();
            }
            pq.offer(lecture[i][1]);
        }
        System.out.println(pq.size());
    }
}
