package exercise_coding.backjun.backjun20230408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class exam01 {

    static int N;
    static int answer;
    static List<Integer> bullet;
    static int[][] boardBack;
    final static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        boardBack = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        bullet = new ArrayList<>();
        StringTokenizer st;
        List<int[]> bonusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 10) {
                    bonusList.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.arraycopy(board, 0, boardBack, 0, N);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            bullet.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(bullet);

        //보너스 표적 먼저 제거!
        for (int[] ints : bonusList) {
            bullet.remove(0);
            answer += board[ints[0]][ints[1]];
            board[ints[0]][ints[1]] = 0;
        }

        if (bullet.size() == 0) {
            System.out.println(answer);
            return;
        }

        //그 다음엔 값이 큰 순서부터 내려온다.
        backTracking(board, answer);
        System.out.println("answer = " + answer);

    }

    private static void backTracking(int[][] board, int score) {
        if (bullet.size() == 0) {
            answer = Math.max(answer, score);
            return;
        }
        int bull = bullet.get(bullet.size() - 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = board[i][j];
                if (target <= bull) {
                    changeBoard(board, i, j);
                    board[i][j] = 0;
                    bullet.remove(bullet.size() - 1);
                    backTracking(board, score + target);
                    board[i][j] = target;
                    bullet.add(bull);
                } else {
                    board[i][j] -= bullet.get(bullet.size() - 1);

                    bullet.remove(bullet.size() - 1);
                    backTracking(board, score);
                    board[i][j] = target;
                    bullet.add(bull);
                }
            }
        }
    }

    private static void changeBoard(int[][] board, int x, int y) {
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx >= board.length || ny < 0
                || ny >= board[0].length) {
                continue;
            }

            if (board[nx][ny] == 0) {
                board[nx][ny] = board[x][y] / 4;
            }
        }
    }
}
