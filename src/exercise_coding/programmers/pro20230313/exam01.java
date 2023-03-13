//무지의 먹방 라이브
//그냥 해봤는데 실패..
package exercise_coding.programmers.pro20230313;

import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        int[] food_times = {5, 1, 4};
        long k = 6;
        System.out.println(solution(food_times,k));
    }
    public static int solution(int[] food_times, long k) {
        if(Arrays.stream(food_times).sum() <= k){
            return -1;
        }
        long totalRate = k / food_times.length;
        long remain = k - totalRate;
        int lastIdx = 0;
        for (int i = 0; i < food_times.length; i++) {
            food_times[i] -= totalRate;
            if(food_times[i] < 0){
                int idx = (i+1) % food_times.length;
                int minus = food_times[i];
                while (minus < 0){
                    food_times[idx]--;
                    idx = (idx+1) % food_times.length;
                    minus++;
                }
            }
        }
        System.out.println(Arrays.toString(food_times));
        for (int j = 0; j < food_times.length; j++) {
            if(food_times[j] <= 0){
                continue;
            }
            remain--;
            if(remain == 0){
                lastIdx = j;
            }
        }
        return (lastIdx+1);
    }
}
