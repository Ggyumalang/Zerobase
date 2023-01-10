package Programmers.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam2 {
    public static class People{
        int start;
        int end;

        public People(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //사람의 수
        int N = Integer.parseInt(br.readLine());
        List<People> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int start = first < second ? first : second;
            int end = first > second ? first : second;
            list.add(new People(start,end));
        }

        Collections.sort(list, (x,y) -> x.end - y.end); //끝점을 기준으로 오름차순한다.

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //끝점들을 담아본다?

        int d = Integer.parseInt(br.readLine());//철로의 길이
        int max = Integer.MIN_VALUE;

        for(People people : list) {
            pq.offer(people.start);

            while (!pq.isEmpty() && pq.peek() < people.end - d){
                pq.poll();
            }

            max = Math.max(max,pq.size());
        }

        System.out.println(max);


        //최대한 많이 사람들을 포함하는 철로의 위치를 잡아라!

    }
}
