package Binary_search;

//寻找旋转数组中的最小值
public class Demo7 {
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        if (nums[mid] >= nums[0] && nums[mid] < nums[nums.length - 1])
            return nums[0];
//        if (nums[mid] < nums[0] && nums[mid] > nums[nums.length - 1])
//            return nums[nums.length - 1];
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,1}));
    }
}
