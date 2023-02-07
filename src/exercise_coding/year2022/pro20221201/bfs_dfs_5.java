package exercise_coding.year2022.pro20221201;

public class bfs_dfs_5 {
    static final int SIZE = 101;
    static boolean[][] board = new boolean[SIZE][SIZE]; // true: 점
    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle,characterX,characterY,itemX,itemY));

    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 2배로 늘리기
        int srcRow = characterY * 2;
        int srcCol = characterX * 2;
        int dstRow = itemY * 2;
        int dstCol = itemX * 2;

        markRect(rectangle); // 그래프에 사각형 테두리만 표시

        // + 1: 마지막 위치에서 시작점으로 돌아온 거리
        int totalDistance = findDistance(srcRow, srcCol, srcRow, srcCol, new boolean[SIZE][SIZE], 0) + 1;
        int distance = findDistance(srcRow, srcCol, dstRow, dstCol, new boolean[SIZE][SIZE], 0);

        return Math.min(distance, totalDistance - distance) / 2;
    }

    public static void markRect(int[][] rectangles) {
        for (int[] rect: rectangles) {
            int firstRow = 2* rect[1];
            int firstCol = 2* rect[0];
            int secondRow = 2* rect[3];
            int secondCol = 2* rect[2];

            markEdge(firstRow, firstCol, secondRow, secondCol);
        }

        for (int[] rect: rectangles) {
            int firstRow = 2* rect[1];
            int firstCol = 2* rect[0];
            int secondRow = 2* rect[3];
            int secondCol = 2* rect[2];

            markSpace(firstRow, firstCol, secondRow, secondCol);
        }
    }

    // 그래프에 테두리 모두 표시
    public static void markEdge(int firstRow, int firstCol, int secondRow, int secondCol) {
        for(int row = firstRow; row <= secondRow; row++) {
            board[row][firstCol] = true;
        }
        for(int col = firstCol + 1; col <= secondCol; col++) {
            board[secondRow][col] = true;
        }
        for(int row = secondRow - 1; row >= firstRow; row--) {
            board[row][secondCol] = true;
        }
        for (int col = secondCol - 1; col > firstCol; col--) {
            board[firstRow][col] = true;
        }
    }

    // 테두리를 제외한 사각형 너비 영역을 모두 빈공간으로 표시한다
    public static void markSpace(int firstRow, int firstCol, int secondRow, int secondCol) {
        for (int row = firstRow + 1; row < secondRow; row++) {
            for (int col = firstCol + 1; col < secondCol; col++) {
                board[row][col] = false;
            }
        }
    }

    public static int findDistance(int row, int col, final int dstRow, final int dstCol, final boolean[][] visited, int count) {
        if (count > 0 && row == dstRow && col == dstCol) {
            return count;
        }

        visited[row][col] = true;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && board[newRow][newCol] && !visited[newRow][newCol]) {
                return findDistance(newRow, newCol, dstRow, dstCol, visited, count+1);
            }
        }

        return count;
    }


}
