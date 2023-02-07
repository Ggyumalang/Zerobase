//백준 1253번 좋다

package exercise_coding.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int cnt = 0;
        Arrays.sort(arr);
        long max = Arrays.stream(arr).max().getAsLong();
        HashSet<Long> set = new HashSet<>();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i ; j++) {
                long sum = arr[i] + arr[j];
                if( sum > max) {
                    break;
                }
                set.add(sum);
            }
        }

        System.out.println(set);

        for (int i = 0; i < N; i++) {
            if(set.contains(arr[i]))cnt++;
        }
        System.out.println(cnt);

    }

//    public static boolean binarySearch(int[] arr, int target , int left , int right){
//        while (left <= right){
//            if(arr[left] + arr[right] < target){
//                right++;
//            }
//        }
//    }
}
