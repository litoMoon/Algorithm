package LeetCode;

import java.util.*;

public class LongestAnagram {
    public static void main(String[] args) {
        String str1="baabc";
        String str2="abc";
        System.out.println(findAnagrams(str1,str2));
    }
    public static List<Integer> findAnagrams(String ss, String pp) {
        List<Integer> list=new ArrayList<>();//存放最终结果
        if(pp.length()>ss.length()) return list;
        int left=0,right=0;

        //对数组进行排序
        char[] ch=pp.toCharArray();
        Arrays.sort(ch);
        String str1=new String(ch);

        Set<Character> set=new HashSet<>();//查看字母是否单一
        for (char c : ch) {
            set.add(c);//将已存在的字符放入set中
        }

        String str2=null;//存放ss中的子区间数组
        StringBuilder sbu=new StringBuilder();//用来存放字母信息

        while(left<ss.length() && right<ss.length()){
            while(right-left+1<=pp.length() && right<ss.length()){
                if(!set.contains(ss.charAt(right))){
                    left=right+1;
                    right=left;
                    sbu=new StringBuilder();
                    continue;
                }
                sbu.append(ss.charAt(right));
                right++;

            }
            if(sbu.length()!=0){
                str2=sbu.toString();
                char []ch2=str2.toCharArray();
                Arrays.sort(ch2);
                str2=new String(ch2);
                if(str1.equals(str2)){
                    list.add(left);
                }
                left++;
                sbu.deleteCharAt(0);
            }

        }
        return list;
    }
}
