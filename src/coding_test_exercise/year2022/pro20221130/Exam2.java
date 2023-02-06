package coding_test_exercise.year2022.pro20221130;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam2 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
//        int[] order = {5, 4, 3, 2, 1};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        Queue<Integer> belt = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < order.length; i++) {
            sub.push(i+1);
            while (!sub.isEmpty()){
                if(sub.peek() == order[cnt]){
                    belt.offer(sub.pop());
                    cnt++;
                }else {
                    break;

                }
            }
        }

        return belt.size();
    }
}
