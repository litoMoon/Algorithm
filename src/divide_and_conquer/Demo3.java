package divide_and_conquer;

//数组中第k大的元素

import java.util.PriorityQueue;
import java.util.Random;

public class Demo3 {
    public static void main(String[] args) {
     //   findKthLargest(new int[]{5,2,4,1,3,6,0}, 2);
        System.out.println(findKthLargest(new int[]{5,2,4,1,3,6,0}, 2));

    }
    //解法一：堆排序
//    public static int findKthLargest1(int[] nums, int k) {
//
//
//    }
    //解法二：快速排序算法（先排序+选择）
    public static int findKthLargest(int[] nums, int k) {

        return  sortQuick(nums,0,nums.length-1,k);

    }
    //实现快速排序
    public static void sortQuick1(int []nums,int l,int r){
        if(l>=r) return; //由于这里是递归，注意递归结束的条件
        int left=l-1,right=r+1,i=l;
        //求取随机值，使用方法随机选择基准元素
        int rand=new Random().nextInt(r-l+1);
        rand=rand%(r-l+1)+l;//求出基准值的下标
        while(i<right){
            if(nums[i]<nums[rand]) swap(nums,++left,i++);
            else if(nums[i]==nums[rand]) i++;
            else swap(nums,--right,i);
        }
        sortQuick1(nums,l,left);//第一段需要重新进行排序
        sortQuick1(nums,right,r);//最后一段需要重新进行排序
    }
    //实现元素之间的交换过程
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //优化上述代码
    public static int sortQuick(int []nums,int l,int r,int k){
     //   if(l>=r) return nums[l]; //由于这里是递归，注意递归结束的条件
        int left=l-1,right=r+1,i=l,count1=0,count2=0,count3=0;
        //求取随机值，使用方法随机选择基准元素
        int rand=new Random().nextInt(r-l+1);
        rand=rand%(r-l+1)+l;//求出基准值的下标
        int num=nums[rand];
        while(i<right){
            if(nums[i]<num) {
                swap(nums,++left,i++);
            }
            else if(nums[i]==num) {
                i++;
            }
            else {
                swap(nums,--right,i);
            }
        }
        //三块区间 [l-left+1] [right-left-1] [r-right+1]
        int b=right-left-1,c=r-right+1;
        if(c>=k){
             return sortQuick(nums,right,r,k);//最后一段需要重新进行排序
        }else if(b+c>=k) return num;
        else return  sortQuick(nums,l,left,k-(b+c));//第一段需要重新进行排序
    }
}
