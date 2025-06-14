package exercise_coding.leetcode.leet20250612;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(convert(s,numRows));

        s = "AB";
        numRows = 1;
        System.out.println(convert(s,numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }
        int row = 0;
        List<List<Character>> strList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strList.add(new ArrayList<>());
        }

        boolean max = false;

        for(char c : s.toCharArray()) {
            strList.get(row).add(c);
            if(max) {
                row--;
                if(row == 0) {
                    max = false;
                }
            } else {
                row++;
                if(row == numRows - 1) {
                    max = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(List<Character> list : strList) {
            for(Character c : list) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
