//종이 자르기
package exercise_coding.programmers.pro20230220;

import java.math.BigInteger;

public class exam01_1 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }

    public static long solution(int w, int h) {
        long W = (long)w;
        long H = (long)h;
        return W*H - (W+H-gcd(W,H));
    }

    private static long gcd(long w, long h) {
        if (h == 0) {
            return w;
        }
        return gcd(h, w % h);
    }
}
