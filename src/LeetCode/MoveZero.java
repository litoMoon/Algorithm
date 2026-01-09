package LeetCode;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int []nums=new int[]{0,1,0,3,12};
        moveZeroes2(nums);
    }
    public static void moveZeroes(int[] nums) {
        int index1=-1,index2=0;
        while(index1<nums.length-1){
            if(nums[++index1]!=0) {
                int cur=nums[index1];
                nums[index1]=nums[index2];
                nums[index2++]=cur;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
    public static void moveZeroes2(int[] nums) {
        int index1 = -1,i = 0;
        while (index1 < nums.length-1) {
            if (nums[++index1] != 0) {
                nums[i++]=nums[index1];
            }
        }
        while(i<nums.length){
            nums[i++]=0;
        }
        System.out.println(Arrays.toString(nums));

    }
}
