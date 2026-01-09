package BFS_Floodbill;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo1 {

    public static void main(String[] args) {
        int [][]array=new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int [][] ret=floodFill(array,1,1,2);
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j]+" ");
            }
            System.out.println();
        }

    }
   static int []t1={-1,1,0,0};
   static int []t2={0,0,-1,1};
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;//说明本应该被渲染的颜色与原颜色一样
        Queue<int []> queue=new ArrayDeque<>();
        queue.add(new int[]{sr,sc});//将坐标放入
        int lenOfH=image.length;//求出横行
        int lenOfZ=image[0].length;//求出列行
        int result=image[sr][sc];

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int m=cur[0],n=cur[1];
            image[m][n]=color;//开始修改颜色

            for (int i = 0; i < 4; i++) {

                if(m+t1[i]>=0 && m+t1[i]<lenOfH && n+t2[i]>=0 && n+t2[i]<lenOfZ && image[m+t1[i]][n+t2[i]]==result){
                    queue.offer(new int[]{m+t1[i],n+t2[i]});
                }
            }
        }
        return image;

    }

}
