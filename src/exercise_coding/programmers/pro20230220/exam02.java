//문자열 이진변환
package exercise_coding.programmers.pro20230220;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }
    static int[] result;
    public static int[] solution(String s) {
        recursion(s,0,0);
        return result;
    }

    public static void recursion(String s, int zeroCnt , int term){
        if(s.equals("1")){
            result = new int[]{term+1, zeroCnt};
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                zeroCnt++;
            }
        }

        s = s.replace("0","");

        if(s.equals("1")){
            result = new int[]{term+1, zeroCnt};
            return;
        }
        int num = s.length();
        s = "";
        while (num >= 1){
            s = num % 2 + s;
            num /= 2;
        }

        recursion(s,zeroCnt,term+1);
    }
}
