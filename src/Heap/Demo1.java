package Heap;
import java.util.*;
public class Demo1 {
    public static void main(String[] args) {
        int []stones=new int[]{4,4,4,4};
        System.out.println(lastStoneWeight2(stones));

    }

    //解法二---创建大根堆来解决问题
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->{return b-a;});//别忘了里面是一条语句
        for(int i=0;i<stones.length;i++){
            heap.add(stones[i]);//将元素放入大根堆
        }
        while(!heap.isEmpty() && heap.size()>1){//当堆不为空时
            int t1=heap.poll();
            int t2=heap.poll();
            if(t2!=t1) heap.add(Math.abs(t2-t1));
        }
        if(heap.size()!=0) return heap.poll();
        return 0;
    }
    //解法一
    public static int lastStoneWeight1(int[] stones) {
        //先对数组进行排序
        int len=stones.length;
        while(len!=1){
            Arrays.sort(stones,0,len);
            int right=len-1;
            int left=right-1;
            if(stones[left]==stones[right]){
                left-=2;
                right=left+1;
                len-=2;
                if(len==0){
                    return 0;
                }
            }else{
                left--;
                stones[right-1]=stones[right]-stones[right-1];
                len-=1;
                right--;
            }

        }
        return stones[0];

    }
    //解法三---使用数组模拟

    public static int lastStoneWeight2(int[] stones) {
        Arrays.sort(stones);
        for(int i=stones.length-1;i>0;i--){
            if(stones[i]==0) break;
            stones[i-1]=stones[i]-stones[i-1];
            stones[i]=Integer.MAX_VALUE;
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
