package Greed;

import java.util.Arrays;

public class Demo10 {

    public static String largestNumber(int[] nums) {
        String []str=new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            str[i]=Integer.toString(nums[i]);//将数字转化为字符串并保存起来
        }
        Arrays.sort(str,(a, b)->{
            return (b+a).compareTo(a+b);//字符串的拼接
        });
        StringBuffer ret=new StringBuffer();
        for(int i=0;i<str.length;i++) {
            ret.append(str[i]);
        }
        String s =ret.toString();
        if(s.charAt(0)=='0') return "0";
        return s;
    }
    public static void main(String[] args) {
        int[]nums=new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));

    }
}
