package Programmers.pro20221130;

public class Exam3 {
    static int cnt;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }

    public static int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, 0 , target , 0);

        return cnt;
    }

    private static void dfs(int[] numbers, int depth, int target , int result) {
        if(depth == numbers.length) {
            System.out.println(result);
            if(target == result) {
                cnt++;
            }
            return;
        }

        int add = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers,depth+1,target,add);
        dfs(numbers,depth+1,target,minus);
    }

}
