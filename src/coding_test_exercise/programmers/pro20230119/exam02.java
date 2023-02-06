//프로그래머스 아이템 줍기
package coding_test_exercise.programmers.pro20230119;

public class exam02 {
    static final int SIZE = 101;
    static int[][] dirs = {{-1,0} , {1,0} , {0,-1} , {0,1}};
    static boolean[][] board = new boolean[SIZE][SIZE];
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle,characterX,characterY,itemX,itemY));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //좌표 2배로 늘리기
        int srcRow = characterY * 2;
        int srcCol = characterX * 2;
        int dstRow = itemY * 2;
        int dstCol = itemX * 2;

        markRect(rectangle); //그래프에 사각형 테두리를 표시한다.

        // 마지막 위치에서 시작점으로 돌아온 거리
        int totalDistance = findDistance(srcRow, srcCol , srcRow, srcCol , new boolean[SIZE][SIZE] , 0) + 1;
        int distance = findDistance(srcRow, srcCol , dstRow , dstCol , new boolean[SIZE][SIZE] , 0);
        System.out.println("totalDistance = " + totalDistance);
        System.out.println("distance = " + distance);
        return Math.min(distance, (totalDistance - distance)) / 2;
    }

    private static int findDistance(int row, int col, int dstRow, int dstCol, boolean[][] visited, int cnt) {
        if(cnt > 0 && row == dstRow && col == dstCol){
            return cnt;
        }

        visited[row][col] = true;

        for(int[] dir : dirs){
            int nr = row + dir[1];
            int nc = col + dir[0];

            if(nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE && board[nr][nc] && !visited[nr][nc]){
                return findDistance(nr,nc,dstRow,dstCol,visited,cnt+1);
            }
        }
        return cnt;
    }

    private static void markRect(int[][] rectangle) {
        //테두리를 먼저 그린다.
        for(int[] rect : rectangle){
            int firstRow = 2*rect[1];
            int firstCol = 2*rect[0];
            int secondRow = 2*rect[3];
            int secondCol = 2*rect[2];
            markEdge(firstRow,firstCol,secondRow,secondCol);
        }

        for(int[] rect : rectangle){
            int firstRow = 2*rect[1];
            int firstCol = 2*rect[0];
            int secondRow = 2*rect[3];
            int secondCol = 2*rect[2];
            markSpace(firstRow,firstCol,secondRow,secondCol);
        }
    }

    //그래프에 테두리 표시
    private static void markEdge(int firstRow, int firstCol, int secondRow, int secondCol) {
        for (int row = firstRow; row <= secondRow; row++) {
            board[row][firstCol] = true;
        }

        for (int col = firstCol+1; col <= secondCol; col++) {
            board[secondRow][col] = true;
        }

        for (int row = secondRow-1; row >= firstRow ; row--) {
            board[row][secondCol] = true;
        }

        for (int col = secondCol-1; col > firstCol; col--) {
            board[firstRow][col] = true;
        }
    }

    //테두리를 제외한 사각형 너비 영역을 모두 빈 공간으로 표시한다.
    private static void markSpace(int firstRow, int firstCol, int secondRow, int secondCol) {
        for (int row = firstRow+1; row < secondRow; row++) {
            for (int col = firstCol+1; col < secondCol; col++) {
                board[row][col] = false;
            }
        }
    }
}
