package Greed;

public class Demo5 {
    //最长递增子序列
    public static void main(String[] args) {
        int []nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }
    public static int lengthOfLIS1(int[] nums) {
        //返回值
        int ret=1;
        //创建dp数组
        int[] dp=new int[nums.length];
        //初始dp数组的值都为1
        for(int i=0;i<nums.length;i++) dp[i]=1;
        for (int i = 1; i <nums.length ; i++) {
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            //每次完了都进行一下更新
            ret=Math.max(ret,dp[i]);
        }
        return ret;

    }

    public static int lengthOfLIS(int[] nums) {
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
    public static void BinarySearch(int []ret,int x,int c){
        int left=0,right=c-1,mid=0;
       while(left<right){
           mid=(left+right)/2;
           if(ret[mid]>x){
               right=mid;//需要找打第一个大于x的数并将这个数进行替换
           }else if(ret[mid]<x){
               left=mid+1;//left的那一边永远是小于目标值的，left会一步一步走，直到最后走到第一个大于x的数
           }else{
               ret[mid]=x;
               return ;
           }
       }
       ret[right]=x;
    }
}
