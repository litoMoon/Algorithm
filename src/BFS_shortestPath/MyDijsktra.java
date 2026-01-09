package BFS_shortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
public class MyDijsktra {
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][]graph=new int[][]{
                {0, 6, INF, 1},
                {6, 0, 5, 2},
                {INF, 5, 0, INF},
                {1, 2, INF, 0}
        };
        System.out.println(Arrays.toString(dijsktra(graph)));
    }
    public static int[] dijsktra(int[][]g){
        int len=g.length;
        boolean[] visited=new boolean[len];
        int[] dist=new int[len];
        Arrays.fill(dist,INF);//最初将所有的距离都设置为 int 的最大值
        dist[0]=0;
        for(int i=0;i<len;i++){
            //查找到 dist 中的距离最短的值
            int u=-1;
            int mindist=INF;
            for(int j=0;j<len;j++){
               if(!visited[j] && dist[j]<mindist){
                   u=j;
                   mindist=dist[j];
               }
            }
            if(u==-1) break;
            visited[u]=true;
            for(int j=0;j<len;j++){
                if(!visited[j] && g[u][j]!=INF && dist[u]+g[u][j]<dist[j]){
                    dist[j]=dist[u]+g[u][j];
                }

            }
        }
        return dist;

    }
}
*/
import java.util.*;

public class MyDijsktra {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 6, INF, 1},
                {6, 0, 5, 2},
                {INF, 5, 0, INF},
                {1, 2, INF, 0}
        };
        System.out.println(Arrays.toString(dijkstraOptimized(graph)));
    }

    public static int[] dijkstraOptimized(int[][] g) {
        int len = g.length;
        int[] dist = new int[len];//dist中存储的是从起点到当前点的最短值，边走边更新
        Arrays.fill(dist, INF);
        dist[0] = 0;
        boolean[] visited = new boolean[len];
        // 使用优先队列（最小堆）来存储节点和到达该节点的距离
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(0, 0));
        while (!minHeap.isEmpty()) {
            // 取出当前距离最小的节点
            Node currentNode = minHeap.poll();//堆优化后就可以直接取出，不用在进行比较
            int u = currentNode.vertex;

            // 如果已经处理过，跳过
            if (visited[u]) continue;

            visited[u] = true;

            // 遍历所有邻接节点
            for (int v = 0; v < len; v++) {
                if (!visited[v] && g[u][v] != INF) {//这里 !=INF 表示两个点之间是有距离的
                    int newDist = dist[u] + g[u][v];
                    if (newDist < dist[v]) {//如果说当前产生的这个距离比之前到达这个地点的距离小的话就更新这个距离
                        dist[v] = newDist;
                        // 将新距离加入堆中（可能有重复节点，但距离更小，与上面判断是否已经处理过，跳过相呼应）
                        minHeap.offer(new Node(v, newDist));
                    }
                }
            }
        }

        return dist;
    }

    // 辅助类，存储节点和距离
    static class Node implements Comparable<Node>{
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }

    }
}