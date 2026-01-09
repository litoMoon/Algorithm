package Greed;

public class Demo8 {
    public static void main(String[] args) {
        int[] num=new int[]{7,6,4,3,7};
        System.out.println(maxProfit(num));

    }
    //买卖股票的最佳时机
    public static int maxProfit1(int[] prices) {
        int tmp=prices[0],ret=0;
       for(int i=1;i<prices.length;i++){
           int n=prices[i]-tmp;
           if(n>0){
               ret+=n;
               tmp=prices[i];
           }else if(ret==0){
               tmp=prices[i];
           }
       }
       return ret;
    }

    //买卖股票的最佳时机Ⅰ---使用库函数
    public static int maxProfit(int[] prices) {
      int ret=0,min=prices[0];
        for (int i = 1; i < prices.length; i++) {
            ret=Math.max(ret,prices[i]-min);
            min=Math.min(min,prices[i]);//求出最小值
        }
      return ret;
    }

}
