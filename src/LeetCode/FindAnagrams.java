package LeetCode;

import java.util.*;

public class FindAnagrams {

    //方法一
    public static List<Integer> findAnagrams1(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Set<Character> set=new HashSet<>();

        //将 p 中所有元素放入 set 中
        for(int i=0;i<p.length();i++) set.add(p.charAt(i));
        char[] ch=p.toCharArray();
        Arrays.sort(ch);
        p=new String(ch);

        StringBuilder sbu=new StringBuilder();
        int left=0,right=0;

        while(right < s.length()) {

            while(right<s.length() && sbu.length()<p.length()){
                char cur=s.charAt(right);
                if(!set.contains(cur)){
                    left=right+1;
                    right++;
                    sbu=new StringBuilder();
                    continue;
                }
                sbu.append(cur);
                right++;//此时right已经指向后面的一个元素了
            }

            char[] ch2=sbu.toString().toCharArray();
            Arrays.sort(ch2);
            String ss=new String(ch2);
            if(ss.equals(p)) list.add(left);
            if(ss.length()>0) sbu.deleteCharAt(0);
            left++;

        }
        return list;
    }

    //方法二
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int []sCount=new int[26];
        int []pCount=new int[26];
        int m=s.length();
        int n=p.length();
        if(m<n) return new ArrayList<>();
        for(int i=0;i<n;i++){
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sCount,pCount)) list.add(0);
        for(int i=n;i<m;i++){
            sCount[s.charAt(i)-'a']++;
            sCount[s.charAt(i-n)-'a']--;
            if(Arrays.equals(sCount,pCount)) list.add(i-n+1);
        }
        return list;

    }


    public static void main(String[] args) {
        String s = "ababababab", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);

    }
}
