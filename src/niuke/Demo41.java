package niuke;

import java.util.Scanner;

//记忆化搜索
public class Demo41 {
    public static int[][] memo;
    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int n, m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int[][] nums = new int[n][m];
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        int res = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(dfs(nums, i, j), res);
            }
        }
        System.out.println(res);

    }
    public static int dfs(int[][] nums, int i, int j) {
        if (memo[i][j] != -1) return memo[i][j];
        int let = 1;
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (x >= 0 && x < n && y >= 0 && y < m && nums[i][j] > nums[x][y]) {
                let = Math.max(1 + dfs(nums, x, y), let);
            }
        }
        memo[i][j] = let;
        return let;
    }
}
