//프로그래머스 - 도둑
package exercise_coding.programmers.pro20230428;

import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        int[] money = {1,2,3,1};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int[] fDp = new int[money.length-1];
        fDp[0] = money[0];
        fDp[1] = money[0];

        for (int i = 2; i < money.length-1; i++) {
            fDp[i] = Math.max(fDp[i-1], fDp[i-2]+ money[i]) ;
        }

        System.out.println(Arrays.toString(fDp));

        int[] sDp = new int[money.length];
        sDp[0] = 0;
        sDp[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            sDp[i] = Math.max(sDp[i-1], sDp[i-2] + money[i]);
        }

        System.out.println(Arrays.toString(sDp));

        return Math.max(fDp[money.length-2], sDp[money.length-1]);
    }

}
