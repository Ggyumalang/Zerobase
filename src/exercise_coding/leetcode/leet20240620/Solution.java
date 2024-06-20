//71. Simplify Path
package exercise_coding.leetcode.leet20240620;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));

        path = "/home//foo/";
        System.out.println(simplifyPath(path));

        path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));

        path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));

        path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        StringBuilder answer = new StringBuilder();
        Stack<String> stack = new Stack<>();
        stack.push("/");

        for (String str : path.split("/")) {
            if (str.isEmpty()) {
                continue;
            }

            if (stack.peek().equals("/") && str.equals("/")) {
                continue;
            }

            if (str.equals("..")) {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push("/");
                }
            } else if (str.equals(".")) {
                continue;
            } else {
                stack.push(str);
                stack.push("/");
            }
        }

        if (stack.size() > 1 && stack.peek().equals("/")) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }
}
