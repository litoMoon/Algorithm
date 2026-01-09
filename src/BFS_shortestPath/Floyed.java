package BFS_shortestPath;
import java.util.*;
public class Floyed {
    static int INF= Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        long[][]graph=new long[n+1][n+1];
        //将 graph 数组的值全部填为最大值
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],INF);//将数组填满
        }
        while(m-->0){
            int a=scan.nextInt();
            int b=scan.nextInt();
            graph[a][b]=graph[b][a]=1;
        }
       floyed(graph);

        scan.close();

    }
    public static void floyed(long[][] g){
        long max=0;
        int len=g.length;
        //这里就已经是算出了各个点之间的最短距离，如果各个点之间是相通的，那么就可以求出值，如果不相通会仍是初始值INF
        for(int k=1;k<len;k++){
            for (int i = 1; i <len ; i++) {
                for (int j = 1; j <len ; j++) {
                    if(i==j) g[i][j]=0;
                    if(i!=j && i!=k && j!=k && g[i][k]+g[k][j]<g[i][j]){
                        g[i][j]=g[i][k]+g[k][j];
                    }
                }
            }
        }
        boolean flag=false;
        for (int i = 1; i <len ; i++) {
            for (int j = 1; j <len ; j++) {
                if(g[i][j]==INF){
                   flag=true;
                }else{
                   max=Math.max(g[i][j],max);
                }
            }
        }
        if(flag) System.out.println("NO");
        else{
            System.out.println("YES");
        }
        System.out.println(max);
    }
}
