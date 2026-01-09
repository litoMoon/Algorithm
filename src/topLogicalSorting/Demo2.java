package topLogicalSorting;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
      //  String[] w=new String[]{"wrt","wrf","er","ett","rftt"};
    //    String[] w=new String[]{"wrt","wrtkj"};
//        String[] w=new String[]{"abc","ab"};
//        String[] w=new String[]{"z","z"};
        String[] w=new String[]{"z","x","a","zb","zx"};

        System.out.println(alienOrder(w));


    }
    public static String alienOrder(String[] words) {
        int len=words.length;
        char a=' ',b=' ';
        HashMap<Character, List<Character>> map=new HashMap<>();//用来建图
        HashMap<Character,Integer> map1=new HashMap<>();//用来计算入度
        Queue<Character> q=new ArrayDeque<>();
        StringBuilder sbu=new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int sz=words[i].length();
            for (int j = 0; j < sz; j++) {
                map1.put(words[i].charAt(j),0);
            }

        }
        //先收集先后信息
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int cur1=0;
                int cur2=0;
                while(cur1<words[i].length() && cur2<words[j].length()){
                     a=words[i].charAt(cur1);
                     b=words[j].charAt(cur2);
                    if(a==b){
                        cur1++;
                        cur2++;
                    }else {
                        if(!map.containsKey(a)){
                            map.put(a,new ArrayList<>());
                        }
                        if(!map.get(a).contains(b))  {
                            map.get(a).add(b);//当他不存在的时候在将他放入
                            map1.put(b,map1.getOrDefault(b,0)+1);
                        }
                        break;
                    }
                }
                if(cur1<words[i].length() && cur2==words[j].length()) {
                   return "";
                }
            }
        }

        //遍历hash表
        for (char ch:map1.keySet()) {
            if(map1.get(ch)==0){
                q.add(ch);
            }
        }

        //判断
        while(!q.isEmpty()){
            char cur=q.poll();
            sbu.append(cur);
            if(!map.containsKey(cur)) continue;//入度为 0 ，但是可以没有其他点
            for (char c:map.get(cur)) {
                int num=map1.get(c)-1;
                map1.put(c,num);
                if(num==0){
                    q.add(c);
                }
            }
        }

        for (char c:map1.keySet()) {
            if(map1.get(c)!=0) return "" ;
        }


        return sbu.toString();

    }
}
