//백준  1107번 리모컨
package exercise_coding.backjun.backjun20230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class exam01 {
    static List<Integer> banned;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 100){
            System.out.println(0);
            return;
        }

        int size = Integer.parseInt(br.readLine());

        if(size == 0) {
            System.out.println((int)Math.ceil(Math.log10(N)));
            return;
        }
        banned = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            banned.add(Integer.parseInt(st.nextToken()));
        }
        String num = String.valueOf(N);
        List<Integer> nums = new ArrayList<>();
        int idx = 0;
        while (idx < num.length()){
            System.out.println("answer = " + answer);
            System.out.println("idx = " + idx);
            int n = num.charAt(idx) - '0';
            if(!banned.contains(n)){
                nums.add(n);
            }else {
                makeNum(N,num.length()-1, nums);
            }
            idx++;
            System.out.println("nums = " + nums);
        }
        System.out.println(answer);

    }

    private static void makeNum(int n, int len, List<Integer> nums) {
        int size = nums.size();

        int nowNum = (int) (n / Math.pow(10,len-size));
        System.out.println("nowNum = " + nowNum);

        if(nums.size() == 0){
            for (int i = 1; nowNum + i <= 9; i++) {
                if(!banned.contains(nowNum+i)){
                    nums.add(nowNum+i);
                    break;
                }else if(!banned.contains(nowNum-i)){
                    nums.add(nowNum-i);
                    break;
                }
            }
        }else {
            int newNum = nums.stream().reduce(0,(x,y)-> 10 * x + y);
            int minDiff = Integer.MAX_VALUE;
            int num = -1;
            for (int i = 0; i < 9; i++) {
                int diff = Math.abs(nowNum - newNum*10 + i);
                if(minDiff > diff){
                    num = i;
                }
            }
            nums.add(num);
        }
        System.out.println(nums);
    }
}
