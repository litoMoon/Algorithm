package HashMap;

import java.util.HashMap;

//两数之和
public class Demo1 {
    public static void main(String[] args) {
       int[] arr=new int[]{3,2,4};
       int []ret=twoSum(arr,6);
        for (int x:ret) {
            System.out.print(x+" ");
        }

    }

    //方法一：先将所有的元素先丢入 hash 表中
    public static int[] twoSum1(int[] nums, int target) {
        //数组的存储值有负数值，不适合使用数组，使用 Hash 表来对内容进行求解
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            int num = hash.getOrDefault(result,-1);
            if (num != -1 && i!=num) {
                return new int[]{i, num};
            }
        }
        return null;

    }
    //方法二：边计算边丢
    public static int[] twoSum2(int[] nums, int target) {
      HashMap<Integer,Integer> hash=new HashMap<>();
      hash.put(nums[0],0);
        for (int i = 1; i <nums.length ; i++) {
            int result=target-nums[i];
            int num=hash.getOrDefault(result,-1);
            if(num!=-1){
                return new int[]{i,num};
            }
            hash.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    //方法三：对方法二进行更加简单一步的优化，可以使用 contains 方法
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x=target-nums[i];
            if(hash.containsKey(x)){//存在值
                return new int[]{i,hash.get(x)};//hash 表中存储的值为 数组的下标
            }
             //当if不成立，将数组元素放入 hash 表中
            hash.put(nums[i],i );
        }
   return new int[]{-1,-1};
    }

}