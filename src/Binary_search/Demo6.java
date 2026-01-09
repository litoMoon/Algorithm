package Binary_search;

public class Demo6 {
    public static int findPeakElement(int[] nums) {
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]) right=mid;
            else left=mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 2, 6, 4}));


    }
}
