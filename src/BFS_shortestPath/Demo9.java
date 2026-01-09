/*
package BFS_shortestPath;


    import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

    public class Demo9 {
        static int INF=Integer.MAX_VALUE;
        public static void main(String[] args) {
            //在主函数中需要建图
            Scanner scan = new Scanner(System.in);
            int n=scan.nextInt();
            int m=scan.nextInt();
            int[][] graph=new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                Arrays.fill(graph[i],INF);
            }
            while(m-->0){
                int u=scan.nextInt();
                int v=scan.nextInt();
                graph[u][v]=Math.min(graph[u][v],scan.nextInt());//因为题目中有指出可能有些边是双向的，有些边不是，所以不用每条边都设置为双向的
            }
            long ret=dijkstra(graph);
            if(ret==INF) {
                System.out.println(-1);

            }else System.out.println(ret);

            scan.close();
        }
        public static long dijkstra(int[][] g){
            int len=g.length;
            long []dist=new long[len];
            Arrays.fill(dist,INF);
            dist[1]=0;

            boolean[] visited=new boolean[len];
            PriorityQueue<Node> queue=new PriorityQueue<>();//Node内部已经实现了比较方法
            queue.offer(new Node(1,0));
            while(!queue.isEmpty()){
                Node c=queue.poll();
                int u=c.x;
                long d=c.distance;
                if(visited[u]) continue;
                visited[u]=true;

                //处理当前这个最小值节点的邻接点
                for(int i=1;i<len;i++){
                    if(!visited[i] && g[u][i]!=INF && d+g[u][i]<dist[i]){
                        dist[i]=d+g[u][i];
                        queue.offer(new Node(i,dist[i]));
                    }
                }

            }
            return dist[len-1];
        }
    }
    class Node implements Comparable<Node>{
        int x;
        long distance;
        public Node(int x,long distance){
            this.x=x;
            this.distance=distance;
        }
        public int compareTo(Node o){
            return (int)(this.distance-o.distance);
        }
    }
*/

