package HashMap;

import java.lang.reflect.Array;
import java.util.*;

public class Demo5 {
    public static void main(String[] args) {
        String []strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
        int []arr=new int[]{1,2,3,4,5};
        char[] chars=new char[]{'a','b'};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(chars));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        //List<String> 其中 List 是容器，List<String>，表示容器中存储的元素为字符串
        HashMap<String,List<String>> hash=new HashMap<>();

        for(String str: strs){

            //对字符进行重排序的过程
         char[] chars=str.toCharArray();//将字符串转化为字符数组
             Arrays.sort(chars);//将字符数组进行重排序
            String key=Arrays.toString(chars);//将字符数组又重新转化为字符串

            //判读字符是否原始存在
            if(!hash.containsKey(key)){
                hash.put(key,new ArrayList<>());
            }
            hash.get(key).add(str);
            // hash.get(key) 此时得到的是一个 ArrayList()
            // hash.get(key).add(str) 此时表示在得到的 列表中加入元素str

        }
        return new ArrayList(hash.values());



    }
}
//在Java中对字符串进行重排序的时候，并没有直接的函数可以对字符串进行重排序，
//可以先将字符串转化为字符数组，然后调用Arrays.Sort(字符数组)，然后对其重新进行排序

//将数组转化为字符串输出的方法 Arrays.toString(任意类型数组名称)
//Arrays.xx 类型的方法
//Array.xx 类型的方法
