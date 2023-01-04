//Leetcode - Beautiful Arrangement
//외국 사이트에서 본 풀이..
//

package Programmers.leet20230104;

public class exam02_1 {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(countArrangement(n));
    }
    public static int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        return process(1, visited);
    }

    private static int process(int start, boolean[] visited) {
        if (start == visited.length) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i < visited.length; i ++) {
            if (visited[i] == false && (start % i == 0 || i % start == 0)) {
                visited[i] = true;
                count += process(start + 1, visited);
                visited[i] = false;
            }
        }
        System.out.println(count);
        return count;
    }
}
