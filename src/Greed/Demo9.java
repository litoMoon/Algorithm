package Greed;
public class Demo9 {

    //买卖股票的最佳时机Ⅱ
    public static void main(String[] args) {
        int []nums=new int[]{1,2,3,4,5,6,7};
        System.out.println(maxProfit(nums));

    }
    public static int maxProfit1(int[] prices) {
        int n=prices.length;

        //创建dp表
        int [][]dp=new int[n][2];

        //初始化
        dp[0][0]=-prices[0];

        //填表
        for (int i = 1; i <n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);

        }
        return dp[n-1][1];

    }

    //使用双指针解这道贪心的题
    public static int maxProfit2(int[] prices) {
        int left=0,right=0,ret=0, i=0;
        for( ;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                continue;
            }else{
                right=i;
                ret+=prices[right]-prices[left];//更新最终返回的结果值
                left=i+1;
                right=left;
            }

        }
        right=i;
        ret+=prices[right]-prices[left];
        return ret;

    }

    //使用库函数解决---将交易拆分为一天一天的进行计算
    public static int maxProfit(int[] prices) {
       int max=0;
        for (int i = 1; i < prices.length; i++) {
            max+=Math.max(0,prices[i]-prices[i-1]) ;//将差值与0进行比较，只要差值为正数的值
        }
        return max;
    }
}
