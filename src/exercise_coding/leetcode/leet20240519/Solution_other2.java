package exercise_coding.leetcode.leet20240519;

import java.util.Stack;

public class Solution_other2 {
    public static void main(String[] args) {
        String s = "1 + 1";
        System.out.println(calculate(s));

        s = " 2-1 + 2 ";
        System.out.println(calculate(s));

        s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));

        s = "123456";
        System.out.println(calculate(s));

        s = "- (3 + (4 + 5))";
        System.out.println(calculate(s));

        s = "1-( -2)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        final Stack<Integer> stack = new Stack<>();

        int sign = 1, number = 0, result = 0;

        for(int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);

            if(Character.isDigit(c)) {
                number = 10 * number + c - '0';
            } else if(c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if(c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if(c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if(number != 0)
            result += sign * number;

        return result;
    }
    
}
