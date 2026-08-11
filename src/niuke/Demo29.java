package niuke;

import java.util.*;

//主持人调度2
public class Demo29 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{2147483646,2147483647},{-2147483648,-2147483647}};
        System.out.println(minmumNumberOfHost(2,arr));

    }
    public static int minmumNumberOfHost (int n, int[][] startEnd) {
        int count = 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        //根据开始时间长短来排序
//        Arrays.sort(startEnd, (v1, v2) -> {
//            if (v1[0] != v2[0]) return v1[0] - v2[0];
//            return v1[1] - v2[1];
//        });
        Arrays.sort(startEnd, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        minHeap.offer(startEnd[0][1]);
        count++;
        for (int i = 1; i < n; i++) {
            int cur = minHeap.peek();
            if (startEnd[i][0] < cur) {
                count++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(startEnd[i][1]);
        }
        return count;
    }
}
