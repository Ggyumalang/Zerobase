//
package exercise_coding.year2022.pro20221219;

import java.util.Stack;

public class exam01_1 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        System.out.println(solution(number,k));

        number = "1231234";
        k = 3;
        System.out.println(solution(number,k));

        number = "4177252841";
        k = 4;
        System.out.println(solution(number,k));
    }
    public static String solution(String number, int k) {
        char[] result = new char[number.length()-k];
        Stack<Character> stack =new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
            System.out.println("k >>" + k);
            System.out.println(stack);
        }
        System.out.println(stack);
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
