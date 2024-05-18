// Leetcode - 71. Simplify Path
package exercise_coding.leetcode.leet20240518;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        String path = "/home";
        System.out.println(simplifyPath(path));

        path = "/home//foo/";
        System.out.println(simplifyPath(path));

        path = "/home/user/Documents/../Pictures";
        System.out.println(simplifyPath(path));

        path = "/../";
        System.out.println(simplifyPath(path));

        path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
        path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        if(path.charAt(0) != '/') {
            return "";
        }

        for(String str : strings) {
            if(!str.isEmpty()){
                stack.push(str);
            }
        }

        System.out.println(stack);
        String answer = "";
        int isOmit = 0;
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if(cur.equals("..")) {
                isOmit++;
                continue;
            } else if(cur.equals(".")) {
                continue;
            } else {
                if(isOmit > 0) {
                    isOmit--;
                    continue;
                }
                answer = "/" + cur + answer;
            }
        }

        return answer.equals("") ? "/" : answer;
    }
}
