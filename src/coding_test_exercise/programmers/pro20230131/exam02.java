package coding_test_exercise.programmers.pro20230131;

import java.util.*;

public class exam02 {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
        int[] answers = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(solution(answers)));
    }
    static int[] one = {1,2,3,4,5};
    static int[] two = {2,1,2,3,2,4,2,5};
    static int[] three = {3,3,1,1,2,2,4,4,5,5};
    public static int[] solution(int[] answers) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            if(one[(i%one.length)] == answers[i]){
                map.put(0, map.getOrDefault(0,0)+1);
            }

            if(two[(i%two.length)] == answers[i]){
                map.put(1, map.getOrDefault(1,0)+1);
            }

            if(three[(i%three.length)] == answers[i]){
                map.put(2, map.getOrDefault(2,0)+1);
            }
        }
        List<Map.Entry<Integer,Integer>> mapSort = new ArrayList<>(map.entrySet());
        Collections.sort(mapSort,(x,y) -> {
            if(x.getValue() == y.getValue()){
                return x.getKey() - y.getKey();
            }
            return y.getValue() - x.getValue();
        });
        List<Integer> answer = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry : mapSort){
            if(maxVal <= entry.getValue()){
                maxVal = entry.getValue();
                answer.add(entry.getKey()+1);
            }else {
                break;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
