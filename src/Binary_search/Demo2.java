package Binary_search;

import java.util.Arrays;

public class Demo2 {
    public static int[] searchRange(int[] nums, int target) {
        int left=0,right=nums.length-1,ret_left=-1,ret_right=-1;

        if(nums.length==0) return new int[]{ret_left,ret_right};
        //查找左端点
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target) left=mid+1;
            else if(nums[mid]>=target) right=mid;
        }
        if(nums[left]==target){
            ret_left=left;
        }
        left=0; right=nums.length-1;
        //查找右端点
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]<=target) left=mid;
            else if(nums[mid]>target) right=mid-1;
        }
        if(nums[left]==target){
            ret_right=left;
        }

        return new int[]{ret_left,ret_right};
    }

    public static void main(String[] args) {
        int []nums=new int[]{};
        int target=6;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }
}
