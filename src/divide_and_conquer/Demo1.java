package divide_and_conquer;

public class Demo1 {
    public static void sortColors(int[] nums) {
        int left=-1,right=nums.length;
        for (int i = 0; i < right; ) {
            if(nums[i]==0) swap(++left,i++,nums);
            else if(nums[i]==1) i++;
            else if(nums[i]==2) swap(--right,i,nums);
        }
        for (int x:nums) {
            System.out.print(x+" ");
        }

    }
    public static void swap(int x,int y,int []nums){
        int temp=nums[x];
       nums[x]=nums[y];
        nums[y]=temp;
    }
    public static void main(String[] args) {
        sortColors(new int[]{2,1,0});
    }
}
