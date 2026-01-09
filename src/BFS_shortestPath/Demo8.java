package BFS_shortestPath;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo8 {
    static int []dx=new int[]{1,-1,0,0};
    static int []dy=new int[]{0,0,-1,1};
    static int[][]a;//定义数组存储值
    static boolean[][] bool;
    static int n,m;
    static long ans;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        a=new int[n][m];
        bool=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=scan.nextInt();
            }
        }
        bfs();
        System.out.println(ans);
    }
    public static void bfs(){
        PriorityQueue<color> queue=new PriorityQueue<>();//默认是小根堆
        queue.offer(new color(0,0,a[0][0]));
        bool[0][0]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                color c=queue.poll();//弹出数组元素
                ans=Math.max(ans,c.time);
                for (int i = 0; i < 4; i++) {
                    int x=c.x+dx[i];
                    int y=c.y+dy[i];
                    if(x>=0 && x<n && y>=0 && y<m && !bool[x][y]){
                        queue.offer(new color(x,y,c.time+a[x][y]));//更新堆
                        bool[x][y]=true;
                    }
                }
            }
        }
    }
}
class color implements Comparable<color>{
    int x;
    int y;
    int time;
    public color(int x,int y,int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }

    @Override
    public int compareTo(color o) {
        return this.time-o.time;
    }
}
