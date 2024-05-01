//백준 5557번 1학년 - 골드5
// 방식 1 - 실패..
package exercise_coding.backjun.back20240412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int limitNum = 20;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        map.put(0, new HashMap<>(Map.of(arr[0], 1)));

        for (int i = 1; i < n - 1; i++) {
            List<Integer> plusList = new ArrayList<>();
            List<Integer> minusList = new ArrayList<>();
            map.put(i, new HashMap<>());

            for (int num : map.get(i - 1).keySet()) {
                int plusVal = num + arr[i];
                if (plusVal >= 0 && plusVal <= 20) {
                    map.get(i).put(plusVal, map.get(i).getOrDefault(plusVal, 0) + 1);
                }

                int minusVal = num - arr[i];
                if (minusVal >= 0 && minusVal <= 20) {
                    map.get(i).put(minusVal, map.get(i).getOrDefault(minusVal, 0) + 1);
                }
            }
            System.out.println(map);
        }
    }
}
