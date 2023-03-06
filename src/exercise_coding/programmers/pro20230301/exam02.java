package exercise_coding.programmers.pro20230301;

import java.util.*;

public class exam02 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(operations)));
        operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> pqIncreasing = new PriorityQueue<>();
        PriorityQueue<Integer> pqDecreasing = new PriorityQueue<>(Comparator.reverseOrder());
        for(String operation : operations){
            String[] oper = operation.split(" ");
            if(oper[0].equals("I")){
                pqIncreasing.offer(Integer.parseInt(oper[1]));
                pqDecreasing.offer(Integer.parseInt(oper[1]));
            }else if(oper[0].equals("D")){
                if(oper[1].equals("1")){
                    pqIncreasing.remove(pqDecreasing.poll());
                } else if (oper[1].equals("-1")) {
                    pqDecreasing.remove(pqIncreasing.poll());
                }
            }
        }
        if(pqIncreasing.isEmpty() && pqDecreasing.isEmpty()){
            return new int[]{0,0};
        }
        return new int[]{pqDecreasing.peek(), pqIncreasing.peek()};
    }
}
