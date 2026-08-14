package niuke;

import java.util.*;

public class Demo39 {
    public static int[] dx = new int[] {1, -1, 0, 0};
    public static int[] dy = new int[] {0, 0, -1, 1};
    public static int solve (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxCount = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Queue<int[]> queue = new ArrayDeque<>();
                boolean[][] bool = new boolean[row][col];
                queue.add(new int[] {i, j});
                bool[i][j] = true;
                int count = 0;
                while (!queue.isEmpty()) {
                    int[] cur  = queue.poll();
                    count++;
                    int minNum = 10001, indexX = -1, indexY = -1;
                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k];
                        int y = cur[1] + dy[k];
                        if (x >= 0 && x < row && y >= 0 && y < col && !bool[x][y]) {
                            if (minNum > matrix[x][y] && matrix[x][y] > matrix[cur[0]][cur[1]]) {
                                minNum = matrix[x][y];
                                indexX = x;
                                indexY = y;
                            }
                        }
                    }
                    if (indexX != -1) {
                        bool[indexX][indexY] = true;
                        queue.add(new int[] {indexX, indexY});
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

//    [[1,2,3],[4,5,6],[7,8,9]]
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 2, 3},{4, 5, 6},{1,1,1}};
        int[][] arr = new int[][]{{9, 2, 5},{7, 1, 3},{6, 5, 4}};
//        int[][] arr = new int[][]{{1,2},{1,3}};
        System.out.println(solve(arr));
    }
}
