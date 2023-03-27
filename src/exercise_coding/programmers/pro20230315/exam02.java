//프로그래머스 4단 고음
//뭔지 모르겠음..
package exercise_coding.programmers.pro20230315;

public class exam02 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int answer = 0;
        return check(n-2,2);
    }

    //n은 현재값, p가 plus의 개수
    private static int check(int n, int p) {
        if(n == 3 && p == 2) return 1;
        else if (n < 3 || Math.log(n) / Math.log(3) * 2 < p) {
            return 0;
        }else if(n == 3 && p == 3){
            return 0;
        }
        return check(n-1,p+1)+(n%3==0&&p>1?check(n/3,p-2):0);
    }
}
