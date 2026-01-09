package Binary_search;

public class Demo1 {
    public static int search(int[] nums, int target) {
        int ret=-1,left=0,right=nums.length-1,mid=0;
        while(left<=right){
             mid=(left+right)/2;
             if(nums[mid]>target) right=mid-1;
             else if (nums[mid]<target) left=mid+1;
             else {
                 ret=mid;
                 break;
             }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,3,5,9,12};
        int target=2;
        System.out.println(search(nums, target));
    }
}
