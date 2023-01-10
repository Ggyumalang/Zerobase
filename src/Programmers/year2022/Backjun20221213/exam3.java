package Programmers.year2022.Backjun20221213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam3 {
    public static class Jewelry{
        int w;//무게
        int p;//가격

        public Jewelry(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        int N = Integer.parseInt(st.nextToken()); //보석의 수
        int K = Integer.parseInt(st.nextToken()); //가방의 수
        Jewelry[] jewelries = new Jewelry[N]; //보석의 무게 및 보석의 가격
        int[] bags = new int[K]; //가방의 무게
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jewelries,(x,y) ->{
            if(x.w == y.w){
                return (int)(y.p - x.p);
            }
            return (int)(x.w - y.w); //무게별로 오름차순
        });
        Arrays.sort(bags); //가방의 무게를 오름차순하고
        int idx = 0;
        PriorityQueue<Integer> pqJewelry = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < K; i++) {
            while(idx < N && jewelries[idx].w <= bags[i]){
                //가방의 무게보다 작거나 같은 쥬얼리들을 넣는다.
                pqJewelry.offer(jewelries[idx++].p);
            }

            if(!pqJewelry.isEmpty()){
                answer += pqJewelry.poll();
            }
        }

        System.out.println(answer);
    }
}
