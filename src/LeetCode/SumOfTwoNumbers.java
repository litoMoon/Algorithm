package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[]nums=new int[]{2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums,target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = target - nums[i];
            if (counts.containsKey(cur)) {
                return new int[]{counts.get(cur), i};
            }
            counts.put(nums[i], i);
        }
        return new int[]{};
    }
}
