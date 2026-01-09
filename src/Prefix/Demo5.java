package Prefix;

import java.util.HashMap;
import java.util.Map;

public class Demo5 {
    public  static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>(); //创建hash表
        hash.put(0,1);
        int sum=0,ret=0;
        for(int x:nums){
            sum+=x;
            ret+=hash.getOrDefault(sum-k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return ret;

    }

    public static void main(String[] args) {
        int []nums=new int[]{3,5,4,4,-3,-5};
        System.out.println(subarraySum(nums, 8));
    }
}
