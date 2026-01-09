package BFS_shortestPath;

import java.util.ArrayDeque;
import java.util.Queue;

//二维数组表示迷宫
//一维数组表示初始坐标
public class Demo1 {
    static int[] dx=new int[]{-1,1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
    public static int nearestExit(char[][] maze, int[] entrance) {
        int ret = 0, x = 0, y = 0, count = 0, result = 1,flag=0;
        int lenOfH = maze.length;
        int lenOfZ = maze[0].length;
        boolean[][] bool = new boolean[lenOfH][lenOfZ];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { entrance[0], entrance[1] });
        bool[entrance[0]][entrance[1]] = true;
        while (!q.isEmpty()) {
            count=0; flag=0;
            while (result > 0) {
                int[] cur = q.poll();
                result--;
                for (int i = 0; i < 4; i++) {// 一轮循环下来后表示已经走了第一轮
                    x = cur[0] + dx[i];
                    y = cur[1] + dy[i];
                    if (x >= 0 && x <= lenOfH - 1 && y >= 0 && y <= lenOfZ - 1 && maze[x][y] == '.' && !bool[x][y]) {
                        if (x == 0 || x == lenOfH - 1 || y == 0 || y == lenOfZ - 1)
                            return ret + 1;
                        bool[x][y] = true;
                        q.offer(new int[] { x, y });
                        count++;
                        flag=1;
                    }
                }
            }
            result=count;
            if(result!=0) ret++;
        }
        if(flag==0 || ret==0) return -1;
        else return ret;
    }

    public static void main(String[] args) {
       char[][] maze=new char[][]{{'+','.','+','+','+','+','+'},
               {'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','+','.','+'},
               {'+','+','+','+','+','.','+'}};
        System.out.println(nearestExit(maze,new int[]{0,1}));


    }
}
