//프로그래머스 - KAKAO BLIND - 개인정보 수집 유효기간
package exercise_coding.programmers.pro20240525;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));

        today = "2019.12.28";
        terms = new String[]{"A 25"};
        privacies = new String[]{"2008.11.03 A"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int[] todayInt = new int[3];
        String[] sp = today.split("\\.");
        for (int i = 0; i < 3; i++) {
            todayInt[i] = Integer.parseInt(sp[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            int[] arr = new int[3];
            sp = split[0].split("\\.");
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(sp[j]);
            }

            int[] curr = calc(arr, map.get(split[1]));
            if (validate(todayInt, curr)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean validate(int[] todayInt, int[] destroy) {
        System.out.println(Arrays.toString(todayInt));
        System.out.println(Arrays.toString(destroy));
        //연도가 today가 더 크면 당연히 폐기 해야함 의심의 여지 x
        if (todayInt[0] > destroy[0]) {
            return true;
        } else if (todayInt[0] == destroy[0]) {
            //연도가 같을 때
            if (todayInt[1] > destroy[1]) {
                //today month가 더 크면 폐기
                return true;
            } else if (todayInt[1] == destroy[1]) {
                //month 같을 경우 today 날짜가 폐기 날짜 -1 보다 크면 폐기
                return todayInt[2] > destroy[2] - 1;
            }
        }
        return false;
    }

    private static int[] calc(int[] arr, int month) {
        int num = arr[1] + month;
        if (num > 12) {
            int remain = num % 12;
            if (remain == 0) {
                arr[0] = arr[0] + num / 12 - 1;
                arr[1] = 12;
            } else {
                arr[0] += (num) / 12;
                arr[1] = remain;
            }
        } else {
            arr[1] += month;
        }

        System.out.println(num);

        return arr;
    }
}
