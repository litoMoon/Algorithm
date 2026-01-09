package Prefix;

import java.util.*;
public class Demo6 {
    public  static int subarraysDivByK1(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        hash.put(0,1); // 0对任何一个元素取余最终的结果为0,处理边界情况
        int sum=0,ret=0;
        for (int x:nums) {
            sum+=x;
            int cur=(sum%k+k)%k;//这样可以确保任何一个取余的结果都为整数
            ret+=hash.getOrDefault(cur,0); //如果有相同的就直接返回这个结果就可以了
            hash.put(cur,hash.getOrDefault(cur,0)+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int []num=new int[]{4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK1(num, 5));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int[] modMap = new int[k]; // reminder: value
        modMap[0] = 1;

        int curSum = 0, cntRet = 0, reminder = 0;
        for (int n : nums) {
            curSum += n;
            reminder = (curSum % k + k) % k;
            cntRet += modMap[reminder];
            modMap[reminder]++;
        }

        return cntRet;
    }
}
