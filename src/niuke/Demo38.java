package niuke;

import java.util.*;

public class Demo38 {
    public static int[] dx = new int[] {0, 0, 1, -1};
    public static int[] dy = new int[] {1, -1, 0, 0};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[][] bool = new boolean[n + 1][m + 1];
        char[][] ch = new char[n + 1][m + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0, stype = 0;//记录出口数量, 最近的出口步数
        for (int i = 1; i <= n; i++) {
            String str = in.next();
            for (int j = 0; j < m; j++) {
                ch[i][j + 1] = str.charAt(j);
                if (ch[i][j + 1] == 'k') {
                    queue.add(new int[] {i, j + 1});
                    bool[i][j + 1] = true;
                }
            }
        }
        int minStype = n * m + 1;
        while (!queue.isEmpty()) {
//            int size = queue.size();
            stype++;
//            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];

                    if (x >= 0 && x <= n && y >= 0 && y <= m && !bool[x][y] && (ch[x][y] == '.' || ch[x][y] == 'e')) {
                        if (ch[x][y] == 'e') {
                            minStype = Math.min(minStype, stype);
                            count++;
                        } else {
                            queue.add(new int[] {x, y});
                        }
                        bool[x][y] = true;
                    }
                }

        }
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count + " " + minStype);
        }
    }
}
