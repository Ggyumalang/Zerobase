// 3. Longest Substring Without Repeating Characters
package exercise_coding.leetcode.leet20240723;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

        s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int cnt = 1;
        int answer = 1;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);

            if (list.contains(now)) {
                answer = Math.max(answer, cnt);
                while (!list.isEmpty() && list.contains(now)) {
                    list.remove(0);
                }
                list.add(now);
                cnt = list.size();
            } else {
                cnt++;
                list.add(now);
            }
        }

        return Math.max(answer, cnt);
    }
}
