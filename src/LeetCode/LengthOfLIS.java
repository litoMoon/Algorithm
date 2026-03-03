package LeetCode;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] ret=new int[nums.length];
        int count=0;
        ret[0]=nums[count++];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>ret[count-1]) {
                ret[count++]=nums[i];
                continue;
            }
            BinarySearch(ret,nums[i],count);
        }
        return count;


    }
    public void BinarySearch(int []ret,int x,int c){
        int left=0,right=c-1,mid=0;
        while(left<right){
            mid=(left+right)/2;
            if(ret[mid]>x){
                right=mid;
            }else if(ret[mid]<x){
                left=mid+1;
            }else{
                ret[mid]=x;
                return ;
            }
        }
        ret[right]=x;
    }
}
