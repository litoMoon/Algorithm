package BFS_shortestPath;
import java.util.*;
public class Demo10 {
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        //在主函数中需要建图
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[][] graph=new int[n+1][n+1];
        int []wait=new int[n+1];
        for(int i=1;i<=n;i++){
            wait[i]=scan.nextInt();
        }
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],INF);
        }
        while(m-->0){
            int u=scan.nextInt();
            int v=scan.nextInt();
            int d=scan.nextInt();
            graph[u][v]=d;
            graph[v][u]=d;
        }

        //题目的要求不能落下，如果不满足条件需要输出-1
        int ret=dijkstra(graph,wait);
        System.out.println(ret);

        scan.close();
    }
    public static int dijkstra(int[][] g,int []w){
        int len=g.length;
        int []dist=new int[len];
        Arrays.fill(dist,INF);
        dist[1]=0;

        boolean[] visited=new boolean[len];
        PriorityQueue<Node> queue=new PriorityQueue<>();//Node内部已经实现了比较方法
        queue.offer(new Node(1,0));
        while(!queue.isEmpty()){
            Node c=queue.poll();
            int u=c.x;
            int d=c.distance;
            if(visited[u]) continue;
            visited[u]=true;

            //处理当前这个最小值节点的邻接点
            for(int i=1;i<len;i++){
                if(!visited[i] && g[u][i]!=INF && d+g[u][i]+w[i]<dist[i]){
                    dist[i]=d+g[u][i]+w[i];
                    queue.offer(new Node(i,dist[i]));
                }
            }

        }
        return dist[len-1]-w[len-1];
    }
}
class Node implements Comparable<Node>{
    int x;
    int distance;
    public Node(int x,int distance){
        this.x=x;
        this.distance=distance;
    }
    public int compareTo(Node o){
        return this.distance-o.distance;
    }
}
