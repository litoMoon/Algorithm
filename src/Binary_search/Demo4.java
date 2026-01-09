package Binary_search;

public class Demo4 {
    public static int searchInsert(int[] nums, int target) {
        int ret=0,left=0,right=nums.length-1;
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(nums[mid]>target) right=mid-1;
            else left=mid;
        }
        if(nums[left]==target) return left;
        return left+1;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,6};
        System.out.println(searchInsert(arr, 7));
    }
}
