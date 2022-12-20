package Programmers.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] consent = new boolean[K+1];
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //consent 꽂힌 수
        int cnt = 0;
        int idx = 0;
        while (cnt < N) {
            if(!consent[arr[idx]]){
                consent[arr[idx]] = true;
                cnt++;
            }
            idx++;
        }
        int result = 0;
        for (int i = 0; i < K; i++) {
            if(!consent[arr[i]]){
                ArrayList<Integer> list = new ArrayList<>(); //뒤에서 사용될 지금 사용 중인 친구들 담을 list
                for (int j = i+1; j < arr.length; j++) {
                    if (!list.contains(arr[j]) && consent[arr[j]]) {
                        list.add(arr[j]);
                    }
                }

                if(list.size() >= N){
                    //나중에 사용될 것들이 많다면..
                    consent[list.get(N-1)] = false; //가장 나중의 것을 먼저 뺀다.
                }else {
                    for (int k = 1; k <= K; k++) { //i이전의 것들에서 뺀다
                        if(consent[k] && !list.contains(k)){
                            consent[k] = false;
                            break;
                        }
                    }
                }
                result++;
                consent[arr[i]] = true;
            }
        }

        System.out.println(result);


    }
}
