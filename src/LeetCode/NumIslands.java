package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumIslands {
    int[] x = new int[] { -1, 1, 0, 0 };
    int[] y = new int[] { 0, 0, -1, 1 };

    public int numIslands(char[][] grid) {
        int ret = 0, flag = 0;
        int lenOfH = grid.length;
        int lenOfz = grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();//创建一个数组用于存储值
        boolean[][] bool = new boolean[grid.length][grid[0].length];// 创建一个同等规模的 boolean 数组,默认的初始值是 false
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                flag = 0;
                if (grid[i][j] == '1' && !bool[i][j]) {
                    bool[i][j] = true;
                    flag = 1;
                    q.offer(new int[] { i, j });
                }
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int t1 = cur[0];
                    int t2 = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int m = t1 + x[k];
                        int n = t2 + y[k];
                        if (m >= 0 && m < lenOfH && n >= 0 && n < lenOfz && grid[m][n] == '1' && !bool[m][n]) {
                            q.offer(new int[] { m, n });
                            bool[m][n] = true;
                            // flag=1;
                        }
                    }
                }
                if (flag == 1)
                    ret++;
            }

        }

        return ret;

    }
}
