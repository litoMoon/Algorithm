package LeetCode;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = -1, right = nums.length,i=0;
        while( i < right) {
            if (nums[i] == 0)
                swap(++left, i++, nums);
            else if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
                swap(--right, i, nums);
        }
        for (int x:nums) {
            System.out.print(x+" ");
        }

    }

    public void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
