package Luogu;

import java.util.*;
import java.io.*;

public class Demo10 {
    //爆破题---并查集 + kruskal 算法 + 内部类
    static Read7 scan=new Read7();
    static int []x;
    static int []y;
    static int []r;
    static double [][]graph;
    static double []distance;
    static boolean[] visited;
    static double INF=Double.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        int n=scan.nextInt();
        x=new int[n+1];
        y=new int[n+1];
        r=new int[n+1];
        graph=new double[5020][5020];
        visited=new boolean[5020];//用来记录当前数字是否被访问过
        distance=new double[n+1];//每到一个节点就更新当前节点到邻接点的距离
        visited[1]=true;
        //用来统计最终的结果
        double total_sum=0;
        for(int i=1;i<=n;i++){
            x[i]=scan.nextInt();
            y[i]=scan.nextInt();
            r[i]=scan.nextInt();
        }
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int dx=x[i]-x[j];
                int dy=y[i]-y[j];
                int r1=r[i];
                int r2=r[j];
                double distance=Math.sqrt(dx*dx+dy*dy);//表示两点之间的距离
                double sum=r1+r2;//表示两点的半径
                if(distance<=sum){
                   graph[i][j]=graph[j][i]=0;
                }else{
                    graph[i][j]=graph[j][i]=distance-sum;
                }
            }
        }
        for (int i = 1; i <=n ; i++) {
            distance[i]=graph[1][i];//记录最短距离的数组
        }
        for(int i=1;i<=n;i++){
            double min=Double.MAX_VALUE;//记录最小值
            int k=-1;

            //寻找最小值及其对应的下标---单独创建类，使用堆优化这个操作
            for (int j = 1; j <=n ; j++) {
                if(!visited[j] && distance[j]<min){
                    k=j;
                    min=distance[j];
                }

            }
            if(min==INF) break;//说明已经到了最后
            visited[k]=true;
            total_sum+=min;
            //更新最小值的距离
            for (int j = 1; j <=n ; j++) {
                if(!visited[j] && graph[k][j]<distance[j]){
                    distance[j]=graph[k][j];
                }
            }
        }
        System.out.printf("%.2f",total_sum);
    }
    //find 函数进行查找
}
class Read7{
    StringTokenizer st=new StringTokenizer("");
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException{
        while(!st.hasMoreTokens()){
            st=new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }
    String nextLine() throws IOException{
        return bf.readLine();
    }
    int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
}

