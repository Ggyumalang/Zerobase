//백준 - 컵라면
//그리디 알고리즘 + 우선순위큐
// 1. Array sort(데드라인 오름차순, 데드라인이 같다면 컵라면 갯수 내림차순)
// 2. 우선순위 큐 생성(컵라면 획득 개수를 담음 - 오름차순)
// 3. Array for문 탐색하면서 우선순위큐 원소 개수가 현재 index의 데드라인보다 작으면 바로 집어넣기
// 4. 만약 데드라인과 같은 우선순위큐 원소 개수이면 peek해서 열어본 컵라면 개수와 비교
// 5. 현재 문제의 컵라면 보상이 크면 poll한 후 해당 컵라면 개수를 넣음
// 6. 우선순위큐 원소 전부 꺼내면서 컵라면 갯수 세기

package exercise_coding.backjun.backjun20230522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dead = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dead[i][0] = Integer.parseInt(st.nextToken());
            dead[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dead, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int size = pq.size();

            if(size < dead[i][0]){
                pq.offer(dead[i][1]);
            } else if (!pq.isEmpty() && size == dead[i][1]) {
                int cnt = pq.peek();
                if(cnt < dead[i][1]) {
                    pq.poll();
                    pq.offer(dead[i][1]);
                }
            }
        }
        int answer = 0;
        while (!pq.isEmpty()){
            answer += pq.poll();
        }
        System.out.println(answer);


    }

}
