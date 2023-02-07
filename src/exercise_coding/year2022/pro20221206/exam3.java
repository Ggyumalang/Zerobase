package exercise_coding.year2022.pro20221206;

import java.util.Arrays;
import java.util.PriorityQueue;

public class exam3 {
    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y - x);
        PriorityQueue<Integer> finalMaxHeap = maxHeap;
        boolean isMinHeap = true;

        for(String operation : operations) {
            String[] ope = operation.split(" ");
            if(ope[0].equals("I")){
                minHeap.offer(Integer.parseInt(ope[1]));
                isMinHeap = true;
            }else if(ope[0].equals("D")){
                int flag = Integer.parseInt(ope[1]);
                if(flag == -1 && !minHeap.isEmpty()) {
                    minHeap.poll();
                    isMinHeap = true;
                } else if (flag == 1 && !minHeap.isEmpty()) {
                    finalMaxHeap.clear();
                    minHeap.stream().forEach(x-> finalMaxHeap.offer(x));
                    finalMaxHeap.poll();
                    minHeap.clear();
                    finalMaxHeap.stream().forEach(x->minHeap.offer(x));
                    isMinHeap = false;
                }
            }else {
                return null;
            }
        }
        if(isMinHeap) {
            maxHeap.clear();
            minHeap.stream().forEach(x-> finalMaxHeap.offer(x));
        }else {
            minHeap.clear();
            maxHeap.stream().forEach(x->minHeap.offer(x));
        }
        return minHeap.isEmpty() ? new int[]{0,0} : new int[]{finalMaxHeap.peek(),minHeap.peek()};
    }
}
