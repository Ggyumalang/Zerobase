//프로그래머스 - 택배 배달과 수거하기
package exercise_coding.programmers.pro20230519;

public class exam01 {

    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};
        System.out.println("solution(cap,n,deliveries,pickups) = " + solution(cap,n,deliveries,pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int give = 0;
        int get = 0;

        for (int i = n-1; i >= 0 ; i--) {
            if(deliveries[i] != 0 || pickups[i] != 0){
                int cnt = 0;
                while (give < deliveries[i] || get < pickups[i]){
                    cnt++;
                    give += cap;
                    get += cap;
                }
                give -= deliveries[i];
                get -= pickups[i];
                answer += (long)(i + 1) * cnt * 2;
            }
        }
        return answer;
    }
}
