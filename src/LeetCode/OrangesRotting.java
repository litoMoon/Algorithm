package LeetCode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class OrangesRotting {
    public static int[]changeX=new int[]{0,0,1,-1};
    public static int[]changeY=new int[]{1,-1,0,0};
    public static int orangesRotting(int[][] grid) {
        int count=0;
        Queue<int[]> queue=new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            int flag=0;
            while(size-->0){
                int []cur=queue.poll();
                for(int i = 0;i <4 ; i++){
                    int x=changeX[i]+cur[0];
                    int y=changeY[i]+cur[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                        flag=1;
                        grid[x][y]=2;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            if(flag==1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][]arr=new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}
