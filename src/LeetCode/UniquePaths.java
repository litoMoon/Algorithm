package LeetCode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        // 创建dp表
        int[][] dp = new int[m + 1][n + 1];

        // 初始化dp表
        dp[0][1] = 1;

        // 填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
