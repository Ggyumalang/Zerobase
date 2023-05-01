//프로그래머스 - 단어 퍼즐 문제
//백트래킹 형태로 풀었는데 실패..
package exercise_coding.programmers.pro20230501;

public class exam01 {

    public static void main(String[] args) {
        String[] strs = {"ab", "na", "n", "a", "bn"};
        String t = "nabnabn";
        System.out.println(solution(strs, t));

        strs = new String[]{"ba", "na", "n", "a"};
        t = "banana";
        System.out.println(solution(strs, t));
    }
    static int answer;
    static String[] sArr;
    public static int solution(String[] strs, String t) {
        sArr = strs.clone();
        answer = Integer.MAX_VALUE;
        recursion(t , 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void recursion(String t , int count) {

        if(count >= answer){
            return;
        }

        if(t.equals("")){
            answer = Math.min(answer, count);
            return;
        }
        for (String str : sArr) {
            if (t.startsWith(str)) {
                String temp = t;
                t = t.substring(str.length());
                recursion(t , count+1);
                t = temp;
            }
        }
    }


}
