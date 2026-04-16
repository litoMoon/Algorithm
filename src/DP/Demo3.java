package DP;

public class Demo3 {
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            for (int j = 1; j <= cur; j++) {
                if(i + j == len - 1) return dp[i] + 1;
                dp[i + j] = Math.min(dp[i] + 1 , dp[i + j]);

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums=new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
