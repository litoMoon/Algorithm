package LeetCode;

public class MaxProfit {
    //买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int ret=0,min=prices[0];
        for (int i = 1; i < prices.length; i++) {
            ret=Math.max(ret,prices[i]-min);
            min=Math.min(min,prices[i]);//求出最小值
        }
        return ret;
    }
}
