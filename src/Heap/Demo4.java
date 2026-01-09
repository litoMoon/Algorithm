package Heap;

import java.util.*;

public class Demo4 {
    public static void main(String[] args) {
       // Comparable  是一个在 java.lang 底下的接口，实现其接口需要重写 compareTo 方法
       // Comparator 是一个在java.util底下的接口，实现其接口需要重写 compare 方法
        List<String> list= topKFrequent(new String[]{"the","the","the","the","sunny","sunny","is","is","is","day","ab"},4);
        for (String s :list) {
            System.out.print(s+" ");
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> list=new ArrayList<>();//list用来存储最后的元素结果

        //创建hash表，先统计每个单词出现的次数
        HashMap<String,Integer> map=new HashMap<>();
        for (String s:words) {
            map.put(s,map.getOrDefault(s,0)+1);//先记录下每个元素出现的次数
        }

        //实现堆---这里的比较器是每次需要排序的时候会按照的规则
        PriorityQueue<Map.Entry<String,Integer>> heap=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0) return o2.getKey().compareTo(o1.getKey());//如果两个单词出现的频次相同的时候，按照字典的顺序进行排序
                return o1.getValue()-o2.getValue();
            }
        });

        //将元素放入堆中
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(heap.size()<k){
                heap.offer(entry);//当堆中的元素个数小于等于 k 的时候，直接将元素扔进去
            }else {
                if (entry.getValue().compareTo(heap.peek().getValue())>0){  //当元素的值大于堆顶元素的值相等的时候，
                    heap.poll();
                    heap.add(entry);
                }else if(entry.getValue().compareTo(heap.peek().getValue())==0){
                    if(entry.getKey().compareTo(heap.peek().getKey())<0){
                        heap.poll();
                        heap.offer(entry);
                    }
                }
            }
        }
        //注意这里从堆里弹出和从按顺序从 heap 里一个一个的出来是不一样的，
        //从堆里每次弹出来他都会调整顺序，确保每次出来的都是题目要求的数

        //将元素放入list中返回
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> num=heap.poll();
            list.add(num.getKey());
        }
        Collections.reverse(list);//这个可以用来翻转列表
        return list;
    }



    }
