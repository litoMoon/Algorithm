package LeetCode;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int []dp=new int[nums.length+1];
        dp[0]=0;
        int ret=Integer.MIN_VALUE;//用来存储最终结果的返回值
        for(int i=1;i<=nums.length;i++){
            dp[i]=Math.max(nums[i-1],dp[i-1]+nums[i-1]);//因为nums[i]有可能结果为负数，所以结果需要取max
            ret=Math.max(dp[i],ret);
        }
        return ret;


    }
}
