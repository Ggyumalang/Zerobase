//leetCode - Decode Ways
//재귀로 풀었더니 시간초과..
package exercise_coding.leetcode.leet20230528;

public class exam02 {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));

        s = "111111111111111111111111111111111111111111111";
        System.out.println(numDecodings(s));
    }

    static int answer;
    public static int numDecodings(String s) {
        recursion(s,0);
        return answer;
    }

    private static void recursion(String s, int idx) {

        if(s.equals("") || idx >= s.length()){
            answer++;
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if(idx+i > s.length()){
                return;
            }
            String substr = s.substring(idx, idx+i);
            if(isPromising(substr)){
                recursion(s, idx+i);
            }
        }
    }

    private static boolean isPromising(String substr) {

        if(substr.charAt(0) == '0'){
            return false;
        }

        int num = Integer.parseInt(substr);

        if(num <= 0){
            return false;
        }

        return num <= 26;
    }

}
