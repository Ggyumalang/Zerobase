//프로그래머스 사라지는 발판
package exercise_coding.programmers.pro20230306;

public class exam02 {
    public static void main(String[] args) {
        int[][] board =	{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        System.out.println(solution(board,aloc,bloc));

        board = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        aloc = new int[]{1, 0};
        bloc = new int[]{1, 2};
        System.out.println(solution(board,aloc,bloc));

        board = new int[][]{{1, 1, 1, 1, 1}};
        aloc = new int[]{0, 0};
        bloc = new int[]{0, 4};
        System.out.println(solution(board,aloc,bloc));

        board = new int[][]{{1}};
        aloc = new int[]{0, 0};
        bloc = new int[]{0, 0};
        System.out.println(solution(board,aloc,bloc));
    }

    static class Result{
        int cnt;
        boolean win;

        public Result(int cnt, boolean win) {
            this.cnt = cnt;
            this.win = win;
        }
    }
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] boardCopy;
    static int n,m;
    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        boardCopy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0 , boardCopy[i], 0 , m);
        }
        return dfs(aloc[0],aloc[1],bloc[0],bloc[1], 0).cnt;
    }

    private static Result dfs(int x, int y, int x2, int y2, int cnt) {
        boolean win = false;
        int min = n*m;
        int max = cnt;

        if(boardCopy[x][y] == 1){
            for(int[] dir : dirs){
                int xNext = x + dir[0];
                int yNext = y + dir[1];

                if(xNext < 0 || yNext < 0 || xNext >= n || yNext >= m){
                    continue;
                }

                if(boardCopy[xNext][yNext] == 0){
                    continue;
                }

                boardCopy[x][y] = 0;
                Result result = dfs(x2,y2,xNext,yNext,cnt+1);
                win |= !result.win;

                if(win){
                    min = Math.min(min, result.cnt);
                }else {
                    max = Math.max(max,result.cnt);
                }

                boardCopy[x][y] = 1;
            }

        }

        return new Result(win ? min : max, win);
    }
}
