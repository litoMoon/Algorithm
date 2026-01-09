package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Demo7 {
    List<String> ret;
    StringBuffer path;
    int len;
    public List<String> letterCasePermutation(String _s) {
        len=_s.length();//记录字符串的长度
        ret=new ArrayList<>();
        path=new StringBuffer();
        dfs(_s,0);
        return ret;
    }
    public void dfs2(String s,int pos) {
        if (pos == len) {
            ret.add(path.toString());
            return;
        }
        char ch = s.charAt(pos);//获取到了数字字符
        if (ch >= '0' && ch <= '9') {
            path.append(ch);
            dfs2(s, pos + 1);
        } else if ('a' <= ch && ch <= 'z') {
            //选择转化为大写---调用库方法
            char cur = Character.toUpperCase(ch);
            path.append(cur);
            dfs2(s, pos + 1);
            path.deleteCharAt(path.length() - 1);
            //选择不转化为大写
            path.append(ch);
            dfs2(s, pos + 1);
            path.deleteCharAt(path.length() - 1);
        } else if ('A' <= ch && ch <= 'Z') {
            //选择转化为小写---调用库方法
            char cur = Character.toLowerCase(ch);
            path.append(cur);
            dfs2(s, pos + 1);
            path.deleteCharAt(path.length() - 1);

            //选择不转化为小写
            path.append(ch);
            dfs2(s, pos + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
    //上面dfs2的更简洁版本
        public void dfs(String s,int pos){
            if(pos==len) {

            }

    }

    public static void main(String[] args) {
        char ch='w';
        char cur=Character.toUpperCase(ch);
        System.out.println(ch);
        System.out.println(cur);
    }
}
