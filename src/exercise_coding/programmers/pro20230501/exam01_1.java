//프로그래머스 - 단어 퍼즐 문제
//Dp 로 풀어야한다.
//참고 : https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.4-%EB%8B%A8%EC%96%B4-%ED%8D%BC%EC%A6%90

package exercise_coding.programmers.pro20230501;

import java.util.Arrays;

public class exam01_1 {

    public static void main(String[] args) {
        String[] strs = {"ab", "na", "n", "a", "bn", "nab"};
        String t = "nabnabn";
        System.out.println(solution(strs, t));

        strs = new String[]{"ba", "na", "n", "a"};
        t = "banana";
        System.out.println(solution(strs, t));
    }
    public static int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n];
        Arrays.fill(dp, (int)1e9);

        for (int i = 0; i < n; i++) {
            String tStr = t.substring(0,i+1);

            for(String str : strs) {
                if(tStr.endsWith(str)){
                    int diff = tStr.length() - str.length();

                    //둘의 차가 0 이라는 것은 서로 같음을 의미
                    //즉 해당 조각을 1번 사용하는 것으로 지금 문자열 완성이 가능하다.
                    if(diff == 0) {
                        dp[i] = 1;
                    }else {
                        //그렇지 않은 경우 점화식 적용
                        dp[i] = Math.min(dp[i], dp[diff - 1] + 1);
                    }
                }
                System.out.println(Arrays.toString(dp));
            }
        }


        return dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1];
    }

}
