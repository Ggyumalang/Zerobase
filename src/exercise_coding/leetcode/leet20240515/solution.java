//leetCode 125.Valid Palindrome
package exercise_coding.leetcode.leet20240515;

public class solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        System.out.println(sb);
        System.out.println(sb.reverse());
        return sb.toString().contentEquals(sb.reverse());
    }

    public static boolean isPalindrome2(String s) {
        if(s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char curFirst = s.charAt(start);
            char curEnd = s.charAt(end);

            if(!Character.isLetterOrDigit(curFirst)) {
                start++;
            } else if(!Character.isLetterOrDigit(curEnd)) {
                end--;
            } else {
                if(Character.toLowerCase(curFirst) != Character.toLowerCase(curEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
