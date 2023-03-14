package exercise_coding.backjun.backjun20230314;

import java.util.HashSet;
import java.util.Set;

public class exam01 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 10000 ; i++) {
            //각 자릿수
            int newNum = calcNum(i);
            set.add(newNum);

            if(set.contains(i)){
                continue;
            }
            System.out.println(i);
        }
    }

    private static int calcNum(int num) {
        int newNum = num;
        String number = String.valueOf(num);
        for (int i = 0; i < number.length(); i++) {
            newNum += Character.getNumericValue(number.charAt(i));
        }
        return newNum;
    }
}
