package BFS_multiSource;

import java.util.ArrayDeque;
import java.util.Queue;

//地图中的最高点
public class Demo3 {
    public static void main(String[] args) {
        int [][]arr=new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        int[][] h=highestPeak(arr);
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < h[0].length; j++) {
                System.out.print(h[i][j]+" ");
            }
            System.out.println();
        }

    }
    static int[] dx=new int[]{-1,1,0,0};
    static int[] dy=new int[]{0,0,1,-1};
    static   int [][]ret;
    public static int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        ret=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j]=-1;
            }
        }
        Queue<int[]> q=new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[i][j]==1) {
                    q.offer(new int[]{i,j});
                    ret[i][j]=0;
                }
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int sz=q.size();
            count++;
            for (int i = 0; i < sz; i++) {
                int[] cur=q.poll();
                for(int j=0;j<4;j++){
                    int x=cur[0]+dx[j];
                    int y=cur[1]+dy[j];
                    if(x>=0 && x<m && y>=0 && y<n && isWater[x][y]==0 && ret[x][y]==-1){
                        ret[x][y]=count;
                        q.offer(new int[]{x,y});
                    }

                }
            }
        }
       return ret;
    }
}
