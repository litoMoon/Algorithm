package bitManipulation;

public class Demo4 {
    public static void main(String[] args) {
        int []ret=singleNumber(new int[]{1,2,3,1,2,3,4,5});
        for (int x:ret) {
            System.out.print(x+" ");
        }

    }
    public static int[] singleNumber1(int[] nums) {
        int []ret=new int[2];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum^=nums[i]; // 注意这里异或是不同的才为 1 ，相同的则为 0
        }
        sum&=(-sum);//取出最后面一位的 1 ,且其余位均为 0
        for (int num:nums) {
            if((num&sum)==0){
                ret[0]^=num;
            }else ret[1]^=num;
        }
        return ret;
    }
    public static int[] singleNumber(int[] nums) {
        int res = 0;
        int res_1 = 0;
        int n = nums.length;
        for(int num:nums){
            res^=num;
        }
        int rightOne = res&(~res+1);
        for(int num:nums){
            if((num&rightOne)!=0) res_1 ^= num;
        }
        return new int[]{res_1,res^res_1};
    }
}
