//dfs
package exercise_coding.programmers.pro20231031;

public class exam01 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int answer = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int idx, int sum) {
        if (sum == target && idx == numbers.length) {
            answer++;
            return;
        }

        if (idx >= numbers.length) {
            return;
        }

        dfs(numbers, target, idx + 1, sum + numbers[idx]);
        dfs(numbers, target, idx + 1, sum - numbers[idx]);

    }
}
