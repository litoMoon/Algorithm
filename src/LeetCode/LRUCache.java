package LeetCode;

import java.util.HashMap;

/*public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}*/
public class LRUCache {

    private int capacity;
    private HashMap<Integer,TwoDirNode> map;
    private TwoDirNode head=new TwoDirNode(0,0);
    private TwoDirNode tail=new TwoDirNode(0,0);


    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            TwoDirNode node=map.get(key);
            makeRecent(key,node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        TwoDirNode node=new TwoDirNode(key,value);
        if(map.containsKey(key)){
            makeRecent(key,node);
        }else{
            if(map.size()<capacity){
                addNode(node);
            }else if(map.size()==capacity){
                remove();
                addNode(node);
            }
        }
        //更新 map 的值
        map.put(key,node);//map中加入元素信息
    }

    private void remove() {
        TwoDirNode node=head.next;
        head.next.next.prev=head;
        head.next=head.next.next;
        map.remove(node.key);
    }

    //新增加一个元素
    private void addNode(TwoDirNode node) {
        node.next=tail;
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
    }

    private void makeRecent(int key,TwoDirNode node) {
        TwoDirNode preNode = map.get(key);//之前map中存储过
        //删除之前的元素
        preNode.prev.next=preNode.next;
        preNode.next.prev=preNode.prev;

        //插入新的元素
        node.next=tail;
        tail.prev.next=node;
        node.prev=tail.prev;
        tail.prev=node;
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
}
class TwoDirNode{
    int key;
    int value;
    TwoDirNode next;
    TwoDirNode prev;
    public TwoDirNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}

