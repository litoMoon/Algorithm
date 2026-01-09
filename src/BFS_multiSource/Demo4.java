package BFS_multiSource;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo4 {
    public static void main(String[] args) {
        int[][] g=new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxDistance(g));

    }
    static int[] dx=new int[]{-1,1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
    static int [][]ret;
    public static int maxDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       ret=new int[m][n];
        Queue<int[]> q=new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1) {
                    q.offer(new int[]{i,j});//如果为 1 将其数组下标存入队列中
                    ret[i][j]=-1;
                }
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int sz=q.size();
            count++;
            for (int i = 0; i < sz; i++) {
                int []cur=q.poll();
                for (int j = 0; j < 4; j++) {
                    int x=cur[0]+dx[j];
                    int y=cur[1]+dy[j];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0 && ret[x][y]!=-1){
                        q.offer(new int[]{x,y});
                        ret[x][y]=-1;
                    }
                }
            }
        }
         return count==1?-1:count - 1;
    }
}
