package exercise_coding.leetcode.leet20230314;

public class exam01 {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));

        x = 120;
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        long max = (long)Integer.MAX_VALUE;
        long min = (long)Integer.MIN_VALUE;
        String s = String.valueOf(x);
        long answer = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '-'){
                answer *= -1;
                break;
            }
            answer += Character.getNumericValue(s.charAt(i));
            if(i!=0 ){
                if(i==1 && s.charAt(0) == '-'){
                    continue;
                }
                answer *= 10;
            }
        }
        if(answer > max){
            return 0;
        } else if (answer < min) {
            return 0;
        }
        return (int)answer;
    }
}
