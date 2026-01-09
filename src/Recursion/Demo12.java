package Recursion;

public class Demo12 {
   /* int max=0;//记录最大值
    int m,n;
    int []dx=new int[]{1,-1,0,0};
    int []dy=new int[]{0,0,-1,1};
    boolean [][]vis;
    int tmp;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    tmp=0;
                    tmp+=grid[i][j];
                    vis[i][j]=true;
                    dfs(grid,i,j);
                    vis[i][j]=false;

                    //对于结果的判断，需要考虑多一点
                    if(tmp>max){
                        max=tmp;
                    }
                }
            }

        }
        return max;
    }
    public void dfs(int[][] grid,int _x,int _y){

        //上下左右进行遍历
        for(int i=0;i<4;i++){
            int x=_x+dx[i],y=_y+dy[i];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=0 && !vis[x][y]){
                tmp+=grid[x][y];
                vis[x][y]=true;
                dfs(grid,x,y);
                vis[x][y]=false;
                if(tmp>max){
                    max=tmp;
                }
                tmp-=grid[x][y];
            }
        }
        return ;
    }*/
//继上面版本优化后的版本
    int max=0;//记录最大值
    int m,n;
    int []dx=new int[]{1,-1,0,0};
    int []dy=new int[]{0,0,-1,1};
    boolean [][]vis;
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    vis[i][j]=true;
                    dfs(grid,i,j,grid[i][j]);
                    vis[i][j]=false;
                }
            }

        }
        return max;
    }
    public void dfs(int[][] grid,int _x,int _y,int path){
        max=Math.max(max,path);
        //上下左右进行遍历
        for(int i=0;i<4;i++){
            int x=_x+dx[i],y=_y+dy[i];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=0 && !vis[x][y]){
                vis[x][y]=true;
                dfs(grid,x,y,path+grid[x][y]);
                //恢复现场
                vis[x][y]=false;
            }
        }
    }
}
