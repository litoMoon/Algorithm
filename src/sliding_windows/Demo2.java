package sliding_windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo2 {
    public static List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hash1=new HashMap<String,Integer>();
        List<Integer> ret=new ArrayList<>();
        for (int i=0;i<words.length;i++){
            hash1.put(words[i],hash1.getOrDefault(words[i],0)+1);
        }
        int len=words.length,m=words[0].length();
        for (int i = 0; i < m; i++) {
            HashMap<String,Integer> hash2=new HashMap<String,Integer>();
            int count=0;
            for (int left = i, right = i;right+m<=s.length();right+=m){
                //进窗口
                String s1=s.substring(right,right+m);
                hash2.put(s1,hash2.getOrDefault(s1,0)+1);//将生成的字符串放入 hash2 中
                //判断是否需要改变 count 的值
                if(hash2.get(s1)<= hash1.getOrDefault(s1,0)) count++;
                // 判断是否需要滑动窗口
                if(right-left+1 > len*m){
                    //取出值
                    String out=s.substring(left,left+m);
                    //判断并更新 count 的值
                    if(hash2.get(out)<=hash1.getOrDefault(out,0)) count--;
                    hash2.put(out,hash2.get(out)-1);
                    left+=m;
                }
                if(count==len){
                    ret.add(left);
                }
            }
        }
         return ret;

    }

    public static void main(String[] args) {
        String [] words=new String[]{"word","good","best","good"};
        List<Integer> ret=findSubstring("wordgoodgoodgoodbestword",words);
        for (int x:ret) {
            System.out.print(x+" ");
        }
    }
}
