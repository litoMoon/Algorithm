package LeetCode;

import java.util.*;

public class CanFinish {
    public static boolean canFinish(int n, int[][] p) {
        int[] in=new int[n];//用于记录元素入度的次数
        Queue<Integer> queue=new ArrayDeque<>();//存入当前本次入度为0的全部元素
        HashMap<Integer,List<Integer>> map=new HashMap<>();//拓扑建图
        for(int i=0;i<p.length;i++){
            int a=p[i][0],b=p[i][1];
            if(!map.containsKey(b)) map.put(b,new ArrayList<>());
            map.get(b).add(a);//建图
            in[a]++;//计算入度
        }
        for(int i=0;i<n;i++){
            if(in[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int cur=queue.poll();
                List<Integer> list=map.get(cur);
                for(int x:list){
                    in[x]--;
                    if(in[x]==0) queue.offer(x);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(in[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        canFinish(2,new int[][]{{1,0}});
    }
}
