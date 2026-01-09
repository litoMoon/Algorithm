package bitManipulation;

public class Demo6 {
    public static int missingNumber(int[] nums) {
        int ret=0,i=0;
        for(;i<nums.length;i++){
            ret^=nums[i];
            ret^=i;
        }
        return ret^i;
    }

    public static void main(String[] args) {
        int []nums=new int[]{3,1,2,5,0};
        System.out.println(missingNumber(nums));
    }
}
