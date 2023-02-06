//백준 주차장
package coding_test_exercise.year2022.pro20221130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Exam4 {

    static class ParkingLot{
        int no;
        int weightPrice;

        public ParkingLot(int no, int weightPrice) {
            this.no = no;
            this.weightPrice = weightPrice;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //자동차의 무게를 저장할 것
        int[] carWeight = new int[M+1];
        int income = 0;

        //주차요금을 저장할 Map
        HashMap<Integer,Integer> parkingPrice = new HashMap<>();
        //주차장의 상태를 나타낼 PriorityQueue 1 ~ N 까지 저장
        PriorityQueue<Integer> parkingPlace = new PriorityQueue<>();
        IntStream.rangeClosed(1,N).forEach(x->parkingPlace.offer(x));

        for (int i = 0; i < N; i++) {
            //1~N까지의 주차요금 저장
            parkingPrice.put(i+1,Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= M; i++) {
            //1~M까지의 자동차의 무게 저장
            carWeight[i] = Integer.parseInt(br.readLine());
        }
        //주차장 오간 기록을 저장하는 배열
        int[] records = new int[2*M];

        for (int i = 0; i < 2*M; i++) {
            records[i] = Integer.parseInt(br.readLine());
        }
        //주차장에 들어와있는 차와 주차장, 주차장번호를 기록한 Map
        HashMap<Integer,ParkingLot> enteredMap = new HashMap<>();
        //주차장이 꽉차서 기다리고 있는 차들을 저장한 큐
        Queue<Integer> standBy = new LinkedList<>();

        for (int i = 0; i < records.length; i++) {
            if(records[i] > 0){
                //주차장에 들어왔음을 의미함.

                if(parkingPlace.isEmpty()){
                    //주차장이 꽉 찼는데 차가 계속 들어왔기 때문에 stanBy 큐에 넣어주었다.
                    standBy.offer(records[i]);
                    continue;
                }
                enteredMap.put(records[i],new ParkingLot(parkingPlace.peek(),parkingPrice.get(parkingPlace.poll())));
            }else {
                int num = records[i] * -1;
                //주차장에서 나갔음을 의미함.
                //차량의 무게
                int weight = carWeight[num];
                //공원에서 단위무게 비용
                int parkPrice = enteredMap.get(num).weightPrice;
                //인컴에 차량의 무게 * 공원의 단위무게 비용값을 누적한다.
                income += weight * parkPrice;
                //주차장에서 나갔기 때문에 enteredMap에 들어있는 주차장 번호를 다시 parkingPlace 큐에 넣어준다.
                parkingPlace.offer(enteredMap.get(num).no);

                if(!standBy.isEmpty()) {
                    enteredMap.put(standBy.poll(), new ParkingLot(parkingPlace.peek(), parkingPrice.get(parkingPlace.poll())));
                }
                enteredMap.remove(num);
            }
        }
        System.out.println(income);

    }
}
