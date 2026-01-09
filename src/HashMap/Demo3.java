package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo3 {
    public static void main(String[] args) {
        containsDuplicate(new int[]{1, 2, 3, 4});
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
    }
    // ①：异或  ②：哈希表
    //这里使用哈希表来解题
    public static boolean containsDuplicate1(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();//用来记录元素出现的个数
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])) return true;
            hash.put(nums[i],i);
        }
        return false;
    }
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> hash=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.contains(nums[i])) return true;
            hash.add(nums[i]);
        }
        return false;
    }
}
