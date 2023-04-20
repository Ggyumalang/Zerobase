package for_easy_use;

public class direction {
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] board;
    public static void dfs(int x, int y, int idx){
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length ){
                continue;
            }

            if(board[nx][ny] == 1){
                board[nx][ny] = idx;
                dfs(nx,ny,idx);
            }
        }

    }
}
