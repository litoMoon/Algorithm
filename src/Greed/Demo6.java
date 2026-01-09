package Greed;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet1(int[] nums) {
        List<Integer> ret=new ArrayList<>();
        ret.add(nums[0]);

        for(int i=1;i<nums.length;i++){

            //这里才是真的在后面添加元素，才会对ret这个返回链表增加长度
            if(nums[i]>ret.get(ret.size()-1)) {
                ret.add(nums[i]);
                if(ret.size()==3) return true;
            }
            else{

                //这里是修改链表内的元素，不会使得链表的长度增加
                int left=0,right=ret.size()-1,mid=0;
                while(left<right){
                    mid=(left+right)/2;
                    if(ret.get(mid)>=nums[i]){
                        right=mid;//需要找到第一个大于nums[i]的值，并进行替换
                    }else{
                        left=mid+1;
                    }

                }
                ret.set(left,nums[i]);
            }
        }
        return false;
    }
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
      int first=nums[0];
      int second=Integer.MAX_VALUE;//
        for(int i=1;i<nums.length;i++){
            if(nums[i]>second) return true;
            else if(nums[i]>first){
                second=nums[i];
            }else{
                first=nums[i];
            }
        }
        return false;
    }
}
