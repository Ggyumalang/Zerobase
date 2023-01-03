//프로그래머스 도둑질
package Programmers.pro20230103;

import java.util.Arrays;

public class exam02_1 {
    public static void main(String[] args) {
        int[] money = {1,2,3,1};
//        int[] money = {1,2,3,4,5};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int len = money.length;
        int[] dpInclude0 = new int[len];
        int[] dpExclude0 = new int[len];
        dpInclude0[0] = dpInclude0[1] = money[0];
        dpExclude0[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpInclude0[i] = Math.max(dpInclude0[i-1], money[i] + dpInclude0[i-2]);
            dpExclude0[i] = Math.max(dpExclude0[i-1], money[i] + dpExclude0[i-2]);
        }

        System.out.println(Arrays.toString(dpInclude0));
        System.out.println(Arrays.toString(dpExclude0));

        return Math.max(dpInclude0[len-2], dpExclude0[len-1]);
    }
}
