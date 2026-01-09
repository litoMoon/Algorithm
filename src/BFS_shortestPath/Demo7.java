/*package BFS_shortestPath;

import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Demo7 {
    //    思路
//    以样例来说，(0,0)的位置首先花一秒进行染色，接下来待染色的就是(0,1) (1,0)
//    再加上已经花费了的一秒，用图解来表示就是
//
//    0 3
//    5
//    也就是右边需要三秒染色，下面需要五秒染色，所以下一个状态就是右边染色成功后四周的也准备染色，染色时间就是这个点需要的时间+3
//
//    0 0 6
//    5 8
    static int[][] w = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 方向数组
    static int[][] a;
    static int count = 0;
    static int n, m;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        dfs();
    }

    public static void dfs() {
        PriorityBlockingQueue<color> query = new PriorityBlockingQueue<>();// 创建优先队列,实现Comparable可以排序
        // queue的增加元素方法add和offer的区别在于，add方法在队列满的情况下将选择抛异常的方法来表示队列已经满了，
        // 而offer方法通过返回false表示队列已经满了；在有限队列的情况，使用offer方法优于add方法；
        query.offer(new color(a[0][0], 0, 0));// 向队列加入第一个元素
        a[0][0] = 0;// 经过时间结束
        while (query.isEmpty() == false) {// 队列不为空
            color temp = query.poll();// 取出队首并且移除队首
            if (temp.time > count)
                count = temp.time;
            for (int i = 0; i < 4; i++) {// 向四个方向开始染色
                int x = temp.x + w[i][0];
                int y = temp.y + w[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] > 0) {
                    query.offer(new color(a[x][y] + temp.time, x, y));// 只要方格上的值不为0说明还没有染色完成
                    a[x][y] = 0;// 染色时间到了
                }
            }

        }
        System.out.println(count);
    }
}

class color implements Comparable<color> {// 颜色类
    public int time;
    public int x;
    public int y;

    public color(int time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(color o) {
        // TODO Auto-generated method stub
        return this.time - o.time;
    }

}*/
