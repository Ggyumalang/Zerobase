//Leetcode - 224. Basic Calculator
package exercise_coding.leetcode.leet20240519;

import java.util.Stack;

public class Solution {
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

    public static int idx;
    public static int calculate(String s) {
        idx = 0;
        return recursion(s, false, true, new Stack<>());
    }
    
    public static int recursion(String s, boolean isMinus, boolean isPlus, Stack<Integer> stack) {
        int answer = 0;
        String strNum = "";

        while ( idx < s.length()) {
            char c = s.charAt(idx);
            if(Character.isDigit(c)) {
                if (idx < s.length() - 1 && Character.isDigit(s.charAt(idx+1))) {
                    strNum += c;
                    idx++;
                    continue;
                }

                if(!strNum.isEmpty()) {
                    strNum += c;
                    stack.push(Integer.parseInt(strNum));
                    strNum = "";
                    continue;
                }
                int num = Character.getNumericValue(c);
                if(isMinus) {
                    stack.push(num * -1);
                    isMinus = false;
                } else {
                    if(isPlus) {
                        stack.push(num);
                    }
                }
            } else if(c == '(') {
                idx++;
                stack.push(recursion(s, isMinus, isPlus, new Stack<Integer>()));
            } else if( c == '-') {
                isMinus = true;
            } else if( c== ')') {
                int val = 0;
                while (!stack.isEmpty()) {
                    val += stack.pop();
                }
                return val;
            } else if( c == '+') {
                isPlus = true;
            }
            idx++;
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
