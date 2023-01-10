package Programmers.year2022.sorting;

import java.util.Arrays;

public class exam3_1 {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {0, 1, 1};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length-i; //인용된 논문의 수

            if(citations[i] >= h) {
                return h;
            }
        }
        return answer;
    }
}
