package Prefix;
import java.util.*;
public class Demo7 {
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
          hash.put(0,-1); //处理边界的情况
        int sum=0,ret=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==0?-1:1); //将这里的 0 转化为 -1
            if(hash.containsKey(sum)) ret=Math.max(ret,i-hash.get(sum));
            else hash.put(sum,i); //将前缀和及前缀和的数组下标放入
        }
        return ret;
    }
    public static void main(String[] args) {
        int []nums=new int[]{1,0};
        System.out.println(findMaxLength(nums));


    }
}
