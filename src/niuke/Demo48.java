package niuke;

import java.util.*;

//拓扑排序
public class Demo48 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        groups.add(arr);
        System.out.println(findOrder(3, groups));

    }

    public static ArrayList<Integer> findOrder (int n, ArrayList<ArrayList<Integer>> groups) {
        // 存储指向信息
        List<List<Integer>> edges = new ArrayList<>();
        // 存储入度信息
        int[] nums = new int[n];
        ArrayList<Integer> ret = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < groups.size(); i++) {
            int cur1 = groups.get(i).get(0), cur2 =  groups.get(i).get(1);
            nums[cur1]++; edges.get(cur2).add(cur1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ret.add(cur);
            for (int x : edges.get(cur)) {
                nums[x]--;
                if (nums[x] == 0) queue.add(x);
            }
        }

        if (ret.size() == n) {
            return ret;
        }

        return new ArrayList<>();
    }
}
