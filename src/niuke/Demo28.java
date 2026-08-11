package niuke;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//走迷宫
public class Demo28 {
//    static int[] px = new int[]{0, 0, 1, -1};
//    static int[] py = new int[]{1, -1, 0, 0};
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int x1 = in.nextInt();
//        int y1 = in.nextInt();
//        int x2 = in.nextInt();
//        int y2 = in.nextInt();
//        in.nextLine();
//        int minCount = 0, x = 0, y = 0;
//        if (x1 == x2 && y1 == y2) {
//            System.out.println(minCount);
//            return ;
//        }
//        int[][] arr = new int[n][m];
//        boolean[][] bool = new boolean[n][m];
//        Queue<int[]> queue = new ArrayDeque<>();
//        for (int i = 0; i < n; i++) {
//            String str = in.nextLine();
//            int pos = 0;
//            while (pos < str.length()) {
//                if (str.charAt(pos) == '.') {
//                    arr[i][pos++] = 1;
//                } else {
//                    arr[i][pos++] = 0;
//                }
//            }
//        }
//
//        bool[x1 - 1][y1 - 1] = true;
//        queue.add(new int[]{x1 - 1, y1 - 1});
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int flag = 0;
//            while (size-- > 0) {
//                int[] cur = queue.poll();
//                bool[cur[0]][cur[1]] = true;
//                for (int i = 0; i < 4; i++) {
//                    //获得新 x 和 y 的坐标
//                    x = cur[0] + px[i];
//                    y = cur[1] + py[i];
//                    if (x >= 0 && x < n && y >= 0 && y < m && !bool[x][y] && arr[x][y] == 1) {
//                        //坐标合法并且当前数值可取
//                        if (x == x2 - 1 && y == y2 - 1) {
//                            System.out.println(minCount + 1);
//                            return ;
//                        } else {
//                            flag = 1;
////                            bool[x][y] = true;
//                            queue.add(new int[]{x, y});
//                        }
//
//                    }
//                }
//            }
//            if (flag == 1) minCount++;
//        }
//        System.out.println(-1);
//    }
    public static int N = 1010;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int n, m, x1, y1, x2, y2;
    public static char[][] arr = new char[N][N];
    public static int[][] dist = new int[N][N]; // 标记当前位置有没有搜索过，以及⾛到该位置时候的最短步数
    public static int bfs()
    {
        if(arr[x2][y2] == '*') return -1;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                dist[i][j] = -1; // 表明刚开始每个位置都没有搜索过

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        dist[x1][y1] = 0;
        while(!q.isEmpty())
        {
            int[] t = q.poll();
            int a = t[0], b = t[1];
            for(int i = 0; i < 4; i++)
            {
                int x = a + dx[i], y = b + dy[i];
                if(x >= 1 && x <= n && y >= 1 && y <= m && arr[x][y] == '.' &&
                        dist[x][y] == -1)
                {
                    q.add(new int[]{x, y});
                    dist[x][y] = dist[a][b] + 1;
                    if(x == x2 && y == y2)
                    {
                        return dist[x][y];
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        x1 = in.nextInt(); y1 = in.nextInt();
        x2 = in.nextInt(); y2 = in.nextInt();
        for(int i = 1; i <= n; i++)
        {
            String tmp = in.next();
            for(int j = 1; j <= m; j++)
            {
                arr[i][j] = tmp.charAt(j - 1);
            }
        }
        System.out.println(bfs());
    }
}

