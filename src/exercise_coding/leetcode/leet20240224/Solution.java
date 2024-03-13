package exercise_coding.leetcode.leet20240224;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));

        citations = new int[] {3,1,1};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        if(citations.length == 1) {
            if(citations[0] == 0) {
                return 0;
            }
            return 1;
        }

        citations = Arrays.stream(citations).sorted().toArray();
        int len = citations.length % 2 == 0 ? citations.length / 2 -1 : citations.length / 2;
        int mid = citations[len];

        int upCnt = (int) Arrays.stream(citations)
                .filter(x -> mid <= x)
                .count();

        int downCnt = (int) Arrays.stream(citations)
                .filter(x -> mid == x)
                .count();
        return citations[len];
    }
}
