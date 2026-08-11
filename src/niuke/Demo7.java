package niuke;

public class Demo7 {
    static int m, n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] vis = new boolean[210][210];
    public static void main(String[] args) {
        char[][] arr=new char[][]{{'1','0','0','0','0'}};
        System.out.println(solve(arr));
    }
    public static int solve (char[][] grid)
    {
        // dfs
        m = grid.length; n = grid[0].length;
        int ret = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    ret++;
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }
    public static void dfs(char[][] grid, int i, int j)
    {
        vis[i][j] = true;
        for(int k = 0; k < 4; k++)
        {
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' &&
                    !vis[x][y])
            {
                dfs(grid, x, y);
            }
        }
    }
}
