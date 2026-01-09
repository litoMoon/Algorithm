package Greed;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        int []nums=new int[]{30,34,3,5,9};
        l(nums);           //9 5 34 3 30
        System.out.println(l(nums));
//30 5
    }
    public static String l(int[] nums){
        int n=nums.length;
        String[] strs=new String[n];
        for(int i=0;i<n;i++) strs[i]=""+nums[i];

        Arrays.sort(strs,(a, b)->{
            return (b+a).compareTo(a+b);//大于0返回1需要交换
        });

        StringBuffer ret=new StringBuffer();
        for(String s:strs) ret.append(s);

        if(ret.charAt(0)=='0') return "0";
        return ret.toString();
    }
}
