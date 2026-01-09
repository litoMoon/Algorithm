package Heap;

import java.util.*;

public class Demo3 {
    public static void main(String[] args) {
      List<String> list=  topKFrequent(new String[]{"the","the","the","the","sunny","sunny","is","is","is","day","ab"},4);
        for (String s :list) {
            System.out.print(s+" ");
        }
    }
            public static List<String> topKFrequent(String[] words, int k) {
                Map<String, Integer> map = new HashMap<>();
                //找到各个单词出现的频率
                for (String s : words) {
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        int val = map.get(s);
                        map.put(s, val + 1);
                    }
                }
                //建立小根堆，将前k个元素放入进去
                PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue().compareTo(o2.getValue())==0){
                            return o2.getKey().compareTo(o1.getKey());
                        }
                        return o1.getValue() - o2.getValue();
                    }
                });
                //将其他元素放入并对其进行比较
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (minHeap.size() < k) {
                        minHeap.offer(entry);
                    } else {
                        Map.Entry<String, Integer> top = minHeap.peek();
                        if (top.getValue().compareTo(entry.getValue()) < 0) {
                            minHeap.poll();
                            minHeap.offer(entry);
                        } else {
                            if (top.getValue().compareTo(entry.getValue()) == 0) {
                                if (top.getKey().compareTo(entry.getKey()) > 0) {
                                    minHeap.poll();
                                    minHeap.offer(entry);
                                }
                            }
                        }

                    }
                }
                List<String> ret = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    Map.Entry<String, Integer> tmp = minHeap.poll();
                    ret.add(tmp.getKey());
                }
                Collections.reverse(ret);
                return ret;
            }
}
