package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        isPalindrome(0,s,path,res);//0表示遍历的起点从字符串第一个字符开始
        return res;
    }
    public static void isPalindrome(int i,String s,List<String> path,List<List<String>> res){
        if(i==s.length()){
            res.add(new ArrayList<>(path));
            return ;
        }
        //遍历当前字符串
        for(int j=i;j<s.length();j++){
            if(yesPalindrome(i,j,s)){
                //true表示为回文串
                path.add(s.substring(i,j+1));
                isPalindrome(++i,s,path,res);
                path.remove(path.size()-1);
            }
        }


    }
    public static boolean yesPalindrome(int left,int right,String s){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
