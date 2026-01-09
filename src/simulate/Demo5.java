package simulate;

import java.util.Arrays;
import java.util.*;

//数青蛙
public class Demo5 {
    public static void main(String[] args) {
        //minNumberOfFrogs("crcoakroak");
        System.out.println(minNumberOfFrogs("ccrrooaakk"));
    }
    //croak
    public static int minNumberOfFrogs(String c) {//一般题目中会已知字符种类个数
        String t="croak";
        int n=t.length();//表示字符串的种类的长度
        char[] cur= c.toCharArray();//将字符串转化为字符数组，方便于后续的遍历
        int[] hash=new int[n];//依据字符的种类，创建 hash 表

        // 创建 hashMap 将数组下标和字符的关系映射出来
        Map<Character,Integer> temp=new HashMap<>();
        for(int i=0;i<n;i++){
            temp.put(t.charAt(i),i);//将字符下标和字符的关系映射起来了
        }

        for (int i = 0; i <cur.length; i++) {
            char ch=cur[i];
            if(ch==t.charAt(0)) {
                if(hash[n-1]!=0) hash[n-1]--;
                hash[0]++;
            }else {
                int m=temp.get(ch);//返回的ch对应的下标
                if(hash[m-1]==0) return -1;
                hash[m]++;
                hash[m-1]--;
            }
        }
        for (int i = 0; i < n-1; i++) {
            if(hash[i]!=0) return -1;
        }
        return hash[n-1];

    }
    public static int minNumberOfFrogs1(String c) {
        int []hash=new int[26];//创建 hash 表
        for (int i = 0; i < c.length(); i++) {
            char x=c.charAt(i);
            if(x=='c'){
                hash[x-'a']=hash['k'-'a']!=0?hash['k'-'a']--:hash[x-'a']+1;
                //   if( hash[x-'a']>1) return -1;
            }else if(x=='r'){
                hash[x-'a']=hash['c'-'a']!=0?hash['c'-'a']--:hash[x-'a']+1;
                // if( hash[x-'a']>1) return -1;
            }else if(x=='o'){
                hash[x-'a']=hash['r'-'a']!=0?hash['r'-'a']--:hash[x-'a']+1;
                // if( hash[x-'a']>1) return -1;
            }else if(x=='a'){
                hash[x-'a']=hash['o'-'a']!=0?hash['o'-'a']--:hash[x-'a']+1;
                // if( hash[x-'a']>1) return -1;
            }else if(x=='k'){
                //if(hash['k'-'a']!=0)
                hash[x-'a']+=hash['a'-'a']--;

            }
        }
        if(hash['c'-'a']!=0 || hash['a'-'a']!=0 || hash['r'-'a']!=0 || hash['o'-'a']!=0) return -1;
        return hash['k'-'a'];
    }
}
