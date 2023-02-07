//프로그래머스 도둑질
package exercise_coding.programmers.pro20230103;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        int[] money = {1,2,3,1};
//        int[] money = {1,2,3,4,5};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        if(money.length == 3){
            return Arrays.stream(money).max().getAsInt();
        }

        int[] dpForGetFirst = new int[money.length];
        int[] dpForIgnoreFirst = new int[money.length];

        //첫집을 무조건 털고 마지막 집은 무조건 털지 않는 경우
        dpForGetFirst[0] = money[0];
        dpForGetFirst[1] = money[0];

        //첫집을 무조건 털지 않는 경우
        dpForIgnoreFirst[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dpForIgnoreFirst[i] = Math.max(dpForIgnoreFirst[i-1] , dpForIgnoreFirst[i-2] + money[i]);
            dpForGetFirst[i] = Math.max(dpForGetFirst[i-1], dpForGetFirst[i-2] + money[i]);
        }
        return Math.max(dpForIgnoreFirst[money.length-1],dpForGetFirst[money.length-2]);
    }
}
