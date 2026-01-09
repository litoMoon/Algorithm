package BFS_shortestPath;

import java.util.*;
public class Demo5 {
    static int[] dx=new int[]{1,-1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
    static boolean[][]  bool=new boolean[2020][2020];//用来标记元素是否已经被使用过;
    static Map<Integer,int[]> map;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        Queue<int[]> queue=new ArrayDeque<>();
        map=new HashMap<>();
        while(m-->0){
            int x1=scan.nextInt();
            int y1=scan.nextInt();
            int x2=scan.nextInt();
            int y2=scan.nextInt();
            int tmp=x1*n+y1;
            map.put(tmp,new int[]{x2-1,y2-1});//可以传送的下标
        }
        queue.add(new int[]{n-1,n-1});//将数组下标扔了进去
        bool[n-1][n-1]=true;
        while(!queue.isEmpty()){
            int len=queue.size();
            while(len>0){
                int []cur=queue.poll();
                len--;


                //判断有没有直达当前这个点的
            }
        }


    }
}
