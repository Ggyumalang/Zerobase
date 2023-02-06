package coding_test_exercise.backjun.backjun20230118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //현재 선물이 가장 많이 담겨있는 상자에서 원하는 만큼 가져가야 하기 때문에..
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //내림차순 정렬
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        Queue<Integer> waitQueue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            waitQueue.offer(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        boolean isOk = true;
        while (cnt < M){
            //선물 상자에 있는 선물의 수가 원하는 선물의 수보다 크거나 같을 때
            if(pq.peek() >= waitQueue.peek()){
                int remain = pq.poll() - waitQueue.poll();
                if(remain != 0){
                    pq.offer(remain);
                }
            }else {
                isOk = false;
                //더 작다면?
                break;
            }
            cnt++;
        }

        System.out.println(isOk ? 1 : 0);
    }
}
