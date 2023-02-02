package Programmers.leet20230201;

import java.util.*;

public class exam01 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> result;
    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        final Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<char[]> list = new ArrayList<>();
        //조합해야한다 두 개를
        for (int i = 0; i < digits.length(); i++) {
            list.add(map.get(digits.charAt(i)-'0').toCharArray());
        }

        backTrack(list,0,"");
        return result;
    }

    public static void backTrack(List<char[]> list , int idx , String str){
        if(idx == list.size()){
            System.out.println(str);
            result.add(str);
            return;
        }

        for (int i = 0; i < list.get(idx).length; i++) {
            backTrack(list, idx+1, str+list.get(idx)[i]);
        }
    }
}
