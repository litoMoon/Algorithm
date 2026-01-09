package BFS_multiSource;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo1 {
    public static void main(String[] args) {
        int [][]mat=new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int [][]ret=updateMatrix(mat);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }

    }

    //正着写的解法会超时
    public static int[][] updateMatrix1(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        //创建一个数组用于存储返回值
        int [][]ret=new int[m][n];
        //遍历数组
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==0) ret[i][j]=0;
                else ret[i][j]=-1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==1){
                    ret[i][j]=bfs(mat,ret,i,j);
                }
            }
        }
     return ret;
    }
    static int []dx=new int[]{-1,1,0,0};
    static int []dy=new int[]{0,0,-1,1};
    public static int bfs(int [][]mat,int[][]ret,int bx,int by){
        int count=0;
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{bx,by});
        while(!q.isEmpty()){
            int []cur=q.poll();
            int sz=q.size();
            count++;
            while(sz-- >0){
                for (int i = 0; i < 4; i++) {
                    int x=cur[0]+dx[i];
                    int y=cur[1]+dy[i];
                    if(x>=0 && x<mat.length && y>=0 && y<mat[0].length && ret[x][y]!=-1){
                        if(mat[x][y]==0) return count;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
      return -1;
    }

    //第二种解法正难则反
    public static int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        //创建一个数组用于存储返回值
        int [][]ret=new int[m][n];
        Queue<int[]> q=new ArrayDeque<>();

        //遍历数组
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==0){
                    ret[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else ret[i][j]=-1;
            }
        }
        int count=0;
        while(!q.isEmpty()){
            //多源数组跑一遍
            int sz=q.size();
            count++;
            for (int i = 0; i < sz; i++) {
                int []curN=q.poll();
                for (int j = 0; j < 4; j++) {
                    int x=curN[0]+dx[j];
                    int y=curN[1]+dy[j];
                    if(x>=0 && x<m && y>=0 && y<n && mat[x][y]!=0 && ret[x][y]==-1){
                        q.offer(new int[]{x,y});
                        ret[x][y]=count;
                    }
                }
            }
        }


//        while(!q.isEmpty()){
//            int count=0;
//            int []cur=q.poll();
//            Queue<int[]> q1=new ArrayDeque<>();
//            q1.offer(new int[]{cur[0],cur[1]});
//            while(!q1.isEmpty()){
//                int sz=q1.size();
//                count++;
//                for (int i = 0; i < sz; i++) {
//                    int []curN=q1.poll();
//                    for (int j = 0; j < 4; j++) {
//                        int x=curN[0]+dx[j];
//                        int y=curN[1]+dy[j];
//                        if(x>=0 && x<m && y>=0 && y<n && mat[x][y]!=0 && ret[x][y]==-1){
//                            q1.offer(new int[]{x,y});
//                            ret[x][y]=count;
//                        }
//                    }
//                }
//            }
//
//        }
        return ret;
    }
}
