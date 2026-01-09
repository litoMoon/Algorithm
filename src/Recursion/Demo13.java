package Recursion;

public class Demo13 {
    boolean[][] vis;
    int m,n;
    int []dx=new int[]{0,0,1,-1};
    int []dy=new int[]{1,-1,0,0};
    int count,ret;
    public int uniquePathsIII(int[][] grid) {
        int x=0,y=0;
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 || grid[i][j]==2) count++;
                if(grid[i][j]==1){
                    x=i; y=j;
                    vis[i][j]=true;
                }
            }
        }
        dfs(grid,x,y,0);
        return ret;
    }
    public void dfs(int[][] g,int _x,int _y,int step){
        if(g[_x][_y]==2 ) {
            if(step==count){
                ret++;
            }
            return ;
        }
        for(int i=0;i<4;i++){
            int x=_x+dx[i],y=_y+dy[i];
            if(x>=0 && x<m && y>=0 && y<n && g[x][y]!=-1 && !vis[x][y]){
                vis[x][y]=true;
                dfs(g,x,y,step+1);
                vis[x][y]=false;
            }
        }

    }
}
