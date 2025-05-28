package exercise_coding.leetcode.leet20250528;

public class Solution {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
        x = -121;
        System.out.println(isPalindrome(x));
        x = 10;
        System.out.println(isPalindrome(x));
        x = 11011;
        System.out.println(isPalindrome(x));
        x = 100111;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if( x < 0) {
            return false;
        }
        String val = String.valueOf(x);
        int len = val.length();

        if(len == 1) {
            return true;
        }

        for (int i = 0; i < len/2 ; i++) {
            System.out.println(val.charAt(i));
            System.out.println(val.charAt(len-1-i));
            if(val.charAt(i) != val.charAt(len-1-i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(int x) {
        // 음수이거나, 0으로 나눠떨어지지만 0이 아닌 수들은 false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        if(x % 10 == x) {
            return true;
        }

        int originalNumber = x;
        int reversedNumber = 0;

        // x 를 형변환없이 뒤집음
        while (x > 0) {
            int lastDigit = x % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            x /= 10;
        }

        return originalNumber == reversedNumber;
    }
}
