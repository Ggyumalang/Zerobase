//Leetcode - 224. Basic Calculator
package exercise_coding.leetcode.leet20240519;

import java.util.Stack;

public class Solution_other {
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

        s = "(7)-(0)+(4)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            stack.push(c);
        }

        System.out.println(stack);
        return recursion(stack, false, new Stack<>());
    }
    
    public static int recursion(Stack<Character> stack, boolean isMinus, Stack<Integer> newStack) {
        int answer = 0;
        String strNum = "";

        while (!stack.isEmpty()) {
            char c = stack.pop();

            if(Character.isDigit(c)) {
                strNum = strNum + c;
                while (Character.isDigit(c) && !stack.isEmpty()) {
                    if(!Character.isDigit(stack.peek())) {
                        break;
                    }
                    c = stack.pop();
                    strNum = strNum + c;
                }
            }

            if(!strNum.isEmpty()) {
                if(isMinus) {
                    newStack.push(Integer.parseInt(strNum) * -1);
                } else {
                    newStack.push(Integer.parseInt(strNum));
                }
                isMinus = false;
                strNum = "";
            } else if(c == '(') {
                int recursion = recursion(stack, false, new Stack<Integer>());
                newStack.push(isMinus ? recursion * -1 : recursion );
                isMinus = false;
            } else if( c == '-') {
                isMinus = !isMinus;
            } else if( c== ')') {
                int val = 0;
                while (!newStack.isEmpty()) {
                    val += newStack.pop();
                }
                return val;
            }
        }
        while (!newStack.isEmpty()) {
            answer += newStack.pop();
        }
        return answer;
    }
}
