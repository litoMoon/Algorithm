package BFS_shortestPath;

import java.util.Arrays;

public class DijkstraAlgorithm {
    // 定义一个常量表示无穷大
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length; // 顶点的数量
        int[] dist = new int[n]; // 用于存储从起点到每个顶点的最短距离
        boolean[] visited = new boolean[n]; // 标记数组，表示某个顶点是否已经被访问过

        // 初始化
        Arrays.fill(dist, INF); // 初始时，将所有顶点的距离设置为无穷大
        dist[start] = 0; // 起点到自身的距离为0

        for (int i = 0; i < n; i++) {
            // 找出未访问的顶点中距离起点最近的顶点
            int u = -1;
            int minDist = INF;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    u = j;
                    minDist = dist[j];
                }
            }

            // 如果没有找到未访问的顶点，说明所有顶点都已访问过，算法结束
            if (u == -1) {
                break;
            }

            // 标记当前顶点为已访问
            visited[u] = true;

            // 更新从当前顶点出发到其他未访问顶点的距离
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[u][j] != INF && dist[u] + graph[u][j] < dist[j]) {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }

        // 输出结果
        System.out.println("从顶点 " + start + " 到其他各顶点的最短距离：");
        for (int i = 0; i < n; i++) {
            System.out.println("顶点 " + i + " 的最短距离为：" + dist[i]);
        }
    }

    public static void main(String[] args) {
        // 构建图的邻接矩阵
        int[][] graph = {
                {0, 6, INF, 1},
                {6, 0, 5, 2},
                {INF, 5, 0, INF},
                {1, 2, INF, 0}
        };

        // 从顶点0开始运行Dijkstra算法
        dijkstra(graph, 0);
    }
}
