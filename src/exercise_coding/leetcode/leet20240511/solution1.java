//leetCode 12.Integer to Roman
package exercise_coding.leetcode.leet20240511;

import java.util.HashMap;
import java.util.Map;

public class solution1 {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));

        num = 58;
        System.out.println(intToRoman(num));

        num = 1994;
        System.out.println(intToRoman(num));

        num = 10;
        System.out.println(intToRoman(num));

        num = 100;
        System.out.println(intToRoman(num));
    }

    static String answer;
    public static String intToRoman(int num) {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "I");
        map1.put(5, "V");
        map1.put(4, "IV");
        map1.put(9, "IX");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(10, "X");
        map2.put(50, "L");
        map2.put(40, "XL");
        map2.put(90, "XC");

        Map<Integer, String> map3 = new HashMap<>();
        map3.put(100, "C");
        map3.put(400, "CD");
        map3.put(500, "D");
        map3.put(900, "CM");

        Map<Integer, String> map4 = new HashMap<>();
        map4.put(1000, "M");

        int ten = 1;
        answer = "";
        while (num >= 1) {
            int val = num % 10 * ten;
            System.out.println(val);
            System.out.println(num);
            System.out.println(ten);
            if(num == 1 && ten > 1) {
                val = num * ten;
            }
            num /= 10;

            if(ten == 1) {
                addAnswer(map1, val, 1,  5);
            } else if(ten == 10) {
                addAnswer(map2, val, 10,  50);
            } else if(ten == 100) {
                addAnswer(map3, val, 100,  500);
            } else if(ten == 1000) {
                if(map4.containsKey(val)) {
                    answer = map4.get(val) + answer;
                } else {
                    for (int i = 1000; i <= val ; i+=1000) {
                        answer = map4.get(1000) + answer;
                    }
                }
            }

            ten = ten * 10;
        }

        return answer;
    }

    private static void addAnswer(Map<Integer, String> map1, int val, int small, int big) {
        if(map1.containsKey(val)) {
            answer = map1.get(val) + answer;
        } else {
            if(val < big) {
                for (int i = small; i <= val; i+= small) {
                    answer = map1.get(small) + answer;
                }
            } else {
                for (int i = small; i <= val % big; i+= small) {
                    answer = map1.get(small) + answer;
                }
                answer = map1.get(big) + answer;
            }
        }
    }
}
