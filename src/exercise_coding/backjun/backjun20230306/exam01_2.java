package exercise_coding.backjun.backjun20230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class exam01_2 {
    static List<Integer> list;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 100) {
            System.out.println(0);
            return;
        }

        int size = Integer.parseInt(br.readLine());

        if (size == 0) {
            System.out.println((int) Math.ceil(Math.log10(N)));
            return;
        }
        list = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            list.remove(Integer.valueOf(Integer.parseInt(st.nextToken())));
        }
        String num = String.valueOf(N);
        List<Integer> nums = new ArrayList<>();
        int idx = 0;
        while (idx < num.length()) {
            int n = num.charAt(idx) - '0';
            makeNum(N, num.length() - 1, nums);
            idx++;
        }
        for (int i : nums) {
            answer += i;
            answer *= 10;
        }
        System.out.println(Math.abs(N - answer / 10) + nums.size());

    }

    private static void makeNum(int n, int len, List<Integer> nums) {
        int size = nums.size();

        int nowNum = (int) (n / Math.pow(10, len - size));
        System.out.println("nowNum = " + nowNum);

        int newNum = 0;
        for (int i : nums) {
            newNum += i;
            newNum *= 10;
        }
        System.out.println("newNum = " + newNum);
        int minDiff = Integer.MAX_VALUE;
        int num = -1;
        for (int i = 0; i < list.size(); i++) {
            int diff = Math.abs(nowNum - (newNum + list.get(i)));
            if (minDiff > diff) {
                num = list.get(i);
                minDiff = diff;
            }
        }
        System.out.println("num = " + num);
        nums.add(num);
    }
}
