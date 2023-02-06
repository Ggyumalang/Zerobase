//완전탐색 - 최소 직사각형
package coding_test_exercise.programmers.pro20230131;

public class exam01 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];

            if(a > b){
                sizes[i][0] = b;
                sizes[i][1] = a;
            }
        }

        for (int i = 0; i < sizes.length; i++) {
            row = Math.max(row, sizes[i][0]);
            col = Math.max(col, sizes[i][1]);
        }

        return row * col;
    }
}
