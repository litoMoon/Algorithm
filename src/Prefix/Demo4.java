package Prefix;

public class Demo4 {
    public static int[] productExceptSelf(int[] nums) {
        int[]f=new int[nums.length];//创建f表
        int[]g=new int[nums.length];//创建g表

        //初始化
        f[0]=1; g[nums.length-1]=1;
        //填写f表
        for (int i = 1; i < nums.length; i++) {
            f[i]=f[i-1]*nums[i-1];
        }
        //填写g表
        for (int i = nums.length-2; i >=0 ; i--) {
            g[i]=g[i+1]*nums[i+1];
        }

        int []ret=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i]=f[i]*g[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int []nums=new int[]{1,2,3,4};
        for (int x:productExceptSelf(nums)) {
            System.out.print(x+" ");
        }
    }
}
