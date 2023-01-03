//프로그래머스 사칙연산
//dp[최대or최소][범위의시작][범위의끝] = 범위의 최대 혹은 최소값
//다시 해봐야함..,,
package Programmers.pro20230102;

public class exam03 {

    //dp의 1차원의 0은 최대테이블, 1은 최소 테이블
    static int[][][] dp = new int[2][200][200];
    static char[] oper; //연산자를 기록
    static int[] nums; // 숫자를 기록
    static String arrClone[];
    static int tmp = 987654321;

    public static void init(){
        int n = arrClone.length/2;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[0][i][j] = -1 * tmp;
                dp[1][i][j] = tmp;
            }
        }
            nums = new int[n + 1];
            oper = new char[n];

            //arr의 짝수 idx 는 수자가 기록, 홀수 idx에는 연산자가 기록
            for (int i = 0; i < arrClone.length; i++) {
                if(i%2 == 0) nums[i/2] = Integer.parseInt(arrClone[i]);
                else oper[i/2] = arrClone[i].charAt(0);
            }
    }

    //flag == 0 이면 최대 , 1이면 최소
    public static int solve(int flag ,int start , int end){
        //범위가 숫자 하나로 일치시
        if(start == end) {
            return dp[flag][start][end] = nums[start];
        }
        
        //이미 해결했던 문제라면
        if(flag == 0 && dp[flag][start][end] != -1 * tmp){
            return dp[flag][start][end];
        }
        
        if(flag == 1 && dp[flag][start][end] != tmp){
            return dp[flag][start][end];
        }
        
        //flag에 따라 초기값을 준다.
        int ret = (flag == 0) ? -1 * tmp : tmp;
        
        //방문체크
        dp[flag][start][end] = 0;
        
        if(flag == 0){
            //최댓값을 구해야하는 경우
            for (int mid = start ; mid < end ; mid++){
                if(oper[mid] == '-'){
                    //두 구간 사이의 연산자가 -일때, 최대 - 최소여야함.
                    ret = Math.max(ret,solve(0,start,mid) - solve(1,mid+1,end));
                }else {
                    //두 구간 사이의 연산자가 +일때, 최대 + 최대
                    ret = Math.max(ret, solve(0,start,mid) + solve(0,mid+1,end));
                }
            }
        }else {
            //최소를 구해야하는 경우
            for (int mid = start; mid < end; mid++) {
                if(oper[mid] == '-') // 두 구간 사이의 연산자가 - 일때 최소 - 최대
                    ret = Math.min(ret, solve(1,start,mid) - solve(1,mid+1,end));
                else {
                    //두 구간 사이의 연산자가 +일때 최소 + 최소
                    ret = Math.min(ret,solve(1,start,mid) + solve(1,mid+1,end));
                }
            }
        }
        return dp[flag][start][end] = ret;
    }
    public static void main(String[] args) {
        String arr[] = {"1", "-", "3", "+", "5", "-", "8"};
        System.out.println(solution(arr));
    }

    public static int solution(String arr[]) {
        int answer = -1;
        arrClone = arr.clone();
        init();
        //solve(처음부터 마지막의 최대값) , flag = 0, start = 0, end = 마지막 idx
        return answer = solve(0,0,arr.length/2);
    }
}
