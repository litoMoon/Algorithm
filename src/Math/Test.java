package Math;

//判断一个数是否是一个数的几次幂
public class Test {
    public boolean isPowerOfK(int n,int k){//判断n是否为k的整数次幂
        if(n<=0 || k<=1) {
            //n是小于或者等于0 的数不满足题意，k必须为大于 1的整数，整数次幂
            return false;
        }
        while(n % k==0){
            n/=k;
        }
        return n==1;//如果 n==1 就代表是最终的结果
    }
}
