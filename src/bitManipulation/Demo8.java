package bitManipulation;

public class Demo8 {
    public static void main(String[] args) {
        int []arr=new int[]{2,3};
        for (int x :missingTwo(arr)) {
            System.out.print(x+" ");
        }
    }
    public static int[] missingTwo(int[] nums) {
        int sum=0,len=nums.length;
        for (int i = 0; i <nums.length; i++) {
            sum^=nums[i];
        }
        for (int i=1;i<=len+2;i++) {
            sum^=i;
        }
        //取出最后一位
        sum&=-sum;
      int[] ret=new int[2];
        for (int i = 0; i < len; i++) {
            if((sum&nums[i])==0) ret[0]^=nums[i];
            else ret[1]^=nums[i];
        }
        for (int i = 1; i <=len+2 ; i++) {
            if((sum&i)==0) ret[0]^=i;
            else ret[1]^=i;
        }
        return ret;
    }
}
