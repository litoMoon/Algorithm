package Recursion;


import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    //定义数组
    String []str=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    StringBuffer path;
    List<String> ret;
    public List<String> letterCombinations(String digits) {
        ret=new ArrayList<>();
        dfs(digits,0,path);
        return ret;


    }
    public void dfs(String d,int m,StringBuffer _path){
        if(m==d.length()) return;
        StringBuffer path=new StringBuffer(_path);
        int num=d.charAt(m)-'0';//将数字字符转化为数字
        for(int i=0;i<str[num].length();i++){


        }
    }
}
