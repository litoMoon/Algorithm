package BFS_multiSource;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo2 {
    public static void main(String[] args) {
        int[][] g=new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(g));

    }
    static int[]dx=new int[]{1,-1,0,0};
    static int[]dy=new int[]{0,0,1,-1};
   static int [][] curN;
    public static int numEnclaves(int[][] grid) {
        int ret=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new ArrayDeque<>();
        curN=new int[m][n];//初始化数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curN[i][j]=grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            if(grid[i][0]==1) q.offer(new int[]{i,0});
            if(grid[i][n-1]==1) q.offer(new int[]{i,n-1});
        }
        for (int i = 0; i < n; i++) {
            if(grid[0][i]==1) q.offer(new int[]{0,i});
            if(grid[m-1][i]==1) q.offer(new int[]{m-1,i});
        }
        while(!q.isEmpty()){
            int sz=q.size();
            for (int i = 0; i < sz; i++) {
                int []cur=q.poll();
                curN[cur[0]][cur[1]]=2;
                for (int j = 0; j < 4; j++) {
                    int x=cur[0]+dx[j];
                    int y=cur[1]+dy[j];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1 && curN[x][y]!=2){
                        curN[x][y]=2;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        for (int i = 0; i < curN.length; i++) {
            for (int j = 0; j < curN[0].length; j++) {
                if(curN[i][j]==1) ret++;
            }
        }
        return ret;
    }
}
