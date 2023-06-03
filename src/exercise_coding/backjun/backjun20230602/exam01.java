//백준 - 도서관 1461
package exercise_coding.backjun.backjun20230602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] books = new int[N];

        st = new StringTokenizer(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if(books[i] >= 0) {
                plus.add(books[i]);
            }else {
                minus.add(books[i]);
            }
        }

        Collections.sort(plus);
        Collections.sort(minus, Comparator.reverseOrder());

        if(N == 1) {
            System.out.println(books[0]);
            return;
        }

        int answer = 0;
        boolean isBigPlus =
            Math.abs(Collections.max(plus)) >= Math.abs(Collections.min(minus));

        int minusCnt = minus.size();
        int plusCnt = plus.size();

        if(isBigPlus){
            while (minusCnt > 0) {
                answer += minus.get(minusCnt-1) * -2;
                minusCnt -= M;
            }

            while (plusCnt > 0) {
                if(plusCnt == plus.size()) {
                    answer += plus.get(plusCnt-1);
                }else {
                    answer += plus.get(plusCnt-1) * 2;
                }
                plusCnt -= M;
            }

        }else {
            while (plusCnt > 0) {
                answer += plus.get(plusCnt-1) * 2;
                plusCnt -= M;
            }

            while (minusCnt > 0) {
                if(minusCnt == minus.size()) {
                    answer += minus.get(minusCnt-1) * -1;
                }else {
                    answer += minus.get(minusCnt-1) * -2;
                }
                minusCnt -= M;
            }
        }



        System.out.println(answer);

    }

}
