//Letter Combinations of a Phone Number
package exercise_coding.leetcode.leet20230616;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class exam01_other {
    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));

        digits = "23";
        System.out.println(letterCombinations(digits));

        digits = "234";
        System.out.println(letterCombinations(digits));
    }

    //Map 에 각 숫자에 해당하는 문자열들을 담는다.
    final static Map<Integer, List<Character>> map = Map.of(1, new ArrayList<>()
            , 2, List.of('a', 'b', 'c')
            , 3, List.of('d', 'e', 'f')
            , 4, List.of('g', 'h', 'i')
            , 5, List.of('j', 'k', 'l')
            , 6, List.of('m', 'n', 'o')
            , 7, List.of('p', 'q', 'r', 's')
            , 8, List.of('t', 'u', 'v')
            , 9, List.of('w', 'x', 'y', 'z'));

    static List<String> answer;
    public static List<String> letterCombinations(String digits) {
        answer = new ArrayList<>();

        if(digits.length() == 0) return answer;

        solve("" , 0 , digits, digits.length());

        return answer;
    }

    private static void solve(String str, int idx, String digit, int length) {

        //문자의 수와 같아지면 answer에 넣고 return
        if(str.length() == length) {
            answer.add(str);
            return;
        }

        int n = Character.getNumericValue(digit.charAt(idx));

        List<Character> s = map.get(n);

        //각 Character 마다 돌아준다.
        for (Character c : s) {
            solve(str + c, idx + 1, digit, length);
        }

    }
}
