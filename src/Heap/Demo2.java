package Heap;

import java.util.PriorityQueue;

public class Demo2 {
    public static void main(String[] args) {

    }

}
class KthLargest {
    PriorityQueue<Integer> heap=new PriorityQueue<>();//默认就是建立小根堆
    //因为add方法里面也需要使用到k，但是k的取值只在第一个函数中存在，所以说需要重新创建一个新的变量用来保存这个k
    //否则这个k只能作为参数传递去下一个函数
    int k=0;

    public KthLargest(int _k, int[] nums) {//这个是一个构造函数
        k=_k;

        //这里会需要先将之前的元素放进去
        for(int x:nums){
            heap.offer(x);
            while(heap.size()>k){
                heap.poll();
            }
        }
    }
    //这里的意思是调用这个类里的add函数的时候，函数就会返回其中的第k大的元素
    public int add(int val) {
        heap.offer(val);
        while(heap.size()>k){
            heap.poll();//当堆里的元素个数超过了k个的时候，此时将元素丢出去，只保留大的这几个
        }
        return heap.peek();//注意这里不是把元素丢出去，因为这里会找到第k大的元素，但是后面还会添加进来新的元素
        //需要判断这个新的元素的排名值，判断这个排名值的时候也需要用到之前的元素，所以说不能将那个元素弹出去。

    }
}
