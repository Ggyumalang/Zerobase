//그리디 >> 구명보트
//이분탐색을 통해 푸는 문제였음..

package exercise_coding.year2022.pro20221219;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
//        int[] people = {70, 50, 80, 50};
//        int[] people = {70, 50, 80};
        int[] people = {50, 50, 50, 60, 70,80};
//        int[] people = {70, 50, 80,60,60};
        int limit = 130;
        System.out.println(solution(people,limit));
    }
    public static int solution(int[] people, int limit) {
        //먼저 오름차순을 해서.. 50 50 70 80
        Arrays.sort(people);
        int cnt = 0;
        int left = 0;
        int right = people.length-1;
        while (left < right) {
            int sum = people[left] + people[right];
            if(sum > limit){
                right--;
            }else {
                left++;
                right--;
            }
            cnt++;
        }

        if(left == right) cnt++;

        return cnt;
    }
}
