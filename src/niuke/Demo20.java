package niuke;

import java.util.*;

public class Demo20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] x = new int[m+1];
        Map<Integer, List<Integer>> hash = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();//队列
//        int[] ret = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int a = in.nextInt(), b = in.nextInt();
            if (!hash.containsKey(a)) hash.put(a, new ArrayList<>());
            hash.get(a).add(b);//建图
            x[b]++;//计数
        }
        for (int i = 1; i <= m; i++) {
            if (x[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
                List<Integer> ans = hash.getOrDefault(cur, new ArrayList<>());
                for (int num : ans) {
                    x[num]--;
                    if(x[num] == 0) queue.add(num);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if(x[i] != 0) {
                System.out.println(-1);
                return;
            }
            System.out.print(i + " ");
        }
        if(x[m] != 0) {
            System.out.println(-1);
            return;
        }
        System.out.print(m);
    }
}
