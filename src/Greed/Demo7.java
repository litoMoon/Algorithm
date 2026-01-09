package Greed;

public class Demo7 {
    //最长连续递增序列
    public int findLengthOfLCIS(int[] nums) {
        int ret=1,max=1;//用来记录连续序列的长度
        int first=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>first){
                ret++;
                if(ret>max) max=ret;//调用库函数的耗时是要大于单纯的比较的
            }else{
                ret=1;
            }
            first=nums[i];
        }
        return max;
    }
}
