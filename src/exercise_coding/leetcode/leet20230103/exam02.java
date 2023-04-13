package exercise_coding.leetcode.leet20230103;

import java.util.ArrayList;

public class exam02 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0 || s.equals("")){
            return true;
        }
        ArrayList<Character> dp = new ArrayList<>();
        for(char c : s.toCharArray()){
            dp.add(c);
        }
        char target = dp.get(0);
        for (char c : t.toCharArray()){
            if(c == target){
                System.out.println(dp);
                dp.remove(0);
                if(dp.isEmpty()){
                    return true;
                }
                target = dp.get(0);
            }
        }
        return false;
    }

}
