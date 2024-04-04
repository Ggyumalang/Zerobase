//백준 15652 - N과 M (4) 실버 3
package exercise_coding.backjun.back20240404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class solution {

    static int n, m;
    static List<List<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new ArrayList<>();

        backtracking(new ArrayList<>());

        System.out.println(answer);

        for (List<Integer> list : answer) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void backtracking(List<Integer> list) {
        System.out.println(list);

        if (list.size() == m) {
            Collections.sort(list);
            answer.add(new ArrayList<>(list));
            System.out.println(answer);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (list.size() < m) {
                if (list.size() > 0 && list.get(list.size() - 1) > i) {
                    continue;
                }
                list.add(i);
                backtracking(list);
            }
            list.remove(Integer.valueOf(i));
        }

    }

}
