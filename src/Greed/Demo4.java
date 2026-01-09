package Greed;

public class Demo4 {
    public static void main(String[] args) {
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        wiggleMaxLength(nums);
        System.out.println(wiggleMaxLength(nums));
    }
    //求出最长摆动序列的长度
    public static int wiggleMaxLength(int[] nums) {
        //if(nums.length==1) return 1;
        int ret=1;
        int left=0;
        int right=0;
        for (int i = 1; i < nums.length; i++) {
            right=nums[i]-nums[i-1];
            if(right==0) continue;
            if(right*left<=0) ret++;
            left=right;
        }

        return ret;
    }

}
