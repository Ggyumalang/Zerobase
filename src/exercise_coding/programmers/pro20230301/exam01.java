//카카오 보행자 천국
//dfs깡으로 풀었는데 시간초과 뜸
package exercise_coding.programmers.pro20230301;

import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(m,n,cityMap));

        m = 3;
        n = 6;
        cityMap = new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(solution(m,n,cityMap));
    }

    static int MOD = 20170805;
    final static int[][] dirs = {{1,0},{0,1}};
    static int answer,N,M;
    static int[][] citiMapCopy;
    static boolean[][] visited;
    public static int solution(int m, int n, int[][] cityMap) {
        answer = 0;
        N = n;
        M = m;
        citiMapCopy = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < cityMap.length; i++) {
            System.arraycopy(cityMap[i],0,citiMapCopy[i],0,N);
        }
        dfs(0,0, false,false);
        return answer%MOD;
    }

    private static void dfs(int x, int y, boolean fromLeft, boolean fromUp) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        if(x == M-1 && y == N-1){
            answer++;
            System.out.println("answer = " + answer);
            System.out.println(Arrays.deepToString(visited));
            return;
        }

        visited[x][y] = true;
        for(int[] dir : dirs){
            int nX = x + dir[0];
            int nY = y + dir[1];

            if(nX < 0 || nX >= M || nY < 0 || nY >= N ){
                continue;
            }

            if(citiMapCopy[nX][nY] == 1){
                continue;
            }

            if(visited[nX][nY]){
                continue;
            }

            if(fromLeft && (nX != x || nY != y+1)){
                continue;
            }else if(fromUp && (nX != x+1 || nY != y)){
                continue;
            }

            if(citiMapCopy[nX][nY] == 2){
                if(x==nX && y == nY-1){
                    dfs(nX,nY,true,false);
                } else if (x == nX-1 && y == nY) {
                    dfs(nX,nY,false,true);
                }
            } else if (citiMapCopy[nX][nY] == 0) {
                dfs(nX,nY,false,false);
            }
        }
        visited[x][y] = false;
    }
}
