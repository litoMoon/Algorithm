package LeetCode;


import java.util.HashMap;
import java.util.Map;

/*class LFUCache {
    private static class Node {
        int key, value, freq = 1; // 新书只读了一次
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> keyToNode = new HashMap<>();
    private final Map<Integer, Node> freqToDummy = new HashMap<>();
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) { // 有这本书
            node.value = value; // 更新 value
            return;
        }
        if (keyToNode.size() == capacity) { // 书太多了
            Node dummy = freqToDummy.get(minFreq);
            Node backNode = dummy.prev; // 最左边那摞书的最下面的书
            keyToNode.remove(backNode.key);
            remove(backNode); // 移除
            if (dummy.prev == dummy) { // 这摞书是空的
                freqToDummy.remove(minFreq); // 移除空链表
            }
        }
        node = new Node(key, value); // 新书
        keyToNode.put(key, node);
        pushFront(1, node); // 放在「看过 1 次」的最上面
        minFreq = 1;
    }

    private Node getNode(int key) {
        if (!keyToNode.containsKey(key)) { // 没有这本书
            return null;
        }
        Node node = keyToNode.get(key); // 有这本书
        remove(node); // 把这本书抽出来
        Node dummy = freqToDummy.get(node.freq);
        if (dummy.prev == dummy) { // 抽出来后，这摞书是空的
            freqToDummy.remove(node.freq); // 移除空链表
            if (minFreq == node.freq) { // 这摞书是最左边的
                minFreq++;
            }
        }
        node.freq++; // 看书次数 +1
        pushFront(node.freq, node); // 放在右边这摞书的最上面
        return node;
    }

    // 创建一个新的双向链表
    private Node newList() {
        Node dummy = new Node(0, 0); // 哨兵节点
        dummy.prev = dummy;
        dummy.next = dummy;
        return dummy;
    }

    // 在链表头添加一个节点（把一本书放到最上面）
    private void pushFront(int freq, Node x) {
        Node dummy = freqToDummy.computeIfAbsent(freq, k -> newList());//判断新的freq是否存在对应的freq的结点，如果不存在添加结点
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }

    // 删除一个节点（抽出一本书）
    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }
}*/

class LFUCache {
    //定义内部类？？
    public static class Node{
        int key,value,freq=1;
        Node prev,next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int capacity=0;
    HashMap<Integer,Node> freqMap=new HashMap<>();//记录访问频次的
    HashMap<Integer,Node> nodeMap=new HashMap<>();//记录结点的
    int minFreq=1;

    public LFUCache(int capacity) {
        this.capacity=capacity;

    }

    public int get(int key) {
        Node node=getNode(key);
        return node==null?-1:node.value;
    }

    public void put(int key, int value) {
        Node node=getNode(key);
        if(node!=null){
            node.value=value;
            return;
        }
        //如果说已满足容量--清理缓存
        if(nodeMap.size()==capacity){
            Node dummy=freqMap.get(minFreq);//找到频次最少对应的哨兵结点
            Node backNode=dummy.prev;
            nodeMap.remove(backNode.key);
            remove(backNode);
            if(dummy.prev==dummy) freqMap.remove(minFreq);
        }
        //某元素第一次被 put
        node=new Node(key,value);
        nodeMap.put(key,node);
        pushFront(node.freq,node);//最近被使用的元素放在前面
        minFreq=1;
    }

    private Node getNode(int key) {
        //key对应的值不存在
        if(!nodeMap.containsKey(key)) return null;
        //key对应的值存在
        Node node=nodeMap.get(key);
        remove(node);
        Node dummy=freqMap.get(node.freq);
        if(dummy.prev==dummy){
            //当前频次对应的元素结点为空节点了
            freqMap.remove(node.freq);
            if (node.freq==minFreq) minFreq++;
        }
        node.freq++;
        pushFront(node.freq,node);
        return node;
    }

    private void remove(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    //对应频次下关联的结点的排列
    private void pushFront(int freq,Node node) {
        Node dummy=freqMap.computeIfAbsent(freq,k->NodeList());//这里freMap中也会慢慢增加元素
        node.next=dummy.next;
        node.prev=dummy;
        node.next.prev=node;
        node.prev.next=node;
    }

    //创建哨兵结点
    private Node NodeList() {
        Node dummy=new Node(0,0);//创建新的结点
        dummy.prev=dummy;
        dummy.next=dummy;
        return dummy;
    }

}