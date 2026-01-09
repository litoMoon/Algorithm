package topLogicalSorting;

import java.util.*;


public class Demo1 {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));

    }
    //建图的两个办法
    //List<List<Integer>> list;
    //HashMap<Integer,List<Integer>> map ，注意第二个比较万能
    public static boolean canFinish(int n, int[][] p) {
        int[] in=new int[n];
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new ArrayDeque<>();
        for (int i = 0; i < p.length; i++) {
            int a=p[i][0],b=p[i][1];//b->a
            if(!map.containsKey(b)) map.put(b,new ArrayList<>());
            map.get(b).add(a);//将a这个元素加入到b指向的链表中
            in[a]++;//计算入度
        }
        for (int i = 0; i < n; i++) {
            if(in[i]==0) q.offer(i);//首次入度为0的进入队列等候
        }
        while(!q.isEmpty()){
            int sz=q.size();
            for (int i = 0; i < sz; i++) {
                int cur=q.poll();
                List<Integer> list= map.getOrDefault(cur,new ArrayList<>());
                for (int x :list) {
                    in[x]--;
                    if(in[x]==0) q.offer(x);
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if(in[i]!=0) return false;
        }
        return true;
    }
}
