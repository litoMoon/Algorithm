package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Demo4 {
    //方法一
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        //将元素放入 hash 表中
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                int num=hashMap.get(nums[i]);
                if(Math.abs(num-i)<=k) return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }

    //方法二
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length<=1) return false;
        HashSet<Integer> set=new HashSet<>();

        int j=0;
        //将元素放入 hash 表中
        for (int i = 0; i < nums.length; i++) {
           if(set.size()>k){
               set.remove(nums[j++]);//当 set 中的元素个数大于 k 个时，此时将元素移出去
           }
           if(set.contains(nums[i])) return true;//在题目已知的k的范围内，找到了相同的元素

            //将元素丢进 set 中
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));

    }
}
