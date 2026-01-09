package Union_Find;

import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to, len;

    public Edge(int from, int to, int len) {
        this.from = from;
        this.to = to;
        this.len = len;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.len, other.len);//这样作比较不容易出错
    }
}

public class Kruskal {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 顶点数
        int m = scanner.nextInt(); // 边数

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int len = scanner.nextInt();
            edges[i] = new Edge(from, to, len);
        }

        int minCost = kruskal(n, edges);
        System.out.println(minCost);
    }

    public static int kruskal(int n, Edge[] edges) {
        // 按权重对边进行排序
        Arrays.sort(edges);

        // 初始化并查集父节点数组
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesAdded = 0;

        for (Edge edge : edges) {
            if (edgesAdded == n - 1) break; // 最小生成树有n-1条边，已经达到了最终的成效

            int rootFrom = find(edge.from);
            int rootTo = find(edge.to);

            if (rootFrom != rootTo) {
                totalCost += edge.len;
                parent[rootFrom] = rootTo;
                edgesAdded++;//边数加一
            }
        }

        return totalCost;
    }

    private static int find(int x) {
        // 路径压缩优化
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
