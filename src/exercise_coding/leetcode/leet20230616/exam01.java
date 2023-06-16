// Letter Combinations of a Phone Number
package exercise_coding.leetcode.leet20230616;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class exam01 {
    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));

        digits = "23";
        System.out.println(letterCombinations(digits));

        digits = "234";
        System.out.println(letterCombinations(digits));
    }

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
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        if(digits.length() == 1) {
            return map.get(Integer.valueOf(digits)).stream().map(String::valueOf).collect(Collectors.toList());
        }

        List<List<Character>> chars = new ArrayList<>();
        answer = new ArrayList<>();

        for(char c : digits.toCharArray()) {
            chars.add(map.get(Character.getNumericValue(c)));
        }

        for (int i = 0; i < chars.get(0).size(); i++) {
            answer.add(String.valueOf(chars.get(0).get(i)));
        }

        for (int i = 1; i < chars.size(); i++) {
            backtracking(chars.get(i));
        }

        return answer;
    }

    private static void backtracking(List<Character> characters) {
        int n = answer.size();
        for (int i = 0; i < n; i++) {
            for (Character character : characters) {
                answer.add(answer.get(i) + character);
            }
        }
        if (n > 0) {
            answer.subList(0, n).clear();
        }
    }
}
