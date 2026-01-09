package Greed;

import java.util.*;


public class Demo2 {
    //创建一个大根堆使用lambda表达式进行的创建
    public static int halveArray1(int[] nums) {
        double sum=0;
        int ret=0;
        PriorityQueue<Double> heap=new PriorityQueue<>((a,b)->b.compareTo(a));
        for(int i=0;i<nums.length;i++){
            heap.add((double)nums[i]);//将元素扔进去创建大根堆
            sum+=nums[i];
        }
        double cur=sum/2;
        while(sum>cur){
            double tmp=heap.poll();
            double m=tmp/2;
            heap.add(m);
            sum-=m;
            ret++;
        }
        return ret;
    }
    public static int halveArray(int[] nums) {
        float sum = 0;
        int ret = 0;
        PriorityQueue<Float> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            heap.add((float) nums[i]);//将元素扔进去创建大根堆
            sum += nums[i];
        }
        float cur = sum / 2;
        while (sum > cur) {
            float tmp = heap.poll();
            float m = tmp / 2;
            heap.add(m);
            sum -= m;
            ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        int []nums=new int[]{5,19,8,1};
        System.out.println(halveArray(nums));
    }
}
