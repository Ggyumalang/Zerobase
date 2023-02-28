//완호네회사
package exercise_coding.programmers.pro20230228;

import java.util.ArrayList;
import java.util.List;

public class exam02 {

    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};
        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores) {
        int workScore = scores[0][0];
        int companyScore = scores[0][1];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            boolean isOk = true;
            for (int j = 0; j < scores.length; j++) {
                if(i==j){
                    continue;
                }
                if(scores[i][0] < scores[j][0]
                    && scores[i][1] < scores[j][1]){
                    if(i==0){
                        return -1;
                    }else {
                        isOk = false;
                        break;
                    }
                }
            }
            if(isOk){
                list.add(List.of(scores[i][0]+scores[i][1], i));
            }
        }

        list.sort((x, y) -> y.get(0) - x.get(0));
        return list.indexOf(List.of(workScore+companyScore, 0))+1;
    }
}
