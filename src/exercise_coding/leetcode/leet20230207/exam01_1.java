package exercise_coding.leetcode.leet20230207;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class exam01_1 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("generateParenthesis(n) = " + generateParenthesis(n));
    }
    static int N;
    static List<String> result;
    public static List<String> generateParenthesis(int n) {
        N = n;
        result = new ArrayList<>();
        backtracking(0,0,"");
        return result;
    }

    public static void backtracking(int open, int close, String s){

        if(s.length() == N*2){
            result.add(s);
            return;
        }

        if(open < N){
            backtracking(open + 1 , close , s + "(");
        }

        if(close < open) {
            backtracking(open , close+1 , s + ")");
        }
    }
}
