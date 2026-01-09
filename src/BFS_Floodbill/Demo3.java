package BFS_Floodbill;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo3 {
    public static void main(String[] args) {
        int [][]grid=new int[][]{{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};//创建初始的岛屿1
        // char[][] grid=new char[][]{{'0'}};
        //char[][] grid=new char[][]{{'0','1','0'},{'1','0','1'},{'0','1','0'}};
        System.out.println(maxAreaOfIsland(grid));


    }
    static int[]x=new int[]{1,-1,0,0};
    static int[]y=new int[]{0,0,-1,1};
    public static int maxAreaOfIsland(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int lenOfH=grid.length;
        int lenOfz=grid[0].length;
        Queue<int[]> q=new ArrayDeque<>();//创建一个数组用于存储值
        boolean[][] bool=new boolean[grid.length][grid[0].length];
        for (int i = 0; i < lenOfH; i++) {
            for (int j = 0; j < lenOfz; j++) {
                int ret=0;
                if(grid[i][j]==1 && !bool[i][j]){
                    bool[i][j]=true;
                    ret++;
                    q.offer(new int[]{i,j});
                }
                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    for (int k = 0; k < 4; k++) {
                        int m=cur[0]+x[k];
                        int n=cur[1]+y[k];
                        if(m>=0 && m<lenOfH && n>=0 && n<lenOfz && grid[m][n]==1 && !bool[m][n]){
                            q.offer(new int[]{m,n});
                            bool[m][n]=true;
                            ret++;
                        }
                    }
                }
                max=Math.max(ret,max);
            }
        }
        return max;

    }
}
