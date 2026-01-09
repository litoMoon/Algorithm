package Prefix;

public class Demo3 {
    public int pivotIndex(int[] nums) {
        int []f=new int[nums.length];
        int []g=new int[nums.length];
        f[0]=g[nums.length-1]=0;
        for(int i=1;i<nums.length;i++){
            f[i]=f[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            g[i]=g[i+1]+nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            if(g[i]==f[i]) return i;
        }
        return -1;

    }
}
